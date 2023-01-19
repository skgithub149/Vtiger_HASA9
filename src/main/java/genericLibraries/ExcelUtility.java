package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains all the reusable methods to perform operations on excel 
 * @author DHARMENDRA KUMAR
 *
 */
public class ExcelUtility {
	private Workbook workbook;
	
	/**
	 * This method initializes excel workbook
	 * @param path
	 */
	public void excelInitialization(String path) {
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to fetch single data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum 
	 * @return
	 */
	public String readDataFromExcel(String sheetName, int rowNum, int cellNum) {
		DataFormatter df = new DataFormatter();
		Sheet sheet = workbook.getSheet(sheetName);
		return df.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
	}
	/**
	 * This method is used to fetch multiple data in key-value format from excel
	 * @param expectedTestName
	 * @param sheetName 
	 * @return
	 */
	public Map<String, String> readDataFromExcel(String expectedTestName, String sheetName) {
		DataFormatter df = new DataFormatter();
		Sheet sheet = workbook.getSheet(sheetName);
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			if (df.formatCellValue(sheet.getRow(i).getCell(1)).contains(expectedTestName)) {
				for (int j = i; j < sheet.getLastRowNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(j).getCell(2));
					String value = df.formatCellValue(sheet.getRow(j).getCell(3));
					map.put(key, value);
					if (df.formatCellValue(sheet.getRow(i).getCell(2)).equals("####")) {
						break;
					}
					break;
				}
			}
		}
		return map;
	}
	
	/**
	 * This method is used to write data into excel
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @param path
	 * @param sheetName 
	 */
	public void setDataToExcel(int rowNum, int cellNum, String data, String path, String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		Cell cell = sheet.getRow(rowNum).createCell(cellNum);
		cell.setCellValue(data);
		
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to  update test status into excel workbook
	 * @param expectedTestName
	 * @param status
	 * @param path
	 * @param sheetName 
	 */
	public void setDataToExcel(String expectedTestName, String status, String path, String sheetName) {
		DataFormatter df = new DataFormatter();
		Sheet sheet = workbook.getSheet(sheetName);
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			if (df.formatCellValue(sheet.getRow(i).getCell(1)).contains(expectedTestName)) {
				sheet.getRow(i).getCell(4).setCellValue(status);
			}
		}
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to close excel workbook
	 */
	public void closeWorkbook() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
