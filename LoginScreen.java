//login completed

import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class LoginScreen extends JDialog{
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	public Employee currentUser = new Employee();
	public EmployeeList employees = new EmployeeList();
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginScreen();
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
	public LoginScreen(ArrayList<Object> allData, JFrame frame, MainApplicationWindow window, MainPanel mainPanel) {
		initialize(allData, frame, window, mainPanel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data, JFrame frame, MainApplicationWindow window, MainPanel mainPanel) {
		employees = (EmployeeList) data.get(2);
		currentUser = (Employee) data.get(6);	
		
		JDialog login = new JDialog();
		
		login.setAlwaysOnTop (true);
		login.setSize(600,250);
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		login.setModal(true);
		login.setModalityType(ModalityType.DOCUMENT_MODAL);
		login.setTitle("User Login");
		if(currentUser == null){
			System.out.println("no current user");
			login.setDefaultCloseOperation(
				JDialog.DO_NOTHING_ON_CLOSE);
			login.addWindowListener(new WindowAdapter() {
			    public void windowClosing(WindowEvent we) {
					setWarningMsg("No user is selected.");
			    }
			});
		}
		else{
			System.out.println("Current user is " + currentUser);
			login.setDefaultCloseOperation(
					JDialog.DISPOSE_ON_CLOSE);
		}
		
		//create login Panel
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 572, 171);
		
		//Username label and textField
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(91, 20, 116, 29);
		TextField usernameText = new TextField();
		usernameText.setBounds(212, 13, 243, 36);
		usernameText.setEditable(true);
		usernameText.setText("");
		loginPanel.setLayout(null);
		loginPanel.add(usernameLabel);
		loginPanel.add(usernameText);
		
		//Password label and textField
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(91, 73, 117, 29);
		loginPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 73, 243, 36);
		passwordField.setText("");
		loginPanel.add(passwordField);
	
		//Submit Login request button
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(225, 117, 89, 37);
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameText.getText();
				char[] password = passwordField.getPassword();
				String passwordString  = "";
				for(int x = 0; x < password.length; x++)
				{
					passwordString += password[x];
				}
				
				String response = callUserLoginProcedure(data, username, passwordString);
				if(response.equals("User successfully logged in"))
				{
					currentUser = employees.getEmployee(username);
					frame.setJMenuBar(null);
					frame.setJMenuBar(window.NavigationMenu(data, currentUser));
					checkRole(mainPanel, currentUser);
					frame.revalidate();
					mainPanel.revalidate();
					System.out.println("mPanel and mBar validated");
					login.dispose();
				}
			}
		});
		loginPanel.add(loginButton);
		login.add(loginPanel);
	}
	
	protected void checkRole(MainPanel mainPanel, Employee currentUser) {
		int userRole = currentUser.getRoleCode();
		if(userRole==3||userRole==5)
		{
			mainPanel.getButtons().getComponent(0).setEnabled(false);
		}
		else
		{
			mainPanel.getButtons().getComponent(0).setEnabled(true);
		}
		if(userRole==4||userRole==6)
		{
			mainPanel.getButtons().getComponent(1).setEnabled(false);
		}
		else
		{
			mainPanel.getButtons().getComponent(1).setEnabled(true);
		}
		if(userRole==5||userRole==6)
		{
			mainPanel.getButtons().getComponent(2).setEnabled(false);
			mainPanel.getButtons().getComponent(3).setEnabled(false);
			mainPanel.getButtons().getComponent(5).setEnabled(false);
		}
		else
		{
			mainPanel.getButtons().getComponent(2).setEnabled(true);
			mainPanel.getButtons().getComponent(3).setEnabled(true);
			mainPanel.getButtons().getComponent(5).setEnabled(true);
		}
	}

	protected String callUserLoginProcedure(ArrayList<Object> data, String username, String password) 
	{
		Connection connect = (Connection) data.get(0);
		EmployeeList employees = (EmployeeList) data.get(2);
		Employee currentUser = (Employee) data.get(6);
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
			else
			{
				for(int x = 0; x < employees.size(); x++)
				{
					if(employees.get(x).getUsername().equals(username))
					{
						currentUser = employees.get(x);
						System.out.println("current employee set");
						currentUser.toString();
						data.set(6, currentUser);
					}
				}
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
	
	public void setWarningMsg(String text){
	    Toolkit.getDefaultToolkit().beep();
	    JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Warning!");
	    dialog.setAlwaysOnTop(true);
	    dialog.setVisible(true);
	}
}
