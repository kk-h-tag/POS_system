package func_Src;

import java.util.Vector;
import gui_Src.*;

public class Compare_Stock {
	
	private Excel_Read readData = new Excel_Read();
	private Excel_Change changeData = new Excel_Change();
	
	private Vector<Stock_Data> stockData = new Vector<Stock_Data>();
	private Vector<Order_Data> orderData = new Vector<Order_Data>();
	
	private int count[] = new int[12];
	private String menuInfo[] = {"º±≈√","Ribeye", "Strip", "Sirloin", "T-Bone", "Toowoo", "Tomato", "Olive", "Rose", "M-Soup", "C-Soup", "Coke", "Sprite"};
	
	public void compareStock(Vector<Order_Data> orderData) {
		
		this.orderData = orderData;
		
		for(int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		
		for(int j = 0; j < orderData.size(); j++) {
			for(int menuNum = 0; menuNum < menuInfo.length; menuNum++) {
				if(orderData.elementAt(j).menuName.equals(menuInfo[menuNum])) {
					count[menuNum]++;
				}
			}
		}
		for(int k = 0; k < count.length;k++) {
			if(count[k] != 0) {
				changeData.reduceStock(menuInfo[k], count[k]);
			}
		}
		
		this.stockData = readData.excel_ReadchangeStock();
		for(int l = 0; l < stockData.size(); l++) {
			if(stockData.elementAt(l).menuStock < 10) {
				Warning_Page warning = new Warning_Page(stockData.elementAt(l).menuName);
			}
		}
		
	}
}
