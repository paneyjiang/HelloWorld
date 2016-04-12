package com.xmltoobject.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.xmltoobject.test.CacheManagerInfo.CacheEngines.CacheEngine;

/**
 * 测试解析xml,通过JAXB
 * 
 * @author jianglh
 * 
 */
public class TestXMLtoObject {

	public static void main(String[] args) throws JAXBException {
		CacheManagerInfo obj = new CacheManagerInfo();
		JAXBContext jax_con = JAXBContext.newInstance(CacheManagerInfo.class
				.getPackage().getName());
		Unmarshaller unmar = jax_con.createUnmarshaller();
		try {
			CacheManagerInfo info = (CacheManagerInfo) unmar
					.unmarshal(new FileInputStream(
							"E:\\workspace\\Test\\src\\cfgcache.xml"));
			System.out.println(info.getCacheEngines().getCacheEngine().size());
			// 遍历解析的文件内容
			for (CacheManagerInfo.CacheEngines.CacheEngine cachengine : info
					.getCacheEngines().getCacheEngine()) {

				System.out.println("enginename:" + cachengine.getEngineName());

			}
			for (CacheManagerInfo.CacheItems.CacheItem cacheitem : info.cacheItems
					.getCacheItem()) {

				System.out.println("cacheitem:" + cacheitem.getCacheName());

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
