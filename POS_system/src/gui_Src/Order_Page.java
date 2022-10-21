package gui_Src;


import java.util.Vector;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import func_Src.*;

public class Order_Page implements ActionListener {

	private JFrame order;
	private JTable table;
	private JPanel menu;
	private JLabel numOfMember_In;
	private JLabel divideCost_In;
	private JLabel cost_In;
	
	private String date;
	private String numOfMember;
	
	
	private Excel_Write write = new Excel_Write();
	private Excel_Change removeData = new Excel_Change();
	private Compare_Stock compare = new Compare_Stock();
	private Seperate_ seperateData = new Seperate_();
	
	public Vector<Order_Data> temp = new Vector<Order_Data>();
	private Vector<Sales_Data> orderData = new Vector<Sales_Data>();

	private String tap[] = {"Table", "Menu", "Cost", "Amount", "º’¥‘ºˆ"};
	public String[] data = new String[5];
	private DefaultTableModel model;

	private JButton menu1;
	private JButton menu2;
	private JButton menu3;
	private JButton menu4;
	private JButton menu5;
	private JButton menu6;
	private JButton menu7;
	private JButton menu8;
	private JButton menu9;
	private JButton menu10;
	private JButton menu11;
	private JButton menu12;
	private JButton orderBtn;
	private JButton delBtn;
	private JButton exitBtn;
	

	private String tableNum;

	public Order_Page(JLabel numOfMember_In,JLabel divideCost_In, JLabel cost_In, String tableNum, String date, String numOfMember) {
		this.numOfMember_In = numOfMember_In;
		this.divideCost_In = divideCost_In;
		this.cost_In = cost_In;
		this.tableNum = tableNum;
		this.date = date;
		this.numOfMember = numOfMember;
		initialize();
		order.setVisible(true);
	}

	private void initialize() {	
		order = new JFrame();
		order.setTitle("¡÷πÆ");
		order.setBounds(100, 100, 999, 700);
		order.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		order.getContentPane().setBackground(Color.WHITE);
		order.getContentPane().setLayout(null);
		order.setResizable(false);
		order.setLocationRelativeTo(null);

		model = new DefaultTableModel(tap, 0);


		JScrollPane TablePane = new JScrollPane();
		TablePane.setViewportBorder(new LineBorder(Color.WHITE));
		TablePane.setBounds(0, 10, 371, 631);
		order.getContentPane().add(TablePane);

		table = new JTable(model);
		TablePane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(Color.RED));
		table.setBackground(Color.WHITE);

		menu = new JPanel();
		menu.setBounds(383, 10, 598, 490);
		menu.setBorder(new LineBorder(new Color(255, 0, 0)));
		menu.setBackground(Color.WHITE);
		order.getContentPane().add(menu);
		menu.setLayout(null);

		menu1 = new JButton("Ribeye");
		menu1.setBackground(new Color(255,255,255));
		menu1.addActionListener(this);
		menu1.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		menu1.setBounds(12, 10, 100, 100);
		menu.add(menu1);

		menu2 = new JButton("Strip");
		menu2.setBackground(new Color(255,255,255));
		menu2.addActionListener(this);
		menu2.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		menu2.setBounds(169, 10, 100, 100);
		menu.add(menu2);

		menu3 = new JButton("Sirloin");
		menu3.setBackground(new Color(255,255,255));
		menu3.addActionListener(this);
		menu3.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		menu3.setBounds(325, 10, 100, 100);
		menu.add(menu3);

		menu4 = new JButton("T-Bone");
		menu4.setBackground(new Color(255,255,255));
		menu4.addActionListener(this);
		menu4.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		menu4.setBounds(486, 10, 100, 100);
		menu.add(menu4);

		menu5 = new JButton("Toowoo");
		menu5.setBackground(new Color(255,255,255));
		menu5.addActionListener(this);
		menu5.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		menu5.setBounds(12, 194, 100, 100);
		menu.add(menu5);

		menu6 = new JButton("Tomato");
		menu6.setBackground(new Color(255,255,255));
		menu6.addActionListener(this);
		menu6.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		menu6.setBounds(169, 194, 100, 100);
		menu.add(menu6);

