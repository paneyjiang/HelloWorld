package com.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * 
 * 
 * <p>
 * 功能描述：zookeeper观察者实现类
 * </p>
 * 
 * @Author: jianglh
 * @CreateDate: 2015-7-17下午3:15:42
 * @UpdateUser: 2015-7-17下午3:15:42
 * @UpdateDate: 2015-7-17下午3:15:42
 * @UpdateRemark: [修改内容]
 * @Version:1.0
 * @since Copyright(c) 北京思特奇信息技术股份有限公司
 */
public class WatcherImpl implements Watcher {

	public static ZooKeeper zk =null;
     
	/**
	 * 
	 * <p>
	 * 监听服务器：
	 * </P>
	 * 
	 * @Author jianglh
	 * @Date 2015-7-20上午10:10:21 in_param: out_param:
	 */
	@Override
	public void process(WatchedEvent event) {
		if (event.getType().equals(Watcher.Event.EventType.NodeCreated)) {
			System.out.println("创建新节点");
		} else if (event.getType().equals(Watcher.Event.EventType.NodeDataChanged)) {
			System.out.println("修改内容");
			initConfig();
		}else if(event.getType().equals(Watcher.Event.EventType.NodeChildrenChanged)){
			System.out.println("修改内容(子节点变化)");
			initConfig();
		} else if (event.getType().equals(Watcher.Event.EventType.NodeDeleted)) {
			System.out.println("删除节点");
		} else if(event.getType().equals(Watcher.Event.EventType.None)){
			System.out.println("连接服务器操作");
		}

	}

	/**
	 * 
	 * <p>
	 * 获取zk实例：
	 * </P>
	 * 
	 * @throws IOException
	 * @Author jianglh
	 * @Date 2015-7-20上午10:11:32 in_param: out_param:
	 */
	public static ZooKeeper getZookeeper() {
		if (zk == null) {
			try {
				//单机访问模式
				// zk = new ZooKeeper("172.21.1.37:2181", 2000, new WatcherImpl());
				//集群访问模式
				zk = new ZooKeeper("192.168.163.236:2182,192.168.163.237:2182,192.168.163.238:2182", 2000, new WatcherImpl());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return zk;
	}

	public static void initConfig() {
		try {
			String driverDate = new String(zk.getData("/RootPath/driver", true,
					null));
			String userDate = new String(zk.getData("/RootPath/username", true,
					null));
			String pwdDate = new String(zk.getData("/RootPath/password", true,
					null));
			System.out.println("driver==" + driverDate);
			System.out.println("userDate==" + userDate);
			System.out.println("pwdDate==" + pwdDate);
			
		   SetConfig.setConfig(driverDate, userDate, pwdDate);
		 //  System.out.println(SetConfig.getConfig().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
