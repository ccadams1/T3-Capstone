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

public class EditUserScreen extends JDialog {
	//sets up variables
	private static final long serialVersionUID = 1L;
	private JTextField userIDTextField;
	private JTextField userNameTextField;
	private JTextField passwordTextField;
	private JTextField retypePasswordTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField phoneTextField;
	private JTextArea textArea;
	private Connection connect;
	private EmployeeList employees;
	private Employee selectedUser;

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
	public EditUserScreen(ArrayList<Object> data)	{
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data) {
		//sets up screen properties
		this.setAlwaysOnTop (true);
		this.setSize(400,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.DOCUMENT_MODAL);
		this.setTitle("Edit User");
		this.getContentPane().setLayout(null);
		
		//gets database information
		employees = (EmployeeList) data.get(2); 
		connect = (Connection) data.get(0);
		
		//user specific labels and textFields
		JLabel lblUserId = new JLabel("User ID:*");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserId.setBounds(10, 17, 149, 29);
		getContentPane().add(lblUserId);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(10, 55, 149, 29);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(10, 93, 149, 29);
		getContentPane().add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("Retype Password:");
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRetypePassword.setBounds(10, 131, 149, 29);
		getContentPane().add(lblRetypePassword);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(10, 169, 149, 29);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(10, 207, 149, 29);
		getContentPane().add(lblLastName);
		
		JLabel lblEmployeeRole = new JLabel("Employee role:");
		lblEmployeeRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeRole.setBounds(10, 245, 149, 29);
		getContentPane().add(lblEmployeeRole);
		
		JLabel lblEmailAddress = new JLabel("Email address:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailAddress.setBounds(10, 283, 149, 29);
		getContentPane().add(lblEmailAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(10, 321, 149, 29);
		getContentPane().add(lblPhoneNumber);
		
		userIDTextField = new JTextField();
		userIDTextField.setToolTipText("Required to edit the user");
		userIDTextField.setColumns(10);
		userIDTextField.setBounds(158, 11, 191, 35);
		getContentPane().add(userIDTextField);
	
		userNameTextField = new JTextField();
		userNameTextField.setBounds(158, 49, 191, 35);
		getContentPane().add(userNameTextField);
		userNameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(158, 87, 191, 35);
		getContentPane().add(passwordTextField);
		
		retypePasswordTextField = new JTextField();
		retypePasswordTextField.setColumns(10);
		retypePasswordTextField.setBounds(158, 125, 191, 35);
		getContentPane().add(retypePasswordTextField);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(158, 163, 191, 35);
		getContentPane().add(firstNameTextField);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(158, 201, 191, 35);
		getContentPane().add(lastNameTextField);

		JComboBox<String> empRoleComboBox = new JComboBox<String>();
		empRoleComboBox.addItem("");
		empRoleComboBox.addItem("Overall Manager");
		empRoleComboBox.addItem("Inventory Manager");
		empRoleComboBox.addItem("Inventory User");
		empRoleComboBox.addItem("POS Manager");
		empRoleComboBox.addItem("POS User");
		empRoleComboBox.setSelectedItem("");
		empRoleComboBox.setBounds(158, 238, 191, 35);
		getContentPane().add(empRoleComboBox);
				
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(158, 277, 191, 35);
		getContentPane().add(emailTextField);
		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(158, 315, 191, 35);
		getContentPane().add(phoneTextField);
		
		//edit button to change employee information
		JButton btnEditUser = new JButton("Edit User");
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gets texrtField information
				String userID = userIDTextField.getText();
				String username = userNameTextField.getText();
				String password = passwordTextField.getText();
				String retypePassword = retypePasswordTextField.getText();
				String fName = firstNameTextField.getText();
				String lName = lastNameTextField.getText();
				String userRole =  (String) empRoleComboBox.getSelectedItem();
				String email = emailTextField.getText();
				String phone = phoneTextField.getText();
				
				//requires employee id to change anything
				if(userID.equals("")){
					setWarningMsg("Please enter information in the *required boxes.");
				}
				//checks password length and match of retyping the password
				else if(password.length() < 8 && password.length() != 0){
					setWarningMsg("Password is too small.");
				}
				else if(password.length() > 16 && password.length() != 0){
					setWarningMsg("Password is too large.");
				}
				else if(!password.equals(retypePassword)){
					setWarningMsg("Passwords do not match.");
				}
				else{
					//finds specific employee
					for(int x = 0; x < employees.size(); x++)
					{
						if(employees.get(x).getUserId().equals(userID))
						{
							selectedUser = employees.get(x);
							selectedUser.print();
						}
					}

					//check for administrator approval
					AdminVerificationScreen adminveri = new AdminVerificationScreen(data);
					if (adminveri.verify)
					{
						//checks changes
						if(!username.equals(""))
						{
							selectedUser.setUsername(username);
						}
						if(!password.equals(""))
						{
							selectedUser.setPassword(password);
						}
						if(!fName.equals(""))
						{
							selectedUser.setFirstName(fName);
						}
						if(!lName.equals(""))
						{
							selectedUser.setLastName(lName);
						}
						if(!userRole.equals(""))
						{
							selectedUser.setRoleCode(userRole);
							selectedUser.setRole(userRole);
						}
						if(!email.equals(""))
						{
							selectedUser.setEmail(email);
						}
						if(!phone.equals(""))
						{
							selectedUser.setPhone(phone);
						}
						//changes employee in the database
						callEditUserProcedure(connect, selectedUser);
						System.out.println("User edit complete");
						//updates displayed text
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 404, 372, 117);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setText(employees.toString());
	}
	
	//edit employee callable procedure
	protected void callEditUserProcedure(Connection connect, Employee temp) 
	{
		CallableStatement stmt = null;
			
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditUser(?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setInt(1, temp.getIntUserID());
			stmt.setString(2, temp.getUsername());
			stmt.setString(3, temp.getPassword());
			stmt.setString(4, temp.getFirstName());
			stmt.setString(5, temp.getLastName());
			stmt.setInt(6, temp.getRoleCode());
			stmt.setString(7, temp.getEmail());
			stmt.setString(8, temp.getPhone());
			stmt.setInt(9, /*temp.isRemoved()*/0);
			stmt.registerOutParameter(10, Types.NVARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to edit user");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(10);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}

	//updates text area
	private void updateDisplay(){
		textArea.setText(employees.toString());
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