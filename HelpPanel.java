import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	
	private int startLine, lastLine, numLines;
	//private JTextArea textArea;
	
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
	
	rdbtnMainScreen.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 1;
			lastLine = 2;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnNavigationBar = new JRadioButton("Navigation Bar");
	rdbtnNavigationBar.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnNavigationBar.setBounds(14, 44, 183, 19);
	tableOfContentsPanel.add(rdbtnNavigationBar);
	tableOfContentsGroup.add(rdbtnNavigationBar);
	
	rdbtnNavigationBar.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 3;
			lastLine = 4;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
		
	JRadioButton rdbtnChangeUsersButton = new JRadioButton("Change Users Button");
	rdbtnChangeUsersButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnChangeUsersButton.setBounds(14, 66, 183, 19);
	tableOfContentsPanel.add(rdbtnChangeUsersButton);
	tableOfContentsGroup.add(rdbtnChangeUsersButton);
		
	rdbtnChangeUsersButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 5;
			lastLine = 6;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnScreenButtons = new JRadioButton("Screen Buttons");
	rdbtnScreenButtons.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnScreenButtons.setBounds(14, 88, 183, 19);
	tableOfContentsPanel.add(rdbtnScreenButtons);
	tableOfContentsGroup.add(rdbtnScreenButtons);
	
	rdbtnScreenButtons.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 7;
			lastLine = 8;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
		
	JRadioButton rdbtnPosSalesScreen = new JRadioButton("POS Sales Screen");
	rdbtnPosSalesScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
	rdbtnPosSalesScreen.setBounds(14, 110, 183, 19);
	tableOfContentsPanel.add(rdbtnPosSalesScreen);
	tableOfContentsGroup.add(rdbtnPosSalesScreen);
	
	rdbtnPosSalesScreen.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 9;
			lastLine = 10;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnItemButtons = new JRadioButton("Item Buttons");
	rdbtnItemButtons.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnItemButtons.setBounds(14, 132, 183, 19);
	tableOfContentsPanel.add(rdbtnItemButtons);
	tableOfContentsGroup.add(rdbtnItemButtons);
	
	rdbtnItemButtons.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 11;
			lastLine = 12;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnSalesPanel = new JRadioButton("Sales Panel");
	rdbtnSalesPanel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnSalesPanel.setBounds(14, 154, 183, 19);
	tableOfContentsPanel.add(rdbtnSalesPanel);
	tableOfContentsGroup.add(rdbtnSalesPanel);
	
	rdbtnSalesPanel.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 13;
			lastLine = 14;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnCheckoutPanel = new JRadioButton("Checkout Panel");
	rdbtnCheckoutPanel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnCheckoutPanel.setBounds(202, 22, 183, 19);
	tableOfContentsPanel.add(rdbtnCheckoutPanel);
	tableOfContentsGroup.add(rdbtnCheckoutPanel);
	
	rdbtnCheckoutPanel.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 15;
			lastLine = 16;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnCashoutScreen = new JRadioButton("Cashout Window");
	rdbtnCashoutScreen.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnCashoutScreen.setBounds(202, 44, 183, 19);
	tableOfContentsPanel.add(rdbtnCashoutScreen);
	tableOfContentsGroup.add(rdbtnCashoutScreen);
	
	rdbtnCashoutScreen.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 17;
			lastLine = 18;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnInventoryScreen = new JRadioButton("Inventory Screen");
	rdbtnInventoryScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
	rdbtnInventoryScreen.setBounds(202, 66, 183, 19);
	tableOfContentsPanel.add(rdbtnInventoryScreen);
	tableOfContentsGroup.add(rdbtnInventoryScreen);
	
	rdbtnInventoryScreen.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 19;
			lastLine = 20;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnAddItemButton = new JRadioButton("Add Item Button");
	rdbtnAddItemButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnAddItemButton.setBounds(202, 88, 183, 19);
	tableOfContentsPanel.add(rdbtnAddItemButton);
	tableOfContentsGroup.add(rdbtnAddItemButton);
	
	rdbtnAddItemButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 21;
			lastLine = 22;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnEditItemButton = new JRadioButton("Edit Item Button");
	rdbtnEditItemButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnEditItemButton.setBounds(202, 110, 183, 19);
	tableOfContentsPanel.add(rdbtnEditItemButton);
	tableOfContentsGroup.add(rdbtnEditItemButton);
	
	rdbtnEditItemButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 23;
			lastLine = 24;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnDeleteItemButton = new JRadioButton("Delete Item Button");
	rdbtnDeleteItemButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnDeleteItemButton.setBounds(202, 132, 183, 19);
	tableOfContentsPanel.add(rdbtnDeleteItemButton);
	tableOfContentsGroup.add(rdbtnDeleteItemButton);
	
	rdbtnDeleteItemButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 25;
			lastLine = 26;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnSearchScreen = new JRadioButton("Search Screen");
	rdbtnSearchScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
	rdbtnSearchScreen.setBounds(202, 154, 183, 19);
	tableOfContentsPanel.add(rdbtnSearchScreen);
	tableOfContentsGroup.add(rdbtnSearchScreen);
	
	rdbtnSearchScreen.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 27;
			lastLine = 28;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnCustomerSearch = new JRadioButton("Customer Search");
	rdbtnCustomerSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnCustomerSearch.setBounds(388, 22, 183, 19);
	tableOfContentsPanel.add(rdbtnCustomerSearch);
	tableOfContentsGroup.add(rdbtnCustomerSearch);
	
	rdbtnCustomerSearch.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 29;
			lastLine = 30;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnInventorySearch = new JRadioButton("Inventory Search");
	rdbtnInventorySearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnInventorySearch.setBounds(388, 44, 183, 19);
	tableOfContentsPanel.add(rdbtnInventorySearch);
	tableOfContentsGroup.add(rdbtnInventorySearch);
	
	rdbtnInventorySearch.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 31;
			lastLine = 32;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnSupplierSearch = new JRadioButton("Supplier Search");
	rdbtnSupplierSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnSupplierSearch.setBounds(388, 66, 183, 19);
	tableOfContentsPanel.add(rdbtnSupplierSearch);
	tableOfContentsGroup.add(rdbtnSupplierSearch);
	
	rdbtnSupplierSearch.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 33;
			lastLine = 34;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnReportsScreen = new JRadioButton("Reports Screen");
	rdbtnReportsScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
	rdbtnReportsScreen.setBounds(388, 88, 183, 19);
	tableOfContentsPanel.add(rdbtnReportsScreen);
	tableOfContentsGroup.add(rdbtnReportsScreen);
	
	rdbtnReportsScreen.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 35;
			lastLine = 36;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnViewReports = new JRadioButton("View Reports");
	rdbtnViewReports.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnViewReports.setBounds(388, 110, 183, 19);
	tableOfContentsPanel.add(rdbtnViewReports);
	tableOfContentsGroup.add(rdbtnViewReports);
	
	rdbtnViewReports.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 37;
			lastLine = 38;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnSaveReports = new JRadioButton("Save Reports");
	rdbtnSaveReports.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnSaveReports.setBounds(388, 132, 183, 19);
	tableOfContentsGroup.add(rdbtnSaveReports);
	tableOfContentsPanel.add(rdbtnSaveReports);
	
	rdbtnSaveReports.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 39;
			lastLine = 40;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnPrintReports = new JRadioButton("Print Reports");
	rdbtnPrintReports.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnPrintReports.setBounds(388, 154, 183, 19);
	tableOfContentsPanel.add(rdbtnPrintReports);
	tableOfContentsGroup.add(rdbtnPrintReports);
	
	rdbtnPrintReports.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 41;
			lastLine = 42;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnHelpScreen = new JRadioButton("Help Screen");
	rdbtnHelpScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
	rdbtnHelpScreen.setBounds(578, 22, 183, 19);
	tableOfContentsPanel.add(rdbtnHelpScreen);
	tableOfContentsGroup.add(rdbtnHelpScreen);
	
	rdbtnHelpScreen.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 43;
			lastLine = 44;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnUserLogin = new JRadioButton("User Login");
	rdbtnUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnUserLogin.setBounds(578, 44, 183, 19);
	tableOfContentsPanel.add(rdbtnUserLogin);
	tableOfContentsGroup.add(rdbtnUserLogin);
	
	rdbtnUserLogin.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 45;
			lastLine = 46;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnAddingNewUser = new JRadioButton("Adding New User");
	rdbtnAddingNewUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnAddingNewUser.setBounds(578, 66, 183, 19);
	tableOfContentsPanel.add(rdbtnAddingNewUser);
	tableOfContentsGroup.add(rdbtnAddingNewUser);
	
	rdbtnAddingNewUser.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 47;
			lastLine = 48;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnSettings = new JRadioButton("Settings");
	rdbtnSettings.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnSettings.setBounds(578, 88, 183, 19);
	tableOfContentsPanel.add(rdbtnSettings);
	tableOfContentsGroup.add(rdbtnSettings);
	
	rdbtnSettings.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 49;
			lastLine = 50;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnInventoryNotification = new JRadioButton("Inventory Notification");
	rdbtnInventoryNotification.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnInventoryNotification.setBounds(578, 110, 183, 19);
	tableOfContentsPanel.add(rdbtnInventoryNotification);
	tableOfContentsGroup.add(rdbtnInventoryNotification);
	
	rdbtnInventoryNotification.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 51;
			lastLine = 52;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnTempHold = new JRadioButton("temp hold");
	rdbtnTempHold.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnTempHold.setBounds(578, 132, 183, 19);
	tableOfContentsPanel.add(rdbtnTempHold);
	tableOfContentsGroup.add(rdbtnTempHold);
	
	rdbtnTempHold.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 53;
			lastLine = 54;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
	JRadioButton rdbtnTempHold_1 = new JRadioButton("temp hold");
	rdbtnTempHold_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnTempHold_1.setBounds(578, 154, 183, 19);
	tableOfContentsPanel.add(rdbtnTempHold_1);
	tableOfContentsGroup.add(rdbtnTempHold_1);
	
	rdbtnTempHold_1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startLine = 55;
			lastLine = 56;
			numLines = lastLine - startLine;
			updateDisplay(textArea);
		}
	});
	
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
	
	//Initialize text for ScrollPane
	startLine = 0;
	numLines = 50;
	updateDisplay(textArea);
	}
	
	private void updateDisplay(JTextArea text){
		// Set as actionListener to determine which lines of help file to display
		FileReader reader = null;
		BufferedReader br = null;
		try{
			File helpDoc = new File("helpSampleDoc.txt");
			reader = new FileReader(helpDoc);
			br = new BufferedReader(reader);
			for(int i = 1; i < startLine; i++){
				br.readLine();
			}
			String linesIWant = "";
			for(int i = -1; i < numLines; i++){
				linesIWant += br.readLine() + "\n";
			}
			text.setText(linesIWant);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
