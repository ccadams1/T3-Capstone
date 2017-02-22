import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.Font;

public class InventoryNotificationWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryNotificationWindow window = new InventoryNotificationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InventoryNotificationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("menu"));
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Inventory Notification");
		
		JTextPane txtpnTheFollowingInventory = new JTextPane();
		txtpnTheFollowingInventory.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtpnTheFollowingInventory.setBackground(UIManager.getColor("menu"));
		txtpnTheFollowingInventory.setText("The following inventory is at or below 10% par stock levels.");
		txtpnTheFollowingInventory.setBounds(22, 13, 528, 73);
		frame.getContentPane().add(txtpnTheFollowingInventory);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 98, 572, 223);
		frame.getContentPane().add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setEditable(false);
	}
}
