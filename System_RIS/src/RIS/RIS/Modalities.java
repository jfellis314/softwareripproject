package RIS;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import RIS.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Modalities extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modalities frame = new Modalities();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Modalities() {
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1550, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SystemUsers adminPages=new SystemUsers();
				adminPages.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				adminPages.setVisible(true);
			}
		});
		homeBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		homeBtn.setBounds(10, 10, 101, 31);
		contentPane.add(homeBtn);
		
		JButton userInfoBtn = new JButton("User Info");
		userInfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInfo userinfoPages=new UserInfo();
				userinfoPages.setVisible(true);
			}
		});
		userInfoBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		userInfoBtn.setBounds(121, 10, 127, 31);
		contentPane.add(userInfoBtn);
		
		JButton adminBtn = new JButton("Admin");
		adminBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		adminBtn.setBounds(258, 10, 101, 31);
		contentPane.add(adminBtn);
		
		JButton referralsBtn = new JButton("Referrals");
		referralsBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		referralsBtn.setBounds(369, 10, 127, 31);
		contentPane.add(referralsBtn);
		
		JButton appointmentsBtn = new JButton("Appointments");
		appointmentsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Appointments adminPages=new Appointments();
				adminPages.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				adminPages.setVisible(true);
			}
		});
		appointmentsBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		appointmentsBtn.setBounds(506, 10, 173, 31);
		contentPane.add(appointmentsBtn);
		
		JButton ordersBtn = new JButton("Orders");
		ordersBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Orders adminPages=new Orders();
				adminPages.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				adminPages.setVisible(true);
			}
		});
		ordersBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		ordersBtn.setBounds(689, 10, 101, 31);
		contentPane.add(ordersBtn);
		
		JLabel lblNewLabel = new JLabel("Logged In As:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(1011, 10, 127, 31);
		contentPane.add(lblNewLabel);
		
		JTextArea loginStatus = new JTextArea();
		loginStatus.setBounds(1148, 10, 228, 31);
		contentPane.add(loginStatus);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login adminPages=new Login();
				adminPages.setVisible(true);
			}
		});
		logoutBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		logoutBtn.setBounds(1394, 10, 112, 31);
		contentPane.add(logoutBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 51, 1540, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Modalities");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(750, 63, 127, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Search:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(1171, 80, 62, 28);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newModalities newPages=new newModalities();
				newPages.setVisible(true);
			}
		});
		btnNew.setForeground(Color.BLUE);
		btnNew.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNew.setBounds(1426, 80, 80, 28);
		contentPane.add(btnNew);
		
		textField = new JTextField();
		textField.setBounds(1243, 80, 173, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("2 / 8");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(795, 750, 36, 31);
		contentPane.add(lblNewLabel_4);
		
		JButton changePane = new JButton("-->");
		changePane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PatientAlerts adminPages=new PatientAlerts();
				adminPages.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				adminPages.setVisible(true);	
			}
		});
		changePane.setFont(new Font("Tahoma", Font.BOLD, 12));
		changePane.setBounds(835, 750, 55, 31);
		contentPane.add(changePane);
		
		JButton changePane2 = new JButton("<--");
		changePane2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SystemUsers adminPages=new SystemUsers();
				adminPages.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				adminPages.setVisible(true);
			}
		});
		changePane2.setFont(new Font("Tahoma", Font.BOLD, 12));
		changePane2.setBounds(730, 750, 55, 31);
		contentPane.add(changePane2);
		
		
		JLabel lblNewLabel_5 = new JLabel("Patient Alerts");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(900, 750, 94, 31);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("System Users");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(636, 750, 87, 31);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 747, 1540, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 180, 1540, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Modality ID");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(30, 158, 101, 17);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Modality ");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(430, 158, 101, 17);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Modality Price");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1.setBounds(830, 158, 112, 17);
		contentPane.add(lblNewLabel_3_1_1_1);
		
	}

}
