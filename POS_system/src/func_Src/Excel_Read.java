package func_Src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.poi.xssf.usermodel.*;


public class Excel_Read {

	private Vector<Member_Data> memberVec = new Vector<Member_Data>();
	private Vector<Sales_Data> salesVec = new Vector<Sales_Data>();
	private Vector<Sales_Data> salesAllVec = new Vector<Sales_Data>();
	private Vector<Staff_Data> staffVec = new Vector<Staff_Data>();
	private Vector<Stock_Data> stockVec = new Vector<Stock_Data>();
	private SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
	private String combineStr = "";


	public Vector<Member_Data> excel_ReadId() {

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
		int rowNum = sheet.getPhysicalNumberOfRows() + 1;
		for(int rowIndex = 1; rowIndex < rowNum; rowIndex++) {
			XSSFRow row = sheet.getRow(rowIndex);
			if(row != null) {
				int cellNum = row.getPhysicalNumberOfCells();
				for(int columnIndex = 0; columnIndex <= cellNum; columnIndex++) {
					XSSFCell cell = row.getCell(columnIndex);
					String data = "";
					if(cell == null) {
						continue;
					}
					else {
						switch(cell.getCellType()) {
						case XSSFCell.CELL_TYPE_BLANK :
							data = cell.getBooleanCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_NUMERIC :
							data = cell.getNumericCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_STRING :
							data = cell.getStringCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_ERROR :
							data = cell.getErrorCellValue() + "";
							break;
						}
						combineStr += data + "\t";
					}
				}
			}
		}
		StringTokenizer split = new StringTokenizer(combineStr);
		while(split.hasMoreTokens()) {
			String name = split.nextToken();
			String id = split.nextToken();
			String passWord = split.nextToken();

			Member_Data login_Data = new Member_Data(name, id, passWord);
			memberVec.addElement(login_Data);

		}


		return this.memberVec;
	}


