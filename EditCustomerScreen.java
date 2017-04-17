import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.sql.CallableStatement;
import java.sql.Connection; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList; 
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class EditCustomerScreen extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField addressTextField;
	private JTextField cityTextField;
	private JTextField stateTextField;
	private JTextField zipCodeTextField;
	private JTextField phoneTextField;
	private JTextField emailTextField;
	private JTextField customerIDtextField;
	private JTextArea textArea;
	private Customer selectedCustomer;
	
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
		this.setModalityType(ModalityType.DOCUMENT_MODAL);
		this.setTitle("Edit Customer");
		this.getContentPane().setLayout(null);
		
		customers = (CustomerList) data.get(1); 
		Connection connect = (Connection) data.get(0);
		

		JLabel lblCustomerId = new JLabel("Customer ID*:");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustomerId.setBounds(10, 17, 149, 29);
		getContentPane().add(lblCustomerId);
		
		JLabel lblFName = new JLabel("First Name:");
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFName.setBounds(10, 55, 149, 29);
		getContentPane().add(lblFName);
		
		JLabel lblLName = new JLabel("Last Name:");
		lblLName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLName.setBounds(10, 93, 149, 29);
		getContentPane().add(lblLName);
		
		JLabel lblAddress = new JLabel("Street Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(10, 131, 149, 29);
		getContentPane().add(lblAddress);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCity.setBounds(10, 169, 149, 29);
		getContentPane().add(lblCity);
		
		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblState.setBounds(10, 207, 149, 29);
		getContentPane().add(lblState);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblZipCode.setBounds(10, 245, 149, 29);
		getContentPane().add(lblZipCode);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhone.setBounds(10, 283, 149, 29);
		getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(10, 321, 149, 29);
		getContentPane().add(lblEmail);
		
		customerIDtextField = new JTextField();
		customerIDtextField.setToolTipText("Required to edit the customer");
		customerIDtextField.setColumns(10);
		customerIDtextField.setBounds(158, 11, 191, 35);
		customerIDtextField.setText("");
		getContentPane().add(customerIDtextField);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(158, 49, 191, 35);
		getContentPane().add(firstNameTextField);
		firstNameTextField.setText("");
		firstNameTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(158, 87, 191, 35);
		lastNameTextField.setText("");
		getContentPane().add(lastNameTextField);
		
		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(158, 125, 191, 35);
		addressTextField.setText("");
		getContentPane().add(addressTextField);
		
		cityTextField = new JTextField();
		cityTextField.setColumns(10);
		cityTextField.setBounds(158, 163, 191, 35);
		cityTextField.setText("");
		getContentPane().add(cityTextField);
		
		stateTextField = new JTextField();
		stateTextField.setColumns(10);
		stateTextField.setBounds(158, 201, 191, 35);
		stateTextField.setText("");
		getContentPane().add(stateTextField);
		
		zipCodeTextField = new JTextField();
		zipCodeTextField.setColumns(10);
		zipCodeTextField.setBounds(158, 238, 191, 35);
		zipCodeTextField.setText("");
		getContentPane().add(zipCodeTextField);
		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(158, 277, 191, 35);
		phoneTextField.setText("");
		getContentPane().add(phoneTextField);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(158, 315, 191, 35);
		emailTextField.setText("");
		getContentPane().add(emailTextField);
				
		JButton btnEditCustomer = new JButton("Edit Customer");
		btnEditCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerID = customerIDtextField.getText();
				String fName = firstNameTextField.getText();
				String lName = lastNameTextField.getText();
				String address = addressTextField.getText();
				String city = cityTextField.getText();
				String state = stateTextField.getText();
				int zipCode = 00000;
				try{
					zipCode = Integer.parseInt(zipCodeTextField.getText());
				}
				catch(NumberFormatException e1)
				{
				}
				String phone = phoneTextField.getText();
				String email = emailTextField.getText();
				
				if(customerID.equals("")){
					setWarningMsg("Please enter information in the *required boxes.");
				}
				else{
					for(int x = 0; x < customers.size(); x++)
					{
						if(customers.getCustomer(x).getID().equals(customerID))
						{
							selectedCustomer = customers.getCustomer(x);
						}
					}

					AdminVerificationScreen adminveri = new AdminVerificationScreen(data);
					if (adminveri.verify)
					{
						callEditCustomerProcedure(connect, selectedCustomer);
						if(!fName.equals(""))
						{
							selectedCustomer.setFName(fName);
						}
						if(!lName.equals(""))
						{
							selectedCustomer.setLName(lName);
						}
						if(!address.equals(""))
						{
							selectedCustomer.setStAdress1(address);
						}
						if(!city.equals(""))
						{
							selectedCustomer.setCity(city);
						}
						if(!state.equals(""))
						{
							selectedCustomer.setState(state);
						}
						if(!zipCodeTextField.getText().equals(""))
						{
							selectedCustomer.setZipCode(zipCode);
						}
						if(!phone.equals(""))
						{
							selectedCustomer.setPhone1(phone);
						}
						if(!email.equals(""))
						{
							selectedCustomer.setEmail(email);
						}
						System.out.println("User customer complete");
						updateDisplay();
					}
					else
					{
						setWarningMsg("Administrator not verified. No "
								+ "information was saved.");
					}
				}
			}
		});
		btnEditCustomer.setBounds(99, 356, 155, 37);
		getContentPane().add(btnEditCustomer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 404, 372, 117);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		updateDisplay();
	}

	protected void callEditCustomerProcedure(Connection connect, Customer temp) {
		CallableStatement stmt = null;
				
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditCustomer(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setInt(1, Integer.parseInt(temp.getID()));
			stmt.setString(2, temp.getFName());
			stmt.setString(3, temp.getLName());
			stmt.setString(4, temp.getStAdress1());
			stmt.setString(5, "");
			stmt.setString(6, temp.getCity());
			stmt.setString(7, temp.getState());
			stmt.setInt(8, temp.getZipCode());
			stmt.setString(9, temp.getPhone1());
			stmt.setString(10, "");
			stmt.setString(11, temp.getWebsite());
			stmt.setString(12, temp.getEmail());
			stmt.setString(13, "");
			stmt.registerOutParameter(14, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to edit customer");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(14);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	
	private void updateDisplay(){
		String allCustomers = "";
		for(int x = 0; x < customers.size(); x++)
		{
			allCustomers += customers.getCustomer(x).toString() + "\n";
		}
		textArea.setText(allCustomers);
	}
	
	public void setWarningMsg(String text){
	    Toolkit.getDefaultToolkit().beep();
	    JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Warning!");
	    dialog.setAlwaysOnTop(true);
	    dialog.setVisible(true);
	}
}