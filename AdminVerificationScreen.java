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
import javax.swing.WindowConstants;

public class AdminVerificationScreen extends JDialog{
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	public EmployeeList employees = new EmployeeList();
	public Employee currentUser = new Employee(); 
	public Employee admin = new Employee();
	public boolean verify;
	
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
	public AdminVerificationScreen(ArrayList<Object> data, boolean verify) {
		initialize(data, verify);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data, boolean verification) {
		employees = (EmployeeList) data.get(2);
		currentUser = (Employee) data.get(6);
		admin = employees.get(0);
				
		JDialog adminVeri = new JDialog();
		adminVeri.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		adminVeri.setAlwaysOnTop (true);
		adminVeri.setSize(600,250);
		adminVeri.setLocationRelativeTo(null);
		adminVeri.setVisible(true);
		adminVeri.setModal(true);
		adminVeri.setModalityType(ModalityType.APPLICATION_MODAL);
		adminVeri.setTitle("Administrator Verification");
		
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
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameText.getText();
				String password = passwordField.getText();
				
				if(!username.equals(admin.getUsername()))
				{
					setWarningMsg("Invalid Username. Note Usernames and "
							+ "Passwords are case sensitive");
				}
				else
				{
					if(!password.equals(admin.getPassword()))
					{
						setWarningMsg("Invalid Password.");
					}
					else
					{
						changedVerification();
						System.out.println("Administrator verified");
						adminVeri.revalidate();
					}					
				}
			}
		});
		verificationPanel.add(verificationButton);
		adminVeri.add(verificationPanel);
		
		if (currentUser.getUserId()=="1"){
			changedVerification();
			System.out.println("is Admin");
		}
		
		if(this.verify){
			verification = verify; 
			adminVeri.dispose();
		}
	}
	
	public void changedVerification()
	{
		verify = true;
	}

	public void setWarningMsg(String text){
	    Toolkit.getDefaultToolkit().beep();
	    JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Warning!");
	    dialog.setAlwaysOnTop(true);
	    dialog.setVisible(true);
	}

	//temp code
	public boolean getVerification() {
		return false;
	}
}