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
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class EditUserScreen extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextArea textArea;
	
	/////Test Purposes only/////////
	private EmployeeList employees;
	private Employee emp1, emp2, emp3;
	///////////////////////////////////
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new EditUserScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditUserScreen()	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setAlwaysOnTop (true);
		this.setSize(400,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Edit User");
		this.getContentPane().setLayout(null);
		
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
		
		textField = new JTextField();
		textField.setBounds(158, 49, 191, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(158, 87, 191, 35);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(158, 125, 191, 35);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(158, 163, 191, 35);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(158, 201, 191, 35);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(158, 277, 191, 35);
		getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(158, 315, 191, 35);
		getContentPane().add(textField_6);
		
		JComboBox comboBox = new JComboBox();
		////////////////Temp code for testing purposes/////////////
		comboBox.addItem("");
		comboBox.addItem("test");
		comboBox.addItem("test2");
		comboBox.setSelectedItem("");
		///////////////////////////////////////////////////////////
		comboBox.setBounds(158, 238, 191, 35);
		getContentPane().add(comboBox);
		
		JButton btnEditUser = new JButton("Edit User");
		/*
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminVerificationScreen();
			}
		});
		*/
		
		
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserId.setBounds(10, 17, 149, 29);
		getContentPane().add(lblUserId);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("Required to edit the user");
		textField_7.setColumns(10);
		textField_7.setBounds(158, 11, 191, 35);
		getContentPane().add(textField_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 404, 372, 117);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		//////////////////TEST PURPOSES ONLY////////////////
		employees = new EmployeeList();
		emp1 = new Employee("first", "pass", "WillyJames", "Huff", "CEO", "@yahoo", "919");
		emp2 = new Employee("second", "random", "Rackem", "Willy", "Manager", "@aol", "684");
		emp3 = new Employee("third", "pword", "Funky", "Chicken", "janitor", "@gmail", "123");
		employees.addEmployee(emp1);
		employees.addEmployee(emp2);
		employees.addEmployee(emp3);
		textArea.setText(employees.toString());
		
		/////////////////////////////////////////////////////
		
		btnEditUser.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				String text_1 = textField_1.getText();
				String text_2 = textField_2.getText();
				String text_3 = textField_3.getText();
				String text_4 = textField_4.getText();
				String text_5 = textField_5.getText();
				String text_6 = textField_6.getText();
				String text_7 = textField_7.getText();
				////////////temp code for user role////////////////////////////////////
				String combo = (String) comboBox.getSelectedItem();
				///////////////////////////////////////////////////////////////////////

				if(text_7.equals("")){
					//Return warning (User Id Required)
					return;
				}
				int index = -1;
				for(int i = 0; i < employees.size(); i++){
					if(employees.get(i).getUserId().equals(text_7)){
						index = i;
					}
				}
				if(index >= 0){
					if(!text.equals("")){
						employees.get(index).setUsername(text);
					}
					if(!text_1.equals("")){
						if(text_1.equals(text_2)){
							employees.get(index).setPassword(text_1);
						}
						else{
							//Return warning (Passwords Dont Match)
						}
					}
					if(!text_3.equals("")){
						employees.get(index).setFirstName(text_3);
					}
					if(!text_4.equals("")){
						employees.get(index).setLastName(text_4);
					}
					if(!text_5.equals("")){
						employees.get(index).setEmail(text_5);
					}
					if(!text_6.equals("")){
						employees.get(index).setPhone(text_6);
					}
					if(!combo.equals("")){
						employees.get(index).setRole(combo);
					}
					updateDisplay();
				}
			}
			
		});
		
		btnEditUser.setBounds(99, 356, 155, 37);
		getContentPane().add(btnEditUser);
	}
	
	private void updateDisplay(){
		textArea.setText(employees.toString());
	}
}
