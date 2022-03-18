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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo();
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
	public UserInfo() {
		setTitle("User Info");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New User Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(200, 0, 106, 21);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 19, 498, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 211, 498, 2);
		contentPane.add(separator_1);
		
		JButton btnSubmit = new JButton("Update Info");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBounds(100, 232, 118, 21);
		contentPane.add(btnSubmit);
		
		JButton btnClose = new JButton("Cancel");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setBounds(300, 232, 118, 21);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_1_0 = new JLabel("Display Name :");
		lblNewLabel_1_0.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_0.setBounds(10, 35, 85, 13);
		contentPane.add(lblNewLabel_1_0);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(10, 65, 68, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email Address :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_2.setBounds(10, 95, 85, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Username :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_3.setBounds(10, 125, 85, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Change Password :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_4.setBounds(10, 155, 99, 13);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Confirm Password :");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_5.setBounds(10, 185, 118, 13);
		contentPane.add(lblNewLabel_1_5);
		
		textField = new JTextField();
		textField.setBounds(125, 32, 215, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(125, 62, 215, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(125, 182, 215, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(125, 152, 215, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(125, 122, 215, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(125, 92, 215, 20);
		contentPane.add(textField_5);
		
	}

}
