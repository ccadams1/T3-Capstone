import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	//sets up variables
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JPanel buttons, bottomPanel;
	public JButton sales, inventory, reports, search, help;			
	public static JButton settings, changeUser;
	public static JPanel pos;
	public Employee currentUser = new Employee();
	public LoginScreen login = null;

	//constructor with necessary variable parameters
	public MainPanel(JMenuBar menuBar, ArrayList<Object> data, JFrame mainFrame, MainApplicationWindow window){
		//initiates it's panel
		mainPanel = this;
		//gets current user data
		currentUser = (Employee) data.get(6);
		
		//Create JFrame and GridLayout
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, 772, 476);
		mainPanel.setVisible(true);
					
		//Create JPanel for Buttons
		buttons = new JPanel();
		buttons.setBounds(0, 0, 772, 431);
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
		bottomPanel.setBounds(0, 431, 772, 75);
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
		
		settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets main as visible screen
				new SettingsScreen(data, mainFrame);
			}
		});
		
		changeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets main as visible screen
				login = new LoginScreen(data, mainFrame, window, (MainPanel) mainPanel);
			}
		});
		
		//Add buttons to Panels
		buttons.add(sales);
		buttons.add(inventory);
		buttons.add(reports);
		buttons.add(search);
		buttons.add(help);
		buttons.add(settings);
		bottomPanel.add(changeUser);
				
		//Add components to JFrame
		mainPanel.add(buttons);
		mainPanel.add(bottomPanel);
	}
	
	//returns the panel with the buttons
	public JPanel getButtons()
	{
		return buttons;
	}
}