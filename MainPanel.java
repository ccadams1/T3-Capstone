import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MainPanel extends JPanel{
	private JPanel buttonsPanel;
	private JButton sales, inventory, reports, search, supplier, settings;
	private JButton changeUser;
	private JPanel bottomPanel;
	
	public MainPanel()
	{
		//bounds should be set to (0, 0, 772, 476)
		this.setBounds(0, 0, 772, 476);
		this.setLayout(null);
				
		//sets up mainPanel
		Panel mainPanel = new Panel();
		mainPanel.setBounds(0, 0, 772, 476);
		this.add(mainPanel);		
		mainPanel.setLayout(null);
					
		//sets up buttons Panel
		buttonsPanel = new JPanel();
		buttonsPanel.setBounds(0, 0, 772, 410);
		buttonsPanel.setLayout(new GridLayout(2, 3));
		
		
		//sets up bottomPanel
		bottomPanel = new JPanel();
		bottomPanel.setBounds(0, 410, 772, 476);
		
		//adds panels to MainPanel
		mainPanel.add(buttonsPanel);
		mainPanel.add(bottomPanel);
		
		
		//creates JButtons
		sales = new JButton("POS");
		inventory = new JButton("INVENTORY");
		reports = new JButton("REPORTS");
		search = new JButton("SEARCH");
		supplier = new JButton("SUPPLIER");
		settings = new JButton("SETTINGS");
		changeUser = new JButton("CHANGE USER");
		
		//Add buttons to Panels
		buttonsPanel.add(sales);
		buttonsPanel.add(inventory);
		buttonsPanel.add(reports);
		buttonsPanel.add(search);
		buttonsPanel.add(supplier);
		buttonsPanel.add(settings);
		bottomPanel.add(changeUser);

		
		//buttons.setBorder(new TitledBorder(null, "Inventory", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		//buttons.setLayout(null);
				
				
		
		
	}	
} 
