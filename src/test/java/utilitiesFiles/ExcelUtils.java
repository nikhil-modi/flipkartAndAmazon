package utilitiesFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String excelFile, String Sheet) throws IOException {
		fis = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(Sheet);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
	}
	
	public static int getCellCount(String excelFile, String Sheet, int rowCount) throws IOException {
		fis = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(Sheet);
		row  = sheet.getRow(rowCount);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;
	}
	
	public static String getCellData(String excelFile, String Sheet, int rowCount, int cellCount) throws IOException {
		fis = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fis);
		sheet  = workbook.getSheet(Sheet);
		row = sheet.getRow(rowCount);
		cell = row.getCell(cellCount);
		String data;
		
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e) {
			data = "";
		}
		workbook.close();
		fis.close();
		return data;
	}
	
	public static void setCellData(String excelFile, String Sheet, int rowCount, int colCount, String data) throws IOException {
		fis = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(Sheet);
		row = sheet.getRow(rowCount);
		cell = row.getCell(colCount);
		fos = new FileOutputStream(excelFile);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}

}
