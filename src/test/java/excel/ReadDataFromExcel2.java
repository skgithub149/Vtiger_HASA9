package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step 1:Convert physical file to java readable object
				FileInputStream fis=new FileInputStream("./src/test/resources/Excel1.xlsx");
				
				//Step 2:Open the excel workbook
				//Import workbook from org.apache.poi.ss.usermodel
				//The below statement throws EncryptedDocumentException,IOException
				Workbook wb = WorkbookFactory.create(fis);
				
				String data = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
				System.out.println(data);
				
				System.out.println(wb.getSheet("Sheet1").getRow(3).getCell(0).getNumericCellValue());
				
				//Step 7:Close Workbook(throws IOException)
				wb.close();

	}

}
