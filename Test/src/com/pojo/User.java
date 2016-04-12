package com.pojo;

import java.util.Date;


public class User {
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private int age=0;
	/**
	 * 出生日期
	 */
	private  Date  born_date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBorn_date() {
		return born_date;
	}
	public void setBorn_date(Date born_date) {
		this.born_date = born_date;
	}

}
