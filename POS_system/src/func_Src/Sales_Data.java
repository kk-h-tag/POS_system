package func_Src;

public class Sales_Data {
	
	public String tableNum;
	public String menuName;
	public int menuCost;
	public int amount;
	public String date;
	public int numOfMember;
	
	public Sales_Data(String tableNum, String menuName, int menuCost, int amount, String date, int numOfMember) {
		this.tableNum = tableNum;
		this.menuName = menuName;
		this.menuCost = menuCost;
		this.amount = amount;
		this.date = date;
		this.numOfMember = numOfMember;
	}
}
