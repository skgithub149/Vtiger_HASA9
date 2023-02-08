package propertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataScript3 {

	public static void main(String[] args) throws IOException {

		// Step 1: Convert the property file into java readable object using file input stream
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");

		// Step 2: Create an instance of Properties class in java.util
		Properties pObj = new Properties();

		// Step 3: Load the file input stream into properties class object
		pObj.load(fis);

		// Step 4: Provide the key and read the value
		System.out.println(pObj.getProperty("url") + "\t" + pObj.getProperty("username") + "\t" + pObj.getProperty("password"));
	}
}
