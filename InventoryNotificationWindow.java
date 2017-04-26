import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.util.ArrayList;

public class InventoryNotificationWindow extends JDialog{
	//sets up variables
	private JFrame frame;
	private Inventory inventory;
	
	/**
	 * Launch the application.
	 
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
	*/
	/**
	 * Create the application.
	 */
	public InventoryNotificationWindow(ArrayList<Object> data) {
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data) {
		//gets inventory data
		inventory = (Inventory) data.get(3);
		
		//sets screen properties
		this.setAlwaysOnTop (true);
		this.setSize(400,350);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Inventory Notification");
		this.getContentPane().setLayout(null);
		
		//displays low inventory information
		JTextPane txtpnTheFollowingInventory = new JTextPane();
		txtpnTheFollowingInventory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnTheFollowingInventory.setBackground(UIManager.getColor("menu"));
		txtpnTheFollowingInventory.setText("The following inventory is at or below 10% par stock levels.");
		txtpnTheFollowingInventory.setBounds(22, 13, 328, 60);
		this.add(txtpnTheFollowingInventory);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 78, 372, 222);
		this.getContentPane().add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setEditable(false);
		
		String list = "     Item Name\tItem ID\tPar Stock\tQuantity\n";
		list += "------------------------------";
		list += "-------------------------------------------------------\n";
		int count = 0;
		//goes through inventory to determine which are lower than 10% par stock
		for(int x = 0; x < inventory.size(); x++)
		{
			if(!inventory.get(x).isRemoved())
			{
				if(inventory.get(x).getParStock()==0)
				{
				}
				else if(((inventory.get(x).getQuantity())/(inventory.get(x).getParStock()))==0 && 
						((inventory.get(x).getQuantity())%(inventory.get(x).getParStock()))
						<=(inventory.get(x).getParStock()*(10.0f/100.0f)))
				{
					count++;
					list += count + ". " + inventory.get(x).getName() + "\t" + inventory.get(x).getId() 
							+ "\t" + inventory.get(x).getParStock() + "\t" + inventory.get(x).getQuantity() + "\n";
					textPane.setText(list);
				}
			}
		}
		
		textPane.setText(list);
	}
}
