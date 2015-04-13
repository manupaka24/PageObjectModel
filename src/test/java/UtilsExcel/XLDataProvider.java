package UtilsExcel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLDataProvider {
	
	static XSSFWorkbook wb = null;
	static XSSFSheet ws = null;
	static XSSFCell cell = null;
	
	
	public Object[][] Data(String FilePath, String SheetName) throws IOException {
		
		FileInputStream fis = new FileInputStream(FilePath);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(SheetName);
		
		int rowNum = ws.getLastRowNum() + 1;
		System.out.println("Number of rows: " + rowNum);
		int colNum = ws.getRow(0).getLastCellNum();
		System.out.println("Number of columns: " + colNum);
		int ci = 0;
		int cj;
		Object[][] dArray = new Object[rowNum-1][colNum];
		
		for (int i=1; i<rowNum; i++, ci++) {
		cj = 0;
			for (int j=0; j<colNum; j++, cj++) {
				dArray[ci][cj] = getCellData(i, j);
				System.out.println(dArray[ci][cj]);
			}
		}
		return dArray;
	}
	

	public static String getCellData(int nRow, int nCol) {
		
		cell = ws.getRow(nRow).getCell(nCol);
		String iCon = cellToString(cell);
		//String iCell = Cell.getStringCellValue();
		//String iCon = cellToString(iCell);
		
		return iCon;	
		/*
		int dataType = Cell.getCellType();
		if (dataType == 0) {	
			return "";
		}
		else {	
			String cellData = Cell.getStringCellValue();
			return cellData;
		}	*/
	}
	
	private static String cellToString(XSSFCell cell) {
	
		int type;
		Object result;
		type = cell.getCellType();
		
		switch(type) {	
		case 0 :
			result = cell.getNumericCellValue();
			break;
		case 1 :
			result = cell.getStringCellValue();
			break;
		default :
			throw new RuntimeException("There is no support for this type of cell");
		}
		return result.toString();
	}
	
	
	
	
	
}
