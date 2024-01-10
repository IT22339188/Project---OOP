package project;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class Staffpage extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textSID;
	private JTextField textPhoneNo;
	private JTextField textEmail;
	private JTable StaffTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staffpage frame = new Staffpage();
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
	public Staffpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 619);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(997, 529, 84, 32);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage.main(null);
			}
		});
		contentPane.setLayout(null);
		btnExit.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btnExit);

		JLabel lblNewLabel = new JLabel("Staff Registation");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setBounds(348, 31, 408, 70);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 44));
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlDkShadow);
		panel.setBounds(39, 151, 537, 378);
		panel.setBorder(
				new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"Registation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Registation", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblStaffIdNo = new JLabel("Staff ID No :");
		lblStaffIdNo.setBounds(13, 23, 83, 17);
		panel.add(lblStaffIdNo);
		lblStaffIdNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblStaffIdNo.setFont(new Font("Arial", Font.BOLD, 14));

		textSID = new JTextField();
		textSID.setFont(new Font("Arial", Font.PLAIN, 14));
		textSID.setBounds(101, 22, 54, 30);
		panel.add(textSID);
		textSID.setHorizontalAlignment(SwingConstants.CENTER);
		textSID.setColumns(10);

		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(13, 66, 54, 30);
		panel.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Arial", Font.BOLD, 14));

		textName = new JTextField();
		textName.setFont(new Font("Arial", Font.PLAIN, 14));
		textName.setBounds(101, 68, 364, 30);
		panel.add(textName);
		textName.setHorizontalAlignment(SwingConstants.LEFT);
		textName.setColumns(10);

		JLabel lblPhoneno = new JLabel("Phone No : ");
		lblPhoneno.setBounds(13, 126, 82, 23);
		panel.add(lblPhoneno);
		lblPhoneno.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneno.setFont(new Font("Arial", Font.BOLD, 14));

		textPhoneNo = new JTextField();
		//validation for phone no
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
		textPhoneNo.setBounds(101, 124, 218, 30);
		panel.add(textPhoneNo);
		textPhoneNo.setHorizontalAlignment(SwingConstants.LEFT);
		textPhoneNo.setColumns(10);

		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setBounds(16, 175, 54, 25);
		panel.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));

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
		textEmail.setBounds(101, 174, 308, 30);
		panel.add(textEmail);
		textEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textEmail.setColumns(10);

		JLabel lblPosition = new JLabel("Position :");
		lblPosition.setBounds(16, 221, 82, 29);
		panel.add(lblPosition);
		lblPosition.setHorizontalAlignment(SwingConstants.LEFT);
		lblPosition.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(16, 271, 82, 29);
		panel.add(lblGender);
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setFont(new Font("Arial", Font.BOLD, 14));

		JRadioButton male = new JRadioButton("Male");
		male.setBounds(101, 275, 70, 21);
		panel.add(male);
		male.setHorizontalAlignment(SwingConstants.CENTER);
		male.setFont(new Font("Arial", Font.PLAIN, 14));

		JRadioButton female = new JRadioButton("Female");
		female.setBounds(194, 275, 82, 21);
		panel.add(female);
		female.setHorizontalAlignment(SwingConstants.CENTER);
		female.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JComboBox cPosition = new JComboBox();
		cPosition.setModel(new DefaultComboBoxModel(new String[] {"-Select the Position-", "Manager", "Receptionist"}));
		cPosition.setFont(new Font("Arial", Font.PLAIN, 14));
		cPosition.setBounds(101, 217, 364, 30);
		panel.add(cPosition);
		
		//save details

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String staffID;
				String name;
				String phoneNo;
				String email;
				String position;
				String gender;
				
				staffID = textSID.getText();
				name = textName.getText();
				phoneNo = textPhoneNo.getText();
				email = textEmail.getText();
				position = (String) cPosition.getSelectedItem();
				gender = male.isSelected() ? "Male" : "Female";
				
				try {
			        pst = con.prepareStatement("insert into staff(staffID,name,phoneNo,email,position,gender)values(?,?,?,?,?,?)");
			        pst.setString(1, staffID);
			        pst.setString(2, name);
			        pst.setString(3, phoneNo);
			        pst.setString(4, email);
			        pst.setString(5, position);
			        pst.setString(6, gender);
			        
			        int rowsUpdated = pst.executeUpdate();
			        
			        if (rowsUpdated > 0) {
			            JOptionPane.showMessageDialog(null, "Record saved Successfully!");
			            table_load();
			        } else {
			            JOptionPane.showMessageDialog(null, "No records were saved.");
			        }
			        
			        textSID.setText("");               
			        textName.setText("");
			        textPhoneNo.setText("");
					textEmail.setText("");
					cPosition.setSelectedItem(null);
					gender.contentEquals(null);
			 
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			    }
			}
		});
		btnNewButton.setBounds(54, 336, 85, 21);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		
		//update details

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String staffID;
				String name;
				String phoneNo;
				String email;
				String position;
				String gender;
				
				staffID = textSID.getText();
				name = textName.getText();
				phoneNo = textPhoneNo.getText();
				email = textEmail.getText();
				position = (String) cPosition.getSelectedItem();
				gender = male.isSelected() ? "Male" : "Female";
				
				try {
			        pst = con.prepareStatement("update staff set name = ?,phoneNo = ? ,email = ? ,position = ? ,gender = ? where staffID = ?");
			        pst.setString(1, name);
			        pst.setString(2, phoneNo);
			        pst.setString(3, email);
			        pst.setString(4, position);
			        pst.setString(5, gender);
			        pst.setString(6, staffID);
			       
			        int rowsUpdated = pst.executeUpdate();
			        
			        if (rowsUpdated > 0) {
			            JOptionPane.showMessageDialog(null, "Record Updated Successfully!");
			            table_load();
			        } else {
			            JOptionPane.showMessageDialog(null, "No records were updated.");
			        }
			        //clear input fields
			        textSID.setText("");               
			        textName.setText("");
			        textPhoneNo.setText("");
					textEmail.setText("");
					cPosition.setSelectedItem(null);
					gender.contentEquals(null);
			 
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			    }
			}
		});
		btnUpdate.setBounds(217, 336, 85, 21);
		panel.add(btnUpdate);
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 14));
		
		//delete details

		JButton btnInsert = new JButton("Delete");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String staffID=textSID.getText();
				try {
					pst = con.prepareStatement("DELETE FROM staff WHERE staffID = ?");
				    pst.setString(1, staffID);
				    int rowsDeleted = pst.executeUpdate();
				    
				    if (rowsDeleted > 0) {
				    	JOptionPane.showMessageDialog(null, "Record deleted successfully!");
				    } else {
				    	JOptionPane.showMessageDialog(null, "No records were deleted!");
				    }
				    
				    con.close(); // Close the database connection
				    
				} catch (SQLException ex) {
				    ex.printStackTrace();
				}
				
			}
		});
		btnInsert.setBounds(373, 336, 85, 21);
		panel.add(btnInsert);
		btnInsert.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JScrollPane details = new JScrollPane();
		details.setBounds(603, 296, 481, 223);
		contentPane.add(details);

		StaffTable = new JTable();
		StaffTable.setBackground(new Color(135, 206, 250));
		StaffTable.setFont(new Font("Arial", Font.PLAIN, 14));
		details.setViewportView(StaffTable);
		StaffTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Staff ID", "Name", "Phone No", "Email", "Position", "Gender"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		StaffTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(119, 136, 153));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(664, 152, 281, 120);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labelSearch = new JLabel("Staff ID No :");
		labelSearch.setBounds(27, 40, 83, 17);
		labelSearch.setHorizontalAlignment(SwingConstants.LEFT);
		labelSearch.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(labelSearch);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSearch.setBounds(120, 40, 132, 19);
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setColumns(10);
		panel_1.add(txtSearch);
		
		//find details
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtSearch.getText();
				try 
			    {	
			    DefaultTableModel dt = (DefaultTableModel)StaffTable.getModel();
			    dt.setRowCount(0);
			    pst = con.prepareStatement("select * from staff where staffID = '"+id+"'");
			    rs = pst.executeQuery();
			    
			    while(rs.next()) {
			    	Vector v = new Vector();
			    	v.add(rs.getString(1));
			    	v.add(rs.getString(2));
			    	v.add(rs.getString(3));
			    	v.add(rs.getString(4));
			    	v.add(rs.getString(5));
			    	v.add(rs.getString(6));
			    	
			    	dt.addRow(v);
			    	rs = pst.executeQuery("select * from staff where staffID = '"+txtSearch.getText()+"'");
			    	
			    	if(rs.next()) { 
			    		textSID.setText(rs.getString("staffID"));
				        textName.setText(rs.getString("name"));
				        textPhoneNo.setText(rs.getString("phoneNo"));
						textEmail.setText(rs.getString("email"));
						cPosition.setSelectedItem(rs.getString("position"));
						
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
		btnFind.setFont(new Font("Arial", Font.PLAIN, 14));
		btnFind.setBounds(82, 78, 85, 21);
		panel_1.add(btnFind);
		Connect();//connect the database
		autoID();//automatically create staff id
		table_load();//save the details in to table
		
	}
	private JTextField txtSearch;

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
	//auto generate the Staff ID
	public void autoID() {
		try {
			Statement s = con.createStatement();
			rs = s.executeQuery("select Max(staffID) from staff");
			rs.next();
			rs.getString("Max(staffID)");
			
			if(rs.getString("Max(staffID)")==null) {
				textSID.setText("S0001");
			}
			else {
				Long resNo = Long.parseLong(rs.getString("MAX(staffID)").substring(2, rs.getString("MAX(staffID)").length()));
				resNo++;
				textSID.setText("S"+ String.format("%04d", resNo));
			}
		} catch (SQLException ex) {
			Logger.getLogger(Staffpage.class.getName()).log(Level.SEVERE, null,ex);
		
		}

	}
	
	//load the data into table
	
	public void table_load()
	{
	    try 
	    {
	    DefaultTableModel dt = (DefaultTableModel)StaffTable.getModel();
	    dt.setRowCount(0);
	    pst = con.prepareStatement("select * from staff");
	    rs = pst.executeQuery();
	    
	    while(rs.next()) {
	    	Vector v = new Vector();
	    	v.add(rs.getString(1));//id
	    	v.add(rs.getString(2));//name
	    	v.add(rs.getString(3));//phone no
	    	v.add(rs.getString(4));//email
	    	v.add(rs.getString(5));//position
	    	v.add(rs.getString(6));//gender
	    	
	    	dt.addRow(v);
	    	
	    }
	 
	} 
	    catch (SQLException e) 
	     {
	        e.printStackTrace();
	  }
	}
}
		
