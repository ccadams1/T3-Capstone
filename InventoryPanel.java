import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class InventoryPanel extends JPanel{
	private JTextField itemNameTextField;
	private JTextField supplierNameTextField;
	private JTextField itemIDTextField;
	private JTextField minPriceTextField;
	private JTextField maxPriceTextField;
	
	public InventoryPanel()
	{
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
		RadioPanel.setBorder(new TitledBorder(null, "Inventory", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		RadioPanel.setLayout(null);
		
		//creates a button group for radio buttons to operate
		ButtonGroup radioButtons = new ButtonGroup();
		
		//creates an add item button and adds it to RadioPanel and ButtonGroup
		JRadioButton addItemButton = new JRadioButton("Add Item");
		addItemButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addItemButton.setBounds(18, 30, 203, 28);
		addItemButton.setSelected(true);
		RadioPanel.add(addItemButton);
		radioButtons.add(addItemButton);
			
		//creates an edit item button and adds it to RadioPanel and ButtonGroup
		JRadioButton editItemButton = new JRadioButton("Edit Item");
		editItemButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editItemButton.setBounds(18, 63, 203, 32);
		RadioPanel.add(editItemButton);
		radioButtons.add(editItemButton);
		
		//creates a delete item button and adds it to RadioPanel and ButtonGroup
		JRadioButton deleteItemButton = new JRadioButton("Delete Item");
		deleteItemButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteItemButton.setBounds(18, 96, 203, 32);
		RadioPanel.add(deleteItemButton);
		radioButtons.add(deleteItemButton);
			
		//adds search button to RadioPanel
		JButton changeInventoryButton = new JButton("Change Inventory");
		changeInventoryButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		changeInventoryButton.setBounds(18, 134, 191, 31);
		RadioPanel.add(changeInventoryButton);
		
		//creates panels that display based on the radio buttons
		//sets edit item Panel
		JPanel editItem = editItemRadioPanel();
		editItem.setBounds(239, 0, 533, 178);
		informationPanel.add(editItem);
		editItem.setVisible(false);

		
		//sets add item Panel
		JPanel addItem = addItemRadioPanel();
		addItem.setBounds(239, 0, 533, 178);
		addItem.setVisible(true);
		informationPanel.add(addItem);
		
		//sets delete item Panel
		JPanel deleteItem = deleteItemRadioPanel();
		deleteItem.setBounds(239, 0, 533, 178);
		deleteItem.setVisible(false);
		informationPanel.add(deleteItem);
		
		//utilizes radio button to display type of item Panel
		addItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addItem.setVisible(true);
				deleteItem.setVisible(false);
				editItem.setVisible(false);
				changeInventoryButton.setVisible(true);
			}
		});
		editItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editItem.setVisible(true);
				addItem.setVisible(false);
				deleteItem.setVisible(false);
				changeInventoryButton.setVisible(true);
			}
		});
		deleteItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteItem.setVisible(true);
				addItem.setVisible(false);
				editItem.setVisible(false);
				changeInventoryButton.setVisible(false);
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
	
	private JPanel addItemRadioPanel()
	{
		JPanel addItemRadioPanel = new JPanel();
		addItemRadioPanel.setLayout(null);
		
		JLabel itemNameLabel = new JLabel("Item name:");
		itemNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemNameLabel.setBounds(10, 12, 114, 29);
		addItemRadioPanel.add(itemNameLabel);
		
		itemNameTextField = new JTextField();
		itemNameTextField.setBounds(103, 5, 179, 35);
		addItemRadioPanel.add(itemNameTextField);
		itemNameTextField.setColumns(10);
		
		JLabel supplierNameLabel = new JLabel("Supplier name:");
		supplierNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierNameLabel.setBounds(10, 92, 114, 29);
		addItemRadioPanel.add(supplierNameLabel);
		
		supplierNameTextField = new JTextField();
		supplierNameTextField.setColumns(10);
		supplierNameTextField.setBounds(124, 85, 231, 35);
		addItemRadioPanel.add(supplierNameTextField);
		
		itemIDTextField = new JTextField();
		itemIDTextField.setColumns(10);
		itemIDTextField.setBounds(376, 5, 146, 35);
		addItemRadioPanel.add(itemIDTextField);
		
		JLabel itemIDLabel = new JLabel("Item ID:");
		itemIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemIDLabel.setBounds(313, 12, 89, 29);
		addItemRadioPanel.add(itemIDLabel);
		
		JLabel itemDescriptionLabel = new JLabel("Item description:");
		itemDescriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemDescriptionLabel.setBounds(10, 137, 134, 29);
		addItemRadioPanel.add(itemDescriptionLabel);
		
		JTextField ItemDescriptionTextField = new JTextField();
		ItemDescriptionTextField.setColumns(10);
		ItemDescriptionTextField.setBounds(134, 130, 388, 35);
		addItemRadioPanel.add(ItemDescriptionTextField);
		
		JLabel itemPriceLabel = new JLabel("Price:");
		itemPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemPriceLabel.setBounds(8, 51, 56, 29);
		addItemRadioPanel.add(itemPriceLabel);
		
		minPriceTextField = new JTextField();
		minPriceTextField.setColumns(10);
		minPriceTextField.setBounds(63, 44, 100, 35);
		addItemRadioPanel.add(minPriceTextField);
		
		JLabel toLabel = new JLabel("to");
		toLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toLabel.setBounds(180, 51, 45, 29);
		addItemRadioPanel.add(toLabel);
		
		maxPriceTextField = new JTextField();
		maxPriceTextField.setColumns(10);
		maxPriceTextField.setBounds(208, 44, 100, 35);
		addItemRadioPanel.add(maxPriceTextField);

		JLabel parStockLabel = new JLabel("Par stock:");
		parStockLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		parStockLabel.setBounds(328, 51, 87, 29);
		addItemRadioPanel.add(parStockLabel);
		
		JTextField parStockTextField = new JTextField();
		parStockTextField.setColumns(10);
		parStockTextField.setBounds(400, 44, 115, 35);
		addItemRadioPanel.add(parStockTextField);
		
		return addItemRadioPanel;
	}

	private JPanel editItemRadioPanel()
	{
		JPanel editItemRadioPanel = new JPanel();
		editItemRadioPanel.setLayout(null);
		
		JLabel itemNameLabel = new JLabel("Item name:");
		itemNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemNameLabel.setBounds(10, 12, 114, 29);
		editItemRadioPanel.add(itemNameLabel);
		
		itemNameTextField = new JTextField();
		itemNameTextField.setBounds(103, 5, 179, 35);
		editItemRadioPanel.add(itemNameTextField);
		itemNameTextField.setColumns(10);
		
		JLabel supplierNameLabel = new JLabel("Supplier name:");
		supplierNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierNameLabel.setBounds(10, 92, 114, 29);
		editItemRadioPanel.add(supplierNameLabel);
		
		supplierNameTextField = new JTextField();
		supplierNameTextField.setColumns(10);
		supplierNameTextField.setBounds(124, 85, 231, 35);
		editItemRadioPanel.add(supplierNameTextField);
		
		itemIDTextField = new JTextField();
		itemIDTextField.setColumns(10);
		itemIDTextField.setBounds(376, 5, 146, 35);
		editItemRadioPanel.add(itemIDTextField);
		
		JLabel itemIDLabel = new JLabel("Item ID:");
		itemIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemIDLabel.setBounds(313, 12, 89, 29);
		editItemRadioPanel.add(itemIDLabel);
		
		JLabel itemDescriptionLabel = new JLabel("Item description:");
		itemDescriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemDescriptionLabel.setBounds(10, 137, 134, 29);
		editItemRadioPanel.add(itemDescriptionLabel);
		
		JTextField ItemDescriptionTextField = new JTextField();
		ItemDescriptionTextField.setColumns(10);
		ItemDescriptionTextField.setBounds(134, 130, 388, 35);
		editItemRadioPanel.add(ItemDescriptionTextField);
		
		JLabel itemPriceLabel = new JLabel("Price:");
		itemPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemPriceLabel.setBounds(8, 51, 56, 29);
		editItemRadioPanel.add(itemPriceLabel);
		
		minPriceTextField = new JTextField();
		minPriceTextField.setColumns(10);
		minPriceTextField.setBounds(63, 44, 100, 35);
		editItemRadioPanel.add(minPriceTextField);
		
		JLabel toLabel = new JLabel("to");
		toLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toLabel.setBounds(180, 51, 45, 29);
		editItemRadioPanel.add(toLabel);
		
		maxPriceTextField = new JTextField();
		maxPriceTextField.setColumns(10);
		maxPriceTextField.setBounds(208, 44, 100, 35);
		editItemRadioPanel.add(maxPriceTextField);

		JLabel parStockLabel = new JLabel("Par stock:");
		parStockLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		parStockLabel.setBounds(328, 51, 87, 29);
		editItemRadioPanel.add(parStockLabel);
		
		JTextField parStockTextField = new JTextField();
		parStockTextField.setColumns(10);
		parStockTextField.setBounds(400, 44, 115, 35);
		editItemRadioPanel.add(parStockTextField);
		
		return editItemRadioPanel;
	}
	
	private JPanel deleteItemRadioPanel()
	{
		JPanel deleteItemRadioPanel = new JPanel();
		deleteItemRadioPanel.setLayout(null);
		
		JLabel itemNameLabel = new JLabel("Item name:");
		itemNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemNameLabel.setBounds(85, 12, 114, 29);
		deleteItemRadioPanel.add(itemNameLabel);
		
		itemNameTextField = new JTextField();
		itemNameTextField.setBounds(173, 5, 179, 35);
		deleteItemRadioPanel.add(itemNameTextField);
		itemNameTextField.setColumns(10);
		
		itemIDTextField = new JTextField();
		itemIDTextField.setColumns(10);
		itemIDTextField.setBounds(189, 85, 146, 35);
		deleteItemRadioPanel.add(itemIDTextField);
		
		JLabel itemIDLabel = new JLabel("Item ID:");
		itemIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemIDLabel.setBounds(115, 92, 89, 29);
		deleteItemRadioPanel.add(itemIDLabel);
		
		JLabel andLabel = new JLabel("AND");
		andLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		andLabel.setBounds(198, 52, 45, 29);
		deleteItemRadioPanel.add(andLabel);
		
		JCheckBox chckbxConfirmDelete = new JCheckBox("Confirm delete");
		chckbxConfirmDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxConfirmDelete.setBounds(125, 129, 199, 37);
		deleteItemRadioPanel.add(chckbxConfirmDelete);
		
		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeleteItem.setBounds(390, 134, 141, 32);
		deleteItemRadioPanel.add(btnDeleteItem);
		
		return deleteItemRadioPanel;
	}
} 
