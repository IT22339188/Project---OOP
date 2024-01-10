package project;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class LoginPage {

	private JFrame frame;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1045, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 1032, 524);
		frame.getContentPane().add(panel);
		panel.setBackground(new Color(0, 0, 0));
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 23, 975, 476);
		panel.add(panel_1);
		panel_1.setBackground(new Color(153, 153, 153));
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setBounds(33, 223, 108, 36);
		lblUsername.setFont(new Font("Arial", Font.BOLD, 18));
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(33, 277, 108, 43);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 18));
		panel_1.add(lblPassword);
		
		JTextArea textUsername = new JTextArea();
		textUsername.setBorder(new LineBorder(new Color(0, 0, 51)));
		textUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		textUsername.setBounds(151, 231, 180, 28);
		panel_1.add(textUsername);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(new LineBorder(new Color(0, 0, 51)));
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		txtPassword.setBounds(151, 287, 180, 28);
		panel_1.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		btnLogin.setBounds(33, 399, 108, 36);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","");
				Statement stmt = con.createStatement();
				String sql = "Select * from login where username= '"+textUsername.getText()+"' and password='"+txtPassword.getText().toString()+"'";
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "Login Sucessfully");
						Homepage.main(null);
				}
				else {
						JOptionPane.showMessageDialog(null, "Incorrect username or password....");
					}
				con.close();
		}catch(Exception e1) {System.out.print(e1);}
				
		   }
		});
		btnLogin.setFont(new Font("Arial", Font.BOLD, 18));
		panel_1.add(btnLogin);
		
		JLabel lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(101, 34, 156, 162);
		panel_1.add(lblImage);
		lblImage.setIcon(new ImageIcon("G:\\project\\images\\username1.png"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\project\\images\\hotel (2).jpg"));
		lblNewLabel.setBounds(354, 0, 621, 476);
		panel_1.add(lblNewLabel);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstPage.main(null);
			}
		});
		btnExit.setFont(new Font("Arial", Font.BOLD, 18));
		btnExit.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		btnExit.setBounds(207, 399, 108, 36);
		panel_1.add(btnExit);
		
		
		
	}
}
