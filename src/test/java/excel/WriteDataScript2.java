package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataScript2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Excel1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Excel1.xlsx");
		workbook.write(fos);
		
		workbook.close();
	}
}
