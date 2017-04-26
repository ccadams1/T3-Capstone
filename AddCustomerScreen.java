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
	//sets up variables
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
	public AddCustomerScreen(ArrayList<Object> data, CheckoutButtonScreen cBS, JLabel customerLabel) {
		initialize(data, cBS, customerLabel);
	}

	private void initialize(ArrayList<Object> data, CheckoutButtonScreen cBS, JLabel customerLabel) {
		//creates jdialog variable
		JDialog addingCus = new JDialog();

		//sets up screen properties
		addingCus.setAlwaysOnTop (true);
		addingCus.setSize(400,450);
		addingCus.setLocationRelativeTo(null);
		addingCus.setVisible(true);
		addingCus.setModal(true);
		addingCus.setModalityType(ModalityType.DOCUMENT_MODAL);
		addingCus.setTitle("Add Customer");
		addingCus.setLayout(null);

		//gets database information
		customers = (CustomerList) data.get(1);
		Connection connect = (Connection) data.get(0);
		
		//customer related label and textFields
		JLabel lblFName = new JLabel("First Name:*");
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFName.setBounds(11, 24, 149, 29);
		addingCus.add(lblFName);
		
		JLabel lblLName = new JLabel("Last Name:*");
		lblLName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLName.setBounds(11, 62, 149, 29);
		addingCus.add(lblLName);
		
		JLabel lblAddress = new JLabel("Address:*");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(11, 100, 149, 29);
		addingCus.add(lblAddress);
		
		JLabel lblCity = new JLabel("City:*");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCity.setBounds(11, 138, 149, 29);
		addingCus.add(lblCity);
		
		JLabel lblState = new JLabel("State:*");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblState.setBounds(11, 176, 149, 29);
		addingCus.add(lblState);
		
		JLabel lblZipCode = new JLabel("Zip Code:*");
		lblZipCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblZipCode.setBounds(11, 214, 149, 29);
		addingCus.add(lblZipCode);
		
		JLabel lblPhone = new JLabel("Phone Number:*");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhone.setBounds(11, 252, 149, 29);
		addingCus.add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(11, 290, 149, 29);
		addingCus.add(lblEmail);
		
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
		cusCityTextField.setBounds(158, 131, 191, 35);
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
		
		//add Customer button
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gets TextField data
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
				
				//checks for required textFields
				if(firstName.equals("") || lastName.equals("") || cusAddress.equals("") || cusCity.equals("") || 
					cusState.equals("") || cusZipTextField.getText().equals("") || cusPhone.equals(""))
				{
					setWarningMsg("Please enter information in the *required boxes.");
				}
				else{
					Customer temp = new Customer(firstName, lastName, cusAddress, cusCity,
							cusState, zipCode, cusPhone, cusEmail);
					System.out.println("New Customer added");
					//adds customer to database
					temp.setID(""+callAddCustomerProcedure(connect, temp));
					//adds customer to program data
					customers.addCustomer(temp);
					//sets CheckoutButtonScreen's thisCustomer as the new customer
					cBS.setCustomer(temp);
					customerLabel.setText("Customer: " + temp.getID() + " " + temp.getFName() 
						+ " " + temp.getLName());
					//closes this screen
					addingCus.dispose();
				}
			}
		});
		
		btnAddCustomer.setBounds(99, 322, 155, 37);
		addingCus.add(btnAddCustomer);
	}
	
	//add customer callable procedure
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

	//warning JDialog message
	public void setWarningMsg(String text){
	    Toolkit.getDefaultToolkit().beep();
	    JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Warning!");
	    dialog.setAlwaysOnTop(true);
	    dialog.setVisible(true);
	}
}
