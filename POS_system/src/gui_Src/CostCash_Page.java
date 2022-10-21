package gui_Src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import func_Src.*;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;


import javax.swing.JTextField;
import javax.swing.JButton;

public class CostCash_Page implements ActionListener {

	private JFrame costCash;
	private JLabel changeMoney;
	private JButton costBtn;
	private JButton backBtn;
	private JTextField payedMoney0;
	
	private String tableNum;
	private int allCost;
	private int resultMoney;
	
	private Seperate_ seperateData = new Seperate_();
	private Excel_Change removeData = new Excel_Change();
	
	
	public CostCash_Page(String tableNum) {
		this.tableNum = tableNum;
		initialize();
		costCash.setVisible(true);
	}

	private void initialize() {
		costCash = new JFrame("현금결제");
		costCash.getContentPane().setBackground(Color.WHITE);
		costCash.getContentPane().setLayout(null);
		costCash.setBounds(100, 100, 500, 500);
		costCash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		costCash.setLocationRelativeTo(null);
		costCash.setResizable(false);
		
		JPanel infoPan = new JPanel();
		infoPan.setBorder(new LineBorder(Color.RED));
		infoPan.setBackground(Color.WHITE);
		infoPan.setBounds(12, 10, 460, 309);
		costCash.getContentPane().add(infoPan);
		infoPan.setLayout(null);
		
		JLabel infoLabel = new JLabel("현금결제");
		infoLabel.setBounds(160, 10, 125, 32);
		infoPan.add(infoLabel);
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel payMoneyInfo = new JLabel("내실돈 :");
		payMoneyInfo.setBounds(61, 62, 69, 32);
		infoPan.add(payMoneyInfo);
		
		allCost = seperateData.byTableSale(tableNum);
		
		JLabel payMoney = new JLabel(allCost+"원");
		payMoney.setHorizontalAlignment(SwingConstants.CENTER);
		payMoney.setBounds(224, 62, 142, 32);
		infoPan.add(payMoney);
		
		JLabel payedMoneyInfo = new JLabel("내신돈 :");
		payedMoneyInfo.setBounds(61, 134, 69, 32);
		infoPan.add(payedMoneyInfo);
		
		payedMoney0 = new JTextField();
		payedMoney0.setHorizontalAlignment(SwingConstants.CENTER);
		payedMoney0.setBounds(224, 134, 142, 32);
		infoPan.add(payedMoney0);
		payedMoney0.addActionListener(this);
		payedMoney0.setColumns(10);
		
		JLabel changeMoneyInfo = new JLabel("거스름돈 :");
		changeMoneyInfo.setBounds(61, 205, 69, 32);
		infoPan.add(changeMoneyInfo);
		
		
		changeMoney = new JLabel();
		changeMoney.setHorizontalAlignment(SwingConstants.CENTER);
		changeMoney.setBounds(224, 205, 142, 32);
		infoPan.add(changeMoney);
		
		JPanel funcPan = new JPanel();
		funcPan.setBorder(new LineBorder(Color.RED));
		funcPan.setBackground(Color.WHITE);
		funcPan.setBounds(12, 329, 460, 122);
		costCash.getContentPane().add(funcPan);
		funcPan.setLayout(null);
		
		costBtn = new JButton("결제");
		costBtn.setBackground(new Color(255,255,255));
		costBtn.setBounds(12, 24, 177, 72);
		costBtn.addActionListener(this);
		funcPan.setLayout(null);
		funcPan.add(costBtn);
		
		backBtn = new JButton("뒤로");
		backBtn.setBackground(Color.WHITE);
		backBtn.setBounds(271, 24, 177, 72);
		backBtn.addActionListener(this);
		funcPan.add(backBtn);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == payedMoney0) {
			resultMoney = Integer.parseInt(payedMoney0.getText()) - allCost;
			changeMoney.setText(resultMoney+"원");
		}
		else if(event.getSource() == costBtn) {
			removeData.removeForCost(tableNum);
			costCash.dispose();
		}
		else if(event.getSource() == backBtn) {
			costCash.dispose();
		}
		
	}
}
