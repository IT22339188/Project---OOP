package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class PaymentPage extends JFrame {

	private JPanel contentPane;
	private JTextField temail;
	private JTextField tamount;
	private JTextField pID;
	private JTable table;
	private JTextField cID;
	private JTextField tsearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentPage frame = new PaymentPage();
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
	public PaymentPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 519);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerId = new JLabel("Email : ");
		lblCustomerId.setBounds(24, 195, 107, 17);
		lblCustomerId.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(lblCustomerId);
		
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
		temail.setBounds(149, 192, 238, 23);
		temail.setHorizontalAlignment(SwingConstants.LEFT);
		temail.setFont(new Font("Arial", Font.PLAIN, 14));
		temail.setColumns(10);
		contentPane.add(temail);
		
		JLabel lblNewLabel_3_1 = new JLabel("Payment Type : ");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(24, 234, 122, 17);
		contentPane.add(lblNewLabel_3_1);
		
		JComboBox ptype = new JComboBox();
		ptype.setModel(new DefaultComboBoxModel(new String[] {"-Select the payment method-", "Cash", "Card"}));
		ptype.setFont(new Font("Arial", Font.PLAIN, 14));
		ptype.setBounds(151, 232, 212, 21);
		contentPane.add(ptype);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Amount : ");
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(24, 279, 74, 17);
		contentPane.add(lblNewLabel_3_1_1);
		
		tamount = new JTextField();
		tamount.setHorizontalAlignment(SwingConstants.LEFT);
		tamount.setFont(new Font("Arial", Font.PLAIN, 14));
		tamount.setColumns(10);
		tamount.setBounds(149, 276, 116, 23);
		contentPane.add(tamount);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Paid Status : ");
		lblNewLabel_3_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_1_2.setBounds(24, 320, 122, 17);
		contentPane.add(lblNewLabel_3_1_2);
		
		JComboBox paidtype = new JComboBox();
		paidtype.setModel(new DefaultComboBoxModel(new String[] {"-Select the paid status-", "Paid", "Non Paid"}));
		paidtype.setFont(new Font("Arial", Font.PLAIN, 14));
		paidtype.setBounds(149, 318, 176, 21);
		contentPane.add(paidtype);
		
		JLabel lblPaymentId = new JLabel("Payment ID : ");
		lblPaymentId.setFont(new Font("Arial", Font.BOLD, 14));
		lblPaymentId.setBounds(24, 100, 122, 17);
		contentPane.add(lblPaymentId);
		
		pID = new JTextField();
		pID.setHorizontalAlignment(SwingConstants.LEFT);
		pID.setFont(new Font("Arial", Font.PLAIN, 14));
		pID.setColumns(10);
		pID.setBounds(149, 97, 52, 23);
		contentPane.add(pID);
		
		JLabel lblPaymentDetails = new JLabel("Payment Details");
		lblPaymentDetails.setFont(new Font("Arial", Font.BOLD, 34));
		lblPaymentDetails.setBounds(288, 11, 275, 74);
		contentPane.add(lblPaymentDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(397, 175, 491, 206);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Payment ID", "Reservation No", "Email", "Payment Status", "Amount", "Paid Status"
			}
		));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBackground(new Color(245, 245, 245));
		scrollPane.setViewportView(table);
		
		JLabel lblCustomerId_1 = new JLabel("Reservation No : ");
		lblCustomerId_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblCustomerId_1.setBounds(24, 149, 122, 17);
		contentPane.add(lblCustomerId_1);
		
		cID = new JTextField();
		cID.setHorizontalAlignment(SwingConstants.LEFT);
		cID.setFont(new Font("Arial", Font.PLAIN, 14));
		cID.setColumns(10);
		cID.setBounds(149, 146, 74, 23);
		contentPane.add(cID);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		panel_1.setBackground(SystemColor.control);
		panel_1.setLayout(null);
		panel_1.setBounds(457, 83, 357, 60);
		contentPane.add(panel_1);
		
		JLabel lblRno_1 = new JLabel("Payment ID : ");
		lblRno_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRno_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblRno_1.setBounds(10, 22, 122, 17);
		panel_1.add(lblRno_1);
		
		tsearch = new JTextField();
		tsearch.setHorizontalAlignment(SwingConstants.LEFT);
		tsearch.setFont(new Font("Arial", Font.PLAIN, 14));
		tsearch.setColumns(10);
		tsearch.setBounds(122, 21, 122, 19);
		panel_1.add(tsearch);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tsearch.getText();
				try 
				{	
				    DefaultTableModel dt = (DefaultTableModel)table.getModel();
				    dt.setRowCount(0);
				    pst = con.prepareStatement("select * from payment where pId = '"+id+"'");
				    rs = pst.executeQuery();
				    
				    while(rs.next()) {
				    	Vector v = new Vector();
				    	v.add(rs.getString(1));//payment id
				    	v.add(rs.getString(2));//reservation no
				    	v.add(rs.getString(3));//email
				    	v.add(rs.getString(4));//payment type
				    	v.add(rs.getString(5));//amount
				    	v.add(rs.getString(6));//paid status
				    	
				    	
				    	
				    	dt.addRow(v);
				    	rs = pst.executeQuery("select * from payment where pId = '"+tsearch.getText()+"'");
				    	
				    	if(rs.next()) { 
				    		pID.setText(rs.getString("pId"));
					        cID.setText(rs.getString("rId"));
					        temail.setText(rs.getString("email"));
					        ptype.setSelectedItem(rs.getString("paytype"));
					        tamount.setText(rs.getString("amount"));
					        paidtype.setSelectedItem(rs.getString("pstatus"));
				    	}
				    }
					        
				}catch(SQLException e1) 
			     {
			        e1.printStackTrace();
			  } 
			}
		});
		btnFind.setFont(new Font("Arial", Font.PLAIN, 14));
		btnFind.setBounds(244, 20, 85, 21);
		panel_1.add(btnFind);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String paymentID;
				String resNo;
				String email;
				String paytype;
				String amount;
				String paystatus;
				
				paymentID = pID.getText();
				resNo = cID.getText();
				email = temail.getText();
				paytype= (String) ptype.getSelectedItem();
				amount = tamount.getText();
				paystatus = (String) paidtype.getSelectedItem();
				
				try {
			        pst = con.prepareStatement("insert into payment(pId,rId,email,paytype,amount,pstatus)values(?,?,?,?,?,?)");
			        pst.setString(1, paymentID);
			        pst.setString(2, resNo);
			        pst.setString(3, email);
			        pst.setString(4, paytype);
			        pst.setString(5, amount);
			        pst.setString(6, paystatus);
			        
			        
                    int rowsUpdated = pst.executeUpdate();
			        
			        if (rowsUpdated > 0) {
			            JOptionPane.showMessageDialog(null, "Record saved Successfully!");
			            table_load();
			        } else {
			            JOptionPane.showMessageDialog(null, "No records were saved.");
			        }
			        
			        pID.setText("");               
			        cID.setText("");
			        temail.setText("");
					ptype.setSelectedItem(null);
					tamount.setText("");
					paidtype.setSelectedItem(null);
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			    }


			}
		});
		btnSave.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSave.setBounds(24, 403, 85, 21);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String paymentID;
				String resNo;
				String email;
				String paytype;
				String amount;
				String paystatus;
				
				paymentID = pID.getText();
				resNo = cID.getText();
				email = temail.getText();
				paytype= (String) ptype.getSelectedItem();
				amount = tamount.getText();
				paystatus = (String) paidtype.getSelectedItem();
				
				try {
			        pst = con.prepareStatement("update payment set rId = ?,email = ?,paytype = ?,amount = ?,pstatus = ? where pId = ?");
			        pst.setString(1, resNo);
			        pst.setString(2, email);
			        pst.setString(3, paytype);
			        pst.setString(4, amount);
			        pst.setString(5, paystatus);
			        pst.setString(6, paymentID);
			        
			        
                    int rowsUpdated = pst.executeUpdate();
			        
			        if (rowsUpdated > 0) {
			            JOptionPane.showMessageDialog(null, "Record updated Successfully!");
			            table_load();
			        } else {
			            JOptionPane.showMessageDialog(null, "No records were updated.");
			        }
			        
			        pID.setText("");               
			        cID.setText("");
			        temail.setText("");
					ptype.setSelectedItem(null);
					tamount.setText("");
					paidtype.setSelectedItem(null);
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			    }


			
			}
		});
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 14));
		btnUpdate.setBounds(119, 403, 85, 21);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String paymentID = pID.getText();
				try {
					pst = con.prepareStatement("DELETE FROM payment WHERE pId = ?");
				    pst.setString(1, paymentID);
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
		btnDelete.setBounds(214, 403, 85, 21);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage.main(null);
			}
		});
		btnExit.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExit.setBounds(843, 451, 85, 21);
		contentPane.add(btnExit);
		
		Connect();
		autoID();
		table_load();
		
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
			rs = s.executeQuery("select Max(pId) from payment");
			rs.next();
			rs.getString("Max(pId)");
			
			if(rs.getString("Max(pId)")==null) {
				pID.setText("P0001");
			}
			else {
				Long resNo = Long.parseLong(rs.getString("MAX(pId)").substring(2, rs.getString("MAX(pId)").length()));
				resNo++;
				pID.setText("P"+ String.format("%04d", resNo));
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
	    DefaultTableModel dt = (DefaultTableModel)table.getModel();
	    dt.setRowCount(0);
	    pst = con.prepareStatement("select * from payment");
	    rs = pst.executeQuery();
	    
	    while(rs.next()) {
	    	Vector v = new Vector();
	    	v.add(rs.getString(1));//payment Id
	    	v.add(rs.getString(2));//reservation no
	    	v.add(rs.getString(3));//email
	    	v.add(rs.getString(4));//payment type
	    	v.add(rs.getString(5));//amount
	    	v.add(rs.getString(6));//paid status
	    	
	    	dt.addRow(v);
	    	
	    }
	 
	} 
	    catch (SQLException e) 
	     {
	        e.printStackTrace();
	  }
	}
	public void calculation() {
		
		
	}
}
