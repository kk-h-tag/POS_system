package gui_Src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CalPay_Page implements ActionListener{

	private JFrame calPay;
	private JButton backBtn;
	
	private String staffName;
	private String age;
	private String gender;
	private String divEmploy;
	private int workHour;
	private int payMoney;

	public CalPay_Page(String staffName ,String age,String gender, String divEmploy, int workHour) {
		
		this.staffName = staffName;
		this.age = age;
		this.gender = gender;
		this.divEmploy = divEmploy;
		this.workHour = workHour;
		
		initialize();
		calPay.setVisible(true);
	}

	private void initialize() {
		calPay = new JFrame("급여 계산");
		calPay.getContentPane().setBackground(Color.WHITE);
		calPay.setBounds(100, 100, 500, 400);
		calPay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calPay.getContentPane().setLayout(null);
		calPay.setLocationRelativeTo(null);
		calPay.setResizable(false);
		
		JPanel infoPan = new JPanel();
		infoPan.setBorder(new LineBorder(Color.RED));
		infoPan.setBackground(Color.WHITE);
		infoPan.setBounds(12, 10, 460, 279);
		calPay.getContentPane().add(infoPan);
		infoPan.setLayout(null);
		
		JLabel nameInfo = new JLabel("이름 :");
		nameInfo.setBounds(12, 10, 122, 31);
		infoPan.add(nameInfo);
		
		JLabel ageInfo = new JLabel("나이 :");
		ageInfo.setBounds(12, 67, 122, 31);
		infoPan.add(ageInfo);
		
		JLabel genderInfo = new JLabel("성별 :");
		genderInfo.setBounds(12, 126, 122, 31);
		infoPan.add(genderInfo);
		
		JLabel divEmployInfo = new JLabel("구분 :");
		divEmployInfo.setBounds(12, 183, 122, 31);
		infoPan.add(divEmployInfo);
		
		JLabel payInfo = new JLabel("급여 :");
		payInfo.setBounds(12, 238, 122, 31);
		infoPan.add(payInfo);
		
		JLabel nameLabel = new JLabel(staffName +"");
		nameLabel.setBounds(193, 10, 122, 31);
		infoPan.add(nameLabel);
		
		JLabel ageLabel = new JLabel(age +"");
		ageLabel.setBounds(193, 75, 122, 31);
		infoPan.add(ageLabel);
		
		JLabel genderLabel = new JLabel(gender +"");
		genderLabel.setBounds(193, 134, 122, 31);
		infoPan.add(genderLabel);
		
		JLabel divLabel = new JLabel(divEmploy+"");
		divLabel.setBounds(193, 191, 122, 31);
		infoPan.add(divLabel);
		
		if(divEmploy.equals("Temp")) {
			payMoney = workHour * 7530;
		}
		else if(divEmploy.equals("Regular")) {
			payMoney = 2000000 + workHour * 7530;
		}
		
		JLabel payLabel = new JLabel(payMoney + "원");
		payLabel.setBounds(193, 238, 122, 31);
		infoPan.add(payLabel);
		
		
		JPanel funcPan = new JPanel();
		funcPan.setBorder(new LineBorder(Color.RED));
		funcPan.setBackground(Color.WHITE);
		funcPan.setBounds(287, 299, 185, 52);
		calPay.getContentPane().add(funcPan);
		funcPan.setLayout(null);
		
		backBtn = new JButton("많이많이버세요");
		backBtn.setBackground(new Color(255,255,255));
		backBtn.setBounds(12, 10, 161, 32);
		backBtn.addActionListener(this);
		funcPan.add(backBtn);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == backBtn) {
			calPay.dispose();
		}
		
	}

}
