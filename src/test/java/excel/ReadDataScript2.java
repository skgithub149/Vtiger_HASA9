package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataScript2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Excel1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String value1 = workbook.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		double value2 = workbook.getSheet("Sheet1").getRow(0).getCell(1).getNumericCellValue();

		workbook.close();
	}
}
