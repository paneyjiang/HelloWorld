package com.xtream.obj;

import java.util.List;

/**
 * 课程类
 * @author jianglh
 *
 */
public class Course {
	
	/**
	 * 名称
	 */
	private  String course_name;
	/**
	 * 学分
	 */
	private  int    couese_score;
	
	/**
	 * 参数
	 */
	private List<Param> params;
	
	public List<Param> getParam() {
		return params;
	}
	public void setParam(List<Param> param) {
		this.params = param;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getCouese_score() {
		return couese_score;
	}
	public void setCouese_score(int couese_score) {
		this.couese_score = couese_score;
	}

}
