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

public class EditSupplierScreen extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField supplierIDTextField;
	private JTextField supplierNameTextField;
	private JTextField addressTextField;
	private JTextField cityTextField;
	private JTextField stateTextField;
	private JTextField zipCodeTextField;
	private JTextField phoneTextField;
	private JTextField websiteTextField;
	private JTextField emailTextField;
	private JTextArea textArea;
	private SupplierList suppliers;
	private Supplier selectedSupplier;
	

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
	public EditSupplierScreen(ArrayList<Object> data)	{
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
		this.setTitle("Edit Supplier");
		this.getContentPane().setLayout(null);
		
		suppliers = (SupplierList) data.get(5); 
		Connection connect = (Connection) data.get(0);

		JLabel lblSupplierId = new JLabel("Supplier ID*:");
		lblSupplierId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSupplierId.setBounds(10, 17, 149, 29);
		getContentPane().add(lblSupplierId);
		
		JLabel lblSupplierName = new JLabel("Supplier Name:");
		lblSupplierName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSupplierName.setBounds(10, 55, 149, 29);
		getContentPane().add(lblSupplierName);
		
		JLabel lblAddress = new JLabel("Street Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(10, 93, 149, 29);
		getContentPane().add(lblAddress);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCity.setBounds(10, 131, 149, 29);
		getContentPane().add(lblCity);
		
		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblState.setBounds(10, 169, 149, 29);
		getContentPane().add(lblState);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblZipCode.setBounds(10, 207, 149, 29);
		getContentPane().add(lblZipCode);
		
		JLabel lblPhone = new JLabel("Phone Number:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhone.setBounds(10, 245, 149, 29);
		getContentPane().add(lblPhone);
		
		JLabel lblWebsite = new JLabel("Website:");
		lblWebsite.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWebsite.setBounds(10, 283, 149, 29);
		getContentPane().add(lblWebsite);
		
		JLabel lblEmailAddress = new JLabel("Email:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailAddress.setBounds(10, 321, 149, 29);
		getContentPane().add(lblEmailAddress);
		
		supplierIDTextField = new JTextField();
		supplierIDTextField.setToolTipText("Required to edit the user");
		supplierIDTextField.setColumns(10);
		supplierIDTextField.setBounds(158, 11, 191, 35);
		getContentPane().add(supplierIDTextField);
		
		supplierNameTextField = new JTextField();
		supplierNameTextField.setBounds(158, 49, 191, 35);
		getContentPane().add(supplierNameTextField);
		supplierNameTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(158, 87, 191, 35);
		getContentPane().add(addressTextField);
		
		cityTextField = new JTextField();
		cityTextField.setColumns(10);
		cityTextField.setBounds(158, 125, 191, 35);
		getContentPane().add(cityTextField);
		
		stateTextField = new JTextField();
		stateTextField.setColumns(10);
		stateTextField.setBounds(158, 163, 191, 35);
		getContentPane().add(stateTextField);
		
		zipCodeTextField = new JTextField();
		zipCodeTextField.setColumns(10);
		zipCodeTextField.setBounds(158, 201, 191, 35);
		getContentPane().add(zipCodeTextField);
		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(158, 238, 191, 35);
		getContentPane().add(phoneTextField);
		
		websiteTextField = new JTextField();
		websiteTextField.setColumns(10);
		websiteTextField.setBounds(158, 277, 191, 35);
		getContentPane().add(websiteTextField);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(158, 315, 191, 35);
		getContentPane().add(emailTextField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 404, 372, 117);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setText(suppliers.toString());
				
		JButton btnEditUser = new JButton("Edit Supplier");
		btnEditUser.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int supplierId = Integer.parseInt(supplierIDTextField.getText().trim());
				String supplierName = supplierNameTextField.getText();
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
				String website = websiteTextField.getText();
				String email = emailTextField.getText();

				if(supplierIDTextField.getText().equals("")){	
					setWarningMsg("Please enter information in the *required boxes.");
				}else{
					for(int x = 0; x < suppliers.size(); x++)
					{
						if(suppliers.getSupplier(x).getID()==supplierId)
						{
							selectedSupplier = suppliers.getSupplier(x);
						}
					}

					AdminVerificationScreen adminveri = new AdminVerificationScreen(data);
					if (adminveri.verify)
					{
						callEditSupplierProcedure(connect, selectedSupplier);
						if(!supplierIDTextField.getText().equals(""))
						{
							selectedSupplier.setID(supplierId);
						}
						if(!supplierName.equals(""))
						{
							selectedSupplier.setName(supplierName);
						}
						if(!address.equals(""))
						{
							selectedSupplier.setStAdress1(address);
						}
						if(!city.equals(""))
						{
							selectedSupplier.setCity(city);
						}
						if(!state.equals(""))
						{
							selectedSupplier.setState(state);
						}
						if(!zipCodeTextField.getText().equals(""))
						{
							selectedSupplier.setZipCode(zipCode);
						}
						if(!phone.equals(""))
						{
							selectedSupplier.setPhone1(phone);
						}
						if(!website.equals(""))
						{
							selectedSupplier.setWebsite(website);
						}
						if(!email.equals(""))
						{
							selectedSupplier.setEmail(email);
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
		btnEditUser.setBounds(99, 356, 155, 37);
		getContentPane().add(btnEditUser);
		
		updateDisplay();
	}
	
	protected void callEditSupplierProcedure(Connection connect, Supplier temp) {
		CallableStatement stmt = null;
			
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditSupplier(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setInt(1, temp.getID());
			stmt.setString(2, temp.getName());
			stmt.setString(3, temp.getStAdress1());
			stmt.setString(4, temp.getStAdress2());
			stmt.setString(5, temp.getCity());
			stmt.setString(6, temp.getState());
			stmt.setInt(7, temp.getZipCode());
			stmt.setBinaryStream(8, null);
			stmt.setString(9, temp.getPhone1());
			stmt.setString(10, temp.getPhone2());
			stmt.setString(11, temp.getWebsite());
			stmt.setString(12, temp.getEmail());
			stmt.setString(13, temp.getFax());
			stmt.setInt(14, /*temp.isRemoved()*/0);
			stmt.registerOutParameter(15, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to edit supplier");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(15);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	
	private void updateDisplay(){
		String allSuppliers = "";
		for(int x = 0; x < suppliers.size(); x++)
		{
			allSuppliers += suppliers.getSupplier(x).toString() + "\n";
		}
		textArea.setText(allSuppliers);
	}
	
	public void setWarningMsg(String text){
	    Toolkit.getDefaultToolkit().beep();
	    JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Warning!");
	    dialog.setAlwaysOnTop(true);
	    dialog.setVisible(true);
	}
}