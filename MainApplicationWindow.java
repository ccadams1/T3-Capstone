import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.CardLayout;

public class MainApplicationWindow {

	private JFrame frame;
	private JPanel mainPanel;
	private JPanel posPanel;
	private JPanel inventoryPanel;
	private JPanel searchPanel;
	private JPanel reportPanel;
	private JPanel helpPanel;
	private JMenuBar menuBar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserScreen login = new UserScreen();
					MainApplicationWindow window = new MainApplicationWindow();
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
	public MainApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//initializes frame and sets layout
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setTitle("T3 Tracking and Inventory for " + "*insert business name here*");
		
		//creates layeredPane Screens to operate on
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, "name_433016626230244");
		
		//Navigation Menu
		//creates navigation menu
		menuBar = NavigationMenu();
		frame.setJMenuBar(menuBar);
		
		//Main panel
		//adds the Main Screen
		mainPanel = new MainPanel(menuBar);
		mainPanel.setBounds(0, 0, 772, 476);
		layeredPane.add(mainPanel);
		
		//POS panel
		//adds the POS Screen
		posPanel = new POSPanel();
		posPanel.setBounds(0, 0, 772, 476);
		layeredPane.add(posPanel);
		posPanel.setLayout(null);		
		
		//Inventory panel
		//adds the Inventory Screen
		inventoryPanel = new InventoryPanel();
		inventoryPanel.setBounds(0, 0, 772, 476);
		layeredPane.add(inventoryPanel);
		inventoryPanel.setLayout(null);

		//Search Panel
		//adds the Search Screen
		searchPanel = new SearchPanel();
		searchPanel.setBounds(0, 0, 772, 476);
		layeredPane.add(searchPanel);
		searchPanel.setLayout(null);
				
		//Report Panel
		//adds the Report Screen
		reportPanel = new ReportPanel();
		reportPanel.setBounds(0, 0, 772, 476);
		layeredPane.add(reportPanel);
		reportPanel.setLayout(null);
		
		//Help Panel
		//adds the Help Screen
		helpPanel = new HelpPanel();
		helpPanel.setBounds(0, 0, 772, 476);
		layeredPane.add(helpPanel);
		helpPanel.setLayout(null);		
	}
	
	public JMenuBar NavigationMenu()
	{
		//Create JMenuBar
		JMenuBar menu = new JMenuBar();
				
		//Main button for menu
		JButton mainScreenButton = new JButton("Main");
		mainScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets main as visible screen
				toggleVisibility(mainPanel, posPanel, inventoryPanel, searchPanel,
						reportPanel, helpPanel);
			}
		});
		menu.add(mainScreenButton);
		
		//POS button for menu
		JButton posScreenButton = new JButton("POS");
		posScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets POS as visible screen
				toggleVisibility(posPanel, mainPanel, inventoryPanel, searchPanel,
						reportPanel, helpPanel);
			}
		});
		menu.add(posScreenButton);
		
		//Inventory button for menu
		JButton inventoryScreenButton = new JButton("Inventory");
		inventoryScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets inventory as visible screen
				toggleVisibility(inventoryPanel, mainPanel, posPanel, searchPanel,
						reportPanel, helpPanel);
			}
		});
		menu.add(inventoryScreenButton);
		
		//Search button for menu
		JButton searchScreenButton = new JButton("Search");
		searchScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets search as visible screen
				toggleVisibility(searchPanel, mainPanel, posPanel, inventoryPanel,
						reportPanel, helpPanel);
			}
		});
		menu.add(searchScreenButton);
		
		//Report button for menu
		JButton reportScreenButton = new JButton("Reports");
		reportScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets reports as visible screen
				toggleVisibility(reportPanel, mainPanel, posPanel, inventoryPanel, 
						searchPanel, helpPanel);
			}
		});
		menu.add(reportScreenButton);
		
		//Help button for menu
		JButton helpScreenButton = new JButton("Help");
		helpScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets help as visible screen
				toggleVisibility(helpPanel, mainPanel, posPanel, inventoryPanel, 
						searchPanel, reportPanel);
			}
		});
		menu.add(helpScreenButton);
		
		mainScreenButton.setBorderPainted(false);
		posScreenButton.setBorderPainted(false);
		inventoryScreenButton.setBorderPainted(false);
		searchScreenButton.setBorderPainted(false);
		reportScreenButton.setBorderPainted(false);
		helpScreenButton.setBorderPainted(false);
		
		//returns Navigation Layout Menu
		return menu;
	}
	
	//sets thisScreen to the visible screen and the rest stay invisible
	private void toggleVisibility(JPanel thisScreen, JPanel otherScreen1, 
			JPanel otherScreen2, JPanel otherScreen3, JPanel otherScreen4, 
			JPanel otherScreen5)
	{
		thisScreen.setVisible(true);
		otherScreen1.setVisible(false);
		otherScreen2.setVisible(false);
		otherScreen3.setVisible(false);
		otherScreen4.setVisible(false);
		otherScreen5.setVisible(false);
	}
}
