package com.zookeeper;

/**
 * 
* 
* <p>数据库连接配置文件bean</p>
* @Author: jianglh     
* @CreateDate:  2015-7-20上午9:59:07
* @UpdateUser:   2015-7-20上午9:59:07
* @UpdateDate:    2015-7-20上午9:59:07
* @UpdateRemark: [修改内容]
* @Version:1.0
* @since 
* Copyright(c) 北京思特奇信息技术股份有限公司
 */
public class ConfigBean {
	/***驱动程序名称***/
	private String driver;
	/***用户名***/
	private String username;
	/***密码***/
	private String password;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
     
	@Override
	public  String toString(){
		
		return "driver==="+driver+","+"username=="+username+","+"password=="+password;
	}
}
