package com.pojo.convert;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter {
	
	private final String dateformatter;
	 
	/**
	 * 默认转换格式
	 * 
	 */
	public DateConverter() {
		super();
		this.dateformatter = "yyyyMMddHHmmss";
	}
 
	/**
	 * 指定特定格式的日期
	 * 
	 * @param dateformatter
	 */
	public DateConverter(String dateformatter) {
		super();
		this.dateformatter = dateformatter;
	}
 
	public boolean canConvert(Class clazz) {
		return Date.class.isAssignableFrom(clazz);
	}
 
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		Date date = (Date) value;
		writer.setValue(format(this.dateformatter, date));
	}
 
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		try {
			return parse(this.dateformatter, reader.getValue());
		} catch (ParseException e) {
			throw new ConversionException(e.getMessage(), e);
		}
	}
 
	/**
	 * 日期格式化
	 * @param pattern
	 * @param date
	 * @return
	 */
	public String format(String pattern, Date date) {
		if (date == null) {
			return "";
		} else {
			return new SimpleDateFormat(pattern).format(date);
		}
	}
 
	/**
	 * 日期格式化
	 * 
	 * @param pattern
	 * @param text
	 * @return
	 */
	public Date parse(String pattern, String text) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.parse(text);
	}
	
}
