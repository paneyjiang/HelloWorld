package com.zookeeper;

/**
 * 
* 
* <p>修改配置文件内容：</p>
* @Author: jianglh     
* @CreateDate:  2015-7-20上午10:03:04
* @UpdateUser:   2015-7-20上午10:03:04
* @UpdateDate:    2015-7-20上午10:03:04
* @UpdateRemark: [修改内容]
* @Version:1.0
* @since 
* Copyright(c) 北京思特奇信息技术股份有限公司
 */
public class SetConfig {
    
	public static ConfigBean config = new ConfigBean();
	/**
	 * 初始化配置文件内容
	 */
	public static void setConfig(String driver,String username,String password){
		config.setDriver(driver);
		config.setPassword(password);
		config.setUsername(username);
	}
	
	public  static ConfigBean getConfig(){
		
		return config;
	}
}
