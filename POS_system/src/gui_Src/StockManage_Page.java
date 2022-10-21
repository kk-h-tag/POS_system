package gui_Src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import func_Src.*;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import javax.swing.JButton;

public class StockManage_Page implements ActionListener {

	private JFrame stockManage;
	private JComboBox choseMenu;
	private JLabel stockValue;

	private Seperate_ seperateData = new Seperate_();
	private Excel_Change changeData =new Excel_Change();
	

	private String menuInfo[] = {"선택","Ribeye", "Strip", "Sirloin", "T-Bone", "Toowoo", "Tomato", "Olive", "Rose", "M-Soup", "C-Soup", "Coke", "Sprite"};
	private JTextField inputStock;
	private JPanel funcPan;
	private JButton addStockBtn;

	public StockManage_Page() {
		initialize();
		stockManage.setVisible(true);
	}

	private void initialize() {
		stockManage = new JFrame("재고추가");
		stockManage.getContentPane().setBackground(Color.WHITE);
		stockManage.getContentPane().setLayout(null);
		stockManage.setBounds(100, 100, 379, 239);
		stockManage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stockManage.setResizable(false);
		stockManage.setLocationRelativeTo(null);
		

		JPanel infoPan = new JPanel();
		infoPan.setBorder(new LineBorder(new Color(255, 0, 0)));
		infoPan.setBackground(Color.WHITE);
		infoPan.setBounds(12, 10, 334, 117);
		stockManage.getContentPane().add(infoPan);
		infoPan.setLayout(null);

		choseMenu = new JComboBox(menuInfo);
		choseMenu.setBounds(102, 24, 127, 21);
		choseMenu.addActionListener(this);
		infoPan.add(choseMenu);

		stockValue = new JLabel("");
		stockValue.setHorizontalAlignment(SwingConstants.CENTER);
		stockValue.setBounds(12, 55, 127, 32);
		infoPan.add(stockValue);

		inputStock = new JTextField();
		inputStock.setBounds(195, 56, 127, 32);
		infoPan.add(inputStock);
		inputStock.setColumns(10);

		funcPan = new JPanel();
		funcPan.setBorder(new LineBorder(Color.RED));
		funcPan.setBackground(Color.WHITE);
		funcPan.setBounds(12, 134, 334, 56);
		stockManage.getContentPane().add(funcPan);
		funcPan.setLayout(null);

		addStockBtn = new JButton("재고 추가");
		addStockBtn.setBackground(Color.WHITE);
		addStockBtn.setBounds(89, 10, 157, 36);
		addStockBtn.addActionListener(this);
		funcPan.add(addStockBtn);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == choseMenu) {
			int menuStock;
			menuStock = seperateData.byStock((String)choseMenu.getSelectedItem());
			stockValue.setText(menuStock + "개");
		}
		else if(event.getSource() == addStockBtn) {
			if(inputStock.getText() != null) {
				changeData.addStock((String)choseMenu.getSelectedItem(), Integer.parseInt(inputStock.getText()));
			}
			stockManage.dispose();
		}

	}

}
