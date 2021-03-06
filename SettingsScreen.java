import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SettingsScreen extends JDialog{
	private static final long serialVersionUID = 1L;

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
	public SettingsScreen(ArrayList<Object> data, JFrame mainFrame) {
		initialize(data, mainFrame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data, JFrame mainFrame) {
		//sets screen properties
		this.setAlwaysOnTop (true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Settings");
		this.setSize(250, 400);
		this.getContentPane().setLayout(null);
		
		//sets up scroll pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(0, 0, 264, 315);
		this.getContentPane().add(scrollPane);
		
		//sets up panel in scroll pane
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(20, 1, 0, 0));
		
		//the following are panels that each add buttons for different editing screens
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
		JButton editSupplier = new JButton("Edit Supplier");
		editSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditSupplierScreen(data);
			}
		});
		panel_4.add(editSupplier);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		JButton editCustomer = new JButton("Edit Customer");
		editCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditCustomerScreen(data);
			}
		});
		panel_5.add(editCustomer);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		JButton editBusiness = new JButton("Edit Business Information");
		editBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditBusinessInformationScreen(data, mainFrame);
			}
		});
		panel_8.add(editBusiness);
	}
}