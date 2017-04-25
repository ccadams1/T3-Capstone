import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class AddCustomerScreen extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField firstNameTextField, lastNameTextField, cusAddressTextField, cusCityTextField;
	private JTextField cusStateTextField, cusZipTextField, cusPhoneTextField;
	private JTextField cusEmailTextField;
	public CustomerList customers = new CustomerList();
	public static Customer thisCustomer;
	
	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AddUserScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 */
	/**
	 * Create the application.
	 */
	public AddCustomerScreen(ArrayList<Object> data, Customer thisCustomer, JLabel customerLabel) {
		initialize(data, thisCustomer, customerLabel);
	}

	private void initialize(ArrayList<Object> data, Customer thisCustomer, JLabel customerLabel) {
		JDialog addingCus = new JDialog();

		addingCus.setAlwaysOnTop (true);
		addingCus.setSize(400,450);
		addingCus.setLocationRelativeTo(null);
		addingCus.setVisible(true);
		addingCus.setModal(true);
		addingCus.setModalityType(ModalityType.DOCUMENT_MODAL);
		addingCus.setTitle("Add Customer");
		addingCus.setLayout(null);

		customers = (CustomerList) data.get(1);
		Connection connect = (Connection) data.get(0);
		AddCustomerScreen.thisCustomer = thisCustomer;
		
		JLabel lblUsername = new JLabel("First Name:*");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(11, 24, 149, 29);
		addingCus.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Last Name:*");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(11, 62, 149, 29);
		addingCus.add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("Address:*");
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRetypePassword.setBounds(11, 100, 149, 29);
		addingCus.add(lblRetypePassword);
		
		JLabel lblFirstName = new JLabel("City:*");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(11, 138, 149, 29);
		addingCus.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("State:*");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(11, 176, 149, 29);
		addingCus.add(lblLastName);
		
		JLabel lblEmployeeRole = new JLabel("Zip Code:*");
		lblEmployeeRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeRole.setBounds(11, 214, 149, 29);
		addingCus.add(lblEmployeeRole);
		
		JLabel lblEmailAddress = new JLabel("Phone Number:*");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailAddress.setBounds(11, 252, 149, 29);
		addingCus.add(lblEmailAddress);
		
		JLabel lblPhoneNumber = new JLabel("Email:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(11, 290, 149, 29);
		addingCus.add(lblPhoneNumber);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(158, 17, 191, 35);
		addingCus.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(158, 55, 191, 35);
		addingCus.add(lastNameTextField);
		
		cusAddressTextField = new JTextField();
		cusAddressTextField.setColumns(10);
		cusAddressTextField.setBounds(158, 93, 191, 35);
		addingCus.add(cusAddressTextField);
		
		cusCityTextField = new JTextField();
		cusCityTextField.setColumns(10);
		addingCus.add(cusCityTextField);
		
		cusStateTextField = new JTextField();
		cusStateTextField.setColumns(10);
		cusStateTextField.setBounds(158, 169, 191, 35);
		addingCus.add(cusStateTextField);
		
		cusZipTextField = new JTextField();
		cusZipTextField.setColumns(10);
		cusZipTextField.setBounds(158, 207, 191, 35);
		addingCus.add(cusZipTextField);
		
		cusPhoneTextField = new JTextField();
		cusPhoneTextField.setColumns(10);
		cusPhoneTextField.setBounds(158, 245, 191, 35);
		addingCus.add(cusPhoneTextField);
		
		cusEmailTextField = new JTextField();
		cusEmailTextField.setColumns(10);
		cusEmailTextField.setBounds(158, 283, 191, 35);
		addingCus.add(cusEmailTextField);
		
		JButton btnAddUser = new JButton("Add Customer");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = firstNameTextField.getText().trim();
				String lastName = lastNameTextField.getText().trim();
				String cusAddress = cusAddressTextField.getText().trim();
				String cusCity = cusCityTextField.getText().trim();
				String cusState = cusStateTextField.getText().trim();
				int zipCode = 00000;
				try{
					zipCode = Integer.parseInt(cusZipTextField.getText().trim());
				}
				catch(NumberFormatException e1)
				{
				}	
				String cusPhone = cusPhoneTextField.getText().trim();
				String cusEmail = cusEmailTextField.getText().trim();
				
				if(firstName.equals("") || lastName.equals("") || cusAddress.equals("") || cusCity.equals("") || 
					cusState.equals("") || cusZipTextField.getText().equals("") || cusPhone.equals(""))
				{
					setWarningMsg("Please enter information in the *required boxes.");
				}
				else{
					Customer temp = new Customer(firstName, lastName, cusAddress, cusCity,
							cusState, zipCode, cusPhone, cusEmail);
					System.out.println("New Customer added");
					temp.setID(""+callAddCustomerProcedure(connect, temp));
					customers.addCustomer(temp);
					AddCustomerScreen.thisCustomer = temp;
					customerLabel.setText("Customer: " + thisCustomer.getID() + " " + thisCustomer.getFName() 
						+ " " + thisCustomer.getLName());
					addingCus.dispose();
				}
			}
		});
		
		btnAddUser.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				System.out.println(getName());
			}
		});
		
		btnAddUser.setBounds(99, 322, 155, 37);
		addingCus.add(btnAddUser);
	}
	
	protected int callAddCustomerProcedure(Connection connect, Customer temp) {
		CallableStatement stmt = null;
		
		int id = -1;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspAddCustomer(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, temp.getFName());
			stmt.setString(2, temp.getLName());
			stmt.setString(3, temp.getStAdress1());
			stmt.setString(4, temp.getStAdress2());
			stmt.setString(5, temp.getCity());
			stmt.setString(6, temp.getState());
			stmt.setInt(7, temp.getZipCode());
			stmt.setString(8, temp.getPhone1());
			stmt.setString(9, temp.getPhone2());
			stmt.setString(10, temp.getWebsite());
			stmt.setString(11, temp.getEmail());
			stmt.setString(12, temp.getFax());
			stmt.registerOutParameter(13, Types.VARCHAR);
			stmt.registerOutParameter(14, Types.INTEGER);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add new customer");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(13);
			id = stmt.getInt(14);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return id;
	}

	public void setWarningMsg(String text){
	    Toolkit.getDefaultToolkit().beep();
	    JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Warning!");
	    dialog.setAlwaysOnTop(true);
	    dialog.setVisible(true);
	}
}
