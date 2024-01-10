package project;

import java.awt.EventQueue;


import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ReservationPage extends JFrame {

	private JPanel contentPane;
	private JTextField tname;
	private JTextField temail;
	private JTextField tphoneno;
	private JTextField tcheckin;
	private JTextField tcheckout;
	private JTable Rtable;
	private JTextField tqty;
	private JTextField rSearch;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationPage frame = new ReservationPage();
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
	private JTextField resId;

	/**
	 * Create the frame.
	 */
	public ReservationPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1155, 753);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(23, 73, 1095, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reservations");
		lblNewLabel.setBounds(91, -42, 253, 48);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 34));
		panel.add(lblNewLabel);
		
		tname = new JTextField();
		tname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tname.setFont(new Font("Arial", Font.PLAIN, 14));
		tname.setBounds(162, 88, 309, 19);
		panel.add(tname);
		tname.setColumns(10);
		
		JLabel lblRno = new JLabel("Reservation No : ");
		lblRno.setBounds(28, 45, 122, 17);
		panel.add(lblRno);
		lblRno.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNewLabel_3 = new JLabel("Checkout_Date");
		lblNewLabel_3.setBounds(512, 86, 110, 17);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Checking_Date");
		lblNewLabel_2.setBounds(512, 46, 106, 17);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Arial", Font.BOLD, 14));
		lblName.setBounds(28, 88, 60, 17);
		panel.add(lblName);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setBounds(28, 136, 60, 17);
		panel.add(lblEmail);
		
		temail = new JTextField();
		temail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String email = temail.getText();
				if(email.endsWith("@gmail.com")) {
					temail.setBackground(Color.green);
				}
				else {
					temail.setBackground(Color.red);
				}
			}
		});
		temail.setFont(new Font("Arial", Font.PLAIN, 14));
		temail.setColumns(10);
		temail.setBounds(162, 135, 309, 19);
		panel.add(temail);
		
		JLabel lblPhoneNo = new JLabel("Phone No : ");
		lblPhoneNo.setFont(new Font("Arial", Font.BOLD, 14));
		lblPhoneNo.setBounds(28, 180, 82, 17);
		panel.add(lblPhoneNo);
		
		tphoneno = new JTextField();
		tphoneno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String pno = tphoneno.getText();
				if(pno.matches("^[0-9]*$") && pno.length()==10) {
					tphoneno.setBackground(Color.green);
				
				}
				else {
					tphoneno.setBackground(Color.red);
				}
			}
		});
		tphoneno.setFont(new Font("Arial", Font.PLAIN, 14));
		tphoneno.setColumns(10);
		tphoneno.setBounds(162, 179, 168, 19);
		panel.add(tphoneno);
		
		tcheckin = new JTextField();
		tcheckin.setFont(new Font("Arial", Font.PLAIN, 14));
		tcheckin.setColumns(10);
		tcheckin.setBounds(629, 45, 168, 19);
		panel.add(tcheckin);
		
		tcheckout = new JTextField();
		tcheckout.setFont(new Font("Arial", Font.PLAIN, 14));
		tcheckout.setColumns(10);
		tcheckout.setBounds(629, 85, 168, 19);
		panel.add(tcheckout);
		
		JLabel lblGender = new JLabel("Gender : ");
		lblGender.setFont(new Font("Arial", Font.BOLD, 14));
		lblGender.setBounds(28, 220, 82, 17);
		panel.add(lblGender);
		
		JRadioButton male = new JRadioButton("Male");
		male.setFont(new Font("Arial", Font.PLAIN, 14));
		male.setBounds(167, 218, 60, 21);
		panel.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setFont(new Font("Arial", Font.PLAIN, 14));
		female.setBounds(231, 218, 73, 21);
		panel.add(female);
		
		JLabel lblNewLabel_3_1 = new JLabel("Room Type : ");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(512, 124, 110, 17);
		panel.add(lblNewLabel_3_1);
		
		JComboBox crtype = new JComboBox();
		crtype.setModel(new DefaultComboBoxModel(new String[] {"None", "A/C single room", "Non A/C single room", "A/C double room", "Non A/C double room", "A/C family room", "Non A/C family room"}));
		crtype.setFont(new Font("Arial", Font.PLAIN, 14));
		crtype.setBounds(629, 123, 168, 21);
		panel.add(crtype);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Package Type : ");
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(512, 165, 122, 17);
		panel.add(lblNewLabel_3_1_1);
		
		JComboBox cPtype = new JComboBox();
		cPtype.setModel(new DefaultComboBoxModel(new String[] {"None", "Birthday party package", "Party package", "Wedding package", "Other package"}));
		cPtype.setFont(new Font("Arial", Font.PLAIN, 14));
		cPtype.setBounds(629, 164, 168, 21);
		panel.add(cPtype);
		
		JLabel lblNewLabel_2_1 = new JLabel("Quantity : ");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(512, 210, 106, 17);
		panel.add(lblNewLabel_2_1);
		
		tqty = new JTextField();
		tqty.setFont(new Font("Arial", Font.PLAIN, 14));
		tqty.setColumns(10);
		tqty.setBounds(629, 209, 82, 19);
		panel.add(tqty);
		
		
		resId = new JTextField();
		resId.setHorizontalAlignment(SwingConstants.CENTER);
		resId.setFont(new Font("Arial", Font.PLAIN, 14));
		resId.setColumns(10);
		resId.setBounds(164, 44, 52, 19);
		panel.add(resId);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSave.setBounds(907, 59, 85, 21);
		panel.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String resno;
				String name;
				String email;
				String phoneNo;
				String gender;
				String checkin;
				String checkout;
				String rtype;
				String ptype;
				String qty;
				resno = resId.getText();
				name = tname.getText();
				email = temail.getText();
				phoneNo = tphoneno.getText();
				gender = male.isSelected() ? "Male" : "Female" ;
				checkin = tcheckin.getText();
				checkout = tcheckout.getText();
				rtype = (String) crtype.getSelectedItem() ;
				ptype = (String) cPtype.getSelectedItem();
				qty = tqty.getText() ;
				
				try {
			        pst = con.prepareStatement("insert into package(resNo,name,email,phoneNo,gender,checkin,checkout,rtype,ptype,qty)values(?,?,?,?,?,?,?,?,?,?)");
			        pst.setString(1, resno);
			        pst.setString(2, name);
			        pst.setString(3, email);
			        pst.setString(4, phoneNo);
			        pst.setString(5, gender);
			        pst.setString(6, checkin);
			        pst.setString(7, checkout);
			        pst.setString(8, rtype);
			        pst.setString(9, ptype);
			        pst.setString(10, qty);
			        
                    int rowsUpdated = pst.executeUpdate();
			        
			        if (rowsUpdated > 0) {
			            JOptionPane.showMessageDialog(null, "Record saved Successfully!");
			            table_load();
			        } else {
			            JOptionPane.showMessageDialog(null, "No records were saved.");
			        }
			        
			        resId.setText("");               
			        tname.setText("");
			        temail.setText("");
			        tphoneno.setText("");
					gender.contentEquals(null);
					tcheckin.setText("");
					tcheckout.setText("");
					crtype.setSelectedItem(null);
					cPtype.setSelectedItem(null);
					tqty.setText("");
					
					
			 
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			    }
			
			}
		});
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resno;
				String name;
				String email;
				String phoneNo;
				String gender;
				String checkin;
				String checkout;
				String rtype;
				String ptype;
				String qty;
				resno = resId.getText();
				name = tname.getText();
				email = temail.getText();
				phoneNo = tphoneno.getText();
				gender = male.isSelected() ? "Male" : "Female" ;
				checkin = tcheckin.getText();
				checkout = tcheckout.getText();
				rtype = (String) crtype.getSelectedItem() ;
				ptype = (String) cPtype.getSelectedItem();
				qty = tqty.getText() ;
				
				
				try {
			
			        pst = con.prepareStatement("update package set name = ? ,email = ?,phoneNo= ?,gender= ?,checkin= ?,checkout= ?,rtype= ?,ptype= ?,qty= ? where resNo = ?");
			        pst.setString(1, name);
			        pst.setString(2, email);
			        pst.setString(3, phoneNo);
			        pst.setString(4, gender);
			        pst.setString(5, checkin);
			        pst.setString(6, checkout);
			        pst.setString(7, rtype);
			        pst.setString(8, ptype);
			        pst.setString(9, qty);
			        pst.setString(10, resno);
                    int rowsUpdated = pst.executeUpdate();
			        
			        if (rowsUpdated > 0) {
			            JOptionPane.showMessageDialog(null, "Record updated Successfully!");
			            table_load();
			        } else {
			            JOptionPane.showMessageDialog(null, "No records were updated.");
			        }
			        
			        resId.setText("");               
			        tname.setText("");
			        temail.setText("");
			        tphoneno.setText("");
					gender.contentEquals(null);
					tcheckin.setText("");
					tcheckout.setText("");
					crtype.setSelectedItem(null);
					cPtype.setSelectedItem(null);
					tqty.setText("");
					
					
			 
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			    }
			}
		});
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 14));
		btnUpdate.setBounds(907, 132, 85, 21);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resno = resId.getText();
				try {
					pst = con.prepareStatement("DELETE FROM package WHERE resNo = ?");
				    pst.setString(1, resno);
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
		btnDelete.setBounds(907, 208, 85, 21);
		panel.add(btnDelete);
		
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Reservations");
		lblNewLabel_4.setBounds(430, 10, 220, 57);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 34));
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 430, 1095, 214);
		contentPane.add(scrollPane);
		
		Rtable = new JTable();
		scrollPane.setViewportView(Rtable);
		Rtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Reservation No", "Name", "Email", "Phone No", "Gender", "Checking_Date", "Checkout_Date", "Room Type", "Package Type", "Quantity"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		Rtable.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(351, 375, 357, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRno_1 = new JLabel("Reservation No : ");
		lblRno_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRno_1.setBounds(10, 10, 122, 17);
		lblRno_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblRno_1);
		
		rSearch = new JTextField();
		rSearch.setHorizontalAlignment(SwingConstants.CENTER);
		rSearch.setFont(new Font("Arial", Font.PLAIN, 14));
		rSearch.setColumns(10);
		rSearch.setBounds(136, 11, 122, 19);
		panel_1.add(rSearch);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = rSearch.getText();
				try 
				{	
				    DefaultTableModel dt = (DefaultTableModel)Rtable.getModel();
				    dt.setRowCount(0);
				    pst = con.prepareStatement("select * from package where resNo = '"+id+"'");
				    rs = pst.executeQuery();
				    
				    while(rs.next()) {
				    	Vector v = new Vector();
				    	v.add(rs.getString(1));//Registration no
				    	v.add(rs.getString(2));//name
				    	v.add(rs.getString(3));//email
				    	v.add(rs.getString(4));//phone no
				    	v.add(rs.getString(5));//gender
				    	v.add(rs.getString(6));//checkin date
				    	v.add(rs.getString(7));//checkout date
				    	v.add(rs.getString(8));//room type
				    	v.add(rs.getString(9));//package type
				    	v.add(rs.getString(10));//quantity
				    	
				    	
				    	dt.addRow(v);
				    	rs = pst.executeQuery("select * from package where resNo = '"+rSearch.getText()+"'");
				    	
				    	if(rs.next()) { 
				    		resId.setText(rs.getString("resNo"));
					        tname.setText(rs.getString("name"));
					        temail.setText(rs.getString("email"));
					        tphoneno.setText(rs.getString("phoneNo"));	
					        if("Male".equals(rs.getString("gender"))) {
							    male.setSelected(true);
							}
						    else {
							    female.setSelected(true);
						    }
					        tcheckin.setText(rs.getString("checkin"));
					        tcheckout.setText(rs.getString("checkout"));
					        crtype.setSelectedItem(rs.getString("rtype"));
					        cPtype.setSelectedItem(rs.getString("ptype"));
					        tqty.setText(rs.getString("qty"));
					        
				    	}
				    		
				    	}
				}
				    catch (SQLException e1) 
				     {
				        e1.printStackTrace();
				  } 
			}
		});
		btnFind.setFont(new Font("Arial", Font.PLAIN, 14));
		btnFind.setBounds(257, 10, 85, 21);
		panel_1.add(btnFind);
		
		JButton btnExitForCustomers = new JButton("Exit for customer");
		btnExitForCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLoginPage.main(null);
			}
		});
		btnExitForCustomers.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExitForCustomers.setBounds(23, 654, 183, 21);
		contentPane.add(btnExitForCustomers);
		
		JButton btnExitForAdmin = new JButton("Exit for admin");
		btnExitForAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage.main(null);
			}
		});
		btnExitForAdmin.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExitForAdmin.setBounds(956, 654, 162, 21);
		contentPane.add(btnExitForAdmin);
		
		Connect();//connect database
		autoID();//automatically generate id
		table_load();//save details to table
		
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
			
			public void autoID() {
				try {
					Statement s = con.createStatement();
					rs = s.executeQuery("select Max(resNo) from package");
					rs.next();
					rs.getString("Max(resNo)");
					
					if(rs.getString("Max(resNo)")==null) {
						resId.setText("R0001");
					}
					else {
						Long resNo = Long.parseLong(rs.getString("MAX(resNo)").substring(2, rs.getString("MAX(resNo)").length()));
						resNo++;
						resId.setText("R"+ String.format("%04d", resNo));
					}
				} catch (SQLException ex) {
					Logger.getLogger(ReservationPage.class.getName()).log(Level.SEVERE, null,ex);
				
				}

			}
			
	//load the data into table
	
			public void table_load()
			{
			    try 
			    {
			    DefaultTableModel dt = (DefaultTableModel)Rtable.getModel();
			    dt.setRowCount(0);
			    pst = con.prepareStatement("select * from package");
			    rs = pst.executeQuery();
			    
			    while(rs.next()) {
			    	Vector v = new Vector();
			    	v.add(rs.getString(1));//Registration no
			    	v.add(rs.getString(2));//name
			    	v.add(rs.getString(3));//email
			    	v.add(rs.getString(4));//phone no
			    	v.add(rs.getString(5));//gender
			    	v.add(rs.getString(6));//checkin date
			    	v.add(rs.getString(7));//checkout date
			    	v.add(rs.getString(8));//room type
			    	v.add(rs.getString(9));//package type
			    	v.add(rs.getString(10));//quantity
			    	
			    	
			    	dt.addRow(v);
			    	
			    }
			 
			} 
			    catch (SQLException e) 
			     {
			        e.printStackTrace();
			  }
			}
}
