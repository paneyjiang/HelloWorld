package com.xtream.obj;

import java.util.Date;
import java.util.List;

public class Student {
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 分数
	 */
	private int score;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 生日
	 */
	private Date birthday;
	
	/**
	 * 主修课程
	 */
	private  List<Course>  courses;

	public List<Course> getCourse() {
		return courses;
	}

	public void setCourse(List<Course> course) {
		this.courses = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
    @Override
	public String toString() {
		return (this.getName() + "," + this.getAge() + ","
				+ this.getAddress() + "," + this.getScore() + ","
				+ this.getBirthday());
	}
}
