package gui_Src;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import func_Src.*;

public class Main_Page implements ActionListener, MouseListener {

	public JFrame pos;

	private Excel_Read memberInfo = new Excel_Read();
	private Main_Page_Action actFunction = new Main_Page_Action();

	private Timer timer;
	private Calendar getTime = Calendar.getInstance();
	private SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA);
	private Date today = new Date();
	private String date = myFormat.format(today);
	private int hour = getTime.get(Calendar.HOUR_OF_DAY); 
	private int min = getTime.get(Calendar.MINUTE); 
	private int sec = getTime.get(Calendar.SECOND);
	private int idNum = 0;

	private JLabel Table_1;
	private JLabel Table_2;
	private JLabel Table_3;
	private JLabel Table_4;
	private JLabel Table_5;
	private JLabel Table_6;
	private JLabel Table_7;
	private JLabel Table_8;
	private JLabel Table_9;
	private JLabel TakeOut_1;
	private JLabel TakeOut_2;
	private JButton orderBtn;
	private JButton costCardBtn;
	private JButton costCashBtn;
	private JButton printBillBtn;
	private JButton salesBtn;
	private JButton rootBtn;
	private JLabel tableNum_In;
	private JLabel timeLabel;
	private JLabel cost_In;
	private JLabel numOfMember;
	private JLabel numOfMember_In;
	private JLabel divideCost_In;
	private JLabel restarantName;



	public Main_Page(int idNum) {
		this.idNum = idNum;
		initialize();
		pos.setVisible(true);
	}

	private void initialize() {

		pos = new JFrame();
		pos.getContentPane().setBackground(Color.WHITE);
		pos.setTitle("TableManager");
		pos.setBounds(100, 100, 1001, 700);
		pos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pos.getContentPane().setLayout(null);
		pos.setLocationRelativeTo(null);
		pos.setResizable(false);

		timer = new javax.swing.Timer(1000, this);
		timer.setInitialDelay(0);
		timer.start();

		JPanel tablePan = new JPanel();
		tablePan.setBackground(Color.WHITE);
		tablePan.setBorder(new LineBorder(Color.RED));
		tablePan.setBounds(10, 101, 580, 551);
		pos.getContentPane().add(tablePan);
		tablePan.setLayout(null);

		Table_1 = new JLabel("Table_1");
		Table_1.setHorizontalAlignment(SwingConstants.CENTER);
		Table_1.setBounds(12, 10, 100, 100);
		Table_1.addMouseListener(this);
		tablePan.add(Table_1);

		Table_2 = new JLabel("Table_2");
		Table_2.setHorizontalAlignment(SwingConstants.CENTER);
		Table_2.setBounds(240, 10, 100, 100);
		Table_2.addMouseListener(this);
		tablePan.add(Table_2);

		Table_3 = new JLabel("Table_3");
		Table_3.setHorizontalAlignment(SwingConstants.CENTER);
		Table_3.setBounds(468, 10, 100, 100);
		Table_3.addMouseListener(this);
		tablePan.add(Table_3);

		Table_4 = new JLabel("Table_4");
		Table_4.setHorizontalAlignment(SwingConstants.CENTER);
		Table_4.setBounds(12, 153, 100, 100);
		Table_4.addMouseListener(this);
		tablePan.add(Table_4);

		Table_5 = new JLabel("Table_5");
		Table_5.setHorizontalAlignment(SwingConstants.CENTER);
		Table_5.setBounds(240, 153, 100, 100);
		Table_5.addMouseListener(this);
		tablePan.add(Table_5);

		Table_6 = new JLabel("Table_6");
		Table_6.setHorizontalAlignment(SwingConstants.CENTER);
		Table_6.setBounds(468, 153, 100, 100);
		Table_6.addMouseListener(this);
		tablePan.add(Table_6);

		Table_7 = new JLabel("Table_7");
		Table_7.setHorizontalAlignment(SwingConstants.CENTER);
		Table_7.setBounds(12, 296, 100, 100);
		Table_7.addMouseListener(this);
		tablePan.add(Table_7);

		Table_8 = new JLabel("Table_8");
		Table_8.setHorizontalAlignment(SwingConstants.CENTER);
		Table_8.setBounds(240, 296, 100, 100);
		Table_8.addMouseListener(this);
		tablePan.add(Table_8);

		Table_9 = new JLabel("Table_9");
		Table_9.setHorizontalAlignment(SwingConstants.CENTER);
		Table_9.setBounds(468, 296, 100, 100);
		Table_9.addMouseListener(this);
		tablePan.add(Table_9);

		TakeOut_1 = new JLabel("TakeOut_1");
		TakeOut_1.setHorizontalAlignment(SwingConstants.CENTER);
		TakeOut_1.setBounds(12, 441, 100, 100);
		TakeOut_1.addMouseListener(this);
		tablePan.add(TakeOut_1);

		TakeOut_2 = new JLabel("TakeOut_2");
		TakeOut_2.setHorizontalAlignment(SwingConstants.CENTER);
		TakeOut_2.setBounds(468, 441, 100, 100);
		TakeOut_2.addMouseListener(this);
		tablePan.add(TakeOut_2);


		JPanel infoPan = new JPanel();
		infoPan.setBackground(Color.WHITE);
		infoPan.setBorder(new LineBorder(new Color(0, 0, 0)));
		infoPan.setBounds(0, 0, 982, 40);
		pos.getContentPane().add(infoPan);
		infoPan.setLayout(null);

		JPanel function_Pan = new JPanel();
		function_Pan.setBackground(Color.WHITE);
		function_Pan.setBorder(new LineBorder(Color.RED));
		function_Pan.setBounds(598, 50, 372, 602);
		pos.getContentPane().add(function_Pan);
		function_Pan.setLayout(null);

		restarantName = new JLabel(memberInfo.excel_ReadId().elementAt(idNum).name);
		restarantName.setHorizontalAlignment(SwingConstants.CENTER);
		restarantName.setFont(new Font("굴림", Font.BOLD, 15));
		restarantName.setBounds(0, 0, 106, 40);
		infoPan.add(restarantName);

		JLabel stateLabel = new JLabel("테이블 현황");
		stateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stateLabel.setFont(new Font("굴림", Font.BOLD, 15));
		stateLabel.setBounds(118, 0, 106, 40);
		infoPan.add(stateLabel);


		timeLabel = new JLabel(hour + "시" + min + "분 " + sec + "초");
		timeLabel.setBounds(865, 0, 117, 40);
		infoPan.add(timeLabel);
		timeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		timeLabel.setFont(new Font("굴림", Font.BOLD, 15));

		JLabel dateLabel = new JLabel("영업일자 :" + date);
		dateLabel.setBounds(680, 0, 173, 40);
		infoPan.add(dateLabel);
		dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dateLabel.setFont(new Font("굴림", Font.BOLD, 15));

		JLabel tableNum = new JLabel("테이블번호 :");
		tableNum.setHorizontalAlignment(SwingConstants.CENTER);
		tableNum.setFont(new Font("굴림", Font.BOLD, 15));
		tableNum.setBounds(12, 29, 134, 30);
		function_Pan.add(tableNum);

		tableNum_In = new JLabel("");
		tableNum_In.setHorizontalAlignment(SwingConstants.CENTER);
		tableNum_In.setBackground(Color.WHITE);
		tableNum_In.setBounds(179, 29, 144, 30);
		function_Pan.add(tableNum_In);

		numOfMember = new JLabel("손님수 :");
		numOfMember.setHorizontalAlignment(SwingConstants.CENTER);
		numOfMember.setFont(new Font("굴림", Font.BOLD, 15));
		numOfMember.setBounds(12, 88, 134, 30);
		function_Pan.add(numOfMember);

		numOfMember_In = new JLabel();
		numOfMember_In.setHorizontalAlignment(SwingConstants.CENTER);
		numOfMember_In.setBackground(Color.WHITE);
		numOfMember_In.setBounds(179, 88, 144, 30);
		function_Pan.add(numOfMember_In);

		JLabel divideCost = new JLabel("1인당 계산금액 :");
		divideCost.setHorizontalAlignment(SwingConstants.CENTER);
		divideCost.setFont(new Font("굴림", Font.BOLD, 15));
		divideCost.setBounds(12, 148, 134, 30);
		function_Pan.add(divideCost);

		divideCost_In = new JLabel();
		divideCost_In.setHorizontalAlignment(SwingConstants.CENTER);
		divideCost_In.setBackground(Color.WHITE);
		divideCost_In.setBounds(179, 148, 144, 30);
		function_Pan.add(divideCost_In);

		JLabel cost = new JLabel("전체금액 :");
		cost.setHorizontalAlignment(SwingConstants.CENTER);
		cost.setFont(new Font("굴림", Font.BOLD, 15));
		cost.setBounds(12, 203, 134, 30);
		function_Pan.add(cost);

		cost_In = new JLabel();
		cost_In.setHorizontalAlignment(SwingConstants.CENTER);
		cost_In.setBackground(Color.WHITE);
		cost_In.setBounds(179, 203, 144, 30);
		function_Pan.add(cost_In);

		orderBtn = new JButton("주문");
		orderBtn.setBackground(new Color(255,255,255));
		orderBtn.setFont(new Font("굴림", Font.BOLD, 20));
		orderBtn.setBounds(16, 258, 130, 90);
		function_Pan.add(orderBtn);

		costCashBtn = new JButton("현금결제");
		costCashBtn.setBackground(new Color(255,255,255));
		costCashBtn.setFont(new Font("굴림", Font.BOLD, 20));
		costCashBtn.setBounds(16, 376, 130, 90);
		function_Pan.add(costCashBtn);

		costCardBtn = new JButton("카드결제");
		costCardBtn.setBackground(new Color(255,255,255));
		costCardBtn.setFont(new Font("굴림", Font.BOLD, 20));
		costCardBtn.setBounds(230, 376, 130, 90);
		costCardBtn.addActionListener(this);
		function_Pan.add(costCardBtn);

		printBillBtn = new JButton("영수증출력");
		printBillBtn.setBackground(new Color(255,255,255));
		printBillBtn.setFont(new Font("굴림", Font.BOLD, 18));
		printBillBtn.setBounds(16, 502, 130, 90);
		function_Pan.add(printBillBtn);

		salesBtn = new JButton("매출");
		salesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Sales_Page salePage =new Sales_Page();
			}
		});
		salesBtn.setBackground(new Color(255,255,255));
		salesBtn.setFont(new Font("굴림", Font.BOLD, 20));
		salesBtn.setBounds(230, 258, 130, 90);
		function_Pan.add(salesBtn);

		rootBtn = new JButton("관리자모드");
		rootBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AdminLogin_Page loginAdmin = new AdminLogin_Page();
			}
		});
		rootBtn.setFont(new Font("굴림", Font.BOLD, 18));
		rootBtn.setBackground(new Color(255,255,255));
		rootBtn.setBounds(230, 502, 130, 90);
		function_Pan.add(rootBtn);	

		orderBtn.addActionListener(actFunction);
		costCardBtn.addActionListener(actFunction);
		costCashBtn.addActionListener(actFunction);
		printBillBtn.addActionListener(actFunction);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		++sec;
		Calendar getTime2 = Calendar.getInstance(); 
		hour = getTime2.get(Calendar.HOUR_OF_DAY); 
		min = getTime2.get(Calendar.MINUTE); 
		sec = getTime2.get(Calendar.SECOND);
		timeLabel.setText(hour + "시" + min + "분 " + sec + "초");
	}

	@Override
	public void mouseClicked(MouseEvent click) {
		if(click.getSource() == Table_1) {
			tableNum_In.setText("Table1");

			actFunction.dataInput(orderBtn, costCashBtn, costCardBtn, printBillBtn,numOfMember_In,divideCost_In,cost_In ,tableNum_In.getText(), date);

			Seperate_ seperateData = new Seperate_();

			numOfMember_In.setText(seperateData.setMemberNum(tableNum_In.getText())+ "명");
			divideCost_In.setText(seperateData.byMemberNum(tableNum_In.getText()) + "원");
			cost_In.setText(seperateData.byTableSale(tableNum_In.getText()) + "원");
		}
		else if(click.getSource() == Table_2) {
			tableNum_In.setText("Table2");

			actFunction.dataInput(orderBtn, costCashBtn, costCardBtn, printBillBtn,numOfMember_In,divideCost_In,cost_In ,tableNum_In.getText(), date);

			Seperate_ seperateData = new Seperate_();

			numOfMember_In.setText(seperateData.setMemberNum(tableNum_In.getText())+ "명");
			divideCost_In.setText(seperateData.byMemberNum(tableNum_In.getText()) + "원");
			cost_In.setText(seperateData.byTableSale(tableNum_In.getText()) + "원");
		}
		else if(click.getSource() == Table_3) {
			tableNum_In.setText("Table3");

			actFunction.dataInput(orderBtn, costCashBtn, costCardBtn, printBillBtn,numOfMember_In,divideCost_In,cost_In ,tableNum_In.getText(), date);
			
			Seperate_ seperateData = new Seperate_();

			numOfMember_In.setText(seperateData.setMemberNum(tableNum_In.getText())+ "명");
			divideCost_In.setText(seperateData.byMemberNum(tableNum_In.getText()) + "원");
			cost_In.setText(seperateData.byTableSale(tableNum_In.getText()) + "원");
		}
		else if(click.getSource() == Table_4) {
			tableNum_In.setText("Table4");

			actFunction.dataInput(orderBtn, costCashBtn, costCardBtn, printBillBtn,numOfMember_In,divideCost_In,cost_In ,tableNum_In.getText(), date);

			Seperate_ seperateData = new Seperate_();

			numOfMember_In.setText(seperateData.setMemberNum(tableNum_In.getText())+ "명");
			divideCost_In.setText(seperateData.byMemberNum(tableNum_In.getText()) + "원");
			cost_In.setText(seperateData.byTableSale(tableNum_In.getText()) + "원");
		}
		else if(click.getSource() == Table_5) {
			tableNum_In.setText("Table5");

			actFunction.dataInput(orderBtn, costCashBtn, costCardBtn, printBillBtn,numOfMember_In,divideCost_In,cost_In ,tableNum_In.getText(), date);

			Seperate_ seperateData = new Seperate_();

			numOfMember_In.setText(seperateData.setMemberNum(tableNum_In.getText())+ "명");
			divideCost_In.setText(seperateData.byMemberNum(tableNum_In.getText()) + "원");
			cost_In.setText(seperateData.byTableSale(tableNum_In.getText()) + "원");
		}
		else if(click.getSource() == Table_6) {
			tableNum_In.setText("Table6");

			actFunction.dataInput(orderBtn, costCashBtn, costCardBtn, printBillBtn,numOfMember_In,divideCost_In,cost_In ,tableNum_In.getText(), date);

			Seperate_ seperateData = new Seperate_();

			numOfMember_In.setText(seperateData.setMemberNum(tableNum_In.getText())+ "명");
			divideCost_In.setText(seperateData.byMemberNum(tableNum_In.getText()) + "원");
			cost_In.setText(seperateData.byTableSale(tableNum_In.getText()) + "원");
		}
		else if(click.getSource() == Table_7) {
			tableNum_In.setText("Table7");

			actFunction.dataInput(orderBtn, costCashBtn, costCardBtn, printBillBtn,numOfMember_In,divideCost_In,cost_In ,tableNum_In.getText(), date);

			Seperate_ seperateData = new Seperate_();

			numOfMember_In.setText(seperateData.setMemberNum(tableNum_In.getText())+ "명");
			divideCost_In.setText(seperateData.byMemberNum(tableNum_In.getText()) + "원");
			cost_In.setText(seperateData.byTableSale(tableNum_In.getText()) + "원");
		}
		else if(click.getSource() == Table_8) {
			tableNum_In.setText("Table8");

			actFunction.dataInput(orderBtn, costCashBtn, costCardBtn, printBillBtn,numOfMember_In,divideCost_In,cost_In ,tableNum_In.getText(), date);
			
			Seperate_ seperateData = new Seperate_();

			numOfMember_In.setText(seperateData.setMemberNum(tableNum_In.getText())+ "명");
			divideCost_In.setText(seperateData.byMemberNum(tableNum_In.getText()) + "원");
			cost_In.setText(seperateData.byTableSale(tableNum_In.getText()) + "원");
		}
		else if(click.getSource() == Table_9) {
			tableNum_In.setText("Table9");

			actFunction.dataInput(orderBtn, costCashBtn, costCardBtn, printBillBtn,numOfMember_In,divideCost_In,cost_In ,tableNum_In.getText(), date);

			Seperate_ seperateData = new Seperate_();

			numOfMember_In.setText(seperateData.setMemberNum(tableNum_In.getText())+ "명");
			divideCost_In.setText(seperateData.byMemberNum(tableNum_In.getText()) + "원");
			cost_In.setText(seperateData.byTableSale(tableNum_In.getText()) + "원");
		}
		else if(click.getSource() == TakeOut_1) {
			tableNum_In.setText("TakeOut1");

			actFunction.dataInput(orderBtn, costCashBtn, costCardBtn, printBillBtn,numOfMember_In,divideCost_In,cost_In ,tableNum_In.getText(), date);

			Seperate_ seperateData = new Seperate_();

			numOfMember_In.setText(seperateData.setMemberNum(tableNum_In.getText())+ "명");
			divideCost_In.setText(seperateData.byMemberNum(tableNum_In.getText()) + "원");
			cost_In.setText(seperateData.byTableSale(tableNum_In.getText()) + "원");
		}
		else if(click.getSource() == TakeOut_2) {
			tableNum_In.setText("TakeOut2");

			actFunction.dataInput(orderBtn, costCashBtn, costCardBtn, printBillBtn,numOfMember_In,divideCost_In,cost_In ,tableNum_In.getText(), date);

			Seperate_ seperateData = new Seperate_();

			numOfMember_In.setText(seperateData.setMemberNum(tableNum_In.getText())+ "명");
			divideCost_In.setText(seperateData.byMemberNum(tableNum_In.getText()) + "원");
			cost_In.setText(seperateData.byTableSale(tableNum_In.getText()) + "원");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
