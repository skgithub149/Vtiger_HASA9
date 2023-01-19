package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInCompleteNewRow {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Excel1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		//Creates new row by deleting older values
		Row r = sh.createRow(4); //if directly use getRow we'll get NullPointerException
		
		Cell c = r.createCell(0); //create new cell by deleting any older data or null data in cell
		c.setCellValue("Suraj"); //writes data into the cell
		
		//saves data into excel
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Excel1.xlsx");
		wb.write(fos);
		wb.close();

	}

}
