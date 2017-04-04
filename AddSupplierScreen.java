import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class AddSupplierScreen extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField supNameTextField, supAddressTextField, supCityTextField;
	private JTextField supStateTextField, supZipTextField, supEmailTextField;
	private JTextField supWebsiteTextField, supPhoneTextField;
	public SupplierList suppliers = new SupplierList();
	
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
	public AddSupplierScreen(ArrayList<Object> data) {
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data) {
		this.setAlwaysOnTop (true);
		this.setSize(400,450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Add Supplier");
		this.getContentPane().setLayout(null);

		suppliers = (SupplierList) data.get(5);
		Connection connect = (Connection) data.get(0);
		
		JLabel lblUsername = new JLabel("Supplier Name:*");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(11, 24, 149, 29);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Address:*");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(11, 62, 149, 29);
		getContentPane().add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("City:*");
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRetypePassword.setBounds(11, 100, 149, 29);
		getContentPane().add(lblRetypePassword);
		
		JLabel lblFirstName = new JLabel("State:*");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(11, 138, 149, 29);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Zip_Code:*");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(11, 176, 149, 29);
		getContentPane().add(lblLastName);
		
		JLabel lblEmployeeRole = new JLabel("Email:");
		lblEmployeeRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeRole.setBounds(11, 214, 149, 29);
		getContentPane().add(lblEmployeeRole);
		
		JLabel lblEmailAddress = new JLabel("Website:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailAddress.setBounds(11, 252, 149, 29);
		getContentPane().add(lblEmailAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(11, 290, 149, 29);
		getContentPane().add(lblPhoneNumber);
		
		supNameTextField = new JTextField();
		supNameTextField.setBounds(158, 17, 191, 35);
		getContentPane().add(supNameTextField);
		supNameTextField.setColumns(10);
		
		supAddressTextField = new JTextField();
		supAddressTextField.setColumns(10);
		supAddressTextField.setBounds(158, 55, 191, 35);
		getContentPane().add(supAddressTextField);
		
		supCityTextField = new JTextField();
		supCityTextField.setColumns(10);
		supCityTextField.setBounds(158, 93, 191, 35);
		getContentPane().add(supCityTextField);
		
		supStateTextField = new JTextField();
		supStateTextField.setColumns(10);
		supStateTextField.setBounds(158, 131, 191, 35);
		getContentPane().add(supStateTextField);
		
		supZipTextField = new JTextField();
		supZipTextField.setColumns(10);
		supZipTextField.setBounds(158, 169, 191, 35);
		getContentPane().add(supZipTextField);
		
		supEmailTextField = new JTextField();
		supEmailTextField.setColumns(10);
		supEmailTextField.setBounds(158, 207, 191, 35);
		getContentPane().add(supEmailTextField);
		
		supWebsiteTextField = new JTextField();
		supWebsiteTextField.setColumns(10);
		supWebsiteTextField.setBounds(158, 245, 191, 35);
		getContentPane().add(supWebsiteTextField);
		
		supPhoneTextField = new JTextField();
		supPhoneTextField.setColumns(10);
		supPhoneTextField.setBounds(158, 283, 191, 35);
		getContentPane().add(supPhoneTextField);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String supName = supNameTextField.getText();
				String supAddress = supAddressTextField.getText();
				String supCity = supCityTextField.getText();
				String supState = supStateTextField.getText();
				String supZip = supZipTextField.getText();
				String supEmail = supEmailTextField.getText();
				String supWebsite = supWebsiteTextField.getText();
				String supPhone = supPhoneTextField.getText();
				
				
				Supplier temp = new Supplier(supName, supAddress, supCity, supState,
						supZip, supEmail, supWebsite, supPhone);
				boolean temps = true;
				AdminVerificationScreen adminveri = new AdminVerificationScreen(data, temps);
				adminveri.addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						if (adminveri.getVerification())
						{
							suppliers.addSupplier(temp);
									
							//Temp code to test functionality
							temp.print();
						}
						else
						{
							setWarningMsg("Administrator not verified. No "
									+ "information was saved.");
						}
					}
				});
			}
		});
		btnAddUser.setBounds(99, 322, 155, 37);
		getContentPane().add(btnAddUser);
	}
	

	public void setWarningMsg(String text){
	    Toolkit.getDefaultToolkit().beep();
	    JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Warning!");
	    dialog.setAlwaysOnTop(true);
	    dialog.setVisible(true);
	}
}
