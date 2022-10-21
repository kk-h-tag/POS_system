package func_Src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Write {

	public void excel_WriteId(String name, String id, String passWord) {

		XSSFWorkbook excelData = null;
		File file = new File("Excel_Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
			excelData = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = excelData.getSheetAt(0);
		int rowNum = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.createRow(rowNum + 1);
		
		row.createCell(0).setCellValue(name);
		row.createCell(1).setCellValue(id);
		row.createCell(2).setCellValue(passWord);
		

		try {
			FileOutputStream inputData = new FileOutputStream(file);
			excelData.write(inputData);
			inputData.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void excel_WriteSales(String tbNum, String name, String cost, String amount,String date, String numOfMember) {

		XSSFWorkbook excelData = null;
		File file = new File("Excel_Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
			excelData = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = excelData.getSheetAt(1);
		int rowNum = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.createRow(rowNum + 1);
		
		row.createCell(0).setCellValue(tbNum);
		row.createCell(1).setCellValue(name);
		row.createCell(2).setCellValue(cost);
		row.createCell(3).setCellValue(amount);
		row.createCell(4).setCellValue(date);
		row.createCell(5).setCellValue(numOfMember);
		
		try {
			FileOutputStream inputData = new FileOutputStream(file);
			excelData.write(inputData);
			inputData.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void excel_WriteAllSales(String tbNum, String name, String cost, String amount,String date,String numOfMember) {

		XSSFWorkbook excelData = null;
		File file = new File("Excel_Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
			excelData = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = excelData.getSheetAt(2);
		int rowNum = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.createRow(rowNum + 1);
		
		row.createCell(0).setCellValue(tbNum);
		row.createCell(1).setCellValue(name);
		row.createCell(2).setCellValue(cost);
		row.createCell(3).setCellValue(amount);
		row.createCell(4).setCellValue(date);
		row.createCell(5).setCellValue(numOfMember);
		
		try {
			FileOutputStream inputData = new FileOutputStream(file);
			excelData.write(inputData);
			inputData.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void excel_WriteStock(String menuName,int menuStock) {

		XSSFWorkbook excelData = null;
		File file = new File("Excel_Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
			excelData = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = excelData.getSheetAt(3);
		int rowNum = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.createRow(rowNum + 1);
		
		row.createCell(0).setCellValue(menuName);
		row.createCell(1).setCellValue(menuStock);
		
		try {
			FileOutputStream inputData = new FileOutputStream(file);
			excelData.write(inputData);
			inputData.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void excel_WriteStaff(String staffName, String age, String gender, String divEmploy, String workHour) {

		XSSFWorkbook excelData = null;
		File file = new File("Excel_Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
			excelData = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = excelData.getSheetAt(5);
		int rowNum = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.createRow(rowNum + 1);
		
		row.createCell(0).setCellValue(staffName);
		row.createCell(1).setCellValue(age);
		row.createCell(2).setCellValue(gender);
		row.createCell(3).setCellValue(divEmploy);
		row.createCell(4).setCellValue(workHour);
		
		try {
			FileOutputStream inputData = new FileOutputStream(file);
			excelData.write(inputData);
			inputData.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
