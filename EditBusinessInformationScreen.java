import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class EditBusinessInformationScreen extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new EditBusinessInformationScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditBusinessInformationScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setAlwaysOnTop (true);
		this.setSize(400,620);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Business Information");
		this.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Business name:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(11, 24, 149, 29);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Address:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(11, 62, 149, 29);
		getContentPane().add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("Address 2:");
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRetypePassword.setBounds(11, 100, 149, 29);
		getContentPane().add(lblRetypePassword);
		
		JLabel lblFirstName = new JLabel("City:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(11, 138, 149, 29);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("State:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(11, 176, 149, 29);
		getContentPane().add(lblLastName);
		
		JLabel lblEmployeeRole = new JLabel("Zip code:");
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
		
		textField = new JTextField();
		textField.setBounds(158, 17, 191, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(158, 55, 191, 35);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(158, 93, 191, 35);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(158, 131, 191, 35);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(158, 169, 191, 35);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(158, 245, 191, 35);
		getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(158, 283, 191, 35);
		getContentPane().add(textField_6);
		
		JButton btnAddUser = new JButton("Save Changes");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminVerificationScreen();
			}
		});
		btnAddUser.setBounds(98, 490, 181, 37);
		getContentPane().add(btnAddUser);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(158, 207, 191, 35);
		getContentPane().add(textField_7);
		
		JLabel lblFax = new JLabel("Fax:");
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFax.setBounds(11, 330, 149, 29);
		getContentPane().add(lblFax);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(158, 323, 191, 35);
		getContentPane().add(textField_8);
		
		JLabel lblWebsite = new JLabel("Website:");
		lblWebsite.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWebsite.setBounds(11, 369, 149, 29);
		getContentPane().add(lblWebsite);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(158, 362, 191, 35);
		getContentPane().add(textField_9);
		
		JLabel lblOwnersFirstName = new JLabel("Owner's first name:");
		lblOwnersFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOwnersFirstName.setBounds(11, 407, 149, 29);
		getContentPane().add(lblOwnersFirstName);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(158, 400, 191, 35);
		getContentPane().add(textField_10);
		
		JLabel lblOwnersLastName = new JLabel("Owner's last name:");
		lblOwnersLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOwnersLastName.setBounds(11, 446, 149, 29);
		getContentPane().add(lblOwnersLastName);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(158, 439, 191, 35);
		getContentPane().add(textField_11);
	}
}
