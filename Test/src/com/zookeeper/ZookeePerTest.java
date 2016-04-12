package com.zookeeper;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZookeePerTest {

	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException 
	 * @throws KeeperException 
	 */
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
	//rmidiao'yo
		WatcherImpl client = new WatcherImpl();
		ZooKeeper zk =client.getZookeeper();
		//String res = zk.create("/rootjianglh", "jianglhtest".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		List  child_list = zk.getChildren("/crmtpd/_data_/seq", null);
		for(int i=0;i<child_list.size();i++){
			String str = (String) child_list.get(i);
			System.out.println(str);
			zk.delete("/crmtpd/_data_/seq/"+str,0 );
		}
		
		/*for(int i=0;i<child_list.size();i++){
			System.out.println(child_list.get(i));
		}*/
		//byte[] ret = zk.getData("/rootjianglh/db.properties", null, null);
	//	System.out.println(ret);
		
		/*	// 创建一个与服务器的连接
		WatcherImpl client = new WatcherImpl();
		ZooKeeper zk =client.getZookeeper();
		String db_value="DBCP.DataSource.ijdbc.driver=oracle.jdbc.driver.OracleDriver" +
				"\n DBCP.DataSource.ijdbc.url=jdbc:oracle:thin:@172.21.0.71:1524:crmcadb" +
				"\n DBCP.DataSource.ijdbc.username=dbchnadm4" +
				"\n DBCP.DataSource.ijdbc.password=dbchnadm123" +
				"\n DBCP.DataSource.ijdbc.maxwait=5000" +
				"\n DBCP.DataSource.ijdbc.maxIdle=5" +
				"\n DBCP.DataSource.ijdbc.testWhileIdle=true" +
				"\n DBCP.DataSource.ijdbc.validationQuery=select '1' from dual";
		//创建一个节点rootjianglh,内容为sequencedir,不验证安全,持久化的节点，客户端断开也存在
		Stat exis_st=zk.exists("/rootjianglh/db.properties", client);
		if(exis_st==null){
		System.out.println("创建节点");
		zk.create("/rootjianglh/db.properties", db_value.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
	//	String res = zk.create("/rootjianglh/", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
	//    System.out.println("==========="+res);
		//	zk.create("/rootjianglh/sequencelock/", "seq".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
		//zk.setData("/rootjianglh/db.properties", db_value.getBytes(), -1);
		Stat st =new Stat();
	   byte[] rev_value = zk.getData("/rootjianglh/db.properties", null, st);
		List  list = zk.getChildren("/rootjianglh", client);
		for(int i=0;i<list.size();i++){
			  System.out.println( list.get(i));
			  // zk.delete("/rootjianglh/"+(String) list.get(i), -1);
		}
		
	   System.out.println(new String(rev_value));
		zk.close();*/
	}

}