		menu7 = new JButton("Olive");
		menu7.setBackground(new Color(255,255,255));
		menu7.addActionListener(this);
		menu7.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		menu7.setBounds(325, 194, 100, 100);
		menu.add(menu7);

		menu8 = new JButton("Rose");
		menu8.setBackground(new Color(255,255,255));
		menu8.addActionListener(this);
		menu8.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		menu8.setBounds(486, 194, 100, 100);
		menu.add(menu8);

		menu9 = new JButton("M-Soup");
		menu9.setBackground(new Color(255,255,255));
		menu9.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		menu9.addActionListener(this);
		menu9.setBounds(12, 380, 100, 100);
		menu.add(menu9);

		menu10 = new JButton("C-Soup");
		menu10.setBackground(new Color(255,255,255));
		menu10.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		menu10.addActionListener(this);
		menu10.setBounds(169, 380, 100, 100);
		menu.add(menu10);

		menu11 = new JButton("Coke");
		menu11.setBackground(new Color(255,255,255));
		menu11.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		menu11.addActionListener(this);
		menu11.setBounds(325, 380, 100, 100);
		menu.add(menu11);

		menu12 = new JButton("Sprite");
		menu12.setBackground(new Color(255,255,255));
		menu12.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		menu12.addActionListener(this);
		menu12.setBounds(486, 380, 100, 100);
		menu.add(menu12);

		JPanel fuctionPan = new JPanel();
		fuctionPan.setBounds(600, 510, 381, 131);
		fuctionPan.setBorder(new LineBorder(Color.RED));
		fuctionPan.setBackground(Color.WHITE);
		order.getContentPane().add(fuctionPan);
		fuctionPan.setLayout(null);

		orderBtn = new JButton("¡÷πÆ");
		orderBtn.setBackground(new Color(255,255,255));
		orderBtn.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		orderBtn.setBounds(10, 10, 112, 111);
		orderBtn.addActionListener(this);
		fuctionPan.add(orderBtn);

		delBtn = new JButton("¡÷πÆ ªË¡¶");
		delBtn.setBackground(new Color(255,255,255));
		delBtn.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		delBtn.setBounds(134, 10, 112, 111);
		delBtn.addActionListener(this);
		fuctionPan.add(delBtn);

