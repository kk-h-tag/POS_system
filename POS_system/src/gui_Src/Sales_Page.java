package gui_Src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class Sales_Page implements ActionListener {

	private JFrame sales;
	private JButton backBtn;
	private JComboBox menuSelec;
	private JLabel menuSaleInfo;
	
	private Seperate_ seperateData = new Seperate_();
	
	private String menuInfo[] = {"선택","Ribeye", "Strip", "Sirloin", "T-Bone", "Toowoo", "Tomato", "Olive", "Rose", "M-Soup", "C-Soup", "Coke", "Sprite"};
	private int todaySale;
	private int monthSale;
	private int yearSale;
	
	
	public Sales_Page() {
		initialize();
		sales.setVisible(true);
	}

	private void initialize() {
		sales = new JFrame("매출 확인");
		sales.getContentPane().setBackground(Color.WHITE);
		sales.getContentPane().setLayout(null);
		sales.setBounds(100, 100, 600, 600);
		sales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sales.setLocationRelativeTo(null);
		sales.setResizable(false);
		
		JPanel infoPan = new JPanel();
		infoPan.setBorder(new LineBorder(Color.RED));
		infoPan.setBackground(Color.WHITE);
		infoPan.setBounds(12, 10, 570, 454);
		sales.getContentPane().add(infoPan);
		infoPan.setLayout(null);
		
		JLabel salesInfo = new JLabel("매출 정보");
		salesInfo.setHorizontalAlignment(SwingConstants.CENTER);
		salesInfo.setBounds(215, 10, 114, 36);
		infoPan.add(salesInfo);
		
		JLabel todaySales = new JLabel("일 매출 :");
		todaySales.setFont(new Font("굴림", Font.BOLD, 15));
		todaySales.setHorizontalAlignment(SwingConstants.CENTER);
		todaySales.setBounds(12, 72, 114, 36);
		infoPan.add(todaySales);
		
		JLabel monthSales = new JLabel("월 매출 :");
		monthSales.setFont(new Font("굴림", Font.BOLD, 15));
		monthSales.setHorizontalAlignment(SwingConstants.CENTER);
		monthSales.setBounds(12, 162, 114, 36);
		infoPan.add(monthSales);
		
		JLabel yearSales = new JLabel("연 매출 :");
		yearSales.setFont(new Font("굴림", Font.BOLD, 15));
		yearSales.setHorizontalAlignment(SwingConstants.CENTER);
		yearSales.setBounds(12, 257, 114, 36);
		infoPan.add(yearSales);
		
		todaySale = seperateData.byDay();
		monthSale = seperateData.byMonth();
		yearSale = seperateData.byYear();
		
		JLabel menuSales = new JLabel("메뉴 매출 :");
		menuSales.setHorizontalAlignment(SwingConstants.CENTER);
		menuSales.setFont(new Font("굴림", Font.BOLD, 15));
		menuSales.setBounds(12, 353, 114, 36);
		infoPan.add(menuSales);
		
		JLabel todayInfo = new JLabel(todaySale + "원");
		todayInfo.setHorizontalAlignment(SwingConstants.CENTER);
		todayInfo.setBounds(184, 72, 341, 36);
		infoPan.add(todayInfo);
		
		JLabel monthInfo = new JLabel(monthSale + "원");
		monthInfo.setHorizontalAlignment(SwingConstants.CENTER);
		monthInfo.setBounds(184, 162, 341, 36);
		infoPan.add(monthInfo);
		
		JLabel yearInfo = new JLabel(yearSale + "원");
		yearInfo.setHorizontalAlignment(SwingConstants.CENTER);
		yearInfo.setBounds(184, 257, 341, 36);
		infoPan.add(yearInfo);
		
		menuSelec = new JComboBox(menuInfo);
		menuSelec.setBackground(new Color(255,255,255));
		menuSelec.setBounds(267, 324, 153, 36);
		menuSelec.addActionListener(this);
		infoPan.add(menuSelec);
		
		menuSaleInfo = new JLabel();
		menuSaleInfo.setHorizontalAlignment(SwingConstants.CENTER);
		menuSaleInfo.setBounds(184, 391, 341, 36);
		infoPan.add(menuSaleInfo);
		
		JPanel funcPan = new JPanel();
		funcPan.setBorder(new LineBorder(Color.RED));
		funcPan.setBackground(Color.WHITE);
		funcPan.setBounds(12, 474, 570, 87);
		sales.getContentPane().add(funcPan);
		funcPan.setLayout(null);
		
		backBtn = new JButton("뒤로");
		backBtn.setBackground(new Color(255,255,255));
		backBtn.setBounds(143, 10, 257, 67);
		backBtn.addActionListener(this);
		funcPan.add(backBtn);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == backBtn) {
			sales.dispose();
		}
		else if(event.getSource() == menuSelec) {
			int menuSale;
			menuSale = seperateData.byMenuName((String)menuSelec.getSelectedItem());
			menuSaleInfo.setText(menuSale + "원");
		}
	}
}
