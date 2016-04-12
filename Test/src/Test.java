import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.pojo.User;


public class Test {
	
	public static void main(String[] args) throws IOException {
		
      String fileName="Pub0010Controller";
      String filePath = "base/pub/pub0010/Pub0010Controller-initMainPage.gv;jsessionidcontroller/Pub0010Controller";
      System.out.println("filePath1===================="+filePath);
      filePath = filePath.replaceAll("/", ".");
      System.out.println("filePath2===================="+filePath);
      if(filePath.contains(";")){
      	 filePath=filePath.split(";")[0];
      	 filePath=filePath.split("-")[0];
      	 filePath=filePath.replace(fileName, "controller."+fileName);
      }
      System.out.println("filePath改造后的===================="+filePath);
	}
	public static void showMsg(User  u){
		
	}

}
