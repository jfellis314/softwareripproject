package RIS;

import RIS.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import RIS.*;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class DiagnosticReports {

	private JFrame frmAdmin;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiagnosticReports window = new DiagnosticReports();
					window.frmAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DiagnosticReports() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdmin = new JFrame();
		frmAdmin.setTitle("Admin");
		frmAdmin.setBounds(100, 100, 1550, 850);
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmin.getContentPane().setLayout(null);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemUsers adminPages=new SystemUsers();
				adminPages.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				adminPages.setVisible(true);
			}
		});
		homeBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		homeBtn.setBounds(10, 10, 101, 31);
		frmAdmin.getContentPane().add(homeBtn);
		
		JButton userInfoBtn = new JButton("User Info");
		userInfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInfo userinfoPages=new UserInfo();
				userinfoPages.setVisible(true);
			}
		});
		userInfoBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		userInfoBtn.setBounds(121, 10, 127, 31);
		frmAdmin.getContentPane().add(userInfoBtn);
		
		JButton adminBtn = new JButton("Admin");
		adminBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		adminBtn.setBounds(258, 10, 101, 31);
		frmAdmin.getContentPane().add(adminBtn);
		
		JButton referralsBtn = new JButton("Referrals");
		referralsBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		referralsBtn.setBounds(369, 10, 127, 31);
		frmAdmin.getContentPane().add(referralsBtn);
		
		JButton appointmentsBtn = new JButton("Appointments");
		appointmentsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Appointments adminPages=new Appointments();
				adminPages.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				adminPages.setVisible(true);
			}
		});
		appointmentsBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		appointmentsBtn.setBounds(506, 10, 173, 31);
		frmAdmin.getContentPane().add(appointmentsBtn);
		
		JButton ordersBtn = new JButton("Orders");
		ordersBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders adminPages=new Orders();
				adminPages.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				adminPages.setVisible(true);
			}
		});
		ordersBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		ordersBtn.setBounds(689, 10, 101, 31);
		frmAdmin.getContentPane().add(ordersBtn);
		
		JLabel lblNewLabel = new JLabel("Logged In As:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(1011, 10, 127, 31);
		frmAdmin.getContentPane().add(lblNewLabel);
		
		JTextArea loginStatus = new JTextArea();
		loginStatus.setBounds(1148, 10, 228, 31);
		frmAdmin.getContentPane().add(loginStatus);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdmin.setVisible(false);
				Login adminPages=new Login();
				adminPages.setVisible(true);
			}
		});
		logoutBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		logoutBtn.setBounds(1394, 10, 112, 31);
		frmAdmin.getContentPane().add(logoutBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 51, 1540, 2);
		frmAdmin.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 180, 1540, 2);
		frmAdmin.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 747, 1540, 2);
		frmAdmin.getContentPane().add(separator_2);
		
		JLabel lblNewLabel_1 = new JLabel("Diagnostic Reports");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(750, 63, 176, 26);
		frmAdmin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Search:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(1171, 80, 62, 28);
		frmAdmin.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(1243, 80, 173, 28);
		frmAdmin.getContentPane().add(textField);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newDiagnosticReport adminPages=new newDiagnosticReport(); 
				adminPages.setVisible(true);
			}
		});
		btnNew.setForeground(Color.BLUE);
		btnNew.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNew.setBounds(1426, 80, 80, 28);
		frmAdmin.getContentPane().add(btnNew);
		
		JLabel lblNewLabel_3_1 = new JLabel("Diagnostic Report ID");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(30, 158, 156, 17);
		frmAdmin.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Radiologist");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(380, 158, 89, 17);
		frmAdmin.getContentPane().add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Order");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1.setBounds(730, 158, 89, 17);
		frmAdmin.getContentPane().add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("Report");
		lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_2.setBounds(1080, 158, 89, 17);
		frmAdmin.getContentPane().add(lblNewLabel_3_1_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("8 / 8");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(795, 750, 36, 31);
		frmAdmin.getContentPane().add(lblNewLabel_4);
		
		JButton changePane2 = new JButton("<--");
		changePane2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileUploads adminPages=new FileUploads();
				adminPages.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				adminPages.setVisible(true);
			}
		});
		changePane2.setFont(new Font("Tahoma", Font.BOLD, 12));
		changePane2.setBounds(730, 750, 55, 31);
		frmAdmin.getContentPane().add(changePane2);
		
		JLabel lblNewLabel_3 = new JLabel("File Uploads");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(651, 750, 74, 31);
		frmAdmin.getContentPane().add(lblNewLabel_3);
	}

	public void setVisible(boolean b) {
		frmAdmin.setVisible(true);
		
	}

	public void setExtendedState(int maximizedBoth) {
		frmAdmin.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
	}

}
