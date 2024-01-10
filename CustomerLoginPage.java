package project;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CustomerLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField cusername;
	private JTextField cpassword;
	private JTextField txtCpassword;
	private JTextField textUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLoginPage frame = new CustomerLoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con; //object for database connection
	PreparedStatement pst; //object for preparing the statement
	ResultSet rs; //object for getting result set

	/**
	 * Create the frame.
	 */
	public CustomerLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(79, 498, 446, 197);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Username : ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(184, 40, 78, 17);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblPassword_1 = new JLabel("Password : ");
		lblPassword_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword_1.setBounds(184, 87, 78, 17);
		panel_1.add(lblPassword_1);
		
		textUsername = new JTextField();
		textUsername.setHorizontalAlignment(SwingConstants.LEFT);
		textUsername.setFont(new Font("Arial", Font.PLAIN, 14));
		textUsername.setColumns(10);
		textUsername.setBounds(272, 40, 141, 19);
		panel_1.add(textUsername);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					String sql = "Select username,password from customerlogin where username= '"+textUsername.getText()+"' and password='"+txtPassword.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "Login Sucessfully");
						ReservationPage.main(null);
					}
					else {
							JOptionPane.showMessageDialog(null, "Incorrect username or password....");
						}
					con.close();
			}catch(Exception e1) {System.out.print(e1);}
				
			}
		});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLogin.setBounds(184, 141, 85, 21);
		panel_1.add(btnLogin);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("G:\\project\\images\\username1.png"));
		lblNewLabel_3.setBounds(24, 27, 137, 150);
		panel_1.add(lblNewLabel_3);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(272, 87, 141, 19);
		panel_1.add(txtPassword);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstPage.main(null);
			}
		});
		btnExit.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExit.setBounds(312, 142, 85, 21);
		panel_1.add(btnExit);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("G:\\project\\images\\royal21.jpg"));
		lblNewLabel_2.setBounds(10, 10, 580, 177);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(127, 222, 355, 249);
		contentPane.add(panel);
		panel.setBackground(new Color(0, 191, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sign up", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username : ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(22, 52, 78, 17);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(22, 99, 78, 17);
		panel.add(lblPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("Conform password :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(22, 144, 128, 17);
		panel.add(lblNewLabel_1_1);
		
		cusername = new JTextField();
		cusername.setHorizontalAlignment(SwingConstants.LEFT);
		cusername.setFont(new Font("Arial", Font.PLAIN, 14));
		cusername.setBounds(110, 51, 141, 19);
		panel.add(cusername);
		cusername.setColumns(10);
		
		cpassword = new JTextField();
		cpassword.setHorizontalAlignment(SwingConstants.LEFT);
		cpassword.setFont(new Font("Arial", Font.PLAIN, 14));
		cpassword.setColumns(10);
		cpassword.setBounds(110, 99, 141, 19);
		panel.add(cpassword);
		
		txtCpassword = new JTextField();
		txtCpassword.setHorizontalAlignment(SwingConstants.LEFT);
		txtCpassword.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCpassword.setColumns(10);
		txtCpassword.setBounds(160, 144, 141, 19);
		panel.add(txtCpassword);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = cusername.getText();
				String password = cpassword.getText();
				String cPassword = txtCpassword.getText();
				
				try {
			        pst = con.prepareStatement("insert into customerlogin(username,password,currentPassword)values(?,?,?)");
			        pst.setString(1, username);
			        pst.setString(2, password);
			        pst.setString(3, cPassword);
			        
			        int rowsUpdated = pst.executeUpdate();
			        
			        if (rowsUpdated > 0) {
			            JOptionPane.showMessageDialog(null, "Record saved Successfully!");
			        } else {
			            JOptionPane.showMessageDialog(null, "No records were saved.");
			        }
			        
			        cusername.setText("");               
			        cpassword.setText("");
			        txtCpassword.setText("");
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			    }
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setBounds(22, 213, 85, 21);
		panel.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = cusername.getText();
				String password = cpassword.getText();
				String cPassword = txtCpassword.getText();
				
				try {
			        pst = con.prepareStatement("update customerlogin set password = ?,currentPassword = ? where username = ?");
			        pst.setString(1, password);
			        pst.setString(2, cPassword);
			        pst.setString(3, username);
			        
			        int rowsUpdated = pst.executeUpdate();
			        
			        if (rowsUpdated > 0) {
			            JOptionPane.showMessageDialog(null, "Record updated Successfully!");
			        } else {
			            JOptionPane.showMessageDialog(null, "No records were updated.");
			        }
			        
			        cusername.setText("");            
			        cpassword.setText("");
			        txtCpassword.setText("");
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			    }
			}
		});
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 14));
		btnUpdate.setBounds(134, 213, 85, 21);
		panel.add(btnUpdate);
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=cusername.getText();
				try {
					pst = con.prepareStatement("DELETE FROM customerlogin WHERE username = ?");
				    pst.setString(1, username);
				    int rowsDeleted = pst.executeUpdate();
				    
				    if (rowsDeleted > 0) {
				    	JOptionPane.showMessageDialog(null, "Record deleted successfully!");
				    } else {
				    	JOptionPane.showMessageDialog(null, "No records were deleted!");
				    }
				    cusername.setText("");
				    con.close(); // Close the database connection
				    
				} catch (SQLException ex) {
				    ex.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(245, 213, 85, 21);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Create a new account");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(64, 20, 187, 13);
		panel.add(lblNewLabel_4);
		Connect();
	}
	public void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hoteldb", "root", "");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}
