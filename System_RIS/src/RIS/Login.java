package RIS;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import RIS.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblText_box = new JLabel("Please Enter in Your Username and Password");
		lblText_box.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblText_box.setBounds(85, 10, 307, 36);
		contentPane.add(lblText_box);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(53, 64, 96, 19);
		contentPane.add(lblUsername);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 44, 466, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 196, 466, 2);
		contentPane.add(separator_1);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(187, 64, 205, 19);
		contentPane.add(txtUsername);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(187, 155, 205, 19);
		contentPane.add(txtPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(53, 155, 96, 19);
		contentPane.add(lblPassword);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				
				//Admin Profile Page
				if (password.contains("admin") && username.contains("admin")) {
					dispose();
					SystemUsers adminPages=new SystemUsers();
					adminPages.setVisible(true);
					adminPages.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					
					
					//Then swap to admin page
				} else if (password.contains("admin"))
				{
					JOptionPane.showMessageDialog(null, "Invaild Username. Please re-enter.", "Login Error",JOptionPane.ERROR_MESSAGE);
					txtUsername.setText(null);
				} else if (username.contains("admin")) 
				{
					JOptionPane.showMessageDialog(null, "Invaild Password. Please re-enter.", "Login Error",JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
				} else 
				{
					JOptionPane.showMessageDialog(null, "Invaild Username or Password. Please re-enter.", "Login Error",JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtUsername.setText(null);
				}
			}
		});
		btnEnter.setBounds(85, 210, 85, 21);
		contentPane.add(btnEnter);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPassword.setText(null);
				txtUsername.setText(null);
			}
		});
		btnReset.setBounds(196, 210, 85, 21);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(307, 210, 85, 21);
		contentPane.add(btnExit);
	}

}
