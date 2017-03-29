import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.CardLayout;

public class MainApplicationWindow {
	private static ArrayList<Object> allData = new ArrayList<Object>();
	private static Connection connection = null;
	private static CustomerList customers = new CustomerList();
	private static Inventory inventory = new Inventory();
	private static SupplierList suppliers = new SupplierList();
	private static EmployeeList employees = new EmployeeList();
	private static MyBusiness myBusiness = new MyBusiness();
	private static Employee currentUser = new Employee();
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
					DatabaseConnection database = new DatabaseConnection();
					connection = database.getConnection();
					PullDatabase pull = new PullDatabase(connection);
					myBusiness = pull.getMyBusinessData();
					//customers.populate(pull.getCustomers());
					employees.populate(pull.getEmployees());
					//inventory.populate(pull.getInventory());
					
					Item test1 = new Item("Test name", "123", 12.50, "New guys", 5, 50, "first item for testing", false);
					Item test2 = new Item("Another Test", "456", 9.00, "More New guys", 10, 50, "second item for testing", false);
					inventory.addItem(test1);
					inventory.addItem(test2);
					
					Customer joe = new Customer ("1", "Joe", "Smoe", "555 transaction rd", "", "raleigh", "NC", 12345,
							1565, 3215, "guy@gmail.com", 8754, false);
					Customer mat = new Customer ("2", "Mat", "Do", "123 califorican dr", "", "raleigh", "NC", 12345,
							4234, 3625, "otherGuy@gmail.com", 8754, false);
					customers.addCustomer(joe);
					customers.addCustomer(mat);
					
					Supplier company1 = new Supplier("Company 1", "2200", "928 make money st", "", "raleigh", "NC", 12345,
							null, 4655, 9865, "www.gobusiness.com", "company@company.com", 5642, false);
					Supplier company2 = new Supplier("Company 2", "1230", "644 business dr", "", "raleigh", "NC", 12345,
							null, 9182, 4563, "www.getmore.com", "company@pro.com", 88324, false);
					suppliers.addSupplier(company1);
					suppliers.addSupplier(company2);
					
					//suppliers.populate(pull.getSuppliers());
					currentUser = null;
					allData.add(connection);
					allData.add(customers);
					allData.add(employees);
					allData.add(inventory);
					allData.add(myBusiness);
					allData.add(suppliers);
					allData.add(currentUser);
					new LoginScreen(allData);
					for(int x = 0; x < employees.size();x++){
						System.out.println(employees.get(x).getPassword());
					}
					MainApplicationWindow window = new MainApplicationWindow(allData);
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
	public MainApplicationWindow(ArrayList<Object> data) {
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data) {
		//initializes frame and sets layout
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setTitle("T3 Tracking and Inventory for " + myBusiness.getBizName());
		
		//creates layeredPane Screens to operate on
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, "name_433016626230244");
		
		//Navigation Menu
		//creates navigation menu
		menuBar = NavigationMenu(data);
		frame.setJMenuBar(menuBar);
		
		//Main panel
		//adds the Main Screen
		mainPanel = new MainPanel(menuBar, data);
		mainPanel.setBounds(0, 0, 772, 476);
		layeredPane.add(mainPanel);
		mainPanel.setVisible(true);
		
		//POS panel
		//adds the POS Screen
		posPanel = new POSPanel(data);
		posPanel.setBounds(0, 0, 772, 476);
		layeredPane.add(posPanel);
		posPanel.setLayout(null);
		posPanel.setVisible(false);
		
		//Inventory panel
		//adds the Inventory Screen
		inventoryPanel = new InventoryPanel(data);
		inventoryPanel.setBounds(0, 0, 772, 476);
		layeredPane.add(inventoryPanel);
		inventoryPanel.setLayout(null);
		inventoryPanel.setVisible(false);
		
		//Search Panel
		//adds the Search Screen
		searchPanel = new SearchPanel(data);
		searchPanel.setBounds(0, 0, 772, 476);
		layeredPane.add(searchPanel);
		searchPanel.setLayout(null);
		searchPanel.setVisible(false);
		
		//Report Panel
		//adds the Report Screen
		reportPanel = new ReportPanel(data);
		reportPanel.setBounds(0, 0, 772, 476);
		layeredPane.add(reportPanel);
		reportPanel.setLayout(null);
		reportPanel.setVisible(false);
		
		//Help Panel
		//adds the Help Screen
		helpPanel = new HelpPanel();
		helpPanel.setBounds(0, 0, 772, 476);
		layeredPane.add(helpPanel);
		helpPanel.setLayout(null);	
		helpPanel.setVisible(false);
		
		
	}
	
	public JMenuBar NavigationMenu(ArrayList<Object> data)
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
				mainPanel.revalidate();
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
				posPanel.revalidate();
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
				inventoryPanel.revalidate();
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
				searchPanel.revalidate();
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
				reportPanel.revalidate();
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
				helpPanel.revalidate();
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
		thisScreen.validate();
		otherScreen1.setVisible(false);
		otherScreen2.setVisible(false);
		otherScreen3.setVisible(false);
		otherScreen4.setVisible(false);
		otherScreen5.setVisible(false);
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		MainApplicationWindow.connection = connection;
	}
}