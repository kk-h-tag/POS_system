package gui_Src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import func_Src.*;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Color;
import javax.swing.*;
import javax.swing.ImageIcon;

public class Login_Page implements ActionListener{

	private JFrame loginPage;
	private JButton loginBtn;
	private JButton memberInBtn;
	private JTextField textId;
	private JPasswordField textPassword;

	private Excel_Read readData = new Excel_Read();
	private Excel_Change changeData = new Excel_Change();
	private Vector<Member_Data> data = new Vector<Member_Data>();
	
	public Login_Page() {
		initialize();
		loginPage.setVisible(true);
	}

	private void initialize() {
		loginPage = new JFrame();
		loginPage.getContentPane().setBackground(Color.WHITE);
		loginPage.setTitle("LogIn");
		loginPage.setBounds(100, 100, 400, 300);
		loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginPage.getContentPane().setLayout(null);
		loginPage.setLocationRelativeTo(null);
		loginPage.setResizable(false);
		
		JPanel top = new JPanel();
		top.setBackground(Color.WHITE);
		top.setBounds(75, 38, 249, 108);
		loginPage.getContentPane().add(top);
		top.setLayout(null);

		JLabel Id = new JLabel("Id");
		Id.setHorizontalAlignment(SwingConstants.CENTER);
		Id.setBounds(0, 8, 70, 30);
		top.add(Id);

		textId = new JTextField();
		textId.setBounds(89, 8, 120, 25);
		top.add(textId);
		textId.setColumns(10);

		JLabel Password = new JLabel("Password");
		Password.setHorizontalAlignment(SwingConstants.CENTER);
		Password.setBounds(0, 58, 70, 30);
		top.add(Password);

		textPassword = new JPasswordField();
		textPassword.setBounds(89, 63, 120, 25);
		top.add(textPassword);
		textPassword.setColumns(10);

		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(255,255,255));
		bottom.setBounds(75, 167, 235, 49);
		loginPage.getContentPane().add(bottom);
		bottom.setLayout(null);

		loginBtn = new JButton("Login");
		loginBtn.setBounds(0, 5, 110, 30);
		loginBtn.addActionListener(this);
		bottom.add(loginBtn);
		loginBtn.setBackground(Color.WHITE);

		memberInBtn = new JButton("MemberIn");
		memberInBtn.setBounds(122, 5, 110, 30);
		memberInBtn.addActionListener(this);
		bottom.add(memberInBtn);
		memberInBtn.setBackground(new Color(255,255,255));
		
		changeData.changeStock();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == loginBtn) {
			
			data = readData.excel_ReadId();
			
			for(int idNum = 0; idNum < data.size(); idNum++) {
				if((data.elementAt(idNum).id).equals(textId.getText()) && (data.elementAt(idNum).passWord).equals(textPassword.getText())) {
					Main_Page pos = new Main_Page(idNum);
					loginPage.dispose();;
					break;
				}
			}
		}
		else if(event.getSource() == memberInBtn) {
			MemberIn_Page memberIn = new MemberIn_Page();
			loginPage.dispose();;
		}
		
	}
}

