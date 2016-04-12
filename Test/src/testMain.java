import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.pojo.convert.DateConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.xmltoobject.test.CacheManagerInfo;


public class testMain {
	private static  XStream xs =null;
	private static  XStream xs_json =null;
	static{
		
		xs= new XStream();
		xs_json=new XStream(new JettisonMappedXmlDriver());
	}
	public static void main(String[] args) {
          

	}
	
	/**
	 * java object trans to xml
	 * @param obj
	 * @return
	 */
	public static String  serializableToXml(Object obj){
		
		//xs.registerConverter(new ParamConverter());
		xs.alias("CacheManagerInfo", CacheManagerInfo.class);
		xs.useAttributeFor(com.xmltoobject.test.Param.class, "name");
		xs.useAttributeFor(com.xmltoobject.test.Param.class, "value");
		String xml = xs.toXML(obj);
		return xml;
	}
	/**
	 * from xml to java object
	 * @param obj
	 * @return
	 */
	public static <T> T  UnserializableToXml(String xml){
		
		xs.registerConverter(new DateConverter());
		Object obj = xs.fromXML(xml);
		return (T)obj;
	}
	/**
	 * from xml to java object
	 * @param obj
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static <T> T  UnserializableToXml_file(File file) throws IOException, ClassNotFoundException{
		
		ObjectInputStream obj = null;
		try {
			obj = xs.createObjectInputStream(new InputStreamReader(new FileInputStream(file)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (T)obj.readObject();
	}
	/**
	 * java object trans to Json
	 * @param obj
	 * @return
	 */
	public static String  serializableToJson(Object obj){
		xs_json.registerConverter(new DateConverter());
		String xml = xs_json.toXML(obj);
		return xml;
	}
	
	/**
	 * from Json to java Object
	 * @param obj
	 * @return 
	 * @return
	 */
	public static <T> T  UnserializableToJson(String json){
		xs_json.registerConverter(new DateConverter());
		Object obj = xs_json.fromXML(json);
		return (T)obj;
	}
}
