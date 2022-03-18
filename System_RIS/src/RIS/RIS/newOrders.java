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

public class newOrders extends JFrame {

	private JPanel contentPane;
	private JTextField orderID;
	private JTextField patient;
	private JTextField referMD;
	private JTextField modal;
	private JTextField notes;
	private JTextField status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newOrders frame = new newOrders();
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
	public newOrders() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Order");
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
		
		JLabel lblNewLabel_1 = new JLabel("Order ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(10, 35, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Patient");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(10, 65, 51, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Referral MD");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_2.setBounds(10, 95, 68, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Modality");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_3.setBounds(10, 125, 85, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Notes");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_4.setBounds(10, 155, 68, 13);
		contentPane.add(lblNewLabel_1_4);
		
		orderID = new JTextField();
		orderID.setBounds(100, 33, 215, 20);
		contentPane.add(orderID);
		orderID.setColumns(10);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Status");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_4_1.setBounds(10, 185, 68, 13);
		contentPane.add(lblNewLabel_1_4_1);
		
		patient = new JTextField();
		patient.setColumns(10);
		patient.setBounds(100, 63, 215, 20);
		contentPane.add(patient);
		
		referMD = new JTextField();
		referMD.setColumns(10);
		referMD.setBounds(100, 93, 215, 20);
		contentPane.add(referMD);
		
		modal = new JTextField();
		modal.setColumns(10);
		modal.setBounds(100, 123, 215, 20);
		contentPane.add(modal);
		
		notes = new JTextField();
		notes.setColumns(10);
		notes.setBounds(100, 153, 215, 20);
		contentPane.add(notes);
		
		status = new JTextField();
		status.setColumns(10);
		status.setBounds(100, 183, 215, 20);
		contentPane.add(status);
	}

}
