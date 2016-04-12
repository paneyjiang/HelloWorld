package com.xtream.testmain;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.xtream.obj.CacheEngine;
import com.xtream.obj.CacheEngines;
import com.xtream.obj.CacheManagerInfo;
import com.xtream.obj.Course;
import com.xtream.obj.Param;
import com.xtream.obj.Student;

public class TestXStream {
	private static XStream xs = null;
	static {
		// new Xpp3Driver(new XmlFriendlyNameCoder("_-", "_") 解决下划线问题
		xs = new XStream(new Xpp3Driver(new XmlFriendlyNameCoder("_-", "_")));

	}

	/**
	 * 将java对象序列化为xml
	 * 
	 * @param obj
	 * @return
	 */
	public static String serializableToXML(Object obj) {
		// 处理特殊字符,或者转换格式,设置显示字段等
		// 别名,比如，在xml中类一般是包含了包路径的，所以我们可以用别名替代
		xs.alias("student", com.xtream.obj.Student.class);
		xs.alias("course", com.xtream.obj.Course.class);

		xs.alias("CacheManagerInfo", com.xtream.obj.CacheManagerInfo.class);
		xs.alias("param", com.xtream.obj.Param.class);
		return xs.toXML(obj);
	}

	/**
	 * 反序列化xml to java 对象
	 * 
	 * @param xml
	 * @return
	 */
	public static <T> T unserializableFromXMl(String xml) {

		return (T) xs.fromXML(xml);
	}

	/**
	 * 测试类
	 * 
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		Student stu = new Student();
		stu.setAddress("四川成都");
		stu.setAge(28);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date date = format.parse("2015-7-9");
		stu.setBirthday(date);
		stu.setName("张三");
		stu.setScore(100);
		// 课程
		Course course = new Course();
		course.setCouese_score(5);
		course.setCourse_name("英语");
		List p_list = new ArrayList();
		Param param = new Param();
		param.setName("redis");
		param.setValue("xml_string");
		Param param2 = new Param();
		param2.setName("mehcache");
		param2.setValue("json_string");
		p_list.add(param);
		p_list.add(param2);
		course.setParam(p_list);
		Course course2 = new Course();
		course2.setCouese_score(6);
		course2.setCourse_name("体育");
		ArrayList list = new ArrayList();
		list.add(course);
		list.add(course2);

		stu.setCourse(list);

		String xml = TestXStream.serializableToXML(stu);
		// System.out.println(xml);

		CacheManagerInfo info = new CacheManagerInfo();
		CacheEngines eng = new CacheEngines();
		
		CacheEngine engine = new CacheEngine();
		engine.setEngineName("redis");
		engine.setImplClass("com.sitech.rtid.common.cache.redis.RedisEngine");
		engine.setEngineDesc("session");
		
		ArrayList engine_list = new ArrayList();
		engine_list.add(engine);
		eng.setCacheEngine(engine_list);
		info.setCacheEngines(eng);
		String xml_info = TestXStream.serializableToXML(info);
		//System.out.println(xml_info);
		
		  // 反序列化
		String from_xml =
		  "<student> <name>张三</name> <score>100</score> <address>四川成都</address> <age>28</age><birthday>2015-01-08 16:07:00.0 UTC</birthday></student>";
		  
		  Student from_obj = TestXStream.unserializableFromXMl(from_xml);
		  
		  System.out.println(from_obj.toString());
		 

	}

}
