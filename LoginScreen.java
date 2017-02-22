import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.text.PasswordView;

import java.awt.GridLayout;
import java.awt.TextComponent;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import javax.swing.JPasswordField;

public class LoginScreen extends JDialog{
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
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
		this.setTitle("User Login");
		
		//create login Panel
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 572, 171);
		
		//Username label and textField
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(91, 20, 116, 29);
		TextField usernameText = new TextField();
		usernameText.setBounds(212, 13, 243, 36);
		usernameText.setEditable(true);
		loginPanel.setLayout(null);
		loginPanel.add(usernameLabel);
		loginPanel.add(usernameText);
		
		//Password label and pextField
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(91, 73, 117, 29);
		PasswordView passwordText = new PasswordView(null);
		loginPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 73, 243, 36);
		loginPanel.add(passwordField);
	
		//Submit Login request button
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(225, 117, 89, 37);
		loginPanel.add(loginButton);
				
		getContentPane().add(loginPanel);
	}
}
