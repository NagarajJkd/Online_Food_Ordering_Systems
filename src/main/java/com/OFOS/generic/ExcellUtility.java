package com.OFOS.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtility {
	
	public String readDataFromExcell(String Sheetname, int row, int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstantUtility.excellpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		String data = sh.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	

	public void writeDataBackToExcell(String sheetname, int row, int cell, String data) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstantUtility.excellpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		sh.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IPathConstantUtility.excellpath);
		wb.write(fos);
		wb.close();
	}
	
	
	public int getLastRowNumberFromExcell(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstantUtility.excellpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		return count;
	}
	
	public HashMap<String,String> getList(String sheetname, int keycell, int valuecell) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstantUtility.excellpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		HashMap<String, String> hs=new HashMap<String, String>();
		for (int i = 0; i <=count ; i++) {
			String key = sh.getRow(i).getCell(keycell).getStringCellValue();
			String value = sh.getRow(i).getCell(valuecell).getStringCellValue();
			hs.put(key, value);
		}
		
		return hs;
	}
	
	public ArrayList<String> getArrayList(String sheetname, int row, int cell) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstantUtility.excellpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		//String data = sh.getRow(row).getCell(cell).getStringCellValue();
		int count = sh.getLastRowNum();
		ArrayList<String> aList=new ArrayList<String>();
		for (int i = 0; i <count; i++) {
			String data = sh.getRow(i).getCell(cell).getStringCellValue();
			aList.add(data);
		}
		
		return aList;
	}
	
	
	/**
	 * This is the method to read the multiple set of date from excell
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleSetOfDataFromExcell(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstantUtility.excellpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		Object obj[][]=new Object[lastrow][lastcell];
		
		for (int i = 0; i <lastrow; i++) {
			for (int j = 0; j <lastcell; j++) {
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		return obj;
				
	}
}
