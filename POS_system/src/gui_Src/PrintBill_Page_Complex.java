package gui_Src;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import func_Src.Sales_Data;

import javax.swing.JButton;

public class PrintBill_Page_Complex implements ActionListener {

	private JFrame printComplexBIll;
	private JTable table;
	private JButton backBtn;

	private String tap[] =  {"Table", "MenuName", "MenuCost", "Amount"};
	private String column[] = new String[4];

	private String tableNum;
	private DefaultTableModel model;
	private Vector<Sales_Data> data = new Vector<Sales_Data>();
	private Seperate_ seperateData = new Seperate_();

	public PrintBill_Page_Complex(String tableNum) {
		this.tableNum = tableNum;
		initialize();
		printComplexBIll.setVisible(true);
	}


	private void initialize() {
		printComplexBIll = new JFrame("영수증 선택");
		printComplexBIll.getContentPane().setBackground(Color.WHITE);
		printComplexBIll.getContentPane().setLayout(null);
		printComplexBIll.setBounds(100, 100, 460, 600);
		printComplexBIll.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		printComplexBIll.setResizable(false);
		printComplexBIll.setLocationRelativeTo(null);
		

		JPanel infoPan = new JPanel();
		infoPan.setBounds(12, 10, 420, 49);
		infoPan.setBorder(new LineBorder(Color.RED));
		infoPan.setBackground(Color.WHITE);
		printComplexBIll.getContentPane().add(infoPan);
		infoPan.setLayout(null);

		JLabel infoLabel = new JLabel("자세한 영수증");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setBounds(130, 10, 142, 29);
		infoPan.add(infoLabel);

		JScrollPane tablePan = new JScrollPane();
		tablePan.setViewportBorder(new LineBorder(Color.WHITE));
		tablePan.setBounds(12, 64, 420, 430);
		printComplexBIll.getContentPane().add(tablePan);

		model = new DefaultTableModel(tap, 0);

		table = new JTable(model);
		tablePan.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(Color.RED));
		table.setBackground(Color.WHITE);

		JPanel funcPan = new JPanel();
		funcPan.setBounds(12, 502, 420, 49);
		funcPan.setBorder(new LineBorder(Color.RED));
		funcPan.setBackground(Color.WHITE);
		printComplexBIll.getContentPane().add(funcPan);
		funcPan.setLayout(null);

		backBtn = new JButton("back");
		backBtn.setBounds(130, 10, 142, 29);
		backBtn.addActionListener(this);
		funcPan.add(backBtn);
		

		data = seperateData.byTableNum(tableNum);

		for(int i = 0; i < data.size(); i++) {
			column[0] = tableNum;
			column[1] = data.elementAt(i).menuName;
			column[2] = Integer.toString(data.elementAt(i).menuCost);
			column[3] = Integer.toString(data.elementAt(i).amount);
			
			model.addRow(column);
		}
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == backBtn) {
			printComplexBIll.dispose();
		}

	}

}
