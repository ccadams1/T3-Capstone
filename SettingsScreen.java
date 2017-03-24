import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SettingsScreen extends JDialog{

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new SettingsScreen();
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
	public SettingsScreen(ArrayList<Object> data) {
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data) {
		this.setAlwaysOnTop (true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Settings");
		this.setSize(200, 400);
		this.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(0, 0, 264, 315);
		this.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(20, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		JButton btnUserInformation = new JButton("Add User");
		btnUserInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddUserScreen(data);
			}
		});
		panel_1.add(btnUserInformation);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		JButton btnEditUser = new JButton("Edit User");
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditUserScreen(data);
			}
		});
		panel_2.add(btnEditUser);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemoveUserScreen(data);
			}
		});
		panel_3.add(btnRemoveUser);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		JButton editBusiness = new JButton("Edit Business Information");
		editBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditBusinessInformationScreen(data);
			}
		});
		panel_4.add(editBusiness);
	}
}