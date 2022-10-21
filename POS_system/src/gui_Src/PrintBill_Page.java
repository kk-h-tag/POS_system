package gui_Src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class PrintBill_Page implements ActionListener {

	private JFrame chosPrintBill;
	private JComboBox chosMenu;
	private JButton printBillBtn;
	
	private String menuInfo[] = {"총액 영수증", "자세한 영수증"};
	private String tap[] = new String[4];
	private String column[] = new String[4];
	
	private String tableNum;
	private DefaultTableModel model;
	
	public PrintBill_Page(String tableNum) {
		this.tableNum = tableNum;
		initialize();
		chosPrintBill.setVisible(true);
	}

	private void initialize() {
		chosPrintBill = new JFrame("영수증 선택");
		chosPrintBill.getContentPane().setBackground(Color.WHITE);
		chosPrintBill.getContentPane().setLayout(null);
		chosPrintBill.setBounds(100, 100, 460, 166);
		chosPrintBill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chosPrintBill.setLocationRelativeTo(null);
		chosPrintBill.setResizable(false);
		
		JPanel infoPan = new JPanel();
		infoPan.setBounds(12, 10, 420, 49);
		infoPan.setBorder(new LineBorder(Color.RED));
		infoPan.setBackground(Color.WHITE);
		chosPrintBill.getContentPane().add(infoPan);
		infoPan.setLayout(null);
		
		JLabel selectMenu = new JLabel("프린트할 영수증을 선택하세요 :");
		selectMenu.setHorizontalAlignment(SwingConstants.CENTER);
		selectMenu.setBounds(12, 10, 187, 32);
		infoPan.add(selectMenu);
		
		chosMenu = new JComboBox(menuInfo);
		chosMenu.setBounds(240, 16, 134, 21);
		chosMenu.addActionListener(this);
		infoPan.add(chosMenu);
	
		
		JPanel funcPan = new JPanel();
		funcPan.setBounds(12, 69, 420, 49);
		funcPan.setBorder(new LineBorder(Color.RED));
		funcPan.setBackground(Color.WHITE);
		chosPrintBill.getContentPane().add(funcPan);
		funcPan.setLayout(null);
		
		printBillBtn = new JButton("영수증 확인");
		printBillBtn.setBounds(111, 10, 156, 29);
		printBillBtn.addActionListener(this);
		funcPan.add(printBillBtn);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == printBillBtn) {
			if(chosMenu.getSelectedIndex() == 0) {
				PrintBill_Page_Simple simpleBill = new PrintBill_Page_Simple(tableNum);
				chosPrintBill.dispose();
			}
			else if(chosMenu.getSelectedIndex() == 1) {
				PrintBill_Page_Complex complexBill = new PrintBill_Page_Complex(tableNum);
				 chosPrintBill.dispose();
			}
		}
	}
}
