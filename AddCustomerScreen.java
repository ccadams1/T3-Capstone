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

public class AddCustomerScreen extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField firstNameTextField, lastNameTextField, cusAddressTextField, cusCityTextField;
	private JTextField cusStateTextField, cusZipTextField, cusPhoneTextField;
	private JTextField cusEmailTextField;
	public CustomerList customers = new CustomerList();
	
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
	public AddCustomerScreen(ArrayList<Object> data) {
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
		this.setTitle("Add Customer");
		this.getContentPane().setLayout(null);

		customers = (CustomerList) data.get(1);
		Connection connect = (Connection) data.get(0);
		
		JLabel lblUsername = new JLabel("First Name:*");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(11, 24, 149, 29);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Last Name:*");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(11, 62, 149, 29);
		getContentPane().add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("Address:*");
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRetypePassword.setBounds(11, 100, 149, 29);
		getContentPane().add(lblRetypePassword);
		
		JLabel lblFirstName = new JLabel("City:*");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(11, 138, 149, 29);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("State:*");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(11, 176, 149, 29);
		getContentPane().add(lblLastName);
		
		JLabel lblEmployeeRole = new JLabel("Zip Code:");
		lblEmployeeRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeRole.setBounds(11, 214, 149, 29);
		getContentPane().add(lblEmployeeRole);
		
		JLabel lblEmailAddress = new JLabel("Phone Number:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailAddress.setBounds(11, 252, 149, 29);
		getContentPane().add(lblEmailAddress);
		
		JLabel lblPhoneNumber = new JLabel("Email:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(11, 290, 149, 29);
		getContentPane().add(lblPhoneNumber);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(158, 17, 191, 35);
		getContentPane().add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(158, 55, 191, 35);
		getContentPane().add(lastNameTextField);
		
		cusAddressTextField = new JTextField();
		cusAddressTextField.setColumns(10);
		cusAddressTextField.setBounds(158, 93, 191, 35);
		getContentPane().add(cusAddressTextField);
		
		cusCityTextField = new JTextField();
		cusCityTextField.setColumns(10);
		cusCityTextField.setBounds(158, 131, 191, 35);
		getContentPane().add(cusCityTextField);
		
		cusStateTextField = new JTextField();
		cusStateTextField.setColumns(10);
		cusStateTextField.setBounds(158, 169, 191, 35);
		getContentPane().add(cusStateTextField);
		
		cusZipTextField = new JTextField();
		cusZipTextField.setColumns(10);
		cusZipTextField.setBounds(158, 207, 191, 35);
		getContentPane().add(cusZipTextField);
		
		cusPhoneTextField = new JTextField();
		cusPhoneTextField.setColumns(10);
		cusPhoneTextField.setBounds(158, 245, 191, 35);
		getContentPane().add(cusPhoneTextField);
		
		cusEmailTextField = new JTextField();
		cusEmailTextField.setColumns(10);
		cusEmailTextField.setBounds(158, 283, 191, 35);
		getContentPane().add(cusEmailTextField);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = firstNameTextField.getText();
				String lastName = lastNameTextField.getText();
				String cusAddress = cusAddressTextField.getText();
				String cusCity = cusCityTextField.getText();
				String cusState = cusStateTextField.getText();
				String cusZip = cusZipTextField.getText();
				String cusPhone = cusPhoneTextField.getText();
				String cusEmail = cusEmailTextField.getText();
				
				
				Customer temp = new Customer(firstName, lastName, cusAddress, cusCity, cusState,
						cusZip, cusPhone, cusEmail);
				boolean temps = true;
				AdminVerificationScreen adminveri = new AdminVerificationScreen(data, temps);
				adminveri.addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						if (adminveri.getVerification())
						{
							customers.addCustomer(temp);
									
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
