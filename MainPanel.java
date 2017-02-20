import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
		
	private JPanel buttons, bottomPanel;
	private JButton sales, inventory, reports, search, help;			
	private JButton settings, changeUser;
	public static JPanel pos;

	public MainPanel(JMenuBar menuBar){
		//Create JFrame and GridLayout
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, 772, 476);
		this.setVisible(true);
					
		//Create JPanel for Buttons
		buttons = new JPanel();
		buttons.setLayout(new GridLayout(2, 3));
				
		// Create Buttons for buttons panel
		sales = new JButton("POS");
		inventory = new JButton("INVENTORY");
		reports = new JButton("REPORTS");
		search = new JButton("SEARCH");
		help = new JButton("HELP");
		settings = new JButton("SETTINGS");
					
		//Create Bottom Panel and Change User Button
		bottomPanel = new JPanel();
		changeUser = new JButton("CHANGE USER");
					
		//Add ActionListeners to buttons
		sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets main as visible screen
				((AbstractButton) menuBar.getComponent(1)).doClick();
			}
		});
				
		inventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets main as visible screen
				((AbstractButton) menuBar.getComponent(2)).doClick();
			}
		});

		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets main as visible screen
				((AbstractButton) menuBar.getComponent(3)).doClick();
			}
		});
		
		reports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets main as visible screen
				((AbstractButton) menuBar.getComponent(4)).doClick();
			}
		});
	
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets main as visible screen
				((AbstractButton) menuBar.getComponent(5)).doClick();
			}
		});
		
		//settings.addActionListener(toSettings);
		//changeUser.addActionListener(toLogin);
		
		//Add buttons to Panels
		buttons.add(sales);
		buttons.add(inventory);
		buttons.add(reports);
		buttons.add(search);
		buttons.add(help);
		buttons.add(settings);
		bottomPanel.add(changeUser);
		
		if (search.isSelected())
		{
			((AbstractButton) menuBar.getComponent(3)).doClick();
		}
		
		//Add components to JFrame
		this.add(buttons, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
	}	
} 
