import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class EditBusinessInformationScreen extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField bizNameTextField;
	private JTextField stAddressTextField;
	private JTextField stAddress2TextField;
	private JTextField cityTextField;
	private JTextField stateTextField;
	private JTextField emailTextField;
	private JTextField phone1TextField;
	private JTextField zipCodeTextField;
	private JTextField faxTextField;
	private JTextField websiteTextField;
	private JTextField ownerFirstNameTextField;
	private JTextField ownerLastNameTextField;

	/**
	 * Launch the application.
	 
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
*/
	/**
	 * Create the application.
	 */
	public EditBusinessInformationScreen(ArrayList<Object> data) {
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data) {
		MyBusiness info = (MyBusiness) data.get(4);
		Connection connect = (Connection) data.get(0);
		
		this.setAlwaysOnTop (true);
		this.setSize(400,620);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Business Information");
		this.getContentPane().setLayout(null);
		
		JLabel lblbusinessName = new JLabel("Business name:");
		lblbusinessName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblbusinessName.setBounds(11, 24, 149, 29);
		getContentPane().add(lblbusinessName);

		bizNameTextField = new JTextField();
		bizNameTextField.setBounds(158, 17, 191, 35);
		getContentPane().add(bizNameTextField);
		bizNameTextField.setColumns(10);
		bizNameTextField.setText(info.getBizName());
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(11, 62, 149, 29);
		getContentPane().add(lblAddress);

		stAddressTextField = new JTextField();
		stAddressTextField.setColumns(10);
		stAddressTextField.setBounds(158, 55, 191, 35);
		getContentPane().add(stAddressTextField);
		stAddressTextField.setText(info.getStAdress1());
		
		JLabel lblAddress2 = new JLabel("Address 2:");
		lblAddress2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress2.setBounds(11, 100, 149, 29);
		getContentPane().add(lblAddress2);

		stAddress2TextField = new JTextField();
		stAddress2TextField.setColumns(10);
		stAddress2TextField.setBounds(158, 93, 191, 35);
		getContentPane().add(stAddress2TextField);
		stAddress2TextField.setText(info.getStAdress2());
		
		JLabel lblcity = new JLabel("City:");
		lblcity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblcity.setBounds(11, 138, 149, 29);
		getContentPane().add(lblcity);
		
		cityTextField = new JTextField();
		cityTextField.setColumns(10);
		cityTextField.setBounds(158, 131, 191, 35);
		getContentPane().add(cityTextField);
		cityTextField.setText(info.getCity());
		
		JLabel lblstate = new JLabel("State:");
		lblstate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblstate.setBounds(11, 176, 149, 29);
		getContentPane().add(lblstate);
		
		stateTextField = new JTextField();
		stateTextField.setColumns(10);
		stateTextField.setBounds(158, 169, 191, 35);
		getContentPane().add(stateTextField);
		stateTextField.setText(info.getState());
		
		JLabel lblzipcode = new JLabel("Zip code:");
		lblzipcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblzipcode.setBounds(11, 214, 149, 29);
		getContentPane().add(lblzipcode);
		
		zipCodeTextField = new JTextField();
		zipCodeTextField.setColumns(10);
		zipCodeTextField.setBounds(158, 207, 191, 35);
		getContentPane().add(zipCodeTextField);
		zipCodeTextField.setText(""+info.getZipCode());
		
		JLabel lblEmailAddress = new JLabel("Email address:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailAddress.setBounds(11, 252, 149, 29);
		getContentPane().add(lblEmailAddress);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(158, 245, 191, 35);
		getContentPane().add(emailTextField);
		emailTextField.setText(info.getEmail());
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(11, 290, 149, 29);
		getContentPane().add(lblPhoneNumber);
		
		phone1TextField = new JTextField();
		phone1TextField.setColumns(10);
		phone1TextField.setBounds(158, 283, 191, 35);
		getContentPane().add(phone1TextField);
		phone1TextField.setText(""+info.getPhone1());
		
		
		JLabel lblFax = new JLabel("Fax:");
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFax.setBounds(11, 330, 149, 29);
		getContentPane().add(lblFax);
		
		faxTextField = new JTextField();
		faxTextField.setColumns(10);
		faxTextField.setBounds(158, 323, 191, 35);
		getContentPane().add(faxTextField);
		faxTextField.setText(""+info.getFax());
		
		JLabel lblWebsite = new JLabel("Website:");
		lblWebsite.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWebsite.setBounds(11, 369, 149, 29);
		getContentPane().add(lblWebsite);
		
		websiteTextField = new JTextField();
		websiteTextField.setColumns(10);
		websiteTextField.setBounds(158, 362, 191, 35);
		getContentPane().add(websiteTextField);
		websiteTextField.setText(info.getWebsite());
		
		JLabel lblOwnersFirstName = new JLabel("Owner's first name:");
		lblOwnersFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOwnersFirstName.setBounds(11, 407, 149, 29);
		getContentPane().add(lblOwnersFirstName);
		
		ownerFirstNameTextField = new JTextField();
		ownerFirstNameTextField.setColumns(10);
		ownerFirstNameTextField.setBounds(158, 400, 191, 35);
		getContentPane().add(ownerFirstNameTextField);
		ownerFirstNameTextField.setText(info.getOwnerFirstName());
		
		JLabel lblOwnersLastName = new JLabel("Owner's last name:");
		lblOwnersLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOwnersLastName.setBounds(11, 446, 149, 29);
		getContentPane().add(lblOwnersLastName);
		
		ownerLastNameTextField = new JTextField();
		ownerLastNameTextField.setColumns(10);
		ownerLastNameTextField.setBounds(158, 439, 191, 35);
		getContentPane().add(ownerLastNameTextField);
		
		JButton btnAddUser = new JButton("Save Changes");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminVerificationScreen();
				//save all data
				saveData(connect, info);
			}
		});
		btnAddUser.setBounds(98, 490, 181, 37);
		getContentPane().add(btnAddUser);
	}
	
	public void saveData(Connection connect, MyBusiness info){
		String query = "UPDATE MY_BUSINESS SET "
				+ "biz_name = " + bizNameTextField.getText() + ", "
				+ "st_address1 = " + stAddressTextField.getText() + ", "
				+ "st_address2 = " + stAddress2TextField.getText() + ", "
				+ "city = " + cityTextField.getText() + ", "
				+ "state = " + stateTextField.getText() + ", "
				+ "zip_code = " + zipCodeTextField.getText() + ", "
				+ "email = " + emailTextField.getText() + ", "
				+ "phone1 = " + phone1TextField.getText() + ", "
				+ "fax = " + faxTextField.getText() + ", "
				+ "website = " + websiteTextField.getText() + ", "
				+ "owner_fname = " + ownerFirstNameTextField.getText() + ", "
				+ "owner_lname = " + ownerLastNameTextField.getText() 
				+ " WHERE biz_name = " + info.getBizName();
				//logo1, logo2, phone2 need to be added
		try{
			Statement stmt = connect.createStatement();
			stmt.executeQuery(query);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		info.setBizName(bizNameTextField.getText());
		info.setStAdress1(stAddressTextField.getText());
		info.setStAdress2(stAddress2TextField.getText());
		info.setCity(cityTextField.getText());
		info.setState(stateTextField.getText());
		info.setZipCode(Integer.parseInt(zipCodeTextField.getText()));
		info.setEmail(emailTextField.getText());
		info.setPhone1(Integer.parseInt(phone1TextField.getText()));
		info.setFax(Integer.parseInt(faxTextField.getText()));
		info.setWebsite(websiteTextField.getText());
		info.setOwnerFirstName(ownerFirstNameTextField.getText());
		info.setOwnerLastName(ownerLastNameTextField.getText());
	}
}
