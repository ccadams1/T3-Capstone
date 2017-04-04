import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.sql.Connection; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class EditCustomerScreen extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextArea textArea;
	
	private CustomerList customers;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new EditUserScreen(data);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditCustomerScreen(ArrayList<Object> data)	{
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data) {
		this.setAlwaysOnTop (true);
		this.setSize(400,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Edit User");
		this.getContentPane().setLayout(null);
		
		customers = (CustomerList) data.get(1); 
		Connection connect = (Connection) data.get(0);
		
		JLabel lblUsername = new JLabel("Customer Id:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(10, 55, 149, 29);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("First Name:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(10, 93, 149, 29);
		getContentPane().add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("Last Name:");
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRetypePassword.setBounds(10, 131, 149, 29);
		getContentPane().add(lblRetypePassword);
		
		JLabel lblFirstName = new JLabel("Street Address:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(10, 169, 149, 29);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("City:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(10, 207, 149, 29);
		getContentPane().add(lblLastName);
		
		JLabel lblEmployeeRole = new JLabel("State:");
		lblEmployeeRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeRole.setBounds(10, 245, 149, 29);
		getContentPane().add(lblEmployeeRole);
		
		JLabel lblEmailAddress = new JLabel("Zip:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailAddress.setBounds(10, 283, 149, 29);
		getContentPane().add(lblEmailAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(10, 321, 149, 29);
		getContentPane().add(lblPhoneNumber);
		
		
		textField = new JTextField();
		textField.setBounds(158, 49, 191, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(158, 87, 191, 35);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(158, 125, 191, 35);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(158, 163, 191, 35);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(158, 201, 191, 35);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(158, 238, 191, 35);
		getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(158, 277, 191, 35);
		getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(158, 315, 191, 35);
		getContentPane().add(textField_7);
		
		
		
		JButton btnEditUser = new JButton("Edit User");
		/*
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminVerificationScreen();
			}
		});
		*/
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserId.setBounds(10, 17, 149, 29);
		getContentPane().add(lblUserId);
		
		textField_8 = new JTextField();
		textField_8.setToolTipText("Required to edit the customer");
		textField_8.setColumns(10);
		textField_8.setBounds(158, 11, 191, 35);
		getContentPane().add(textField_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 404, 372, 117);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setText(customers.toString());
				
		btnEditUser.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				String text_1 = textField_1.getText();
				String text_2 = textField_2.getText();
				String text_3 = textField_3.getText();
				String text_4 = textField_4.getText();
				String text_5 = textField_5.getText();
				String text_6 = textField_6.getText();
				String text_7 = textField_7.getText();
				String text_8 = textField_8.getText();

				if(text_8.equals("")){
					//Return warning (User Id Required)
					return;
				}
				int index = -1;
				
				for(int i = 0; i < customers.size(); i++)
				{
					if(customers.get(i).getID().equals(text_8))
					{
						index = i;
					}
				}
				if(index >= 0)
				{
					int counter = 0;
					String query = "UPDATE USER SET ";
					String queryTail = "";
					
					if(!text.equals(""))
					{
						customers.get(index).setFName(text);
						queryTail += "fName = " + text;
						counter++;
					}
					if(!text_1.equals(""))
					{
						customers.get(index).setLName(text_1);
						if(counter > 0)
						{
							queryTail += ", ";
						}
						queryTail += "lName = " + text_1;
						counter++;
					}
					if(!text_2.equals(""))
					{
						customers.get(index).setStAdress1(text_2);
						if(counter > 0)
						{
							queryTail += ", ";
						}
						queryTail += "st_address1 = " + text_2;
						counter++;
					}
					if(!text_3.equals(""))
					{
						customers.get(index).setCity(text_3);
						if(counter > 0)
						{
							queryTail += ", ";
						}
						queryTail += "city = " + text_3;
						counter++;
					}
					if(!text_4.equals(""))
					{
						customers.get(index).setState(text_4);
						if(counter > 0){
							queryTail += ", ";
						}
						queryTail += "state = " + text_4;
						counter++;
					}
					if(!text_5.equals(""))
					{
						customers.get(index).setZipCode(text_5);
						if(counter > 0)
						{
							queryTail += ", ";
						}
						queryTail += "zip_code = " + text_5;
						counter++;
					}
					if(!text_6.equals(""))
					{
						customers.get(index).setPhone1(text_6);
						if(counter > 0)
						{
							queryTail += ", ";
						}
						queryTail += "phone1 = " + text_6;
						counter++;
					}
					if(!text_7.equals(""))
					{
						customers.get(index).setEmail(text_7);
						if(counter > 0)
						{
							queryTail += ", ";
						}
						queryTail += "email = " + text_7;
						counter++;
					}
					
					query += queryTail + " WHERE UserID = " + text_8;
					if(counter > 0)
					{
						/*
						try{
							Statement stmt = connect.createStatement();
							stmt.executeQuery(query);
						}
						catch (SQLException e1){
							System.out.println(e1);
						}
						*/
					}
					updateDisplay();
				}
			}
		});

		btnEditUser.setBounds(99, 356, 155, 37);
		getContentPane().add(btnEditUser);
	}

	private void updateDisplay(){
		textArea.setText(customers.toString());
	}
}