package propertiesFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataScript1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("/src/test/resources/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		
		p.put("username", "admin");
		
		FileOutputStream fos=new FileOutputStream("/src/test/resources/commonData.properties");
		p.store(fos, "username modified");
	}
}
