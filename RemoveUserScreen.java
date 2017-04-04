import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.JScrollPane;

public class RemoveUserScreen extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField usernameTextField;
	private JTextField userIDTextField;
	private EmployeeList employees;
	private Employee removedUser;
	private Connection connect;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new RemoveUserScreen(ArrayList<Object> data);
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
	public RemoveUserScreen(ArrayList<Object> data) {
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data) {
		this.setAlwaysOnTop (true);
		this.setSize(450,300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Remove User");
		this.getContentPane().setLayout(null);
		
		employees = (EmployeeList) data.get(2);
		connect = (Connection) data.get(0);
		
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
		String userID = userIDTextField.getText().trim();
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int x = 0; x < employees.size(); x++)
				{
					if(employees.get(x).getUserId().equals(userID))
					{
						removedUser = employees.get(x);
					}
				}
				callRemoveUserProcedure(connect, removedUser);
				boolean temps = true; //temp code
				new AdminVerificationScreen(data, temps);
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
	
	protected void callRemoveUserProcedure(Connection connect, Employee temp) 
	{
		CallableStatement stmt = null;
			
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditUser(?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setInt(1, Integer.parseInt(temp.getUserId()));
			stmt.setString(2, temp.getUsername());
			stmt.setString(3, temp.getPassword());
			stmt.setString(4, temp.getFirstName());
			stmt.setString(5, temp.getLastName());
			stmt.setInt(6, /*temp.getRole()*/1);
			stmt.setString(7, temp.getEmail());
			stmt.setString(8, temp.getPhone());
			stmt.setInt(9, /*temp.isRemoved()*/1);
			stmt.registerOutParameter(10, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to remove user");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(10);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
}
