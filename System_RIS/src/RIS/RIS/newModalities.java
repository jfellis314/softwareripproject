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

public class newModalities extends JFrame {

	private JPanel contentPane;
	private JTextField modalID;
	private JTextField modal;
	private JTextField modalPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newModalities frame = new newModalities();
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
	public newModalities() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Modality");
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
		
		JLabel lblNewLabel_1 = new JLabel("Modality ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(10, 50, 68, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Modality");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(10, 100, 51, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Modality Price");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_2.setBounds(10, 150, 79, 13);
		contentPane.add(lblNewLabel_1_2);
		
		modalID = new JTextField();
		modalID.setColumns(10);
		modalID.setBounds(100, 48, 215, 20);
		contentPane.add(modalID);
		
		modal = new JTextField();
		modal.setColumns(10);
		modal.setBounds(100, 98, 215, 20);
		contentPane.add(modal);
		
		modalPrice = new JTextField();
		modalPrice.setColumns(10);
		modalPrice.setBounds(100, 148, 215, 20);
		contentPane.add(modalPrice);
		
	}

}
