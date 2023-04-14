package com.opencart.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.opencart.utility.NewExcelLibrary;


public class dataProviderExcel {

	public static String excelPath = System.getProperty("user.dir") + "\\TestData.xlsx";
	

	//dataprovider without hashmap to create account
	@DataProvider(name = "testDataInput")
	// public Object[][] getTestData(String sheetName) throws IOException {
	public Object[][] getTestData() throws IOException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook book = new XSSFWorkbook(file);

		// XSSFSheet sheet = book.getSheet(sheetName);
		XSSFSheet sheet = book.getSheet("sheet2");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 System.out.println("----row n.o is -----"+sheet.getLastRowNum() + "--Column n.o is------" +
		 sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k] + "   ");
			}
			System.out.println();
		}
		return data;

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>dataprovider with hashmap to create account
	@DataProvider(name = "HM")
	// public Object[][] getTestData(String sheetName) throws IOException {
	public Object[][] getTestDataHM() throws IOException {
		HashMap<String, String> hashMap = new HashMap<String,String>();
		FileInputStream file = null;
		try {
			file = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook book = new XSSFWorkbook(file);

		// XSSFSheet sheet = book.getSheet(sheetName);
		XSSFSheet sheet = book.getSheet("sheet2");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 System.out.println(sheet.getLastRowNum() + "--row number ------" +
		 sheet.getRow(0).getLastCellNum()+"this is column n.o");
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				hashMap.put(sheet.getRow(i).getCell(k).toString(), 
							sheet.getRow(i + 1).getCell(k).toString());
				//data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				//System.out.println(data[i][k] + "   ");
			}
			for(String i1 :hashMap.keySet())
			{
				System.out.println(hashMap.get(i1));
			}
			//System.out.println();
		}
		return new Object[][]{ 
			{hashMap}
			};
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//>>>>>>>>>now we'll use NewExcelLibrary to initialize excel sheet and retrieve data
	//
	//
	//
	//
	
	
	NewExcelLibrary obj = new NewExcelLibrary();
	
	//data provider reading data from NewExcelLibrary
	//dataprovider without hashmap to create account
	@DataProvider(name = "testDataInputNewExcelLibrary")
	// public Object[][] getTestData(String sheetName) throws IOException {
	public Object[][] getTestDataNewExcelLibrary() throws IOException {
		int rows = obj.getRowCount("Sheet2");
		int column = obj.getColumnCount("Sheet2");
		
		int actRows = rows - 1 ;
		
		/*
		FileInputStream file = null;
		try {
			file = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook book = new XSSFWorkbook(file);

		// XSSFSheet sheet = book.getSheet(sheetName);
		XSSFSheet sheet = book.getSheet("sheet2");
		*/
		
		Object[][] data = new Object[actRows][column];

		
		//Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 //System.out.println("----row n.o is -----"+sheet.getLastRowNum() + "--Column n.o is------" +
		 //sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < actRows; i++) {
			for (int k = 0; k < column; k++) {
				data[i][k] = obj.getCellData("Sheet2", k, i+2);
				System.out.println(data[i][k] + "   ");
			}
			System.out.println();
		}
		return data;

	}
	
	
	
	
	
	

	
	//dataprovider with hashmap to create account
	@DataProvider(name = "dPwith_NEL_HMap")
	// public Object[][] getTestData(String sheetName) throws IOException {
	public Object[][] getTestDataNewExcelLibrary_NEL_HMap() throws IOException {
		HashMap<String, String> hashMap12 = new HashMap<String,String>();
		int rows = obj.getRowCount("Sheet2");
		int column = obj.getColumnCount("Sheet2");
		
		int actRows = rows - 1 ;
		
		/*
		FileInputStream file = null;
		try {
			file = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook book = new XSSFWorkbook(file);

		// XSSFSheet sheet = book.getSheet(sheetName);
		XSSFSheet sheet = book.getSheet("sheet2");
		*/
		
		Object[][] data = new Object[actRows][column];

		
		//Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 //System.out.println("----row n.o is -----"+sheet.getLastRowNum() + "--Column n.o is------" +
		 //sheet.getRow(0).getLastCellNum());
		
		for (int i = 0; i < actRows; i++) {
			for (int k = 0; k < column; k++) {
				hashMap12.put(obj.getCellData("Sheet2", k, i+1), 
						obj.getCellData("Sheet2", k, i+2));
			//data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			//System.out.println(data[i][k] + "   ");
		}
		for(String i1 :hashMap12.keySet())
		{
			System.out.println(hashMap12.get(i1));
		}
		//System.out.println();
	}
	return new Object[][]{ 
		{hashMap12}
		};

	}	
	
	
	
}

