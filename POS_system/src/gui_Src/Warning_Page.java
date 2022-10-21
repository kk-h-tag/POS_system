package gui_Src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Warning_Page implements ActionListener{

	private JFrame warning;
	private JButton backBtn;
	
	private String menuName;
	
	public Warning_Page(String menuName) {
		this.menuName = menuName;
		initialize();
		warning.setVisible(true);
	}

	private void initialize() {
		warning = new JFrame("경고");
		warning.getContentPane().setBackground(Color.WHITE);
		warning.getContentPane().setLayout(null);
		warning.setBounds(100, 100, 350, 250);
		warning.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		warning.setResizable(false);
		warning.setLocationRelativeTo(null);
		
		JPanel infoPan = new JPanel();
		infoPan.setBorder(new LineBorder(Color.RED));
		infoPan.setBackground(Color.WHITE);
		infoPan.setBounds(12, 10, 310, 135);
		warning.getContentPane().add(infoPan);
		infoPan.setLayout(null);
		
		JLabel warningLabel = new JLabel("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		warningLabel.setForeground(Color.RED);
		warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warningLabel.setBounds(12, 10, 286, 25);
		infoPan.add(warningLabel);
		
		JLabel menuNameLabel = new JLabel(menuName);
		menuNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuNameLabel.setForeground(Color.BLACK);
		menuNameLabel.setBounds(12, 55, 286, 25);
		infoPan.add(menuNameLabel);
		
		JLabel infoLabel = new JLabel("!!!!!!!!!해당메뉴의 재고가 10개미만입니다!!!!!!!!");
		infoLabel.setBounds(12, 100, 286, 25);
		infoPan.add(infoLabel);
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setForeground(Color.RED);
		
		JPanel funcPan = new JPanel();
		funcPan.setBackground(Color.WHITE);
		funcPan.setBounds(12, 155, 310, 46);
		warning.getContentPane().add(funcPan);
		funcPan.setLayout(null);
		
		backBtn = new JButton("확인");
		backBtn.setBounds(92, 10, 110, 26);
		backBtn.addActionListener(this);
		funcPan.add(backBtn);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == backBtn) {
			warning.dispose();
		}
	}

}
