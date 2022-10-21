package gui_Src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Input_numOfmember_Page implements ActionListener {

	private JFrame inputNum;
	private JTextField input_numOfMember;
	private JButton confBtn;
	private JLabel numOfMember_In;
	private JLabel divideCost_In;
	private JLabel cost_In;
	
	private String tableNum;
	private String date;

	public Input_numOfmember_Page(JLabel numOfMember_In,JLabel divideCost_In, JLabel cost_In ,String tableNum, String date) {
		
		this.numOfMember_In = numOfMember_In;
		this.divideCost_In = divideCost_In;
		this.cost_In = cost_In;
		this.tableNum = tableNum;
		this.date = date;
		initialize();
		inputNum.setVisible(true);
	}


	private void initialize() {
		inputNum = new JFrame("¼Õ´Ô¼ö ÀÔ·Â");
		inputNum.getContentPane().setBackground(Color.WHITE);
		inputNum.getContentPane().setLayout(null);
		inputNum.setBounds(100, 100, 300, 170);
		inputNum.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputNum.setLocationRelativeTo(null);
		inputNum.setResizable(false);
		
		JLabel infoLabel = new JLabel("¼Õ´Ô ¼ö :");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setBounds(12, 10, 80, 40);
		inputNum.getContentPane().add(infoLabel);
		
		input_numOfMember = new JTextField();
		input_numOfMember.setHorizontalAlignment(SwingConstants.LEFT);
		input_numOfMember.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		input_numOfMember.setBounds(143, 10, 116, 40);
		inputNum.getContentPane().add(input_numOfMember);
		input_numOfMember.setColumns(10);
		
		confBtn = new JButton("È®ÀÎ");
		confBtn.setBackground(new Color(255,255,255));
		confBtn.setBounds(65, 77, 154, 34);
		confBtn.addActionListener(this);
		inputNum.getContentPane().add(confBtn);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == confBtn) {
			inputNum.dispose();
			Order_Page order = new Order_Page(numOfMember_In, divideCost_In, cost_In, tableNum, date,input_numOfMember.getText());
		}
	}
}
