import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class AddSupplierScreen extends JDialog {
	//sets up variables
	private static final long serialVersionUID = 1L;
	private JTextField supNameTextField, supAddressTextField, supCityTextField;
	private JTextField supStateTextField, supZipTextField, supEmailTextField;
	private JTextField supWebsiteTextField, supPhoneTextField;
	public SupplierList suppliers = new SupplierList();
	public boolean added = false;
	
	/** Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseConnection database = new DatabaseConnection();
					Connection connection = database.getConnection();
					ArrayList<Object> data = new ArrayList<Object>();
					data.add(connection); //get(0)
					SupplierList suppliers = new SupplierList(); 
					Supplier company1 = new Supplier("Company 1", "2200", "928 make money st", "", "raleigh", "NC", 12345,
							null, "8757", null, "www.gobusiness.com", "company@company.com", null, false);
					Supplier company2 = new Supplier("Company 2", "1230", "644 business dr", "", "raleigh", "NC", 12345,
							null, "9182", null, "www.getmore.com", "company@pro.com", null, false);
					suppliers.addSupplier(company1);
					suppliers.addSupplier(company2);
					data.add(suppliers);
					new AddSupplierScreen(data);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
 
	/**
	 * Create the application.
	 */
	public AddSupplierScreen(ArrayList<Object> data, JComboBox<String> list) {
		list.setSelectedItem("");
		initialize(data, list);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data, JComboBox<String> list) {
		//initiates itself
		JDialog addingSups = new JDialog();
		
		//sets screen properties
		addingSups.setAlwaysOnTop (true);
		addingSups.setSize(400,450);
		addingSups.setLocationRelativeTo(null);
		addingSups.setVisible(true);
		addingSups.setModal(true);
		addingSups.setModalityType(ModalityType.DOCUMENT_MODAL);
		addingSups.setTitle("Add Supplier");
		addingSups.getContentPane().setLayout(null);

		//gets database information
		suppliers = (SupplierList) data.get(5);
		Connection connect = (Connection) data.get(0);
		
		//labels and TextFields related to Suppliers
		JLabel lblUsername = new JLabel("Supplier Name:*");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(11, 24, 149, 29);
		addingSups.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Address:*");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(11, 62, 149, 29);
		addingSups.add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("City:*");
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRetypePassword.setBounds(11, 100, 149, 29);
		addingSups.add(lblRetypePassword);
		
		JLabel lblFirstName = new JLabel("State:*");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(11, 138, 149, 29);
		addingSups.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Zip Code:*");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(11, 176, 149, 29);
		addingSups.add(lblLastName);
		
		JLabel lblEmployeeRole = new JLabel("Email:");
		lblEmployeeRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeRole.setBounds(11, 214, 149, 29);
		addingSups.add(lblEmployeeRole);
		
		JLabel lblEmailAddress = new JLabel("Website:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailAddress.setBounds(11, 252, 149, 29);
		addingSups.add(lblEmailAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(11, 290, 149, 29);
		addingSups.add(lblPhoneNumber);
		
		supNameTextField = new JTextField();
		supNameTextField.setBounds(158, 17, 191, 35);
		addingSups.add(supNameTextField);
		supNameTextField.setColumns(10);
		
		supAddressTextField = new JTextField();
		supAddressTextField.setColumns(10);
		supAddressTextField.setBounds(158, 55, 191, 35);
		addingSups.add(supAddressTextField);
		
		supCityTextField = new JTextField();
		supCityTextField.setColumns(10);
		supCityTextField.setBounds(158, 93, 191, 35);
		addingSups.add(supCityTextField);
		
		supStateTextField = new JTextField();
		supStateTextField.setColumns(10);
		supStateTextField.setBounds(158, 131, 191, 35);
		addingSups.add(supStateTextField);
		
		supZipTextField = new JTextField();
		supZipTextField.setColumns(10);
		supZipTextField.setBounds(158, 169, 191, 35);
		addingSups.add(supZipTextField);
		
		supEmailTextField = new JTextField();
		supEmailTextField.setColumns(10);
		supEmailTextField.setBounds(158, 207, 191, 35);
		addingSups.add(supEmailTextField);
		
		supWebsiteTextField = new JTextField();
		supWebsiteTextField.setColumns(10);
		supWebsiteTextField.setBounds(158, 245, 191, 35);
		addingSups.add(supWebsiteTextField);
		
		supPhoneTextField = new JTextField();
		supPhoneTextField.setColumns(10);
		supPhoneTextField.setBounds(158, 283, 191, 35);
		addingSups.add(supPhoneTextField);
		
		//add supplier button
		JButton btnAddSupplier = new JButton("Add Supplier");
		btnAddSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gets information from TextFields
				String supName = supNameTextField.getText().trim();
				String supAddress = supAddressTextField.getText().trim();
				String supCity = supCityTextField.getText().trim();
				String supState = supStateTextField.getText().trim();
				int supZip = Integer.parseInt(supZipTextField.getText().trim());
				String supEmail = supEmailTextField.getText().trim();
				String supWebsite = supWebsiteTextField.getText().trim();
				String supPhone = supPhoneTextField.getText().trim();
				
				//check for required information
				if(supName.equals("") || supAddress.equals("") || supCity.equals("") || 
						supState.equals("") || supZipTextField.getText().equals("")){
					setWarningMsg("Please enter information in the *required boxes.");
				}
				else{
					Supplier temp = new Supplier(supName, supAddress, supCity, supState,
						supZip, supEmail, supWebsite, supPhone);
				
					//checks for administrator approval
					AdminVerificationScreen adminveri = new AdminVerificationScreen(data);
					if (adminveri.verify)
					{
						System.out.println("New Supplier added");
						//adds supplier to database
						temp.setID(callAddSupplierProcedure(connect, temp));
						//adds supplier to program
						suppliers.addSupplier(temp);
						added = true;
						list.removeAllItems();
						//adds new supplier to comboBox list and selects it 
						for(int x = 0; x< suppliers.size(); x++)
						{
							list.addItem(suppliers.getSupplier(x).getName());
						}
						list.addItem("New Supplier");
						list.setSelectedIndex(suppliers.size()-1);
						list.revalidate();
						addingSups.dispose();
					}
					else
					{
						setWarningMsg("Administrator not verified. No "
								+ "information was saved.");
					}
				}
			}
		});
		btnAddSupplier.setBounds(99, 322, 155, 37);
		addingSups.add(btnAddSupplier);
	}
	
	//callable procedure to add supplier to database
	protected int callAddSupplierProcedure(Connection connect, Supplier temp) {
		CallableStatement stmt = null;
			
		int id = -1;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspAddSupplier(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, temp.getName());
			stmt.setString(2, temp.getStAdress1());
			stmt.setString(3, temp.getStAdress2());
			stmt.setString(4, temp.getCity());
			stmt.setString(5, temp.getState());
			stmt.setInt(6, temp.getZipCode());
			stmt.setBinaryStream(7, null);
			stmt.setString(8, temp.getPhone1());
			stmt.setString(9, temp.getPhone2());
			stmt.setString(10, temp.getWebsite());
			stmt.setString(11, temp.getEmail());
			stmt.setString(12, temp.getFax());
			stmt.setInt(13, /*temp.isRemoved()*/0);
			stmt.registerOutParameter(14, Types.VARCHAR);
			stmt.registerOutParameter(15, Types.INTEGER);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add new supplier");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(14);
			id = stmt.getInt(15);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return id;
	}
	
	//warning jdialog message
	public void setWarningMsg(String text){
	    Toolkit.getDefaultToolkit().beep();
	    JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Warning!");
	    dialog.setAlwaysOnTop(true);
	    dialog.setVisible(true);
	}
}
