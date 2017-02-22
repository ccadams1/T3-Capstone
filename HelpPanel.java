import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class HelpPanel extends JPanel{
	public HelpPanel()
	{
	//bounds should be set to (0, 0, 772, 476)
	this.setBounds(0, 0, 772, 476);
	this.setLayout(null);
				
	//creates a scrolling text area
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(0, 174, 772, 302);
	this.add(scrollPane);
			
	//creates text area to put in the scrollPane
	JTextArea textArea = new JTextArea();
	textArea.setEditable(false);
	scrollPane.setViewportView(textArea);
	textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
	
	JPanel tableOfContentsPanel = new JPanel();
	tableOfContentsPanel.setBounds(0, 0, 772, 178);
	tableOfContentsPanel.setBorder(new TitledBorder(null, "Help Contents", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 18), null));
	this.add(tableOfContentsPanel);
	tableOfContentsPanel.setLayout(null);
	
	ButtonGroup tableOfContentsGroup = new ButtonGroup();
	
	JRadioButton rdbtnMainScreen = new JRadioButton("Main Screen");
	rdbtnMainScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
	rdbtnMainScreen.setBounds(14, 22, 183, 19);
	tableOfContentsPanel.add(rdbtnMainScreen);
	tableOfContentsGroup.add(rdbtnMainScreen);
	
	JRadioButton rdbtnNavigationBar = new JRadioButton("Navigation Bar");
	rdbtnNavigationBar.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnNavigationBar.setBounds(14, 44, 183, 19);
	tableOfContentsPanel.add(rdbtnNavigationBar);
	tableOfContentsGroup.add(rdbtnNavigationBar);
		
	JRadioButton rdbtnChangeUsersButton = new JRadioButton("Change Users Button");
	rdbtnChangeUsersButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnChangeUsersButton.setBounds(14, 66, 183, 19);
	tableOfContentsPanel.add(rdbtnChangeUsersButton);
	tableOfContentsGroup.add(rdbtnChangeUsersButton);
		
	JRadioButton rdbtnScreenButtons = new JRadioButton("Screen Buttons");
	rdbtnScreenButtons.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnScreenButtons.setBounds(14, 88, 183, 19);
	tableOfContentsPanel.add(rdbtnScreenButtons);
	tableOfContentsGroup.add(rdbtnScreenButtons);
		
	JRadioButton rdbtnPosSalesScreen = new JRadioButton("POS Sales Screen");
	rdbtnPosSalesScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
	rdbtnPosSalesScreen.setBounds(14, 110, 183, 19);
	tableOfContentsPanel.add(rdbtnPosSalesScreen);
	tableOfContentsGroup.add(rdbtnPosSalesScreen);
	
	JRadioButton rdbtnItemButtons = new JRadioButton("Item Buttons");
	rdbtnItemButtons.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnItemButtons.setBounds(14, 132, 183, 19);
	tableOfContentsPanel.add(rdbtnItemButtons);
	tableOfContentsGroup.add(rdbtnItemButtons);
	
	JRadioButton rdbtnSalesPanel = new JRadioButton("Sales Panel");
	rdbtnSalesPanel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnSalesPanel.setBounds(14, 154, 183, 19);
	tableOfContentsPanel.add(rdbtnSalesPanel);
	tableOfContentsGroup.add(rdbtnSalesPanel);
	
	JRadioButton rdbtnCheckoutPanel = new JRadioButton("Checkout Panel");
	rdbtnCheckoutPanel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnCheckoutPanel.setBounds(202, 22, 183, 19);
	tableOfContentsPanel.add(rdbtnCheckoutPanel);
	tableOfContentsGroup.add(rdbtnCheckoutPanel);
	
	JRadioButton rdbtnCashoutScreen = new JRadioButton("Cashout Window");
	rdbtnCashoutScreen.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnCashoutScreen.setBounds(202, 44, 183, 19);
	tableOfContentsPanel.add(rdbtnCashoutScreen);
	tableOfContentsGroup.add(rdbtnCashoutScreen);
	
	JRadioButton rdbtnInventoryScreen = new JRadioButton("Inventory Screen");
	rdbtnInventoryScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
	rdbtnInventoryScreen.setBounds(202, 66, 183, 19);
	tableOfContentsPanel.add(rdbtnInventoryScreen);
	tableOfContentsGroup.add(rdbtnInventoryScreen);
	
	JRadioButton rdbtnAddItemButton = new JRadioButton("Add Item Button");
	rdbtnAddItemButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnAddItemButton.setBounds(202, 88, 183, 19);
	tableOfContentsPanel.add(rdbtnAddItemButton);
	tableOfContentsGroup.add(rdbtnAddItemButton);
	
	JRadioButton rdbtnEditItemButton = new JRadioButton("Edit Item Button");
	rdbtnEditItemButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnEditItemButton.setBounds(202, 110, 183, 19);
	tableOfContentsPanel.add(rdbtnEditItemButton);
	tableOfContentsGroup.add(rdbtnEditItemButton);
	
	JRadioButton rdbtnDeleteItemButton = new JRadioButton("Delete Item Button");
	rdbtnDeleteItemButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnDeleteItemButton.setBounds(202, 132, 183, 19);
	tableOfContentsPanel.add(rdbtnDeleteItemButton);
	tableOfContentsGroup.add(rdbtnDeleteItemButton);
	
	JRadioButton rdbtnSearchScreen = new JRadioButton("Search Screen");
	rdbtnSearchScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
	rdbtnSearchScreen.setBounds(202, 154, 183, 19);
	tableOfContentsPanel.add(rdbtnSearchScreen);
	tableOfContentsGroup.add(rdbtnSearchScreen);
	
	JRadioButton rdbtnCustomerSearch = new JRadioButton("Customer Search");
	rdbtnCustomerSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnCustomerSearch.setBounds(388, 22, 183, 19);
	tableOfContentsPanel.add(rdbtnCustomerSearch);
	tableOfContentsGroup.add(rdbtnCustomerSearch);
	
	JRadioButton rdbtnInventorySearch = new JRadioButton("Inventory Search");
	rdbtnInventorySearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnInventorySearch.setBounds(388, 44, 183, 19);
	tableOfContentsPanel.add(rdbtnInventorySearch);
	tableOfContentsGroup.add(rdbtnInventorySearch);
	
	JRadioButton rdbtnSupplierSearch = new JRadioButton("Supplier Search");
	rdbtnSupplierSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnSupplierSearch.setBounds(388, 66, 183, 19);
	tableOfContentsPanel.add(rdbtnSupplierSearch);
	tableOfContentsGroup.add(rdbtnSupplierSearch);
	
	JRadioButton rdbtnReportsScreen = new JRadioButton("Reports Screen");
	rdbtnReportsScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
	rdbtnReportsScreen.setBounds(388, 88, 183, 19);
	tableOfContentsPanel.add(rdbtnReportsScreen);
	tableOfContentsGroup.add(rdbtnReportsScreen);
	
	JRadioButton rdbtnViewReports = new JRadioButton("View Reports");
	rdbtnViewReports.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnViewReports.setBounds(388, 110, 183, 19);
	tableOfContentsPanel.add(rdbtnViewReports);
	tableOfContentsGroup.add(rdbtnViewReports);
	
	JRadioButton rdbtnSaveReports = new JRadioButton("Save Reports");
	rdbtnSaveReports.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnSaveReports.setBounds(388, 132, 183, 19);
	tableOfContentsGroup.add(rdbtnSaveReports);
	tableOfContentsPanel.add(rdbtnSaveReports);
	
	JRadioButton rdbtnPrintReports = new JRadioButton("Print Reports");
	rdbtnPrintReports.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnPrintReports.setBounds(388, 154, 183, 19);
	tableOfContentsPanel.add(rdbtnPrintReports);
	tableOfContentsGroup.add(rdbtnPrintReports);
	
	JRadioButton rdbtnHelpScreen = new JRadioButton("Help Screen");
	rdbtnHelpScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
	rdbtnHelpScreen.setBounds(578, 22, 183, 19);
	tableOfContentsPanel.add(rdbtnHelpScreen);
	tableOfContentsGroup.add(rdbtnHelpScreen);
	
	JRadioButton rdbtnUserLogin = new JRadioButton("User Login");
	rdbtnUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnUserLogin.setBounds(578, 44, 183, 19);
	tableOfContentsPanel.add(rdbtnUserLogin);
	tableOfContentsGroup.add(rdbtnUserLogin);
	
	JRadioButton rdbtnAddingNewUser = new JRadioButton("Adding New User");
	rdbtnAddingNewUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnAddingNewUser.setBounds(578, 66, 183, 19);
	tableOfContentsPanel.add(rdbtnAddingNewUser);
	tableOfContentsGroup.add(rdbtnAddingNewUser);
	
	JRadioButton rdbtnSettings = new JRadioButton("Settings");
	rdbtnSettings.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnSettings.setBounds(578, 88, 183, 19);
	tableOfContentsPanel.add(rdbtnSettings);
	tableOfContentsGroup.add(rdbtnSettings);
	
	JRadioButton rdbtnInventoryNotification = new JRadioButton("Inventory Notification");
	rdbtnInventoryNotification.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnInventoryNotification.setBounds(578, 110, 183, 19);
	tableOfContentsPanel.add(rdbtnInventoryNotification);
	tableOfContentsGroup.add(rdbtnInventoryNotification);
	
	JRadioButton rdbtnTempHold = new JRadioButton("temp hold");
	rdbtnTempHold.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnTempHold.setBounds(578, 132, 183, 19);
	tableOfContentsPanel.add(rdbtnTempHold);
	tableOfContentsGroup.add(rdbtnTempHold);
	
	JRadioButton rdbtnTempHold_1 = new JRadioButton("temp hold");
	rdbtnTempHold_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnTempHold_1.setBounds(578, 154, 183, 19);
	tableOfContentsPanel.add(rdbtnTempHold_1);
	tableOfContentsGroup.add(rdbtnTempHold_1);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.LIGHT_GRAY);
	separator.setOrientation(SwingConstants.VERTICAL);
	separator.setBounds(198, 11, 2, 176);
	tableOfContentsPanel.add(separator);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setForeground(Color.LIGHT_GRAY);
	separator_1.setOrientation(SwingConstants.VERTICAL);
	separator_1.setBounds(387, 11, 2, 176);
	tableOfContentsPanel.add(separator_1);
	
	JSeparator separator_2 = new JSeparator();
	separator_2.setForeground(Color.LIGHT_GRAY);
	separator_2.setOrientation(SwingConstants.VERTICAL);
	separator_2.setBounds(577, 11, 2, 176);
	tableOfContentsPanel.add(separator_2);
	}
}
