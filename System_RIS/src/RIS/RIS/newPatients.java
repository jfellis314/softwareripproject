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
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class newPatients extends JFrame {

	private JPanel contentPane;
	private JTextField patientID;
	private JTextField DoB;
	private JTextField lName;
	private JTextField fName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newPatients frame = new newPatients();
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
	public newPatients() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Patient");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(200, 0, 106, 21);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 19, 498, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 211, 498, 2);
		contentPane.add(separator_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBounds(125, 232, 85, 21);
		contentPane.add(btnSubmit);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setBounds(285, 232, 85, 21);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_1_0 = new JLabel("Patient ID");
		lblNewLabel_1_0.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_0.setBounds(10, 45, 58, 13);
		contentPane.add(lblNewLabel_1_0);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date of Birth");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(10, 80, 68, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Last Name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_2.setBounds(10, 115, 68, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("First Name");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_3.setBounds(10, 150, 68, 13);
		contentPane.add(lblNewLabel_1_3);
		
		patientID = new JTextField();
		patientID.setBounds(100, 43, 215, 20);
		contentPane.add(patientID);
		patientID.setColumns(10);
		
		DoB = new JTextField();
		DoB.setColumns(10);
		DoB.setBounds(100, 78, 215, 20);
		contentPane.add(DoB);
		
		lName = new JTextField();
		lName.setColumns(10);
		lName.setBounds(100, 113, 215, 20);
		contentPane.add(lName);
		
		fName = new JTextField();
		fName.setColumns(10);
		fName.setBounds(100, 148, 215, 20);
		contentPane.add(fName);
	}

}
