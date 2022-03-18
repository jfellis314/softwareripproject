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

public class newAppointments extends JFrame {

	private JPanel contentPane;
	private JTextField appointID;
	private JTextField patient;
	private JTextField order;
	private JTextField DoT;
	private JTextField tech;
	private JTextField radio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newAppointments frame = new newAppointments();
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
	public newAppointments() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Appointment");
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
		
		JLabel lblNewLabel_1_0 = new JLabel("Appointment ID");
		lblNewLabel_1_0.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_0.setBounds(10, 35, 85, 13);
		contentPane.add(lblNewLabel_1_0);
		
		JLabel lblNewLabel_1_1 = new JLabel("Patient");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(10, 65, 51, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Order");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_2.setBounds(10, 95, 68, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date/Time");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_3.setBounds(10, 125, 85, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Technician");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_4.setBounds(10, 155, 68, 13);
		contentPane.add(lblNewLabel_1_4);
		
		appointID = new JTextField();
		appointID.setBounds(100, 33, 215, 20);
		contentPane.add(appointID);
		appointID.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("Radiologist");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_5.setBounds(10, 185, 68, 13);
		contentPane.add(lblNewLabel_1_5);
		
		patient = new JTextField();
		patient.setColumns(10);
		patient.setBounds(100, 63, 215, 20);
		contentPane.add(patient);
		
		order = new JTextField();
		order.setColumns(10);
		order.setBounds(100, 93, 215, 20);
		contentPane.add(order);
		
		DoT = new JTextField();
		DoT.setColumns(10);
		DoT.setBounds(100, 123, 215, 20);
		contentPane.add(DoT);
		
		tech = new JTextField();
		tech.setColumns(10);
		tech.setBounds(100, 153, 215, 20);
		contentPane.add(tech);
		
		radio = new JTextField();
		radio.setColumns(10);
		radio.setBounds(100, 183, 215, 20);
		contentPane.add(radio);
	}

}
