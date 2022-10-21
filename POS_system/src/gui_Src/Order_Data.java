package gui_Src;


public class Order_Data {
	public String tableNum;
	public String menuName;
	public String menuCost;
	public String amount;
	public String date;
	public String numOfMember;
	
	public Order_Data(String tableNum, String menuName,	String menuCost, String amount,	String date, String numOfMember) {
		this.tableNum = tableNum;
		this.menuName = menuName;
		this.menuCost = menuCost;
		this.amount = amount;
		this.date = date;
		this.numOfMember = numOfMember;
	}

}