		exitBtn = new JButton("¡æ∑·");
		exitBtn.setBackground(new Color(255,255,255));
		exitBtn.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		exitBtn.setBounds(258, 10, 112, 111);
		exitBtn.addActionListener(this);
		fuctionPan.add(exitBtn);
		
		
		orderData = seperateData.byTableNum(tableNum);
		for(int i = 0;i < orderData.size(); i++) {
			data[0] = orderData.elementAt(i).tableNum;
			data[1] = orderData.elementAt(i).menuName;
			data[2] = Integer.toString(orderData.elementAt(i).menuCost);
			data[3] = Integer.toString(orderData.elementAt(i).amount);
			data[4] = Integer.toString(orderData.elementAt(i).numOfMember);
			
			model.addRow(data);
		}
	}

	@Override
	public void actionPerformed(ActionEvent click) {
		if(click.getSource() == menu1) {

			data[0] = tableNum;
			data[1] = "Ribeye";
			data[2] = "30000";
			data[3] = "1";
			data[4] = numOfMember;
			
			model.addRow(data);

			Order_Data tableData = new Order_Data(data[0],data[1],data[2],data[3],date, numOfMember);
			temp.addElement(tableData);
		}
		else if(click.getSource() == menu2) {

			data[0] = tableNum;
			data[1] = "Strip";
			data[2] = "25000";
			data[3] = "1";
			data[4] = numOfMember;
			
			model.addRow(data);

			Order_Data tableData = new Order_Data(data[0],data[1],data[2],data[3],date, numOfMember);
			temp.addElement(tableData);
		}
		else if(click.getSource() == menu3) {

			data[0] = tableNum;
			data[1] = "Sirloin";
			data[2] = "25000";
			data[3] = "1";
			data[4] = numOfMember;
			
			model.addRow(data);
			Order_Data tableData = new Order_Data(data[0],data[1],data[2],data[3],date, numOfMember);
			temp.addElement(tableData);
		}
		else if(click.getSource() == menu4) {

			data[0] = tableNum;
			data[1] = "T-Bone";
			data[2] = "20000";
			data[3] = "1";
			data[4] = numOfMember;
			
			model.addRow(data);

			Order_Data tableData = new Order_Data(data[0],data[1],data[2],data[3],date, numOfMember);
			temp.addElement(tableData);
		}
		else if(click.getSource() == menu5) {

			data[0] = tableNum;
			data[1] = "Toowoo";
			data[2] = "15000";
			data[3] = "1";
			data[4] = numOfMember;
			
			model.addRow(data);

			Order_Data tableData = new Order_Data(data[0],data[1],data[2],data[3],date, numOfMember);
			temp.addElement(tableData);
		}
		else if(click.getSource() == menu6) {

			data[0] = tableNum;
			data[1] = "Tomato";
			data[2] = "13000";
			data[3] = "1";
			data[4] = numOfMember;
			
			model.addRow(data);

			Order_Data tableData = new Order_Data(data[0],data[1],data[2],data[3],date, numOfMember);
			temp.addElement(tableData);
		}
		else if(click.getSource() == menu7) {

			data[0] = tableNum;
			data[1] = "Olive";
			data[2] = "10000";
			data[3] = "1";
			data[4] = numOfMember;
			
			model.addRow(data);

			Order_Data tableData = new Order_Data(data[0],data[1],data[2],data[3],date, numOfMember);
			temp.addElement(tableData);
		}
		else if(click.getSource() == menu8) {

			data[0] = tableNum;
			data[1] = "Rose";
			data[2] = "15000";
			data[3] = "1";
			data[4] = numOfMember;
			
			model.addRow(data);

			Order_Data tableData = new Order_Data(data[0],data[1],data[2],data[3],date, numOfMember);
			temp.addElement(tableData);
		}
		else if(click.getSource() == menu9) {

			data[0] = tableNum;
			data[1] = "M-Soup";
			data[2] = "3000";
			data[3] = "1";
			data[4] = numOfMember;
			
			model.addRow(data);

			Order_Data tableData = new Order_Data(data[0],data[1],data[2],data[3],date, numOfMember);
			temp.addElement(tableData);
		}
		else if(click.getSource() == menu10) {

			data[0] = tableNum;
			data[1] = "C-Soup";
			data[2] = "3000";
			data[3] = "1";
			data[4] = numOfMember;
			
			model.addRow(data);

			Order_Data tableData = new Order_Data(data[0],data[1],data[2],data[3],date, numOfMember);
			temp.addElement(tableData);
		}
		else if(click.getSource() == menu11) {

			data[0] = tableNum;
			data[1] = "Coke";
			data[2] = "2000";
			data[3] = "1";
			data[4] = numOfMember;
			
			model.addRow(data);

			Order_Data tableData = new Order_Data(data[0],data[1],data[2],data[3],date, numOfMember);
			temp.addElement(tableData);
		}
		else if(click.getSource() == menu12) {

			data[0] = tableNum;
			data[1] = "Sprite";
			data[2] = "3000";
			data[3] = "1";
			data[4] = numOfMember;
			
			model.addRow(data);

			Order_Data tableData = new Order_Data(data[0],data[1],data[2],data[3],date, numOfMember);
			temp.addElement(tableData);
		}
		else if(click.getSource() == orderBtn) {
			
			for(int i = 0; i < temp.size(); i++) {
				write.excel_WriteSales(temp.elementAt(i).tableNum ,temp.elementAt(i).menuName, temp.elementAt(i).menuCost, temp.elementAt(i).amount, temp.elementAt(i).date, temp.elementAt(i).numOfMember);
			}
		}
		else if(click.getSource() == delBtn) {
			int row = table.getSelectedRow();
			String tableNum = (String) table.getValueAt(row, 0);
			String selecMenu = (String) table.getValueAt(row, 1);
			removeData.removeMenu(tableNum, selecMenu);
			model.removeRow(row);
			
		}
		else if(click.getSource() == exitBtn) {
			compare.compareStock(temp);
			numOfMember_In.setText(numOfMember + "∏Ì");
			divideCost_In.setText(seperateData.byMemberNumImmedi(temp, Integer.parseInt(numOfMember) ,tableNum) + "ø¯");
			cost_In.setText(seperateData.byTableSaleImmedi(temp,tableNum) + "ø¯");
			order.dispose();
		}
	}
}