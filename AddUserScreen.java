import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;

public class AddUserScreen extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField retypePasswordTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField phoneTextField;
	public EmployeeList employees = new EmployeeList();
	
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public AddUserScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setAlwaysOnTop (true);
		this.setSize(400,450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Add User");
		this.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:*");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(11, 24, 149, 29);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:*");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(11, 62, 149, 29);
		getContentPane().add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("Retype Password:*");
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRetypePassword.setBounds(11, 100, 149, 29);
		getContentPane().add(lblRetypePassword);
		
		JLabel lblFirstName = new JLabel("First name:*");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(11, 138, 149, 29);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name:*");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(11, 176, 149, 29);
		getContentPane().add(lblLastName);
		
		JLabel lblEmployeeRole = new JLabel("Employee role:*");
		lblEmployeeRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeRole.setBounds(11, 214, 149, 29);
		getContentPane().add(lblEmployeeRole);
		
		JLabel lblEmailAddress = new JLabel("Email address:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailAddress.setBounds(11, 252, 149, 29);
		getContentPane().add(lblEmailAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(11, 290, 149, 29);
		getContentPane().add(lblPhoneNumber);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(158, 17, 191, 35);
		getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(158, 55, 191, 35);
		getContentPane().add(passwordTextField);
		
		retypePasswordTextField = new JTextField();
		retypePasswordTextField.setColumns(10);
		retypePasswordTextField.setBounds(158, 93, 191, 35);
		getContentPane().add(retypePasswordTextField);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(158, 131, 191, 35);
		getContentPane().add(firstNameTextField);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(158, 169, 191, 35);
		getContentPane().add(lastNameTextField);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(158, 245, 191, 35);
		getContentPane().add(emailTextField);
		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(158, 283, 191, 35);
		getContentPane().add(phoneTextField);
		
		JComboBox<String> empRoleComboBox = new JComboBox<String>();
		////////////////Temp code for testing purposes/////////////
		empRoleComboBox.addItem("");
		empRoleComboBox.addItem("Inventory Manager");
		empRoleComboBox.addItem("Inventory User");
		empRoleComboBox.addItem("POS Manager");
		empRoleComboBox.addItem("POS User");
		empRoleComboBox.setSelectedItem("");
		///////////////////////////////////////////////////////////
		empRoleComboBox.setBounds(158, 207, 191, 35);
		getContentPane().add(empRoleComboBox);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = usernameTextField.getText();
				String text_1 = passwordTextField.getText();
				String text_2 = retypePasswordTextField.getText();
				String text_3 = firstNameTextField.getText();
				String text_4 = lastNameTextField.getText();
				////////////temp code for user role////////////////////////////////////
				String userRole = (String) empRoleComboBox.getSelectedItem();
				///////////////////////////////////////////////////////////////////////
				String text_5 = emailTextField.getText();
				String text_6 = phoneTextField.getText();
				
				
				if(text.equals("") || text_1.equals("") || text_2.equals("") || 
						text_3.equals("") || text_4.equals("") || 
						userRole.equals("")){
					System.out.println(userRole);
					setWarningMsg("Please enter information in the *required boxes.");
				}
				else if(text_1.length() < 8){
					setWarningMsg("Password is too small. Password minimum is 8 characters.");
				}
				else if(text_1.length() > 16){
					setWarningMsg("Password is too large. Password maximum is 16 characters.");
				}
				else if(!text_1.equals(text_2)){
					setWarningMsg("Passwords do not match.");
				}
				else{
					Employee temp = new Employee(text, text_1, text_3, text_4, userRole,
							text_5, text_6);
					
					new AdminVerificationScreen();
					//require boolean of verification to add employee
					employees.addEmployee(temp);
					
					//Temp code to test functionality
					temp.print();
				}
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
