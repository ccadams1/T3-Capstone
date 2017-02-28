import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.PasswordView;

import javax.swing.JPasswordField;

public class AdminVerificationScreen extends JDialog{
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AdminVerificationScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminVerificationScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setAlwaysOnTop (true);
		this.setSize(600,250);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Administrator Verification");
		
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
		PasswordView passwordText = new PasswordView(null);
		verificationPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 73, 243, 36);
		verificationPanel.add(passwordField);
	
		//Submit Verification request button
		JButton verificationButton = new JButton("Verify");
		verificationButton.setBounds(225, 117, 89, 37);
		verificationPanel.add(verificationButton);
				
		getContentPane().add(verificationPanel);
	}
}