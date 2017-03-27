//login completed

import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class LoginScreen extends JDialog{
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	public EmployeeList employees = new EmployeeList();
	public Employee currentUser = new Employee();
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
	public LoginScreen(ArrayList<Object> data) {
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data) {
		employees = (EmployeeList) data.get(2);
		currentUser = (Employee) data.get(6);		
		
		JDialog login = new JDialog();
		
		login.setAlwaysOnTop (true);
		login.setSize(600,250);
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		login.setModal(true);
		login.setModalityType(ModalityType.APPLICATION_MODAL);
		login.setTitle("User Login");
		
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
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameText.getText();
				String password = passwordField.getText();
				
				for(int x = 0; x < employees.size(); x++)
				{
					if(!username.equals(employees.get(x).getUsername()))
					{
						setWarningMsg("Invalid Username. Note Usernames and "
								+ "Passwords are case sensitive");
					}
					else
					{
						if(!password.equals(employees.get(x).getPassword()))
						{
							setWarningMsg("Invalid Password.");
						}
						else
						{
							data.set(6, employees.get(x)); 
							System.out.println("current employee set");	
							login.dispose();
						}			
					}
				}
			}
		});
		loginPanel.add(loginButton);
		login.add(loginPanel);
	}
	
	public void setWarningMsg(String text){
	    Toolkit.getDefaultToolkit().beep();
	    JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Warning!");
	    dialog.setAlwaysOnTop(true);
	    dialog.setVisible(true);
	}
}
