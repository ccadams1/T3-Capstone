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
	private JTextField editItemNameTextField, addItemNameTextField, deleteItemNameTextField;
	private JTextField addSupplierNameTextField, editSupplierNameTextField;
	private JTextField addItemIDTextField, editItemIDTextField, deleteItemIDTextField;
	private JTextField addMinPriceTextField, editMinPriceTextField;
	private JTextField addMaxPriceTextField, editMaxPriceTextField;
	private JTextField addItemDescription, editItemDescription;
	private JTextField addParStockTextField, editParStockTextField;
	private Inventory inventory;
	
	public InventoryPanel()
	{
		
		//change this later////
		//
			inventory = new Inventory();
		//
		///////////////////////
		
		//bounds should be set to (0, 0, 772, 476)
		this.setBounds(0, 0, 772, 476);
		this.setLayout(null);
		
		//sets up a panel for information placement
		Panel informationPanel = new Panel();
		informationPanel.setBounds(0, 0, 772, 178);
		this.add(informationPanel);		
		informationPanel.setLayout(null);
			
		//creates a scrolling text area
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 174, 772, 302);
		this.add(scrollPane);
				
		//creates text area to put in the scrollPane
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));	
		updateInventoryDisplay(textArea);
				
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

		
		//sets add item Panel
		JPanel addItemRadioPanel = new JPanel();
		addItemRadioPanel.setLayout(null);
		
		JLabel addItemNameLabel = new JLabel("Item name:");
		addItemNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addItemNameLabel.setBounds(10, 12, 114, 29);
		addItemRadioPanel.add(addItemNameLabel);
		
		addItemNameTextField = new JTextField();
		addItemNameTextField.setBounds(103, 5, 179, 35);
		addItemRadioPanel.add(addItemNameTextField);
		addItemNameTextField.setColumns(10);
		
		JLabel addSupplierNameLabel = new JLabel("Supplier name:");
		addSupplierNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addSupplierNameLabel.setBounds(10, 92, 114, 29);
		addItemRadioPanel.add(addSupplierNameLabel);
		
		addSupplierNameTextField = new JTextField();
		addSupplierNameTextField.setColumns(10);
		addSupplierNameTextField.setBounds(124, 85, 231, 35);
		addItemRadioPanel.add(addSupplierNameTextField);
		
		addItemIDTextField = new JTextField();
		addItemIDTextField.setColumns(10);
		addItemIDTextField.setBounds(376, 5, 146, 35);
		addItemRadioPanel.add(addItemIDTextField);
		
		JLabel addItemIDLabel = new JLabel("Item ID:");
		addItemIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addItemIDLabel.setBounds(313, 12, 89, 29);
		addItemRadioPanel.add(addItemIDLabel);
		
		JLabel addItemDescriptionLabel = new JLabel("Item description:");
		addItemDescriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addItemDescriptionLabel.setBounds(10, 137, 134, 29);
		addItemRadioPanel.add(addItemDescriptionLabel);
		
		addItemDescription = new JTextField();
		addItemDescription.setColumns(10);
		addItemDescription.setBounds(134, 130, 388, 35);
		addItemRadioPanel.add(addItemDescription);
		
		JLabel addItemPriceLabel = new JLabel("Price:");
		addItemPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addItemPriceLabel.setBounds(8, 51, 56, 29);
		addItemRadioPanel.add(addItemPriceLabel);
		
		addMinPriceTextField = new JTextField();
		addMinPriceTextField.setColumns(10);
		addMinPriceTextField.setBounds(63, 44, 100, 35);
		addItemRadioPanel.add(addMinPriceTextField);
		
		JLabel addToLabel = new JLabel("to");
		addToLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addToLabel.setBounds(180, 51, 45, 29);
		addItemRadioPanel.add(addToLabel);
		
		addMaxPriceTextField = new JTextField();
		addMaxPriceTextField.setColumns(10);
		addMaxPriceTextField.setBounds(208, 44, 100, 35);
		addItemRadioPanel.add(addMaxPriceTextField);

		JLabel addParStockLabel = new JLabel("Par stock:");
		addParStockLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addParStockLabel.setBounds(328, 51, 87, 29);
		addItemRadioPanel.add(addParStockLabel);
		
		addParStockTextField = new JTextField();
		addParStockTextField.setColumns(10);
		addParStockTextField.setBounds(400, 44, 115, 35);
		addItemRadioPanel.add(addParStockTextField);
		addItemRadioPanel.setBounds(239, 0, 533, 178);
		addItemRadioPanel.setVisible(true);
		informationPanel.add(addItemRadioPanel);
		
		//sets edit item Panel
		JPanel editItemRadioPanel = new JPanel();
		editItemRadioPanel.setLayout(null);
				
		JLabel itemNameLabel = new JLabel("Item name:");
		itemNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemNameLabel.setBounds(10, 12, 114, 29);
		editItemRadioPanel.add(itemNameLabel);
				
		editItemNameTextField = new JTextField();
		editItemNameTextField.setBounds(103, 5, 179, 35);
		editItemRadioPanel.add(editItemNameTextField);
		editItemNameTextField.setColumns(10);
				
		JLabel supplierNameLabel = new JLabel("Supplier name:");
		supplierNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierNameLabel.setBounds(10, 92, 114, 29);
		editItemRadioPanel.add(supplierNameLabel);
				
		editSupplierNameTextField = new JTextField();
		editSupplierNameTextField.setColumns(10);
		editSupplierNameTextField.setBounds(124, 85, 231, 35);
		editItemRadioPanel.add(editSupplierNameTextField);
				
		editItemIDTextField = new JTextField();
		editItemIDTextField.setColumns(10);
		editItemIDTextField.setBounds(376, 5, 146, 35);
		editItemRadioPanel.add(editItemIDTextField);
				
		JLabel itemIDLabel = new JLabel("Item ID:");
		itemIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemIDLabel.setBounds(313, 12, 89, 29);
		editItemRadioPanel.add(itemIDLabel);
				
		JLabel itemDescriptionLabel = new JLabel("Item description:");
		itemDescriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemDescriptionLabel.setBounds(10, 137, 134, 29);
		editItemRadioPanel.add(itemDescriptionLabel);
				
		editItemDescription = new JTextField();
		editItemDescription.setColumns(10);
		editItemDescription.setBounds(134, 130, 388, 35);
		editItemRadioPanel.add(editItemDescription);
				
		JLabel itemPriceLabel = new JLabel("Price:");
		itemPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemPriceLabel.setBounds(8, 51, 56, 29);
		editItemRadioPanel.add(itemPriceLabel);
				
		editMinPriceTextField = new JTextField();
		editMinPriceTextField.setColumns(10);
		editMinPriceTextField.setBounds(63, 44, 100, 35);
		editItemRadioPanel.add(editMinPriceTextField);
				
		JLabel toLabel = new JLabel("to");
		toLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toLabel.setBounds(180, 51, 45, 29);
		editItemRadioPanel.add(toLabel);
				
		editMaxPriceTextField = new JTextField();
		editMaxPriceTextField.setColumns(10);
		editMaxPriceTextField.setBounds(208, 44, 100, 35);
		editItemRadioPanel.add(editMaxPriceTextField);

		JLabel editParStockLabel = new JLabel("Par stock:");
		editParStockLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editParStockLabel.setBounds(328, 51, 87, 29);
		editItemRadioPanel.add(editParStockLabel);
				
		editParStockTextField = new JTextField();
		editParStockTextField.setColumns(10);
		editParStockTextField.setBounds(400, 44, 115, 35);
		editItemRadioPanel.add(editParStockTextField);
		editItemRadioPanel.setBounds(239, 0, 533, 178);
		informationPanel.add(editItemRadioPanel);
		editItemRadioPanel.setVisible(false);
		
		//sets delete item Panel
		JPanel deleteItem = deleteItemRadioPanel();
		deleteItem.setBounds(239, 0, 533, 178);
		deleteItem.setVisible(false);
		informationPanel.add(deleteItem);
		
		//utilizes radio button to display type of item Panel
		addItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addItemRadioPanel.setVisible(true);
				deleteItem.setVisible(false);
				editItemRadioPanel.setVisible(false);
				changeInventoryButton.setVisible(true);
			}
		});
		editItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editItemRadioPanel.setVisible(true);
				addItemRadioPanel.setVisible(false);
				deleteItem.setVisible(false);
				changeInventoryButton.setVisible(true);
			}
		});
		deleteItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteItem.setVisible(true);
				addItemRadioPanel.setVisible(false);
				editItemRadioPanel.setVisible(false);
				changeInventoryButton.setVisible(false);
			}
		});
		
		//////////////////////////////////////////////////
		//Adds ActionListener for Change Inventory Button
		//////////////////////////////////////////////////
		changeInventoryButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(addItemButton.isSelected()){
					addToInventory();
				}
				else if(editItemButton.isSelected()){
					editInventory();
				}
				else if(deleteItemButton.isSelected()){
					deleteFromInventory();
				}
				updateInventoryDisplay(textArea);
			}
		});
		
			
	} 
	
	

	
	
	private JPanel deleteItemRadioPanel()
	{
		JPanel deleteItemRadioPanel = new JPanel();
		deleteItemRadioPanel.setLayout(null);
		
		JLabel itemNameLabel = new JLabel("Item name:");
		itemNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemNameLabel.setBounds(85, 12, 114, 29);
		deleteItemRadioPanel.add(itemNameLabel);
		
		deleteItemNameTextField = new JTextField();
		deleteItemNameTextField.setBounds(173, 5, 179, 35);
		deleteItemRadioPanel.add(deleteItemNameTextField);
		deleteItemNameTextField.setColumns(10);
		
		deleteItemIDTextField = new JTextField();
		deleteItemIDTextField.setColumns(10);
		deleteItemIDTextField.setBounds(189, 85, 146, 35);
		deleteItemRadioPanel.add(deleteItemIDTextField);
		
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
	
	private void addToInventory(){
		String n = addItemNameTextField.getText();
		String i = addItemIDTextField.getText();
		String price = addMinPriceTextField.getText();
		double p = 0;
		if(!price.equals("")){
			p = Double.parseDouble(price);
		}
		String s = addSupplierNameTextField.getText();
		String d = addItemDescription.getText();
		////////Temp Code/////////
		//
			int par = 3;
		//	
		//////////////////////////	
			
		if(n.equals("") || i.equals("") || price.equals("") || s.equals("") ){
			// Return Warning (required fields empty)
		}
		else{
			if(d.equals("")){
				inventory.addItem(n, i, p, s, par);
			}
			else{
				inventory.addItem(n, i, p, s, par, d);
			}
			
		}
	}
	
	private void editInventory(){
		String n = editItemNameTextField.getText();
		String i = editItemIDTextField.getText();
		String price = editMinPriceTextField.getText();
		double p = 0;
		if(!price.equals("")){
			p = Double.parseDouble(price);
		}
		String s = editSupplierNameTextField.getText();
		String d = editItemDescription.getText();
		////////Temp Code/////////
		//
			int par = 3;
		//	
		//////////////////////////	
			
		if(n.equals("")){
			// Return Warning (required fields empty)
		}
		else{
			int index = inventory.findItemByName(n);
			if(index >= 0){
				if(!d.equals("")){
					inventory.get(index).setDescription(d);
				}
				if(!price.equals("")){
					inventory.get(index).setPrice(p);
				}
				if(!s.equals("")){
					inventory.get(index).setSupplier(s);
				}
			}
		}
	}
	
	private void deleteFromInventory(){
		
	}
	
	private void updateInventoryDisplay(JTextArea text){
		if(inventory.size() > 0){
			text.setText(inventory.toString());
		}
	}
} 
