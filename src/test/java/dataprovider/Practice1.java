package dataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Practice1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fise=new FileInputStream("./src/test/resources/BusTicket.xlsx");
		Workbook workbook = WorkbookFactory.create(fise);
		
		Object[][] obj=new Object[3][2];
		
		for (int i = 0; i < obj.length; i++) {
			for (int j = 0; j < obj.length ; j++) {
				obj[i][j]=workbook.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
			}
		}
		System.out.println(obj);
		
		
		
		
		
		
		
	}

}
