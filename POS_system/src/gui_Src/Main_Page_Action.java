package gui_Src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main_Page_Action implements ActionListener{

	private JButton orderBtn;
	private JButton costCashBtn;
	private JButton costCardBtn;
	private JButton printBillBtn;
	private JLabel numOfMember_In;
	private JLabel divideCost_In;
	private JLabel cost_In;

	private String tableNum;
	private String date;
	
	
	public void dataInput(JButton orderBtn, JButton costCashBtn, JButton costCardBtn, JButton printBillBtn,JLabel numOfMember_In,JLabel divideCost_In, JLabel cost_In  ,String tableNum, String date) {
		this.orderBtn = orderBtn;
		this.costCashBtn = costCashBtn;
		this.costCardBtn = costCardBtn;
		this.printBillBtn = printBillBtn;
		this.numOfMember_In = numOfMember_In;
		this.divideCost_In = divideCost_In;
		this.cost_In = cost_In;
		this.tableNum = tableNum;
		this.date = date;
	}

	@Override
	public void actionPerformed(ActionEvent click_function) {
		if(click_function.getSource() == orderBtn) {
			Input_numOfmember_Page inputMember = new Input_numOfmember_Page(numOfMember_In, divideCost_In, cost_In,tableNum, date);
		}
		else if(click_function.getSource() == costCashBtn) {
			CostCash_Page cost = new CostCash_Page(tableNum);
		}
		else if(click_function.getSource() == costCardBtn) {
			CostCard_Page cost = new CostCard_Page(tableNum);
		}
		else if(click_function.getSource() == printBillBtn) {
			PrintBill_Page printBill = new PrintBill_Page(tableNum);
		}
	}
}
