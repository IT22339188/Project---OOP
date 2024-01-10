package project;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage frame = new FirstPage();
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
	public FirstPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon icon =new ImageIcon(this.getClass().getResource("/royal.jpg"));
		
		Panel panel = new Panel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(10, 10, 901, 643);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLoginPage.main(null);
			}
		});
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 34));
		btnNewButton.setBounds(10, 573, 200, 60);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Welcome to Royal Hotel");
		lblNewLabel.setForeground(new Color(245, 245, 245));
		lblNewLabel.setBounds(10, 150, 881, 98);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 72));
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage.main(null);
			
			}
		});
		btnAdmin.setBackground(new Color(224, 255, 255));
		btnAdmin.setFont(new Font("Arial", Font.BOLD, 34));
		btnAdmin.setBounds(715, 573, 176, 60);
		panel.add(btnAdmin);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("G:\\project\\images\\royal.jpg"));
		lblNewLabel_1.setBounds(0, 0, 901, 643);
		panel.add(lblNewLabel_1);
	}
}
