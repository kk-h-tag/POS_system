package gui_Src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import func_Src.*;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class CostCard_Page implements ActionListener {

	private JFrame costCard;
	private JButton costBtn;
	private JButton backBtn;
	
	private String tableNum;
	private int allCost;
	private String card[] = {"BC카드", "국민카드", "카카오뱅크", "신한카드", "우리카드", "농협카드", "하나카드", "기업카드", "외환카드"};
	private String installment[] = {"1개월", "2개월", "3개월", "6개월", "12개월", "24개월"};
	
	private Excel_Change removeData = new Excel_Change();
	private Seperate_ seperateData = new Seperate_();
	
	public CostCard_Page(String tableNum) {
		this.tableNum = tableNum;
		initialize();
		costCard.setVisible(true);
	}

	private void initialize() {
		costCard = new JFrame("카드결제");
		costCard.getContentPane().setBackground(Color.WHITE);
		costCard.getContentPane().setLayout(null);
		costCard.setBounds(100, 100, 500, 500);
		costCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		costCard.setLocationRelativeTo(null);
		costCard.setResizable(false);
		
		JPanel infoPan = new JPanel();
		infoPan.setBorder(new LineBorder(Color.RED));
		infoPan.setBackground(Color.WHITE);
		infoPan.setBounds(12, 10, 460, 309);
		costCard.getContentPane().add(infoPan);
		infoPan.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("카드결제");
		lblNewLabel.setBounds(160, 10, 125, 32);
		infoPan.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel payMoney = new JLabel("내실돈 :");
		payMoney.setBounds(61, 62, 69, 32);
		infoPan.add(payMoney);
		
		allCost = seperateData.byTableSale(tableNum);
		
		JLabel payMoneyInfo = new JLabel(allCost+"원");
		payMoneyInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		payMoneyInfo.setBounds(224, 62, 118, 32);
		infoPan.add(payMoneyInfo);
		
		JLabel chooseCard = new JLabel("카드 선택");
		chooseCard.setBounds(61, 133, 69, 32);
		infoPan.add(chooseCard);
		
		JComboBox cardList = new JComboBox(card);
		cardList.setBackground(Color.WHITE);
		cardList.setBounds(217, 124, 159, 32);
		infoPan.add(cardList);
		
		JLabel chooseInstallment = new JLabel("할부 선택");
		chooseInstallment.setBounds(61, 211, 69, 32);
		infoPan.add(chooseInstallment);
		
		JComboBox installmentList = new JComboBox(installment);
		installmentList.setBackground(Color.WHITE);
		installmentList.setBounds(217, 211, 159, 32);
		infoPan.add(installmentList);
		
		JPanel funcPan = new JPanel();
		funcPan.setBorder(new LineBorder(Color.RED));
		funcPan.setBackground(Color.WHITE);
		funcPan.setBounds(12, 329, 460, 122);
		costCard.getContentPane().add(funcPan);
		
		costBtn = new JButton("결제");
		costBtn.setBackground(new Color(255,255,255));
		costBtn.setBounds(12, 24, 177, 72);
		costBtn.addActionListener(this);
		funcPan.setLayout(null);
		funcPan.add(costBtn);
		
		backBtn = new JButton("뒤로");
		backBtn.setBackground(Color.WHITE);
		backBtn.setBounds(271, 24, 177, 72);
		backBtn.addActionListener(this);
		funcPan.add(backBtn);
	}

	@Override
	public void actionPerformed(ActionEvent click) {
		if(click.getSource() == costBtn) {
			removeData.removeForCost(tableNum);
			costCard.dispose();
		}
		if(click.getSource() == backBtn) {
			costCard.dispose();
		}
	}
}
