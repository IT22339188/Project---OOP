package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CustomerPage extends JFrame {

	private JPanel contentPane;
	private JTextField textCustomerID;
	private JTextField textName;
	private JTextField textEmail;
	private JTextField textPhoneNo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerPage frame = new CustomerPage();
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
	private JTextField textSearch;

	/**
	 * Create the frame.
	 */
	public CustomerPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1109, 547);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(33, 121, 477, 297);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCCustomerID = new JLabel("Customer ID : ");
		lblCCustomerID.setBounds(10, 34, 91, 24);
		lblCCustomerID.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblCCustomerID);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(10, 68, 50, 13);
		lblName.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblName);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setBounds(10, 97, 50, 13);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblEmail);
		
		JLabel lblGender = new JLabel("Gender : ");
		lblGender.setBounds(10, 156, 60, 13);
		lblGender.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblGender);
		
		JLabel lblAge = new JLabel("Phone No : ");
		lblAge.setBounds(10, 127, 76, 13);
		lblAge.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblAge);
		
		textCustomerID = new JTextField();
		textCustomerID.setFont(new Font("Arial", Font.PLAIN, 14));
		textCustomerID.setText("C0001");
		textCustomerID.setBounds(109, 34, 50, 23);
		panel.add(textCustomerID);
		textCustomerID.setColumns(10);
		
		textName = new JTextField();
		textName.setFont(new Font("Arial", Font.PLAIN, 14));
		textName.setColumns(10);
		textName.setBounds(109, 66, 285, 24);
		panel.add(textName);
		
		textEmail = new JTextField();
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String email = textEmail.getText();
				if(email.endsWith("@gmail.com")) {
					textEmail.setBackground(Color.green);
				}
				else {
					textEmail.setBackground(Color.red);
				}
			}
		});
		textEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		textEmail.setColumns(10);
		textEmail.setBounds(109, 95, 285, 24);
		panel.add(textEmail);
		
		textPhoneNo = new JTextField();
		textPhoneNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String pno = textPhoneNo.getText();
				if(pno.matches("^[0-9]*$") && pno.length()==10) {
					textPhoneNo.setBackground(Color.green);
				
				}
				else {
					textPhoneNo.setBackground(Color.red);
				}
			}
		});
		textPhoneNo.setFont(new Font("Arial", Font.PLAIN, 14));
		textPhoneNo.setColumns(10);
		textPhoneNo.setBounds(109, 125, 116, 24);
		panel.add(textPhoneNo);
		
		JRadioButton male = new JRadioButton("Male");
		male.setFont(new Font("Arial", Font.PLAIN, 14));
		male.setBounds(109, 153, 60, 21);
		panel.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setFont(new Font("Arial", Font.PLAIN, 14));
		female.setBounds(171, 153, 76, 21);
		panel.add(female);
		
		// save the details
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cusID;
				String name;
				String email;
				String phoneNo;
				String gender;
				
				
				cusID = textCustomerID.getText();
				name = textName.getText();
				email = textEmail.getText();
				phoneNo = textPhoneNo.getText();
				gender = male.isSelected() ? "Male" : "Female";
				
				try {
			        pst = con.prepareStatement("insert into customer(customerID,name,email,phoneNo,gender)values(?,?,?,?,?)");
			        pst.setString(1, cusID);
			        pst.setString(2, name);
			        pst.setString(3, email);
			        pst.setString(4, phoneNo);
			        pst.setString(5, gender);
                    int rowsUpdated = pst.executeUpdate();
			        
			        if (rowsUpdated > 0) {
			            JOptionPane.showMessageDialog(null, "Record saved Successfully!");
			            table_load();
			        } else {
			            JOptionPane.showMessageDialog(null, "No records were saved.");
			        }
			        
			        textCustomerID.setText("");               
			        textName.setText("");
			        textEmail.setText("");
			        textPhoneNo.setText("");
					gender.contentEquals(null);
			 
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			    }
			}
		});
		btnSave.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSave.setBounds(37, 233, 76, 21);
		panel.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cusID;
				String name;
				String email;
				String phoneNo;
				String gender;
				
				cusID = textCustomerID.getText();
				name = textName.getText();
				email = textEmail.getText();
				phoneNo = textPhoneNo.getText();
				gender = male.isSelected() ? "Male" : "Female";
				
				try {
			        pst = con.prepareStatement("update customer set name = ?,email = ? ,phoneNo = ?,gender = ? where customerID = ?");
			        pst.setString(1, name);
			        pst.setString(2, email);
			        pst.setString(3, phoneNo);
			        pst.setString(4, gender);
			        pst.setString(5, cusID);
			       
			        int rowsUpdated = pst.executeUpdate();
			        
			        if (rowsUpdated > 0) {
			            JOptionPane.showMessageDialog(null, "Record Updated Successfully!");
			            table_load();
			        } else {
			            JOptionPane.showMessageDialog(null, "No records were updated.");
			        }
			        //clear input fields
			        textCustomerID.setText("");               
			        textName.setText("");
			        textEmail.setText("");
			        textPhoneNo.setText("");
					gender.contentEquals(null);
			 
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			    }
			}
		});
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 14));
		btnUpdate.setBounds(143, 233, 85, 21);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cusID=textCustomerID.getText();
				try {
					pst = con.prepareStatement("DELETE FROM customer WHERE customerID = ?");
				    pst.setString(1, cusID);
				    int rowsDeleted = pst.executeUpdate();
				    
				    if (rowsDeleted > 0) {
				    	JOptionPane.showMessageDialog(null, "Record deleted successfully!");
				    	table_load();
				    } else {
				    	JOptionPane.showMessageDialog(null, "No records were deleted!");
				    }
				    
				    con.close(); // Close the database connection
				    
				} catch (SQLException ex) {
				    ex.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDelete.setBounds(261, 233, 76, 21);
		panel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(575, 212, 491, 206);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(245, 245, 245));
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Name", "Email", "Phone No", "Gender"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Customer Registration");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 42));
		lblNewLabel.setBounds(301, 24, 477, 74);
		contentPane.add(lblNewLabel);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage.main(null);
			}
		});
		btnExit.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExit.setBounds(1009, 479, 76, 21);
		contentPane.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(658, 121, 342, 67);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSearch = new JLabel("Customer ID : ");
		lblSearch.setBounds(32, 26, 91, 17);
		lblSearch.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lblSearch);
		
		JButton find = new JButton("Find");
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textSearch.getText();
			try 
			{	
			    DefaultTableModel dt = (DefaultTableModel)table.getModel();
			    dt.setRowCount(0);
			    pst = con.prepareStatement("select * from customer where customerID = '"+id+"'");
			    rs = pst.executeQuery();
			    
			    while(rs.next()) {
			    	Vector v = new Vector();
			    	v.add(rs.getString(1));//id
			    	v.add(rs.getString(2));//name
			    	v.add(rs.getString(3));//email
			    	v.add(rs.getString(4));//phone no
			    	v.add(rs.getString(5));//gender
			    	
			    	dt.addRow(v);
			    	rs = pst.executeQuery("select * from customer where customerID = '"+textSearch.getText()+"'");
			    	
			    	if(rs.next()) { 
			    		textCustomerID.setText(rs.getString("customerID"));
				        textName.setText(rs.getString("name"));
						textEmail.setText(rs.getString("email"));
						textPhoneNo.setText(rs.getString("phoneNo"));	
	                    if("Male".equals(rs.getString("gender"))) {
						    male.setSelected(true);
						}
					    else {
						    female.setSelected(true);
					 }
			    	}
			    		
			    	}
			}
			    catch (SQLException e1) 
			     {
			        e1.printStackTrace();
			  } 
			    
			    
			}
		});
		find.setBounds(239, 24, 65, 22);
		find.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(find);
		
		textSearch = new JTextField();
		textSearch.setFont(new Font("Arial", Font.PLAIN, 14));
		textSearch.setBounds(133, 26, 96, 19);
		textSearch.setColumns(10);
		panel_1.add(textSearch);
		Connect();//connect the database
		autoID();//automatically generate customer id
		table_load();//load the details
	}
	//connect the database

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
		//automatically create id
		public void autoID() {
			try {
				Statement s = con.createStatement();
				rs = s.executeQuery("select Max(customerID) from customer");
				rs.next();
				rs.getString("Max(customerID)");
				
				if(rs.getString("Max(customerID)")==null) {
					textCustomerID.setText("C0001");
				}
				else {
					Long resNo = Long.parseLong(rs.getString("MAX(customerID)").substring(2, rs.getString("MAX(customerID)").length()));
					resNo++;
					textCustomerID.setText("C"+ String.format("%04d", resNo));
				}
			} catch (SQLException ex) {
				Logger.getLogger(CustomerPage.class.getName()).log(Level.SEVERE, null,ex);
			
			}

		}
		
		//load the data into table
		
		public void table_load()
		{
		    try 
		    {
		    DefaultTableModel dt = (DefaultTableModel)table.getModel();
		    dt.setRowCount(0);
		    pst = con.prepareStatement("select * from customer");
		    rs = pst.executeQuery();
		    
		    while(rs.next()) {
		    	Vector v = new Vector();
		    	v.add(rs.getString(1));//id
		    	v.add(rs.getString(2));//name
		    	v.add(rs.getString(3));//email
		    	v.add(rs.getString(4));//phone no
		    	v.add(rs.getString(5));//gender
		    	
		    	dt.addRow(v);
		    	
		    }
		 
		} 
		    catch (SQLException e) 
		     {
		        e.printStackTrace();
		  }
		}
}
