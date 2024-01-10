package project;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1147, 608);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 298, 551);
		panel.setBackground(new Color(153, 153, 153));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnStaff = new JButton("Staff");
		btnStaff.setBackground(new Color(0, 0, 0));
		btnStaff.setForeground(new Color(255, 255, 255));
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staffpage.main(null);
			}
		});
		btnStaff.setBounds(20, 280, 250, 57);
		panel.add(btnStaff);
		btnStaff.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnStaff.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerPage.main(null);
			}
			
		});
		btnCustomer.setBackground(new Color(0, 0, 0));
		btnCustomer.setForeground(new Color(255, 255, 255));
		btnCustomer.setBounds(20, 347, 250, 57);
		panel.add(btnCustomer);
		btnCustomer.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnCustomer.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton btnReser = new JButton("Reservation");
		btnReser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationPage.main(null);
			}
		});
		btnReser.setForeground(new Color(255, 255, 255));
		btnReser.setBounds(20, 414, 250, 57);
		panel.add(btnReser);
		btnReser.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnReser.setBackground(new Color(0, 0, 0));
		btnReser.setFont(new Font("Arial", Font.BOLD, 24));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\project\\images\\hoteln.jpg"));
		lblNewLabel.setBounds(20, 31, 250, 221);
		panel.add(lblNewLabel);
		
		JButton btnPaymentDetails = new JButton("Payment Details");
		btnPaymentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentPage.main(null);
			}
		});
		btnPaymentDetails.setForeground(Color.WHITE);
		btnPaymentDetails.setFont(new Font("Arial", Font.BOLD, 24));
		btnPaymentDetails.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnPaymentDetails.setBackground(Color.BLACK);
		btnPaymentDetails.setBounds(20, 481, 250, 57);
		panel.add(btnPaymentDetails);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(960, 504, 163, 57);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage.main(null);
			}
		});
		contentPane.add(btnExit);
		btnExit.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnExit.setBackground(new Color(204, 204, 204));
		btnExit.setForeground(new Color(204, 0, 0));
		btnExit.setFont(new Font("Arial", Font.BOLD, 24));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("G:\\project\\images\\193250000.jpg"));
		lblNewLabel_1.setBounds(301, 10, 822, 551);
		contentPane.add(lblNewLabel_1);
	}
}
