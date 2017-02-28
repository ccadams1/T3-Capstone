import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.JScrollPane;

public class RemoveUserScreen extends JDialog {

	private JTextField usernameTextField;
	private JTextField userIDTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new RemoveUserScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RemoveUserScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setAlwaysOnTop (true);
		this.setSize(450,300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Remove User");
		this.getContentPane().setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernameLabel.setBounds(10, 11, 84, 29);
		this.getContentPane().add(usernameLabel);
		
		JLabel userIDlabel = new JLabel("User ID:");
		userIDlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userIDlabel.setBounds(10, 52, 84, 29);
		this.getContentPane().add(userIDlabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(100, 8, 150, 35);
		this.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		userIDTextField = new JTextField();
		userIDTextField.setBounds(100, 49, 150, 35);
		this.getContentPane().add(userIDTextField);
		userIDTextField.setColumns(10);
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminVerificationScreen();
			}
		});
		btnRemoveUser.setBounds(263, 34, 150, 37);
		this.getContentPane().add(btnRemoveUser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 96, 422, 125);
		this.getContentPane().add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setEditable(false);
	}
}
