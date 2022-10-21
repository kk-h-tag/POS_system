package gui_Src;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

import func_Src.Excel_Write;

import java.awt.Font;
import javax.swing.JLabel;


public class MemberIn_Page {

	private JFrame memberIn;
	private JLabel name;
	private JLabel member;
	private JLabel id;
	private JLabel password;
	private JTextField input_Name;
	private JTextField input_Id;
	private JTextField input_Password;

	private Excel_Write addMember = new Excel_Write();

	public JFrame getMemberFrame() {
		return memberIn;
	}

	public MemberIn_Page() {
		initialize();
		memberIn.setVisible(true);
	}


	private void initialize() {
		memberIn = new JFrame();
		memberIn.setTitle("MemberIn");
		memberIn.getContentPane().setBackground(Color.WHITE);
		memberIn.setBounds(100, 100, 450, 315);
		memberIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		memberIn.getContentPane().setLayout(null);
		memberIn.setLocationRelativeTo(null);
		memberIn.setResizable(false);

		member = new JLabel();
		member.setHorizontalAlignment(SwingConstants.CENTER);
		member.setText("회원가입");
		member.setBorder(null);
		member.setBounds(144, 10, 110, 30);
		memberIn.getContentPane().add(member);

		name = new JLabel();
		name.setForeground(Color.BLACK);
		name.setFont(new Font("굴림", Font.PLAIN, 14));
		name.setText("회사명 :");
		name.setBounds(121, 68, 70, 30);
		name.setBorder(null);
		memberIn.getContentPane().add(name);

		id = new JLabel();
		id.setFont(new Font("굴림", Font.PLAIN, 14));
		id.setText("아이디 :");
		id.setBounds(121, 121, 70, 30);
		id.setBorder(null);
		memberIn.getContentPane().add(id);

		password = new JLabel();
		password.setFont(new Font("굴림", Font.PLAIN, 13));
		password.setText("패스워드 :");
		password.setBorder(null);
		password.setBounds(121, 172, 70, 30);
		memberIn.getContentPane().add(password);

		input_Name = new JTextField();
		input_Name.setBackground(Color.WHITE);
		input_Name.setHorizontalAlignment(SwingConstants.LEFT);
		input_Name.setBorder(new LineBorder(new Color(0, 0, 0)));
		input_Name.setBounds(203, 68, 110, 30);
		input_Name.setColumns(10);
		memberIn.getContentPane().add(input_Name);

		input_Id = new JTextField();
		input_Id.setBorder(new LineBorder(new Color(0, 0, 0)));
		input_Id.setBounds(203, 121, 110, 30);
		input_Id.setColumns(10);
		memberIn.getContentPane().add(input_Id);


		input_Password = new JTextField();
		input_Password.setBorder(new LineBorder(new Color(0, 0, 0)));
		input_Password.setBounds(203, 172, 110, 30);
		input_Password.setColumns(10);
		memberIn.getContentPane().add(input_Password);

		JButton member_Btn = new JButton("회원가입");
		member_Btn.setBackground(new Color(255,255,255));
		member_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Page loginPage = new Login_Page();
				memberIn.setVisible(false);
				addMember.excel_WriteId(input_Name.getText(), input_Id.getText(), input_Password.getText());
			}
		});
		member_Btn.setBounds(144, 230, 110, 30);
		memberIn.getContentPane().add(member_Btn);
	}
}
