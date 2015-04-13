package UtilsExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.SheetBuilder;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AutoPages.A1_HomePageAT;

public class XLCreateSheet {
	
	public void createSheet(String filepath, String sheetName) throws IOException {
		
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.createSheet(sheetName);
	//	Row row = ws.createRow(0);
	//	Cell cell = row.createCell(0);
	//	cell.setCellValue(colName);
		FileOutputStream fos = new FileOutputStream(new File(filepath));
		wb.write(fos);
		fos.close();
		
	}
	
	public void createRow(String filepath, String sheetName, int rowNum) throws IOException {
		
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet ws = wb.getSheet(sheetName);
		Row row = ws.createRow(rowNum);
		
		FileOutputStream fos = new FileOutputStream(filepath);
		wb.write(fos);
		fos.close();
	}
	
	
	public void setColumnData(String filepath, String sheetName, int rowNum, int cellNum, String colName) throws IOException {
		
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet(sheetName);
	//	Row row = ws.createRow(0);
		
		Cell cell = ws.getRow(rowNum).createCell(cellNum);
		cell.setCellValue(colName);
		FileOutputStream fos = new FileOutputStream(new File(filepath));
		wb.write(fos);
		fos.close();
		
	}
	
	public void setColumnData(String filepath, int sheetNum, int rowNum, int cellNum, String colName) throws IOException {
		
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheetAt(sheetNum);
	//	Row row = ws.createRow(0);
		
		Cell cell = ws.getRow(rowNum).createCell(cellNum);
		cell.setCellValue(colName);
		FileOutputStream fos = new FileOutputStream(new File(filepath));
		wb.write(fos);
		fos.close();
		
	}
	
	public void getSheetIndex(String filepath, int indexNum) throws IOException {
		
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
	//	XSSFSheet ws = wb.getSheet(sheetName);
		
		String sheetName= wb.getSheetName(indexNum);
		System.out.println("The name of sheet at index " + indexNum + " is " + sheetName);	
	}
	
	public int getLastCellNum(String filepath, int sheetNum, int rowNum) throws IOException {
		
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheetAt(sheetNum);
		
		int cellNum = ws.getRow(rowNum).getLastCellNum();
		System.out.println("The number of last cell in row " + rowNum + " is " + cellNum);
		return cellNum;
	}

    public void writeDataToExcel(String filepath, String sheetName, int rowNum, int colNum, String data) throws IOException {
    	
    	FileInputStream fis = new FileInputStream(filepath);
    	XSSFWorkbook wb = new XSSFWorkbook(fis);
    	XSSFSheet ws = wb.getSheet(sheetName);
    	
    	Cell cell = ws.getRow(rowNum).createCell(colNum);
    	cell.setCellValue(data);

    	FileOutputStream fos = new FileOutputStream(new File(filepath));
    	wb.write(fos);
    	fos.close();

    }
    
    
    public String getCellData(String filepath, int sheetIndexNum, int rowNum, int colNum) throws IOException {
    	
    	FileInputStream fis = new FileInputStream(filepath);
    	XSSFWorkbook wb = new XSSFWorkbook(fis);
    	XSSFSheet ws = wb.getSheetAt(sheetIndexNum);
    	
    	String value = ws.getRow(rowNum).getCell(colNum).getStringCellValue();
    	
    	
    	System.out.println("The value at specified excesheet row and column is: " + value);
    	return value;
    }
    
    public String getCellData(String filepath, String sheetName, int rowNum, int colNum) throws IOException {
    	
    	FileInputStream fis = new FileInputStream(filepath);
    	XSSFWorkbook wb = new XSSFWorkbook(fis);
    	XSSFSheet ws = wb.getSheet(sheetName);
    	
    	String value = ws.getRow(rowNum).getCell(colNum).getStringCellValue();
    	
    	
    	System.out.println("The value at specified excesheet row and column is: " + value);
    	return value;
    }
    
    
    public int getTotalRows(String filepath, int sheetIndexNum) throws IOException {
    	
    	FileInputStream fis = new FileInputStream(filepath);
    	XSSFWorkbook wb = new XSSFWorkbook(fis);
    	XSSFSheet ws = wb.getSheetAt(sheetIndexNum);
    	
    	int totalRows = ws.getLastRowNum() + 1;
    	System.out.println("Total Number of rows: " + totalRows);
    	return totalRows;
    	
    }
    
	}