	public Vector<Sales_Data> excel_ReadSales() {

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
		int rowNum = sheet.getPhysicalNumberOfRows() + 1;
		for(int rowIndex = 1; rowIndex < rowNum; rowIndex++) {
			XSSFRow row = sheet.getRow(rowIndex);
			if(row != null) {
				int cellNum = row.getPhysicalNumberOfCells();
				for(int columnIndex = 0; columnIndex <= cellNum; columnIndex++) {
					XSSFCell cell = row.getCell(columnIndex);
					String data = "";
					if(cell == null) {
						continue;
					}
					else {
						switch(cell.getCellType()) {
						case XSSFCell.CELL_TYPE_BLANK :
							data = cell.getBooleanCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_NUMERIC :
							data = cell.getNumericCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_STRING :
							data = cell.getStringCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_ERROR :
							data = cell.getErrorCellValue() + "";
							break;
						}
						combineStr += data + "\t";
					}
				}
			}
		}
		StringTokenizer split = new StringTokenizer(combineStr);
		while(split.hasMoreTokens()) {

			try {

				String tableNum = split.nextToken();
				String menuName = split.nextToken();
				int menuCost = Integer.parseInt(split.nextToken());
				int amount = Integer.parseInt(split.nextToken());
				Date tempdate = myFormat.parse(split.nextToken());
				int numOfMember = Integer.parseInt(split.nextToken());

				String date = myFormat.format(tempdate);

				Sales_Data orderData = new Sales_Data(tableNum, menuName, menuCost, amount, date, numOfMember);
				salesVec.addElement(orderData);

			} catch (ParseException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
		}
		
		return this.salesVec;
	}

	public Vector<Sales_Data> excel_ReadAllSales() {

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
		int rowNum = sheet.getPhysicalNumberOfRows() + 1;
		for(int rowIndex = 1; rowIndex < rowNum; rowIndex++) {
			XSSFRow row = sheet.getRow(rowIndex);
			if(row != null) {
				int cellNum = row.getPhysicalNumberOfCells();
				for(int columnIndex = 0; columnIndex <= cellNum; columnIndex++) {
					XSSFCell cell = row.getCell(columnIndex);
					String data = "";
					if(cell == null) {
						continue;
					}
					else {
						switch(cell.getCellType()) {
						case XSSFCell.CELL_TYPE_BLANK :
							data = cell.getBooleanCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_NUMERIC :
							data = cell.getNumericCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_STRING :
							data = cell.getStringCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_ERROR :
							data = cell.getErrorCellValue() + "";
							break;
						}
						combineStr += data + "\t";
					}
				}
			}
		}
		StringTokenizer split = new StringTokenizer(combineStr);
		while(split.hasMoreTokens()) {


			try {
				String tableNum = split.nextToken();
				String menuName = split.nextToken();
				int menuCost = Integer.parseInt(split.nextToken());
				int amount = Integer.parseInt(split.nextToken());
				Date data = myFormat.parse(split.nextToken());
				String date = myFormat.format(data);
				int numOfMember = Integer.parseInt(split.nextToken());

				Sales_Data salesData = new Sales_Data(tableNum, menuName, menuCost, amount, date, numOfMember);
				salesAllVec.addElement(salesData);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
			
		return this.salesAllVec;
	}

	public Vector<Stock_Data> excel_ReadchangeStock() {

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
		int rowNum = sheet.getPhysicalNumberOfRows() + 1;
		for(int rowIndex = 1; rowIndex < rowNum; rowIndex++) {
			XSSFRow row = sheet.getRow(rowIndex);
			if(row != null) {
				int cellNum = row.getPhysicalNumberOfCells();
				for(int columnIndex = 0; columnIndex <= cellNum; columnIndex++) {
					XSSFCell cell = row.getCell(columnIndex);
					String data = "";
					if(cell == null) {
						continue;
					}
					else {
						switch(cell.getCellType()) {
						case XSSFCell.CELL_TYPE_BLANK :
							data = cell.getBooleanCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_NUMERIC :
							data = cell.getNumericCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_STRING :
							data = cell.getStringCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_ERROR :
							data = cell.getErrorCellValue() + "";
							break;
						}
						combineStr += data + "\t";
					}
				}
			}
		}
		StringTokenizer split = new StringTokenizer(combineStr);
		while(split.hasMoreTokens()) {
			String menuName = split.nextToken();
			int menuStock = (int)Double.parseDouble(split.nextToken());

			Stock_Data staffData = new Stock_Data(menuName, menuStock);

			stockVec.addElement(staffData);
		}
		return this.stockVec;
	}

	public Vector<Stock_Data> excel_ReadtodayStock() {

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
		XSSFSheet sheet = excelData.getSheetAt(4);
		int rowNum = sheet.getPhysicalNumberOfRows() + 1;
		for(int rowIndex = 1; rowIndex < rowNum; rowIndex++) {
			XSSFRow row = sheet.getRow(rowIndex);
			if(row != null) {
				int cellNum = row.getPhysicalNumberOfCells();
				for(int columnIndex = 0; columnIndex <= cellNum; columnIndex++) {
					XSSFCell cell = row.getCell(columnIndex);
					String data = "";
					if(cell == null) {
						continue;
					}
					else {
						switch(cell.getCellType()) {
						case XSSFCell.CELL_TYPE_BLANK :
							data = cell.getBooleanCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_NUMERIC :
							data = cell.getNumericCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_STRING :
							data = cell.getStringCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_ERROR :
							data = cell.getErrorCellValue() + "";
							break;
						}
						combineStr += data + "\t";
					}
				}
			}
		}
		StringTokenizer split = new StringTokenizer(combineStr);
		while(split.hasMoreTokens()) {
			String menuName = split.nextToken();
			int menuStock = (int)Double.parseDouble(split.nextToken());

			Stock_Data staffData = new Stock_Data(menuName, menuStock);

			stockVec.addElement(staffData);
		}
		return this.stockVec;
	}

	public Vector<Staff_Data> excel_ReadStaff() {

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
		int rowNum = sheet.getPhysicalNumberOfRows() + 1;
		for(int rowIndex = 1; rowIndex < rowNum; rowIndex++) {
			XSSFRow row = sheet.getRow(rowIndex);
			if(row != null) {
				int cellNum = row.getPhysicalNumberOfCells();
				for(int columnIndex = 0; columnIndex <= cellNum; columnIndex++) {
					XSSFCell cell = row.getCell(columnIndex);
					String data = "";
					if(cell == null) {
						continue;
					}
					else {
						switch(cell.getCellType()) {
						case XSSFCell.CELL_TYPE_BLANK :
							data = cell.getBooleanCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_NUMERIC :
							data = cell.getNumericCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_STRING :
							data = cell.getStringCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_ERROR :
							data = cell.getErrorCellValue() + "";
							break;
						}
						combineStr += data + "\t";
					}
				}
			}
		}
		StringTokenizer split = new StringTokenizer(combineStr);
		while(split.hasMoreTokens()) {
			String staffName = split.nextToken();
			String age = split.nextToken();
			String gender = split.nextToken();
			String divEmploy = split.nextToken();
			int workHour = Integer.parseInt(split.nextToken());

			Staff_Data staffData = new Staff_Data(staffName, age, gender, divEmploy, workHour);

			staffVec.addElement(staffData);
		}
		return this.staffVec;
	}
}