package gui_Src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import func_Src.*;


import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JButton;

public class StaffManage_Page implements ActionListener{

	private JFrame staffManage;
	private JTable table;
	private JPanel funcPan;
	private JButton addStaffBtn;
	private JButton delStaffBtn;
	private JButton calPayBtn;
	private JButton backBtn;
	private JButton addWorkHourBtn;
	
	private String tap[] =  {"이름", "나이", "성별", "구분", "근무시간(H)"};
	private String column[] = new String[5];

	private Vector<Staff_Data> data = new Vector<Staff_Data>();
	private Excel_Read readData = new Excel_Read();
	private Excel_Write writeData = new Excel_Write();
	private Excel_Change change = new Excel_Change();
	private DefaultTableModel model;
	
	
	

	public StaffManage_Page() {
		initialize();
		staffManage.setVisible(true);
	}

	private void initialize() {
		staffManage = new JFrame("직원 관리");
		staffManage.getContentPane().setBackground(Color.WHITE);
		staffManage.setBounds(100, 100, 800, 500);
		staffManage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		staffManage.getContentPane().setLayout(null);
		staffManage.setLocationRelativeTo(null);
		staffManage.setResizable(false);

		JScrollPane tablePan = new JScrollPane();
		tablePan.setBounds(12, 10, 575, 441);
		tablePan.setViewportBorder(new LineBorder(Color.WHITE));
		staffManage.getContentPane().add(tablePan);

		model = new DefaultTableModel(tap, 1);

		table = new JTable(model);
		tablePan.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(Color.RED));
		table.setBackground(Color.WHITE);

		data = readData.excel_ReadStaff();

		for(int i = 0;i < data.size(); i++) {
			column[0] = data.elementAt(i).staffName;
			column[1] = data.elementAt(i).age;
			column[2] = data.elementAt(i).gender;
			column[3] = data.elementAt(i).divEmploy;
			column[4] = Integer.toString(data.elementAt(i).workHour);

			model.addRow(column);
		}

		funcPan = new JPanel();
		funcPan.setBorder(new LineBorder(Color.RED));
		funcPan.setBackground(Color.WHITE);
		funcPan.setBounds(599, 10, 173, 441);
		staffManage.getContentPane().add(funcPan);
		funcPan.setLayout(null);

		addStaffBtn = new JButton("직원 추가");
		addStaffBtn.setToolTipText(
				"성별 : Male or Femail.\t\n" + 
				"구분 : Temp or Regular\t\n" + 
				"추가 하기 전에 엔터를 누른후 추가버튼을 클릭.");
		addStaffBtn.setBackground(new Color(255,255,255));
		addStaffBtn.setBounds(12, 10, 149, 53);
		addStaffBtn.addActionListener(this);
		funcPan.add(addStaffBtn);

		delStaffBtn = new JButton("직원 삭제");
		delStaffBtn.setBackground(new Color(255,255,255));
		delStaffBtn.setBounds(12, 102, 149, 53);
		delStaffBtn.addActionListener(this);
		funcPan.add(delStaffBtn);

		addWorkHourBtn = new JButton("근무시간 추가");
		addWorkHourBtn.setBackground(new Color(255,255,255));
		addWorkHourBtn.setBounds(12, 194, 149, 53);
		addWorkHourBtn.addActionListener(this);
		funcPan.add(addWorkHourBtn);

		calPayBtn = new JButton("급여 계산");
		calPayBtn.setBackground(new Color(255,255,255));
		calPayBtn.setBounds(12, 286, 149, 53);
		calPayBtn.addActionListener(this);
		funcPan.add(calPayBtn);

		backBtn = new JButton("뒤로 가기");
		backBtn.setBackground(new Color(255,255,255));
		backBtn.setBounds(12, 378, 149, 53);
		backBtn.addActionListener(this);
		funcPan.add(backBtn);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == addStaffBtn) {
			int row = table.getSelectedRow();
			
			String staffName =(String) table.getValueAt(row, 0);
			String age = (String) table.getValueAt(row, 1);
			String gender = (String) table.getValueAt(row, 2);
			String divEmploy = (String) table.getValueAt(row, 3);
			String workHour = (String) table.getValueAt(row, 4);

			writeData.excel_WriteStaff(staffName, age, gender, divEmploy, workHour);
			
			staffManage.dispose();
			StaffManage_Page page = new StaffManage_Page();
			
		}
		
		else if(event.getSource() == delStaffBtn) {
			
			int row = table.getSelectedRow();
			String staffName =(String) table.getValueAt(row, 0);
			String age = (String) table.getValueAt(row, 1);
			String gender = (String) table.getValueAt(row, 2);
			
			change.removeStaff(staffName, age, gender);
			model.removeRow(row);
		}
		
		else if(event.getSource() == addWorkHourBtn) {
			
			int row = table.getSelectedRow();
			String staffName =(String) table.getValueAt(row, 0);
			String age = (String) table.getValueAt(row, 1);
			
			AddWorkHour_Page addHour = new AddWorkHour_Page(staffName, age);
			staffManage.dispose();
		}
		
		else if(event.getSource() == calPayBtn) {
			
			int row = table.getSelectedRow();
			String staffName =(String) table.getValueAt(row, 0);
			String age = (String) table.getValueAt(row, 1);
			String gender = (String) table.getValueAt(row, 2);
			String divEmploy = (String) table.getValueAt(row, 3);
			String workHour = (String) table.getValueAt(row, 4);
			
			CalPay_Page calPay = new CalPay_Page(staffName, age, gender, divEmploy, Integer.parseInt(workHour));
		}
		
		else if(event.getSource() == backBtn) {
			staffManage.dispose();
		}

	}

}
