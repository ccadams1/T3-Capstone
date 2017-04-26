import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;

public class AdminVerificationScreen extends JDialog{
	//sets up variables
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	public EmployeeList employees = new EmployeeList();
	public Employee currentUser = new Employee(); 
	public Employee admin = new Employee();
	public boolean verify = false;
	
	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AdminVerificationScreen(data);
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
	public AdminVerificationScreen(ArrayList<Object> data) {
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data) {
		//gets database information
		Connection connect = (Connection) data.get(0);
		employees = (EmployeeList) data.get(2);
		currentUser = (Employee) data.get(6);
		admin = employees.get(0);
			
		//sets screen properties
		JDialog adminVeri = new JDialog();
		adminVeri.setAlwaysOnTop (true);
		adminVeri.setSize(600,250);
		adminVeri.setLocationRelativeTo(null);
		adminVeri.setVisible(true);
		adminVeri.setModal(true);
		adminVeri.setModalityType(ModalityType.DOCUMENT_MODAL);
		adminVeri.setTitle("Administrator Verification");
		
		//admin is 1
		if (currentUser.getRoleCode()==1){
			verify = true;
			System.out.println("is Admin");
			adminVeri.dispose();
		}
		
		while(!verify)
		{
			//create verification Panel
			JPanel verificationPanel = new JPanel();
			verificationPanel.setBounds(0, 0, 572, 171);
			
			//Username label and textField
			JLabel usernameLabel = new JLabel("Username:");
			usernameLabel.setBounds(91, 20, 116, 29);
			TextField usernameText = new TextField();
			usernameText.setBounds(212, 13, 243, 36);
			usernameText.setEditable(true);
			verificationPanel.setLayout(null);
			verificationPanel.add(usernameLabel);
			verificationPanel.add(usernameText);
			
			//Password label and textField
			JLabel passwordLabel = new JLabel("Password: ");
			passwordLabel.setBounds(91, 73, 117, 29);
			verificationPanel.add(passwordLabel);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(212, 73, 243, 36);
			verificationPanel.add(passwordField);
		
			//Submit Verification request button
			JButton verificationButton = new JButton("Verify");
			verificationButton.setBounds(225, 117, 89, 37);
			verificationButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					String username = usernameText.getText();
					char[] password = passwordField.getPassword();
					String passwordString  = "";
					for(int x = 0; x < password.length; x++)
					{
						passwordString += password[x];
					}
					
					//checks if username match password
					String response = callUserLoginProcedure(connect, username, passwordString);
					if(response.equals("User successfully logged in") && employees.getEmployee(username).getRoleCode()==1)
					{
						verify = true;
						System.out.println("Administrator verified");
						adminVeri.dispose();
					}
				}
			});
			verificationPanel.add(verificationButton);
			adminVeri.add(verificationPanel);
		}
	}
	
	//check if username match password
	protected String callUserLoginProcedure(Connection connect, String username, String password) 
	{
		String response = "";
		
		CallableStatement stmt = null;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspLogin(?,?,?)}");
			
			//set the parameters
			stmt.setString(1, username);
			stmt.setNString(2, password);
			stmt.registerOutParameter(3, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to login to employee");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			response = stmt.getString(3);
			System.out.println(response);
			if(!response.equals("User successfully logged in"))
			{
				setWarningMsg(response);
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
			setWarningMsg("Invalid Username. Note usernames and "
					+ "passwords are case sensitive");
		}
		return response;
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