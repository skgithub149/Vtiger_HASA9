package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataScript3 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Excel1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		DataFormatter df=new DataFormatter();
		
		String cellValue = df.formatCellValue(workbook.getSheet("Sheet1").getRow(3).getCell(0));
	}
}
