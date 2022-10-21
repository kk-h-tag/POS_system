package func_Src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Change {

	private Excel_Read readData = new Excel_Read();
	private Excel_Write writeData = new Excel_Write();
	
	private Vector<Sales_Data> sales = new Vector<Sales_Data>();
	private Vector<Sales_Data> cashAll = new Vector<Sales_Data>();
	private Vector<Staff_Data> staff = new Vector<Staff_Data>();
	private Vector<Stock_Data> stock = new Vector<Stock_Data>();

	public void removeData(int sheetNum) {

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

		XSSFSheet sheet = excelData.getSheetAt(sheetNum);
		int numberOfRows = sheet.getPhysicalNumberOfRows();

		for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
			if(sheet.getRow(i) != null) {
				sheet.removeRow(sheet.getRow(i));
			}        
		}      

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

	public void removeForCost(String tableNum) {

		sales = readData.excel_ReadSales();

		for(int i = 0; i < sales.size(); i++) {
			if(sales.elementAt(i).tableNum.equals(tableNum)) {
				writeData.excel_WriteAllSales(sales.elementAt(i).tableNum ,sales.elementAt(i).menuName, Integer.toString(sales.elementAt(i).menuCost), Integer.toString(sales.elementAt(i).amount), sales.elementAt(i).date, Integer.toString(sales.elementAt(i).numOfMember));

			}
			else {
				Sales_Data cashData = new Sales_Data(sales.elementAt(i).tableNum ,sales.elementAt(i).menuName, sales.elementAt(i).menuCost, sales.elementAt(i).amount, sales.elementAt(i).date, sales.elementAt(i).numOfMember);
				cashAll.addElement(cashData);
			}
		}


		this.removeData(1);

		for(int i = 0; i < cashAll.size(); i++) {
			writeData.excel_WriteSales(cashAll.elementAt(i).tableNum ,cashAll.elementAt(i).menuName, Integer.toString(cashAll.elementAt(i).menuCost), Integer.toString(cashAll.elementAt(i).amount), cashAll.elementAt(i).date, Integer.toString(cashAll.elementAt(i).numOfMember));
		}
	}

	public void removeMenu(String tableNum, String menuName) {

		sales = readData.excel_ReadSales();
		for(int i = 0; i < sales.size(); i++) {
			if(sales.elementAt(i).tableNum.equals(tableNum) && sales.elementAt(i).menuName.equals(menuName)) {
				sales.removeElementAt(i);
			}
		}

		this.removeData(1);

		for(int i = 0; i < sales.size(); i++) {
			writeData.excel_WriteSales(sales.elementAt(i).tableNum, sales.elementAt(i).menuName , Integer.toString(sales.elementAt(i).menuCost), Integer.toString(sales.elementAt(i).amount), sales.elementAt(i).date, Integer.toString(sales.elementAt(i).numOfMember));
		}
	}

	public void changeStock() {

		stock = readData.excel_ReadtodayStock();

		this.removeData(3);

		for(int i = 0; i < stock.size(); i++) {
			writeData.excel_WriteStock(stock.elementAt(i).menuName, stock.elementAt(i).menuStock);
		}
	}

	public void reduceStock(String menuName, int count) {

		stock = readData.excel_ReadchangeStock();

		for(int i = 0; i < stock.size(); i++) {
			if(stock.elementAt(i).menuName.equals(menuName)) {
				stock.elementAt(i).menuStock -= count;
				break;
			}
		}

		this.removeData(3);

		for(int i = 0; i < stock.size(); i++) {
			writeData.excel_WriteStock(stock.elementAt(i).menuName, stock.elementAt(i).menuStock);
		}
	}

	public void addStock(String menuName, int count) {

		stock = readData.excel_ReadchangeStock();

		for(int i = 0; i < stock.size(); i++) {
			if(stock.elementAt(i).menuName.equals(menuName)) {
				stock.elementAt(i).menuStock += count;
				break;
			}
		}

		this.removeData(3);

		for(int i = 0; i < stock.size(); i++) {
			writeData.excel_WriteStock(stock.elementAt(i).menuName, stock.elementAt(i).menuStock);
		}
	}

	public void removeStaff(String staffName, String age, String gender) {

		staff = readData.excel_ReadStaff();

		for(int i = 0; i < staff.size(); i++) {
			if(staff.elementAt(i).staffName.equals(staffName) && staff.elementAt(i).age.equals(age) && staff.elementAt(i).gender.equals(gender)) {
				staff.removeElementAt(i);
			}
		}

		this.removeData(5);

		for(int i = 0; i < staff.size(); i++) {
			writeData.excel_WriteStaff(staff.elementAt(i).staffName, staff.elementAt(i).age,staff.elementAt(i).gender, staff.elementAt(i).divEmploy, Integer.toString(staff.elementAt(i).workHour));
		}	
	}

	public void changeWorkHour(String staffName, String age, int hour) {

		staff = readData.excel_ReadStaff();

		for(int i = 0; i < staff.size(); i++) {
			if(staff.elementAt(i).staffName.equals(staffName) && staff.elementAt(i).age.equals(age)) {
				staff.elementAt(i).workHour += hour;
				break;
			}
		}

		this.removeData(5);

		for(int i = 0; i < staff.size(); i++) {
			writeData.excel_WriteStaff(staff.elementAt(i).staffName, staff.elementAt(i).age,staff.elementAt(i).gender, staff.elementAt(i).divEmploy, Integer.toString(staff.elementAt(i).workHour));
		}

	}
}
