import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class AddUserScreen extends JDialog {
	//sets up variables
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
	public AddUserScreen(ArrayList<Object> data) {
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data) {
		//sets screen properties
		this.setAlwaysOnTop (true);
		this.setSize(400,450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.DOCUMENT_MODAL);
		this.setTitle("Add User");
		this.getContentPane().setLayout(null);

		//sets database information
		employees = (EmployeeList) data.get(2);
		Connection connect = (Connection) data.get(0);
		
		//labels and textField specific to employee information
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
		empRoleComboBox.addItem("");
		empRoleComboBox.addItem("Overall Manager");
		empRoleComboBox.addItem("Inventory Manager");
		empRoleComboBox.addItem("Inventory User");
		empRoleComboBox.addItem("POS Manager");
		empRoleComboBox.addItem("POS User");
		empRoleComboBox.setSelectedItem("");
		empRoleComboBox.setBounds(158, 207, 191, 35);
		getContentPane().add(empRoleComboBox);
		
		//button to add new employee
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gets information from textFields
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				String retypePassword = retypePasswordTextField.getText();
				String fName = firstNameTextField.getText();
				String lName = lastNameTextField.getText();
				String userRole =  (String) empRoleComboBox.getSelectedItem();
				String email = emailTextField.getText();
				String phone = phoneTextField.getText();
				
				//checks for required information
				if(username.equals("") || password.equals("") || retypePassword.equals("") || 
						fName.equals("") || lName.equals("") || 
						userRole.equals("")){
					setWarningMsg("Please enter information in the *required boxes.");
				}
				//checks password size and match
				else if(password.length() < 8){
					setWarningMsg("Password is too small.");
				}
				else if(password.length() > 16){
					setWarningMsg("Password is too large.");
				}
				else if(!password.equals(retypePassword)){
					setWarningMsg("Passwords do not match.");
				}
				else{
					Employee temp = new Employee(username, password, fName, lName, userRole,
							email, phone);
					
					//checks for administrator approval
					AdminVerificationScreen adminveri = new AdminVerificationScreen(data);
					if (adminveri.verify)
					{
						System.out.println("New user added");
						//adds employee to database
						temp.setUserId(callAddUserProcedure(connect, temp));
						//adds employee to program
						employees.addEmployee(temp);
					}
					else
					{
						setWarningMsg("Administrator not verified. No "
								+ "information was saved.");
					}
				}
			}
		});
		btnAddUser.setBounds(99, 322, 155, 37);
		getContentPane().add(btnAddUser);
	}
	
	//callable procedure to add employee
	protected int callAddUserProcedure(Connection connect, Employee temp) 
	{
		CallableStatement stmt = null;
		
		int id = -1;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspAddUser(?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, temp.getUsername());
			stmt.setString(2, temp.getPassword());
			stmt.setString(3, temp.getFirstName());
			stmt.setString(4, temp.getLastName());
			stmt.setInt(5, temp.getRoleCode());
			stmt.setString(6, temp.getEmail());
			stmt.setString(7, temp.getPhone());
			stmt.setInt(8, /*temp.isRemoved()*/0);
			stmt.registerOutParameter(9, Types.VARCHAR);
			stmt.registerOutParameter(10, Types.INTEGER);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add new user");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(9);
			id = stmt.getInt(10);
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
