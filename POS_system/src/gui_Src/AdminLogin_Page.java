package gui_Src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AdminLogin_Page implements ActionListener{

	private JFrame adminLogin;
	private JButton loginBtn;
	private JTextField textId;
	private JPasswordField textPassWord;

	public AdminLogin_Page() {
		initialize();
		adminLogin.setVisible(true);
	}

	private void initialize() {
		adminLogin = new JFrame("관리자모드 로그인");
		adminLogin.getContentPane().setBackground(Color.WHITE);
		adminLogin.setBounds(100, 100, 450, 300);
		adminLogin.setAlwaysOnTop(true);
		adminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminLogin.getContentPane().setLayout(null);
		adminLogin.setResizable(false);
		adminLogin.setLocationRelativeTo(null);
		

		JPanel infoPan = new JPanel();
		infoPan.setLayout(null);
		infoPan.setBackground(Color.WHITE);
		infoPan.setBounds(90, 48, 249, 108);
		adminLogin.getContentPane().add(infoPan);

		JLabel id = new JLabel("Id");
		id.setBounds(0, 8, 70, 30);
		infoPan.add(id);

		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(89, 8, 120, 25);
		infoPan.add(textId);

		JLabel passWord = new JLabel("Password");
		passWord.setBounds(0, 58, 70, 30);
		infoPan.add(passWord);

		textPassWord = new JPasswordField();
		textPassWord.setColumns(10);
		textPassWord.setBounds(89, 63, 120, 25);
		infoPan.add(textPassWord);

		JPanel actPan = new JPanel();
		actPan.setLayout(null);
		actPan.setBackground(Color.WHITE);
		actPan.setBounds(90, 166, 235, 49);
		adminLogin.getContentPane().add(actPan);

		loginBtn = new JButton("Login");
		loginBtn.setBackground(new Color(255,255,255));
		
		loginBtn.setBounds(59, 10, 110, 30);
		loginBtn.addActionListener(this);
		actPan.add(loginBtn);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(textId.getText().equals("admin") && textPassWord.getText().equals("root")) {
			Admin_Page adminPage = new Admin_Page();
			adminLogin.dispose();
		}

	}
}
