package map.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		List list = new ArrayList();

		list.add( "first" );

		list.add( "second" );
		Socket socket = new Socket("",99);
		OutputStream out = socket.getOutputStream();
		PrintWriter writer = new PrintWriter(out,true);
		writer.print("");

	}
	public static void changeValue(String name,String age){
		//String nn =name;
		//String aa=age;
		 name="ttttt";
		 age="100";
		System.out.println(name);
		System.out.println(age);
	}

}
