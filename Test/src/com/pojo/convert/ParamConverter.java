package com.pojo.convert;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.xmltoobject.test.CacheManagerInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.xmltoobject.test.Param;
import com.xmltoobject.test.CacheManagerInfo.CacheItems.CacheItem.Params;
public class ParamConverter implements SingleValueConverter  {

	@Override
	public boolean canConvert(Class type) {
		return true;
	}

	@Override
	public Object fromString(String name) {
		
		return new CacheManagerInfo.CacheItems.CacheItem.Params();
	}

	@Override
	public String toString(Object obj) {
		System.out.println(obj);
		return ((Param)((Params) obj).param.get(0)).getName();
	}
	
	
}
