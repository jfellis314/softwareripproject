package RIS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Desk_UnscheduledOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Desk_UnscheduledOrder frame = new Desk_UnscheduledOrder();
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
	public Desk_UnscheduledOrder() {
		setTitle("Receptionist");
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
				Desk_CheckedINAppoint deskPages=new Desk_CheckedINAppoint();
				deskPages.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				deskPages.setVisible(true);
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
		
		JLabel lblNewLabel_1 = new JLabel("Unscheduled Orders");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(725, 63, 228, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Search:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(1171, 80, 62, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("3 / 3");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(795, 750, 36, 31);
		contentPane.add(lblNewLabel_4);
		
		JButton changePane2 = new JButton("<--");
		changePane2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Desk_TodayAppoint deskPages=new Desk_TodayAppoint();
				deskPages.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				deskPages.setVisible(true);
			}
		});
		changePane2.setFont(new Font("Tahoma", Font.BOLD, 12));
		changePane2.setBounds(730, 750, 55, 31);
		contentPane.add(changePane2);
		
		JLabel lblNewLabel_3 = new JLabel("Today's Appointments");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(578, 750, 142, 31);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 747, 1540, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 180, 1540, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Patient");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(30, 158, 80, 17);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Referral MD");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(380, 158, 101, 17);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Modality");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1.setBounds(730, 158, 87, 17);
		contentPane.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Notes");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1_1.setBounds(1080, 158, 101, 17);
		contentPane.add(lblNewLabel_3_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(1243, 80, 173, 28);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}