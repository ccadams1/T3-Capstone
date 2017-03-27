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
	private JTextField itemNameTextField;
	private JTextField supplierNameTextField;
	private JTextField itemIDTextField;
	private JTextField minPriceTextField;
	private JTextField maxPriceTextField;
	
	public SearchPanel(ArrayList<Object> data)
	{
		setCustomers((CustomerList) data.get(1));
		setInventory((Inventory) data.get(3));
		setSuppliers((SupplierList) data.get(5));
		
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
		JRadioButton customerRadioButton = new JRadioButton("Customer Information");
		customerRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customerRadioButton.setBounds(18, 30, 203, 28);
		RadioPanel.add(customerRadioButton);
		radioButtons.add(customerRadioButton);
			
		//creates an inventory button and adds it to RadioPanel and ButtonGroup
		JRadioButton inventoryRadioButton = new JRadioButton("Inventory Information");
		inventoryRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryRadioButton.setSelected(true);
		inventoryRadioButton.setBounds(18, 63, 203, 32);
		RadioPanel.add(inventoryRadioButton);
		radioButtons.add(inventoryRadioButton);
		
		//creates a supplier button and adds it to RadioPanel and ButtonGroup
		JRadioButton supplierRadioButton = new JRadioButton("Supplier Information");
		supplierRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierRadioButton.setBounds(18, 96, 203, 32);
		RadioPanel.add(supplierRadioButton);
		radioButtons.add(supplierRadioButton);
			
		//adds search button to RadioPanel
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSearch.setBounds(18, 134, 191, 31);
		RadioPanel.add(btnSearch);
		
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
	} 
	
	private JPanel customerRadioPanel()
	{
		JPanel customerRadioPanel = new JPanel();
		customerRadioPanel.setLayout(null);
		
		JLabel customerFirstNameLabel = new JLabel("Customer first name:");
		customerFirstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customerFirstNameLabel.setBounds(10, 12, 179, 29);
		customerRadioPanel.add(customerFirstNameLabel);
		
		JTextField customerFirstNameTextField = new JTextField();
		customerFirstNameTextField.setBounds(165, 5, 114, 35);
		customerRadioPanel.add(customerFirstNameTextField);
		customerFirstNameTextField.setColumns(10);
		
		JLabel customerIDLabel = new JLabel("Customer ID:");
		customerIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customerIDLabel.setBounds(8, 51, 128, 29);
		customerRadioPanel.add(customerIDLabel);
		
		JTextField phoneNumberTextField = new JTextField();
		phoneNumberTextField.setColumns(10);
		phoneNumberTextField.setBounds(368, 44, 128, 35);
		customerRadioPanel.add(phoneNumberTextField);
		
		JLabel customerAddressLabel = new JLabel("Customer address: ");
		customerAddressLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customerAddressLabel.setBounds(10, 92, 146, 29);
		customerRadioPanel.add(customerAddressLabel);
		
		JTextField customerAddressTextField = new JTextField();
		customerAddressTextField.setColumns(10);
		customerAddressTextField.setBounds(154, 85, 342, 35);
		customerRadioPanel.add(customerAddressTextField);
		
		JLabel customerEmailAddressLabel = new JLabel("Email address:");
		customerEmailAddressLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customerEmailAddressLabel.setBounds(10, 132, 114, 29);
		customerRadioPanel.add(customerEmailAddressLabel);
		
		JTextField customerEmailAddressTextField = new JTextField();
		customerEmailAddressTextField.setToolTipText("Minimum price");
		customerEmailAddressTextField.setColumns(10);
		customerEmailAddressTextField.setBounds(124, 125, 214, 35);
		customerRadioPanel.add(customerEmailAddressTextField);
		
		JTextField customerLastNameTextField = new JTextField();
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
		
		JTextField customerIDTextField = new JTextField();
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
		
		itemNameTextField = new JTextField();
		itemNameTextField.setBounds(103, 5, 179, 35);
		inventoryRadioPanel.add(itemNameTextField);
		itemNameTextField.setColumns(10);
		
		JLabel itemPriceLabel = new JLabel("Price:");
		itemPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemPriceLabel.setBounds(8, 51, 56, 29);
		inventoryRadioPanel.add(itemPriceLabel);
		
		JLabel supplierNameLabel = new JLabel("Supplier name:");
		supplierNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierNameLabel.setBounds(10, 92, 114, 29);
		inventoryRadioPanel.add(supplierNameLabel);
		
		supplierNameTextField = new JTextField();
		supplierNameTextField.setColumns(10);
		supplierNameTextField.setBounds(124, 85, 231, 35);
		inventoryRadioPanel.add(supplierNameTextField);
		
		itemIDTextField = new JTextField();
		itemIDTextField.setColumns(10);
		itemIDTextField.setBounds(376, 5, 146, 35);
		inventoryRadioPanel.add(itemIDTextField);
		
		JLabel itemIDLabel = new JLabel("Item ID:");
		itemIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemIDLabel.setBounds(313, 12, 89, 29);
		inventoryRadioPanel.add(itemIDLabel);
		
		minPriceTextField = new JTextField();
		minPriceTextField.setColumns(10);
		minPriceTextField.setBounds(63, 44, 119, 35);
		inventoryRadioPanel.add(minPriceTextField);
		
		JLabel toLabel = new JLabel("to");
		toLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toLabel.setBounds(199, 47, 45, 29);
		inventoryRadioPanel.add(toLabel);
		
		maxPriceTextField = new JTextField();
		maxPriceTextField.setColumns(10);
		maxPriceTextField.setBounds(227, 44, 119, 35);
		inventoryRadioPanel.add(maxPriceTextField);
		
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
		
		JTextField supplierEmailTextField = new JTextField();
		supplierEmailTextField.setColumns(10);
		supplierEmailTextField.setBounds(124, 85, 157, 35);
		supplierRadioPanel.add(supplierEmailTextField);
		
		JLabel supplierPhoneNumberLabel = new JLabel("Phone number:");
		supplierPhoneNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierPhoneNumberLabel.setBounds(291, 92, 128, 29);
		supplierRadioPanel.add(supplierPhoneNumberLabel);
		
		JTextField supplierPhoneNumberTextField = new JTextField();
		supplierPhoneNumberTextField.setToolTipText("Minimum price");
		supplierPhoneNumberTextField.setColumns(10);
		supplierPhoneNumberTextField.setBounds(408, 85, 114, 35);
		supplierRadioPanel.add(supplierPhoneNumberTextField);
		
		JTextField supplierIDTextField = new JTextField();
		supplierIDTextField.setColumns(10);
		supplierIDTextField.setBounds(408, 5, 114, 35);
		supplierRadioPanel.add(supplierIDTextField);
		
		JLabel supplierIDLabel = new JLabel("Supplier ID:");
		supplierIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierIDLabel.setBounds(313, 12, 89, 29);
		supplierRadioPanel.add(supplierIDLabel);
		
		JTextField supplierAddressTextField = new JTextField();
		supplierAddressTextField.setColumns(10);
		supplierAddressTextField.setBounds(134, 44, 388, 35);
		supplierRadioPanel.add(supplierAddressTextField);
		
		JLabel supplierWebsiteLabel = new JLabel("Supplier website:");
		supplierWebsiteLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierWebsiteLabel.setBounds(10, 137, 134, 29);
		supplierRadioPanel.add(supplierWebsiteLabel);
		
		JTextField supplierWebsiteTextField = new JTextField();
		supplierWebsiteTextField.setColumns(10);
		supplierWebsiteTextField.setBounds(134, 130, 388, 35);
		supplierRadioPanel.add(supplierWebsiteTextField);
		
		return supplierRadioPanel;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public CustomerList getCustomers() {
		return customers;
	}

	public void setCustomers(CustomerList customers) {
		this.customers = customers;
	}

	public SupplierList getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(SupplierList suppliers) {
		this.suppliers = suppliers;
	}
} 
