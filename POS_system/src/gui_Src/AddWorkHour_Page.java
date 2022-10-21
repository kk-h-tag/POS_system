package gui_Src;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import func_Src.*;

public class AddWorkHour_Page implements ActionListener{

	private JFrame addWorkHour;
	private JTextField input_TodayWorkHour;
	private JButton confBtn;
	
	private String staffName;
	private String age;
	
	private Excel_Change change = new Excel_Change();
	
	public AddWorkHour_Page(String staffName, String age) {
		
		this.staffName = staffName;
		this.age = age;
		initialize();
		addWorkHour.setVisible(true);
	}

	private void initialize() {
		addWorkHour = new JFrame("일한 시간 추가");
		addWorkHour.getContentPane().setBackground(Color.WHITE);
		addWorkHour.getContentPane().setLayout(null);	
		addWorkHour.setBounds(100, 100, 300, 170);
		addWorkHour.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWorkHour.setResizable(false);
		addWorkHour.setLocationRelativeTo(null);
		
		JLabel infoLabel = new JLabel("오늘 일한 시간 :");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setBounds(12, 10, 116, 40);
		addWorkHour.getContentPane().add(infoLabel);
		
		input_TodayWorkHour = new JTextField();
		input_TodayWorkHour.setHorizontalAlignment(SwingConstants.LEFT);
		input_TodayWorkHour.setFont(new Font("굴림", Font.PLAIN, 13));
		input_TodayWorkHour.setBounds(152, 10, 116, 40);
		addWorkHour.getContentPane().add(input_TodayWorkHour);
		input_TodayWorkHour.setColumns(10);
		
		confBtn = new JButton("고생했어욘");
		confBtn.setBackground(new Color(255,255,255));
		confBtn.setBounds(65, 77, 154, 34);
		confBtn.addActionListener(this);
		addWorkHour.getContentPane().add(confBtn);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == confBtn) {
			
			change.changeWorkHour(staffName, age, Integer.parseInt(input_TodayWorkHour.getText()));
			StaffManage_Page manage = new StaffManage_Page();
			addWorkHour.dispose();
			
		}
	}
}
