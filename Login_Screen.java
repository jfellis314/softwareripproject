package Login_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login_Screen {

	private JFrame frmLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Screen window = new Login_Screen();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setBounds(200, 200, 500, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		
		JLabel lblText_box = new JLabel("Please Enter in Your Username and Password");
		lblText_box.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblText_box.setBounds(85, 10, 307, 36);
		frmLogin.getContentPane().add(lblText_box);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(53, 64, 96, 19);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(53, 155, 96, 19);
		frmLogin.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(187, 64, 205, 19);
		frmLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(187, 155, 205, 19);
		frmLogin.getContentPane().add(txtPassword);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				
				//Admin Profile Page
				if (password.contains("admin") && username.contains("admin")) {
					txtPassword.setText(null);
					txtUsername.setText(null);
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
				//End
				
			}
		});
		btnEnter.setBounds(85, 210, 85, 21);
		frmLogin.getContentPane().add(btnEnter);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(196, 210, 85, 21);
		frmLogin.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLogin = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLogin, "Do you wish to exit the program?", "Login Process",
				JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
				System.exit(0);	
				}
				
			}
		});
		btnExit.setBounds(307, 210, 85, 21);
		frmLogin.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 196, 466, 2);
		frmLogin.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 44, 466, 2);
		frmLogin.getContentPane().add(separator_1);
	}
}
