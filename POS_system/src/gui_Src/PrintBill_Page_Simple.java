package gui_Src;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PrintBill_Page_Simple implements ActionListener {

	private JFrame printSimpleBill;
	private JButton backBtn;
	private JTable table;
	
	private String menuInfo[] = {"총액 영수증", "자세한 영수증"};
	private String tap[] = {"Table", "AllCost"};
	private String column[] = new String[2];
	private String tableNum;
	
	private DefaultTableModel model;
	private Seperate_ seperateData = new Seperate_();

	
	public PrintBill_Page_Simple(String tableNum) {
		this.tableNum = tableNum;
		initialize();
		printSimpleBill.setVisible(true);
	}

	
	private void initialize() {
		printSimpleBill = new JFrame("간단한 영수증");
		printSimpleBill.getContentPane().setBackground(Color.WHITE);
		printSimpleBill.getContentPane().setLayout(null);
		printSimpleBill.setBounds(100, 100, 460, 268);
		printSimpleBill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		printSimpleBill.setLocationRelativeTo(null);
		printSimpleBill.setResizable(false);
		
		JPanel infoPan = new JPanel();
		infoPan.setBounds(12, 10, 420, 49);
		infoPan.setBorder(new LineBorder(Color.RED));
		infoPan.setBackground(Color.WHITE);
		printSimpleBill.getContentPane().add(infoPan);
		infoPan.setLayout(null);
		
		JLabel label = new JLabel("총액 영수증");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(126, 10, 142, 29);
		infoPan.add(label);
		
		JScrollPane tablePan = new JScrollPane();
		tablePan.setViewportBorder(new LineBorder(Color.WHITE));
		tablePan.setBounds(12, 64, 420, 101);
		printSimpleBill.getContentPane().add(tablePan);
		
		model = new DefaultTableModel(tap, 0);
		
		table = new JTable(model);
		table.setFont(new Font("굴림", Font.BOLD, 15));
		tablePan.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(Color.RED));
		table.setBackground(Color.WHITE);
		
		JPanel funcPan = new JPanel();
		funcPan.setBounds(12, 175, 420, 49);
		funcPan.setBorder(new LineBorder(Color.RED));
		funcPan.setBackground(Color.WHITE);
		printSimpleBill.getContentPane().add(funcPan);
		funcPan.setLayout(null);
		
		backBtn = new JButton("뒤로");
		backBtn.setBackground(new Color(255,255,255));
		backBtn.addActionListener(this);
		backBtn.setBounds(126, 10, 142, 29);
		
		funcPan.add(backBtn);
		
		
		column[0] = tableNum;
		column[1] = Integer.toString(seperateData.byTableSale(tableNum));
		
		model.addRow(column);
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == backBtn) {
			printSimpleBill.dispose();
		}
		
	}
}
