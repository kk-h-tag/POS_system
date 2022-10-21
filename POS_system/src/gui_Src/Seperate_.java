package gui_Src;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;

import func_Src.*;

public class Seperate_ {

	private Vector<Sales_Data> salesData = new Excel_Read().excel_ReadSales();
	private Vector<Sales_Data> salesAllData = new Excel_Read().excel_ReadAllSales();
	private Vector<Stock_Data> stockData = new Excel_Read().excel_ReadchangeStock();

	private Vector<Sales_Data> tempVec = new Vector<Sales_Data>();
	private Vector<Date_Data> dateData = new Vector<Date_Data>();

	private SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA);

	private Date today = new Date();

	private String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
	private String month =Integer.toString(Calendar.getInstance().get(Calendar.MONTH)+ 1) ;
	private String date = myFormat.format(today);


	public Vector<Sales_Data> byTableNum(String tableNum){

		for(int i = 0; i < salesData.size(); i++) {
			if(salesData.elementAt(i).tableNum.equals(tableNum)) {
				Sales_Data temp = new Sales_Data (salesData.elementAt(i).tableNum, salesData.elementAt(i).menuName, salesData.elementAt(i).menuCost,salesData.elementAt(i).amount,salesData.elementAt(i).date,salesData.elementAt(i).numOfMember);
				tempVec.addElement(temp);
			}
		}

		return tempVec;
	}

	public int byTableSale(String tableNum) {

		int tableSale = 0;

		for(int i = 0; i < salesData.size();i++) {
			if(salesData.elementAt(i).tableNum.equals(tableNum)) {
				tableSale += salesData.elementAt(i).menuCost;
			}
		}

		return tableSale;
	}
	
	public int byTableSaleImmedi(Vector<Order_Data> order,String tableNum) {

		int tableSale = 0;

		for(int i = 0; i < order.size();i++) {
			if(order.elementAt(i).tableNum.equals(tableNum)) {
				tableSale += Integer.parseInt(order.elementAt(i).menuCost);
			}
		}

		return tableSale;
	}

	public int setMemberNum(String tableNum) {

		int memberNum = 0;

		for(int i = 0; i < salesData.size();i++) {
			if(salesData.elementAt(i).tableNum.equals(tableNum)) {
				memberNum = salesData.elementAt(i).numOfMember;
				break;
			}
		}

		return memberNum;
	}

	public int byMemberNum(String tableNum) {
		int divSale = 0;
		int allSale = 0;
		int memberNum = 0;

		memberNum = this.setMemberNum(tableNum);

		if(memberNum ==0) {
			divSale = 0;
		}
		else{
			for(int i = 0; i < salesData.size(); i++) {
				if(salesData.elementAt(i).tableNum.equals(tableNum)) {
					allSale += salesData.elementAt(i).menuCost;
				}
				divSale = allSale / memberNum;
			}
		}
		
		return divSale;
	}
	
	public int byMemberNumImmedi(Vector<Order_Data> order, int memberNum, String tableNum) {
		int divSale = 0;
		int allSale = 0;


		if(memberNum ==0) {
			divSale = 0;
		}
		else{
			for(int i = 0; i < order.size(); i++) {
				if(order.elementAt(i).tableNum.equals(tableNum)) {
					allSale += Integer.parseInt(order.elementAt(i).menuCost);
				}
				divSale = allSale / memberNum;
			}
		}
		return divSale;
	}


	public Vector<Date_Data> divDate(){

		for(int i = 0; i < salesAllData.size(); i++) {
			StringTokenizer st = new StringTokenizer(salesAllData.elementAt(i).date,"-");
			while(st.hasMoreTokens()) {
				String yearTemp = st.nextToken();
				String monthTemp = st.nextToken();
				String dayTemp = st.nextToken();

				Date_Data splitDate = new Date_Data(yearTemp, monthTemp, dayTemp);
				dateData.addElement(splitDate);
			}
		}

		return dateData;
	}

	public int byYear() {

		this.divDate();

		int yearSale = 0;

		for(int i = 0; i < salesAllData.size(); i++) {
			if(dateData.elementAt(i).year.equals(year)) {
				yearSale += salesAllData.elementAt(i).menuCost;
			}
		}

		return yearSale;
	}

	public int byMonth() {

		this.divDate();

		int monthSale = 0;

		for(int i = 0; i < salesAllData.size(); i++) {
			if(dateData.elementAt(i).month.equals(month)) {
				monthSale += salesAllData.elementAt(i).menuCost;
			}
		}
		return monthSale;
	}

	public int byDay() {

		this.divDate();

		int daySale = 0;

		for(int i = 0; i < salesAllData.size(); i++) {
			if(salesAllData.elementAt(i).date.equals(date)) {
				daySale += salesAllData.elementAt(i).menuCost;
			}
		}


		return daySale;
	}

	public int byMenuName(String menuName) {

		int menuSale = 0;

		for(int i = 0; i < salesAllData.size(); i++) {
			if(salesAllData.elementAt(i).menuName.equals(menuName)) {
				menuSale += salesAllData.elementAt(i).menuCost;
			}
		}
		return menuSale;
	}

	public int byStock(String menuName) {

		int menuAmount = 0;

		for(int i = 0; i < stockData.size(); i++) {
			if(stockData.elementAt(i).menuName.equals(menuName)) {
				menuAmount += stockData.elementAt(i).menuStock;
				break;
			}
		}
		return menuAmount;
	}
}
