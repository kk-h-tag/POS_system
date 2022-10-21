package gui_Src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;

public class Admin_Page implements ActionListener{

	private JFrame adminPage;
	private JButton staffAdminBtn;
	private JButton stockAdminBtn;

	public Admin_Page() {
		initialize();
		adminPage.setVisible(true);
	}

	private void initialize() {
		adminPage = new JFrame("包府磊 葛靛");
		adminPage.getContentPane().setBackground(Color.WHITE);
		adminPage.getContentPane().setLayout(null);
		adminPage.setBounds(100, 100, 240, 149);
		adminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminPage.setLocationRelativeTo(null);
		adminPage.setResizable(false);
		
		
		staffAdminBtn = new JButton("流盔包府");
		staffAdminBtn.setBackground(new Color(255,255,255));
		staffAdminBtn.setBounds(12, 10, 100, 100);
		staffAdminBtn.addActionListener(this);
		adminPage.getContentPane().add(staffAdminBtn);
		
		stockAdminBtn = new JButton("犁绊包府");
		stockAdminBtn.setBackground(new Color(255,255,255));
		stockAdminBtn.setBounds(124, 10, 100, 100);
		stockAdminBtn.addActionListener(this);
		adminPage.getContentPane().add(stockAdminBtn);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == staffAdminBtn) {
			StaffManage_Page staffMan = new StaffManage_Page();
			adminPage.dispose();
		}
		else if(event.getSource() == stockAdminBtn) {
			StockManage_Page stockMan = new StockManage_Page();
			adminPage.dispose();
		}
		
	}
	
}
