import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainScreen extends JFrame {
	
	private NavigationBar nav;
	private JPanel buttons, bottomPanel;
	private JButton sales, inventory, reports, search, supplier;
	private JButton settings, changeUser;
	
	public MainScreen(){
		
		//Create JFrame and GridLayout
		super("Main Screen");
		setLayout(new BorderLayout());
		
		
		
		//Create JPanel for Buttons
		buttons = new JPanel();
		buttons.setLayout(new GridLayout(2, 3));
		
		// Create Buttons for buttons panel
		sales = new JButton("POS");
		inventory = new JButton("INVENTORY");
		reports = new JButton("REPORTS");
		search = new JButton("SEARCH");
		supplier = new JButton("SUPPLIER");
		settings = new JButton("SETTINGS");
		
		//Create Bottom Panel and Change User Button
		bottomPanel = new JPanel();
		changeUser = new JButton("CHANGE USER");
		
		//Create ActionListeners
		ActionListener toSales = new goToSales();
		ActionListener toInventory = new goToInventory();
		ActionListener toReports = new goToReports();
		ActionListener toSearch = new goToSearch();
		ActionListener toSupplier = new goToSupplier();
		ActionListener toSettings = new goToSettings();
		ActionListener toLogin = new goToLogin();
		
		//Add ActionListeners to buttons
		sales.addActionListener(toSales);
		inventory.addActionListener(toInventory);
		reports.addActionListener(toReports);
		search.addActionListener(toSearch);
		supplier.addActionListener(toSupplier);
		settings.addActionListener(toSettings);
		changeUser.addActionListener(toLogin);
		
		//Add buttons to Panels
		buttons.add(sales);
		buttons.add(inventory);
		buttons.add(reports);
		buttons.add(search);
		buttons.add(supplier);
		buttons.add(settings);
		bottomPanel.add(changeUser);
		
		//Add components to JFrame
		add(buttons, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class goToSales implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("sales works");
		}
	}
	
	private class goToInventory implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("inventory works");
		}
	}
	
	
	
	private class goToReports implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("reports works");
		}
	}
	
	private class goToSearch implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("search works");
		}
	}
	
	private class goToSupplier implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("supplier works");
		}
	}
	
	private class goToSettings implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("settings works");
		}
	}
	
	private class goToLogin implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("change user works");
		}
	}
	
}
