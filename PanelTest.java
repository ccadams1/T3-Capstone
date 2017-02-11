import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;

public class PanelTest {

	private JFrame frame;
	private JTextField itemNameTextField;
	private JTextField supplierNameTextField;
	private JTextField itemIDTextField;
	private JTextField minPriceTextField;
	private JTextField maxPriceTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelTest window = new PanelTest();
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
	public PanelTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton btnPlaceholder = new JButton("PlaceHolder");
		menuBar.add(btnPlaceholder);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 132, 764, 393);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel RadioPanel = new JPanel();
		RadioPanel.setBorder(new TitledBorder(null, "Search Types", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		RadioPanel.setBounds(10, 20, 764, 45);
		frame.getContentPane().add(RadioPanel);
		RadioPanel.setLayout(null);
		
		ButtonGroup radioButtons = new ButtonGroup();
		
		JRadioButton customerRadioButton = new JRadioButton("Customer Information");
		customerRadioButton.setBounds(6, 16, 154, 23);
		RadioPanel.add(customerRadioButton);
		radioButtons.add(customerRadioButton);
		
		JRadioButton inventoryRadioButton = new JRadioButton("Inventory Information");
		inventoryRadioButton.setSelected(true);
		inventoryRadioButton.setBounds(162, 16, 154, 23);
		RadioPanel.add(inventoryRadioButton);
		radioButtons.add(inventoryRadioButton);
		
		JRadioButton supplierRadioButton = new JRadioButton("Supplier Information");
		supplierRadioButton.setSelected(true);
		supplierRadioButton.setBounds(320, 16, 154, 23);
		RadioPanel.add(supplierRadioButton);
		radioButtons.add(supplierRadioButton);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(665, 11, 89, 23);
		RadioPanel.add(btnSearch);
		
		JPanel customerRP = customerRadioPanel();
		JPanel inventoryRP = inventoryRadioPanel();
		JPanel supplierRP = supplierRadioPanel();
		
		if(customerRadioButton.isSelected())
		{
			customerRP.setVisible(true);
			inventoryRP.setVisible(false);
			supplierRP.setVisible(false);
		}
		else if(supplierRadioButton.isSelected())
		{
			supplierRP.setVisible(true);
			inventoryRP.setVisible(false);
			customerRP.setVisible(false);
		}
		else 
		{
			inventoryRP.setVisible(true);
			inventoryRP.setVisible(false);
			supplierRP.setVisible(false);
		}
		
	}
	
	private JPanel customerRadioPanel()
	{
		JPanel customerRadioPanel = new JPanel();
		customerRadioPanel.setBounds(10, 66, 764, 55);
		frame.getContentPane().add(customerRadioPanel);
		customerRadioPanel.setLayout(null);
		
		JLabel itemNameLabel = new JLabel("Customer Name:");
		itemNameLabel.setBounds(10, 11, 116, 14);
		customerRadioPanel.add(itemNameLabel);
		
		itemNameTextField = new JTextField();
		itemNameTextField.setBounds(95, 8, 187, 20);
		customerRadioPanel.add(itemNameTextField);
		itemNameTextField.setColumns(10);
		
		JLabel supplierNameLabel = new JLabel("Customer phone number:");
		supplierNameLabel.setBounds(10, 30, 137, 14);
		customerRadioPanel.add(supplierNameLabel);
		
		supplierNameTextField = new JTextField();
		supplierNameTextField.setColumns(10);
		supplierNameTextField.setBounds(145, 27, 137, 20);
		customerRadioPanel.add(supplierNameTextField);
		
		JLabel itemIDLabel = new JLabel("Customer ID number:");
		itemIDLabel.setBounds(292, 11, 116, 14);
		customerRadioPanel.add(itemIDLabel);
		
		itemIDTextField = new JTextField();
		itemIDTextField.setColumns(10);
		itemIDTextField.setBounds(402, 8, 187, 20);
		customerRadioPanel.add(itemIDTextField);
		
		JLabel customerAddressLabel = new JLabel("Customer Address:");
		customerAddressLabel.setBounds(292, 30, 100, 14);
		customerRadioPanel.add(customerAddressLabel);
		
		minPriceTextField = new JTextField();
		minPriceTextField.setToolTipText("Minimum price");
		minPriceTextField.setColumns(10);
		minPriceTextField.setBounds(402, 27, 187, 20);
		customerRadioPanel.add(minPriceTextField);
		
		return customerRadioPanel;
	}

	private JPanel inventoryRadioPanel()
	{
		JPanel inventoryRadioPanel = new JPanel();
		inventoryRadioPanel.setBounds(10, 66, 764, 55);
		frame.getContentPane().add(inventoryRadioPanel);
		inventoryRadioPanel.setLayout(null);
		
		JLabel itemNameLabel = new JLabel("Item name:");
		itemNameLabel.setBounds(10, 11, 78, 14);
		inventoryRadioPanel.add(itemNameLabel);
		
		itemNameTextField = new JTextField();
		itemNameTextField.setBounds(84, 8, 187, 20);
		inventoryRadioPanel.add(itemNameTextField);
		itemNameTextField.setColumns(10);
		
		JLabel supplierNameLabel = new JLabel("Supplier name:");
		supplierNameLabel.setBounds(10, 30, 78, 14);
		inventoryRadioPanel.add(supplierNameLabel);
		
		supplierNameTextField = new JTextField();
		supplierNameTextField.setColumns(10);
		supplierNameTextField.setBounds(84, 27, 187, 20);
		inventoryRadioPanel.add(supplierNameTextField);
		
		JLabel itemIDLabel = new JLabel("Item ID number:");
		itemIDLabel.setBounds(321, 11, 100, 14);
		inventoryRadioPanel.add(itemIDLabel);
		
		itemIDTextField = new JTextField();
		itemIDTextField.setColumns(10);
		itemIDTextField.setBounds(402, 8, 187, 20);
		inventoryRadioPanel.add(itemIDTextField);
		
		JLabel priceRangeLabel = new JLabel("Price range:");
		priceRangeLabel.setBounds(321, 30, 100, 14);
		inventoryRadioPanel.add(priceRangeLabel);
		
		minPriceTextField = new JTextField();
		minPriceTextField.setToolTipText("Minimum price");
		minPriceTextField.setColumns(10);
		minPriceTextField.setBounds(402, 27, 78, 20);
		inventoryRadioPanel.add(minPriceTextField);
		
		maxPriceTextField = new JTextField();
		maxPriceTextField.setToolTipText("Maximum Price");
		maxPriceTextField.setColumns(10);
		maxPriceTextField.setBounds(511, 27, 78, 20);
		inventoryRadioPanel.add(maxPriceTextField);
		
		JLabel toLabel = new JLabel("to");
		toLabel.setBounds(489, 30, 100, 14);
		inventoryRadioPanel.add(toLabel);
		
		return inventoryRadioPanel;
	}
	
	private JPanel supplierRadioPanel()
	{
		JPanel supplierRadioPanel = new JPanel();
		supplierRadioPanel.setBounds(10, 66, 764, 55);
		frame.getContentPane().add(supplierRadioPanel);
		supplierRadioPanel.setLayout(null);
		
		JLabel itemNameLabel = new JLabel("Item name:");
		itemNameLabel.setBounds(10, 11, 78, 14);
		supplierRadioPanel.add(itemNameLabel);
		
		itemNameTextField = new JTextField();
		itemNameTextField.setBounds(84, 8, 187, 20);
		supplierRadioPanel.add(itemNameTextField);
		itemNameTextField.setColumns(10);
		
		JLabel supplierNameLabel = new JLabel("Supplier name:");
		supplierNameLabel.setBounds(10, 30, 78, 14);
		supplierRadioPanel.add(supplierNameLabel);
		
		supplierNameTextField = new JTextField();
		supplierNameTextField.setColumns(10);
		supplierNameTextField.setBounds(84, 27, 187, 20);
		supplierRadioPanel.add(supplierNameTextField);
		
		JLabel itemIDLabel = new JLabel("Item ID number:");
		itemIDLabel.setBounds(321, 11, 100, 14);
		supplierRadioPanel.add(itemIDLabel);
		
		itemIDTextField = new JTextField();
		itemIDTextField.setColumns(10);
		itemIDTextField.setBounds(402, 8, 187, 20);
		supplierRadioPanel.add(itemIDTextField);
		
		JLabel priceRangeLabel = new JLabel("Price range:");
		priceRangeLabel.setBounds(321, 30, 100, 14);
		supplierRadioPanel.add(priceRangeLabel);
		
		minPriceTextField = new JTextField();
		minPriceTextField.setToolTipText("Minimum price");
		minPriceTextField.setColumns(10);
		minPriceTextField.setBounds(402, 27, 78, 20);
		supplierRadioPanel.add(minPriceTextField);
		
		maxPriceTextField = new JTextField();
		maxPriceTextField.setToolTipText("Maximum Price");
		maxPriceTextField.setColumns(10);
		maxPriceTextField.setBounds(511, 27, 78, 20);
		supplierRadioPanel.add(maxPriceTextField);
		
		JLabel toLabel = new JLabel("to");
		toLabel.setBounds(489, 30, 100, 14);
		supplierRadioPanel.add(toLabel);
		
		return supplierRadioPanel;
	}
}
