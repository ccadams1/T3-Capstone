import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SearchPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private CustomerList customers = new CustomerList();
	private Inventory inventory = new Inventory();
	private SupplierList suppliers = new SupplierList();
	private JRadioButton customerRadioButton = new JRadioButton();
	private JRadioButton inventoryRadioButton = new JRadioButton();
	private JRadioButton supplierRadioButton = new JRadioButton();
	private JTextField customerFirstNameTextField;
	private JTextField customerLastNameTextField;
	private JTextField customerIDTextField;
	private JTextField customerPhoneNumberTextField;
	private JTextField customerAddressTextField;
	private JTextField customerEmailAddressTextField;
	private JTextField inventoryItemNameTextField;
	private JTextField inventorySupplierNameTextField;
	private JTextField inventoryItemIDTextField;
	private JTextField inventoryMinPriceTextField;
	private JTextField inventoryMaxPriceTextField;
	private JTextField supplierNameTextField;
	private JTextField supplierIDTextField;
	private JTextField supplierPhoneNumberTextField;
	private JTextField supplierAddressTextField;
	private JTextField supplierEmailTextField;
	private JTextField supplierWebsiteTextField;
	
	public SearchPanel(ArrayList<Object> data)
	{
		customers = (CustomerList) data.get(1);
		inventory = (Inventory) data.get(3);
		suppliers = (SupplierList) data.get(5);
		
		//bounds should be set to (0, 0, 772, 476)
		this.setBounds(0, 0, 772, 476);
		this.setLayout(null);
		
		//sets up a panel for information placement
		Panel informationPanel = new Panel();
		informationPanel.setBounds(0, 0, 772, 178);
		this.add(informationPanel);		
		informationPanel.setLayout(null);
			
		//inserts radio button panel into information panel
		JPanel RadioPanel = new JPanel();
		RadioPanel.setBounds(0, 0, 239, 178);
		informationPanel.add(RadioPanel);
		RadioPanel.setBorder(new TitledBorder(null, "Search Types", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		RadioPanel.setLayout(null);
		
		//creates a button group for radio buttons to operate
		ButtonGroup radioButtons = new ButtonGroup();
		
		//creates a customer button and adds it to RadioPanel and ButtonGroup
		customerRadioButton = new JRadioButton("Customer Information");
		customerRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customerRadioButton.setBounds(18, 30, 203, 28);
		RadioPanel.add(customerRadioButton);
		radioButtons.add(customerRadioButton);
			
		//creates an inventory button and adds it to RadioPanel and ButtonGroup
		inventoryRadioButton = new JRadioButton("Inventory Information");
		inventoryRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryRadioButton.setSelected(true);
		inventoryRadioButton.setBounds(18, 63, 203, 32);
		RadioPanel.add(inventoryRadioButton);
		radioButtons.add(inventoryRadioButton);
		
		//creates a supplier button and adds it to RadioPanel and ButtonGroup
		supplierRadioButton = new JRadioButton("Supplier Information");
		supplierRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierRadioButton.setBounds(18, 96, 203, 32);
		RadioPanel.add(supplierRadioButton);
		radioButtons.add(supplierRadioButton);
		
		//creates panels that display based on the radio buttons
		//sets inventory search Panel
		JPanel inv = inventoryRadioPanel();
		inv.setBounds(239, 0, 533, 178);
		informationPanel.add(inv);
		
		//sets customer search Panel
		JPanel cus = customerRadioPanel();
		cus.setBounds(239, 0, 533, 178);
		cus.setVisible(false);
		informationPanel.add(cus);
		
		//sets supplier search Panel
		JPanel sup = supplierRadioPanel();
		sup.setBounds(239, 0, 533, 178);
		sup.setVisible(false);
		informationPanel.add(sup);
		
		//utilizes radio button to display type of search Panel
		customerRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cus.setVisible(true);
				sup.setVisible(false);
				inv.setVisible(false);
			}
		});
		inventoryRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inv.setVisible(true);
				cus.setVisible(false);
				sup.setVisible(false);
			}
		});
		supplierRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sup.setVisible(true);
				cus.setVisible(false);
				inv.setVisible(false);
			}
		});
		
		//creates a scrolling text area
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 174, 772, 302);
		this.add(scrollPane);
		
		//creates text area to put in the scrollPane
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		//adds search button to RadioPanel
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSearch.setBounds(18, 134, 191, 31);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				textArea.setText(textLabel());
				ArrayList results = getResults();
				for (int x = 0; x < results.size(); x++)
				{
					textArea.append(results.get(x).toString() + "\n");
				}
			}
		});
		RadioPanel.add(btnSearch);
	} 
	
	private JPanel customerRadioPanel()
	{
		JPanel customerRadioPanel = new JPanel();
		customerRadioPanel.setLayout(null);
		
		JLabel customerFirstNameLabel = new JLabel("Customer first name:");
		customerFirstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customerFirstNameLabel.setBounds(10, 12, 179, 29);
		customerRadioPanel.add(customerFirstNameLabel);
		
		customerFirstNameTextField = new JTextField();
		customerFirstNameTextField.setBounds(165, 5, 114, 35);
		customerRadioPanel.add(customerFirstNameTextField);
		customerFirstNameTextField.setColumns(10);
		
		JLabel customerIDLabel = new JLabel("Customer ID:");
		customerIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customerIDLabel.setBounds(8, 51, 128, 29);
		customerRadioPanel.add(customerIDLabel);
		
		customerPhoneNumberTextField = new JTextField();
		customerPhoneNumberTextField.setColumns(10);
		customerPhoneNumberTextField.setBounds(368, 44, 128, 35);
		customerRadioPanel.add(customerPhoneNumberTextField);
		
		JLabel customerAddressLabel = new JLabel("Customer address: ");
		customerAddressLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customerAddressLabel.setBounds(10, 92, 146, 29);
		customerRadioPanel.add(customerAddressLabel);
		
		customerAddressTextField = new JTextField();
		customerAddressTextField.setColumns(10);
		customerAddressTextField.setBounds(154, 85, 342, 35);
		customerRadioPanel.add(customerAddressTextField);
		
		JLabel customerEmailAddressLabel = new JLabel("Email address:");
		customerEmailAddressLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customerEmailAddressLabel.setBounds(10, 132, 114, 29);
		customerRadioPanel.add(customerEmailAddressLabel);
		
		customerEmailAddressTextField = new JTextField();
		customerEmailAddressTextField.setToolTipText("Minimum price");
		customerEmailAddressTextField.setColumns(10);
		customerEmailAddressTextField.setBounds(124, 125, 214, 35);
		customerRadioPanel.add(customerEmailAddressTextField);
		
		customerLastNameTextField = new JTextField();
		customerLastNameTextField.setColumns(10);
		customerLastNameTextField.setBounds(382, 5, 114, 35);
		customerRadioPanel.add(customerLastNameTextField);
		
		JLabel customerLastNameLabel = new JLabel("Last name:");
		customerLastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customerLastNameLabel.setBounds(292, 12, 89, 29);
		customerRadioPanel.add(customerLastNameLabel);
		
		JLabel phoneNumberLabel = new JLabel("Phone number:");
		phoneNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneNumberLabel.setBounds(246, 51, 128, 29);
		customerRadioPanel.add(phoneNumberLabel);
		
		customerIDTextField = new JTextField();
		customerIDTextField.setColumns(10);
		customerIDTextField.setBounds(114, 44, 110, 35);
		customerRadioPanel.add(customerIDTextField);
		
		return customerRadioPanel;
	}

	private JPanel inventoryRadioPanel()
	{
		JPanel inventoryRadioPanel = new JPanel();
		inventoryRadioPanel.setLayout(null);
		
		JLabel itemNameLabel = new JLabel("Item name:");
		itemNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemNameLabel.setBounds(10, 12, 114, 29);
		inventoryRadioPanel.add(itemNameLabel);
		
		inventoryItemNameTextField = new JTextField();
		inventoryItemNameTextField.setBounds(103, 5, 179, 35);
		inventoryRadioPanel.add(inventoryItemNameTextField);
		inventoryItemNameTextField.setColumns(10);
		
		JLabel itemPriceLabel = new JLabel("Price:");
		itemPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemPriceLabel.setBounds(8, 51, 56, 29);
		inventoryRadioPanel.add(itemPriceLabel);
		
		JLabel supplierNameLabel = new JLabel("Supplier name:");
		supplierNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierNameLabel.setBounds(10, 92, 114, 29);
		inventoryRadioPanel.add(supplierNameLabel);

		inventorySupplierNameTextField = new JTextField();
		inventorySupplierNameTextField.setColumns(10);
		inventorySupplierNameTextField.setBounds(124, 85, 231, 35);
		inventoryRadioPanel.add(inventorySupplierNameTextField);
		
		inventoryItemIDTextField = new JTextField();
		inventoryItemIDTextField.setColumns(10);
		inventoryItemIDTextField.setBounds(376, 5, 146, 35);
		inventoryRadioPanel.add(inventoryItemIDTextField);
		
		JLabel itemIDLabel = new JLabel("Item ID:");
		itemIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemIDLabel.setBounds(313, 12, 89, 29);
		inventoryRadioPanel.add(itemIDLabel);
		
		inventoryMinPriceTextField = new JTextField();
		inventoryMinPriceTextField.setColumns(10);
		inventoryMinPriceTextField.setBounds(63, 44, 119, 35);
		inventoryMinPriceTextField.setText(" ");
		inventoryRadioPanel.add(inventoryMinPriceTextField);
		
		JLabel toLabel = new JLabel("to");
		toLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toLabel.setBounds(199, 47, 45, 29);
		inventoryRadioPanel.add(toLabel);
		
		inventoryMaxPriceTextField = new JTextField();
		inventoryMaxPriceTextField.setColumns(10);
		inventoryMaxPriceTextField.setBounds(227, 44, 119, 35);
		inventoryMaxPriceTextField.setText(" ");
		inventoryRadioPanel.add(inventoryMaxPriceTextField);
		
		return inventoryRadioPanel;
	}
	
	private JPanel supplierRadioPanel()
	{
		JPanel supplierRadioPanel = new JPanel();
		supplierRadioPanel.setLayout(null);
		
		JLabel supplierNameLabel = new JLabel("Supplier name:");
		supplierNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierNameLabel.setBounds(10, 12, 114, 29);
		supplierRadioPanel.add(supplierNameLabel);
		
		supplierNameTextField = new JTextField();
		supplierNameTextField.setBounds(124, 5, 179, 35);
		supplierRadioPanel.add(supplierNameTextField);
		supplierNameTextField.setColumns(10);
		
		JLabel supplierAddressLabel = new JLabel("Supplier address:");
		supplierAddressLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierAddressLabel.setBounds(8, 51, 128, 29);
		supplierRadioPanel.add(supplierAddressLabel);
		
		JLabel supplierEmailLabel = new JLabel("Supplier email:");
		supplierEmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierEmailLabel.setBounds(10, 92, 114, 29);
		supplierRadioPanel.add(supplierEmailLabel);
		
		supplierEmailTextField = new JTextField();
		supplierEmailTextField.setColumns(10);
		supplierEmailTextField.setBounds(124, 85, 157, 35);
		supplierRadioPanel.add(supplierEmailTextField);
		
		JLabel supplierPhoneNumberLabel = new JLabel("Phone number:");
		supplierPhoneNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierPhoneNumberLabel.setBounds(291, 92, 128, 29);
		supplierRadioPanel.add(supplierPhoneNumberLabel);
		
		supplierPhoneNumberTextField = new JTextField();
		supplierPhoneNumberTextField.setToolTipText("Minimum price");
		supplierPhoneNumberTextField.setColumns(10);
		supplierPhoneNumberTextField.setBounds(408, 85, 114, 35);
		supplierRadioPanel.add(supplierPhoneNumberTextField);
		
		supplierIDTextField = new JTextField();
		supplierIDTextField.setColumns(10);
		supplierIDTextField.setBounds(408, 5, 114, 35);
		supplierRadioPanel.add(supplierIDTextField);
		
		JLabel supplierIDLabel = new JLabel("Supplier ID:");
		supplierIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierIDLabel.setBounds(313, 12, 89, 29);
		supplierRadioPanel.add(supplierIDLabel);
		
		supplierAddressTextField = new JTextField();
		supplierAddressTextField.setColumns(10);
		supplierAddressTextField.setBounds(134, 44, 388, 35);
		supplierRadioPanel.add(supplierAddressTextField);
		
		JLabel supplierWebsiteLabel = new JLabel("Supplier website:");
		supplierWebsiteLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierWebsiteLabel.setBounds(10, 137, 134, 29);
		supplierRadioPanel.add(supplierWebsiteLabel);
		
		supplierWebsiteTextField = new JTextField();
		supplierWebsiteTextField.setColumns(10);
		supplierWebsiteTextField.setBounds(134, 130, 388, 35);
		supplierRadioPanel.add(supplierWebsiteTextField);
		
		return supplierRadioPanel;
	}

	public ArrayList<Object> getResults()
	{
		ArrayList<Object> resultList = new ArrayList<Object>();
		ArrayList<Integer> results = new ArrayList<Integer>();
		boolean addToResults = false;
		
		//uses customer list
		if (customerRadioButton.isSelected())
		{
			ArrayList<Customer> originalList = customers.getList();
			for(int x = 0; x < originalList.size(); x++)
			{
				originalList.get(x).setFName(originalList.get(x).getFName().toLowerCase().trim().replaceAll(" ", ""));
				originalList.get(x).setLName(originalList.get(x).getLName().toLowerCase().trim().replaceAll(" ", ""));
				originalList.get(x).setID(originalList.get(x).getID().toLowerCase().trim().replaceAll(" ", ""));
				originalList.get(x).setPhone1(originalList.get(x).getPhone1());
				originalList.get(x).setStAdress1(originalList.get(x).getStAdress1().toLowerCase().trim().replaceAll(" ", ""));
				originalList.get(x).setEmail(originalList.get(x).getEmail().toLowerCase().trim().replaceAll(" ", ""));
			}
			
			boolean containsFName = false;
			boolean containsLName = false;
			boolean containsID = false;
			boolean containsPhone = false;
			boolean containsAddress = false;
			boolean containsEmail = false;
			
			String searchFName = customerFirstNameTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			String searchLName = customerLastNameTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			String searchID = customerIDTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			String searchPhone = customerPhoneNumberTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			String searchAddress = customerAddressTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			String searchEmail = customerEmailAddressTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			
			for(int y = 0; y < originalList.size(); y++)
			{
				//resets booleans
				addToResults = false;
				containsFName = false;
				containsLName = false;
				containsID = false;
				containsPhone = false;
				containsAddress = false;
				containsEmail = false;
				
				//checks name
				if(!searchFName.equals(""))
				{
					if(originalList.get(y).getFName().contains(searchFName))
					{
						containsFName = true;
					}
				}
				else
				{
					containsFName = true;
				}
				
				if(!searchLName.equals(""))
				{
					if(originalList.get(y).getLName().contains(searchLName))
					{
						containsLName = true;
					}
				}
				else
				{
					containsLName = true;
				}
				
				//checks Id
				if(!searchID.equals(""))
				{
					if(originalList.get(y).getID().contains(searchID))
					{
						containsID = true;
					}
				}
				else
				{
					containsID = true;
				}
				
				//checks Phone
				if(!searchPhone.equals(""))
				{
					if((originalList.get(y).getPhone1()+"").contains(searchPhone))
					{
						containsPhone = true;
					}
				}
				else
				{
					containsPhone = true;
				}
				
				//checks address
				if(!searchAddress.equals(""))
				{
					if(originalList.get(y).getStAdress1().contains(searchAddress))
					{
						containsAddress = true;
					}
				}
				else
				{
					containsAddress = true;
				}
				
				
				//checks email
				if(!searchEmail.equals(""))
				{
					if(originalList.get(y).getEmail().contains(searchEmail))
					{
						containsEmail = true;
					}
				}
				else
				{
					containsEmail = true;
				}
				
				if(containsFName && containsLName && containsID && containsPhone && containsAddress && containsEmail)
				{
					addToResults = true;
				}
				
				if(searchFName.equals("") && searchLName.equals("") && searchID.equals("") && 
						searchPhone.equals("") && searchAddress.equals("") && searchEmail.equals(""))
				{
					addToResults = true;
				}
				
				if(addToResults)
				{
					results.add(y);
				}
			}
			
			//adding items to resultList
			for(int z = 0; z < results.size(); z++)
			{
				resultList.add(customers.getCustomer((int) results.get(z)));
			}
		}
		//uses inventory list
		else if (inventoryRadioButton.isSelected())
		{
			ArrayList<Item> originalList = inventory.getList();	
			for(int x = 0; x < originalList.size(); x++)
			{
				originalList.get(x).setName(originalList.get(x).getName().toLowerCase().trim().replaceAll(" ", ""));
				originalList.get(x).setSupplier(originalList.get(x).getSupplier().toLowerCase().trim().replaceAll(" ", ""));
				originalList.get(x).setId(originalList.get(x).getId().toLowerCase().trim().replaceAll(" ", ""));
			}
			
			boolean containsName = false;
			boolean containsID = false;
			boolean containsMin = false;
			boolean containsMax = false;
			boolean containsSupplierName = false;
			String searchName = inventoryItemNameTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			String searchID = inventoryItemIDTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			Double searchMin = null;
			/*if(!(inventoryMinPriceTextField.getText() == ""))
			{
				searchMin = Double.parseDouble(inventoryMinPriceTextField.getText());
			}*/
			Double searchMax = null;
			/*if(!(inventoryMaxPriceTextField.getText() == null) && !(inventoryMaxPriceTextField.getText() == ""))
			{
				searchMax = Double.parseDouble(inventoryMaxPriceTextField.getText());
			}*/
			String searchSupplierName = inventorySupplierNameTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			
			for(int y = 0; y < originalList.size(); y++)
			{
				//resets add to results boolean
				addToResults = false;
				containsName = false;
				containsID = false;
				containsMin = false;
				containsMax = false;
				containsSupplierName = false;
				
				//checks name
				if(!searchName.equals(""))
				{
					if(originalList.get(y).getName().contains(searchName))
					{
						containsName = true;
					}
				}
				else
				{
					containsName = true;
				}
				
				//checks Id
				if(!searchID.equals(""))
				{
					if(originalList.get(y).getId().contains(searchID))
					{
						containsID = true;
					}
				}
				else
				{
					containsID = true;
				}
				
				//check min and max
				if(!(searchMin == null || (searchMin+"").equals("")) && !(searchMax == null || (searchMax+"").equals("")))
				{
					if(originalList.get(y).getPrice() >= searchMin && originalList.get(y).getPrice() <= searchMax)
					{
						containsMin = true;
						containsMax = true;
					}
				}
				else if((searchMin == null || (searchMin+"").equals("")) && !(searchMax == null || (searchMax+"").equals("")))
				{
					containsMax = true;
					if(originalList.get(y).getPrice() >= searchMin)
					{
						containsMin = true;
					}
				}
				else if(!(searchMin == null || (searchMin+"").equals("")) && (searchMax == null || (searchMax+"").equals("")))
				{
					containsMin = true;
					if(originalList.get(y).getPrice() <= searchMax)
					{
						containsMax = true;
					}
				}
				else
				{
					containsMin = true;
					containsMax = true;
				}
				
				//checks supplier name
				if(!searchSupplierName.equals(""))
				{
					if(originalList.get(y).getSupplier().contains(searchSupplierName))
					{
						containsSupplierName = true;
					}
				}
				else
				{
					containsSupplierName = true;
				}
				
				if(containsName && containsID && containsMin && containsMax && containsSupplierName)
				{
					addToResults = true;
				}
				
				if(searchName.equals("") && searchID.equals("") && (searchMin+"").equals("") 
						&& (searchMin+"").equals("") && searchSupplierName.equals(""))
				{
					addToResults = true;
				}
				
				if(addToResults)
				{
					results.add(y);
				}
			}
			
			//adding items to resultList
			for(int z = 0; z < results.size(); z++)
			{
				resultList.add(inventory.get((int) results.get(z)));
			}
		}
		//uses supplier list
		else
		{
			ArrayList<Supplier> originalList = suppliers.getList();
			for(int x = 0; x < originalList.size(); x++)
			{
				originalList.get(x).setName(originalList.get(x).getName().toLowerCase().trim().replaceAll(" ", ""));
				originalList.get(x).setID(originalList.get(x).getID().toLowerCase().trim().replaceAll(" ", ""));
				originalList.get(x).setPhone1(originalList.get(x).getPhone1());
				originalList.get(x).setStAdress1(originalList.get(x).getStAdress1().toLowerCase().trim().replaceAll(" ", ""));
				originalList.get(x).setEmail(originalList.get(x).getEmail().toLowerCase().trim().replaceAll(" ", ""));
				originalList.get(x).setWebsite(originalList.get(x).getWebsite().toLowerCase().trim().replaceAll(" ", ""));
			}
			
			boolean containsName = false;
			boolean containsID = false;
			boolean containsPhone = false;
			boolean containsAddress = false;
			boolean containsEmail = false;
			boolean containsWebsite = false;
			
			String searchName = supplierNameTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			String searchID = supplierIDTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			String searchPhone = supplierPhoneNumberTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			String searchAddress = supplierAddressTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			String searchEmail = supplierEmailTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			String searchWebsite = supplierWebsiteTextField.getText().toLowerCase().trim().replaceAll(" ", "");
			
			for(int y = 0; y < originalList.size(); y++)
			{
				//resets add to results boolean
				addToResults = false;
				containsName = false;
				containsID = false;
				containsPhone = false;
				containsAddress = false;
				containsEmail = false;
				containsWebsite = false;
				
				//checks name
				if(!searchName.equals(""))
				{
					if(originalList.get(y).getName().contains(searchName))
					{
						containsName = true;
					}
				}
				else
				{
					containsName = true;
				}
				
				//checks Id
				if(!searchID.equals(""))
				{
					if(originalList.get(y).getID().contains(searchID))
					{
						containsID = true;
					}
				}
				else
				{
					containsID = true;
				}
				
				//checks name
				if(!searchName.equals(""))
				{
					if((originalList.get(y).getPhone1()+"").contains(searchPhone))
					{
						containsPhone = true;
					}
				}
				else
				{
					containsPhone = true;
				}
				
				//checks Id
				if(!searchID.equals(""))
				{
					if(originalList.get(y).getStAdress1().contains(searchAddress))
					{
						containsAddress = true;
					}
				}
				else
				{
					containsAddress = true;
				}
				
				//checks name
				if(!searchName.equals(""))
				{
					if(originalList.get(y).getEmail().contains(searchEmail))
					{
						containsEmail = true;
					}
				}
				else
				{
					containsEmail = true;
				}
				
				//checks Id
				if(!searchWebsite.equals(""))
				{
					if(originalList.get(y).getWebsite().contains(searchWebsite))
					{
						containsWebsite = true;
					}
				}
				else
				{
					containsWebsite = true;
				}
				
				if(containsName && containsID && containsPhone && containsAddress && containsEmail && containsWebsite)
				{
					addToResults = true;
				}
				
				if(searchName.equals("") && searchID.equals("") && searchPhone.equals("") 
						&& searchAddress.equals("") && searchEmail.equals("") && searchWebsite.equals(""))
				{
					addToResults = true;
				}
				
				if(addToResults)
				{
					results.add(y);
				}
			}
			
			//adding items to resultList
			for(int z = 0; z < results.size(); z++)
			{
				resultList.add(suppliers.getSupplier((int) results.get(z)));
			}
		}
		
		return resultList; 
	}
	
	public String textLabel()
	{
		String string = "";
		if(customerRadioButton.isSelected())
		{
			string += "Customer ID\tFirst Name\tLast Name\tAddress\t\tCity\tState\tZipcode\tMain Phone\tOther Phone\tEmail\t\tFax\n";
			string += "---------------------------------------------------------------------------------------------------------";
			string += "---------------------------------------------------------------------------------------------------------";
			string += "--------------------------------------------\n";
		}
		else if(inventoryRadioButton.isSelected())
		{
			
		}
		else
		{
			
		}
		return string;
	}
} 
