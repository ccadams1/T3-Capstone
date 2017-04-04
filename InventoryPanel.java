import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class InventoryPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField editItemNameTextField, addItemNameTextField, deleteItemNameTextField;
	private JTextField addQuantityTextField, editItemIDTextField, deleteItemIDTextField;
	private JTextField addPriceTextField, editPriceTextField;
	private JTextField addMaxPriceTextField, editQuantityTextField;
	private JTextField addItemDescription, editItemDescription;
	private JTextField addParStockTextField, editParStockTextField;
	private JComboBox<String> addSupplierNameComboBox, editSupplierNameComboBox;
	private JCheckBox chckbxConfirmDelete;
	private Connection connect;
	private Inventory inventory;
	private SupplierList suppliers;
	
	public InventoryPanel(ArrayList<Object> data)
	{
		connect = (Connection) data.get(0);
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
		
		addSupplierNameComboBox = new JComboBox<String>();
		addSupplierNameComboBox.addItem("");
		for(int x = 0; x< suppliers.size(); x++)
		{
			addSupplierNameComboBox.addItem(suppliers.getSupplier(x).getName());
		}
		addSupplierNameComboBox.addItem("New Supplier");
		addSupplierNameComboBox.setBounds(124, 85, 231, 35);
		addItemRadioPanel.add(addSupplierNameComboBox);
		
		addQuantityTextField = new JTextField();
		addQuantityTextField.setColumns(10);
		addQuantityTextField.setBounds(376, 5, 146, 35);
		addItemRadioPanel.add(addQuantityTextField);
		
		JLabel addQuantityLabel = new JLabel("Quantity:");
		addQuantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addQuantityLabel.setBounds(310, 12, 89, 29);
		addItemRadioPanel.add(addQuantityLabel);
		
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
		
		addPriceTextField = new JTextField();
		addPriceTextField.setColumns(10);
		addPriceTextField.setBounds(63, 44, 100, 35);
		addItemRadioPanel.add(addPriceTextField);

		JLabel addParStockLabel = new JLabel("Par stock:");
		addParStockLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addParStockLabel.setBounds(310, 51, 87, 29);
		addItemRadioPanel.add(addParStockLabel);
		
		addParStockTextField = new JTextField();
		addParStockTextField.setColumns(10);
		addParStockTextField.setBounds(382, 44, 115, 35);
		
		addItemRadioPanel.add(addParStockTextField);
		addItemRadioPanel.setBounds(239, 0, 533, 178);
		addItemRadioPanel.setVisible(true);
		informationPanel.add(addItemRadioPanel);
		
		//sets edit item Panel
		JPanel editItemRadioPanel = new JPanel();
		editItemRadioPanel.setLayout(null);
				
		JLabel itemNameLabel = new JLabel("Item name:");
		itemNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemNameLabel.setBounds(240, 12, 114, 29);
		editItemRadioPanel.add(itemNameLabel);
				
		editItemNameTextField = new JTextField();
		editItemNameTextField.setBounds(333, 5, 179, 35);
		editItemRadioPanel.add(editItemNameTextField);
		editItemNameTextField.setColumns(10);
				
		JLabel supplierNameLabel = new JLabel("Supplier name:");
		supplierNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		supplierNameLabel.setBounds(10, 92, 114, 29);
		editItemRadioPanel.add(supplierNameLabel);
				
		editSupplierNameComboBox = new JComboBox<String>();
		editSupplierNameComboBox.addItem("");
		for(int x = 0; x< suppliers.size(); x++)
		{
			editSupplierNameComboBox.addItem(suppliers.getSupplier(x).getName());
		}
		editSupplierNameComboBox.addItem("New Supplier");
		editSupplierNameComboBox.setBounds(124, 85, 231, 35);
		editItemRadioPanel.add(editSupplierNameComboBox);
				
		editItemIDTextField = new JTextField();
		editItemIDTextField.setColumns(10);
		editItemIDTextField.setBounds(73, 5, 146, 35);
		editItemRadioPanel.add(editItemIDTextField);
				
		JLabel itemIDLabel = new JLabel("Item ID:");
		itemIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemIDLabel.setBounds(10, 12, 89, 29);
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
				
		editPriceTextField = new JTextField();
		editPriceTextField.setColumns(10);
		editPriceTextField.setBounds(63, 44, 100, 35);
		editItemRadioPanel.add(editPriceTextField);
				
		JLabel quantityLabel = new JLabel("Quantity:");
		quantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quantityLabel.setBounds(205, 51, 105, 29);
		editItemRadioPanel.add(quantityLabel);
				
		editQuantityTextField = new JTextField();
		editQuantityTextField.setColumns(10);
		editQuantityTextField.setBounds(283, 44, 50, 35);
		editItemRadioPanel.add(editQuantityTextField);

		JLabel editParStockLabel = new JLabel("Par stock:");
		editParStockLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editParStockLabel.setBounds(378, 51, 87, 29);
		editItemRadioPanel.add(editParStockLabel);
				
		editParStockTextField = new JTextField();
		editParStockTextField.setColumns(10);
		editParStockTextField.setBounds(450, 44, 50, 35);
		editItemRadioPanel.add(editParStockTextField);
		editItemRadioPanel.setBounds(239, 0, 533, 178);
		informationPanel.add(editItemRadioPanel);
		editItemRadioPanel.setVisible(false);
		
		//sets delete item Panel
		JPanel deleteItemRadioPanel = new JPanel();
		deleteItemRadioPanel.setLayout(null);
		
		JLabel deleteItemNameLabel = new JLabel("Item name:");
		deleteItemNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteItemNameLabel.setBounds(85, 12, 114, 29);
		deleteItemRadioPanel.add(deleteItemNameLabel);
		
		deleteItemNameTextField = new JTextField();
		deleteItemNameTextField.setBounds(173, 5, 179, 35);
		deleteItemRadioPanel.add(deleteItemNameTextField);
		deleteItemNameTextField.setColumns(10);
		
		deleteItemIDTextField = new JTextField();
		deleteItemIDTextField.setColumns(10);
		deleteItemIDTextField.setBounds(189, 85, 146, 35);
		deleteItemRadioPanel.add(deleteItemIDTextField);
		
		JLabel deleteItemIDLabel = new JLabel("Item ID:");
		deleteItemIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteItemIDLabel.setBounds(115, 92, 89, 29);
		deleteItemRadioPanel.add(deleteItemIDLabel);
		
		JLabel andLabel = new JLabel("AND");
		andLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		andLabel.setBounds(198, 52, 45, 29);
		deleteItemRadioPanel.add(andLabel);
		
		chckbxConfirmDelete = new JCheckBox("Confirm delete");
		chckbxConfirmDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxConfirmDelete.setBounds(125, 129, 199, 37);
		deleteItemRadioPanel.add(chckbxConfirmDelete);
		
		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeleteItem.setBounds(390, 134, 141, 32);
		
		deleteItemRadioPanel.add(btnDeleteItem);
		deleteItemRadioPanel.setBounds(239, 0, 533, 178);
		deleteItemRadioPanel.setVisible(false);
		informationPanel.add(deleteItemRadioPanel);
		
		//utilizes radio button to display type of item Panel
		addItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addItemRadioPanel.setVisible(true);
				deleteItemRadioPanel.setVisible(false);
				editItemRadioPanel.setVisible(false);
				changeInventoryButton.setVisible(true);
			}
		});
		editItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editItemRadioPanel.setVisible(true);
				addItemRadioPanel.setVisible(false);
				deleteItemRadioPanel.setVisible(false);
				changeInventoryButton.setVisible(true);
			}
		});
		deleteItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteItemRadioPanel.setVisible(true);
				addItemRadioPanel.setVisible(false);
				editItemRadioPanel.setVisible(false);
				changeInventoryButton.setVisible(false);
			}
		});
		
		//Adds ActionListener for Change Inventory Button
		changeInventoryButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(addItemButton.isSelected()){
					addToInventory();
				}
				else if(editItemButton.isSelected()){
					editInventory();
				}
				updateInventoryDisplay(textArea);
			}
		});
		
		
		//Adds ActionListener for Delete Item Button
		btnDeleteItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(deleteItemButton.isSelected()){
					deleteFromInventory();
				}
				updateInventoryDisplay(textArea);
			}
		});
	}
	
	private void addToInventory(){
		String n = addItemNameTextField.getText();
		String quantity = addQuantityTextField.getText();
		String supID = null;
		int q = 0;
		if(!quantity.equals("")){
			q = Integer.parseInt(quantity);
		}
		String price = addPriceTextField.getText();
		double p = 0;
		if(!price.equals("")){
			p = Double.parseDouble(price);
		}
		String s = (String) addSupplierNameComboBox.getSelectedItem();
		if(s.equals("New Supplier"))
		{
			//new addSupplierScreen(data);
		}
		
		String d = addItemDescription.getText();
		String parStock = addParStockTextField.getText();
		int par = 0;
		if(!parStock.equals("")){
			par = Integer.parseInt(parStock);
		}
			
		if(n.equals("") || price.equals("") || s.equals("") ){
			setWarningMsg("Item name, price, Supplier name are required.");
		}
		else{
			for(int x = 0; x < suppliers.size(); x++)
			{
				if(suppliers.getSupplier(x).getName().equals(addSupplierNameComboBox.getSelectedItem()))
				{
					supID = suppliers.getSupplier(x).getID();
				}
			}
			Item newItem = new Item(n, p, Integer.parseInt(supID), s, q, par, d);
			newItem.setId(callAddItemProcedure(connect, newItem)+"");
		}
	}
	
	private void editInventory(){
		String id = editItemIDTextField.getText();
		String n = editItemNameTextField.getText();
		String price = editPriceTextField.getText();
		String supID = null;
		double p = 0;
		if(!price.equals("")){
			p = Double.parseDouble(price);
		}
		String s = (String) editSupplierNameComboBox.getSelectedItem();
		if(s.equals("New Supplier"))
		{
			//new addSupplierScreen(data);
		}
		else
		{
			for(int x = 0; x < suppliers.size(); x++)
			{
				if(suppliers.getSupplier(x).getName().equals(editSupplierNameComboBox.getSelectedItem()))
				{
					supID = suppliers.getSupplier(x).getID();
				}
			}
		}
		String d = editItemDescription.getText();
		String parStock = editParStockTextField.getText();
		int par = 0;
		if(!parStock.equals("")){
			par = Integer.parseInt(parStock);
		}
		String quantity = editQuantityTextField.getText();
		int quant = 0;
		if(!quantity.equals("")){
			quant = Integer.parseInt(quantity);
		}			
		if(id.equals("")){
			setWarningMsg("ID field required");
		}
		else{
			int index = inventory.findItemByID(id);
			inventory.get(index);
			if(index >= 0)
			{
				if(!d.equals(""))
				{
					inventory.get(index).setDescription(d);
				}
				if(!price.equals(""))
				{
					inventory.get(index).setPrice(p);
				}
				if(!s.equals(""))
				{
					inventory.get(index).setSupplier(s);
					inventory.get(index).setSupplierID(Integer.parseInt(supID));
				}
				if(!quantity.equals(""))
				{
					inventory.get(index).setQuantity(quant);
				}
				if(!parStock.equals(""))
				{
					inventory.get(index).setParStock(par);
				}
				callAddItemProcedure(connect, inventory.get(index));
			}
		}
	}
	
	private void deleteFromInventory(){
		String n = deleteItemNameTextField.getText();
		String id = deleteItemIDTextField.getText();
		boolean check = chckbxConfirmDelete.isSelected();
		int index = inventory.findItemByName(n);
		if(index >= 0){
			if(inventory.get(index).getId().equals(id) && check == true){
				inventory.get(index).setRemoved(true);
				callRemoveItemProcedure(connect, inventory.get(index));
			}
			else
			{
				setWarningMsg("Confirm delete check box is not selected.");
			}
		}						
		else
		{
			setWarningMsg("Item name and Item ID do not match.");
		}
	}
	
	private void updateInventoryDisplay(JTextArea text){
		text.setText(inventory.toString());
	}
	
	protected int callAddItemProcedure(Connection connect, Item temp) {
		CallableStatement stmt = null;
		
		int id = (Integer) null;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspAddItem(?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, null);
			stmt.setString(2, temp.getName());
			stmt.setString(3, temp.getDescription());
			stmt.setInt(4, temp.getQuantity());
			stmt.setInt(5, temp.getParStock());
			stmt.setDouble(6, temp.getPrice());
			stmt.setInt(7, temp.getSupplierID());
			stmt.setInt(8, /*temp.isRemoved()*/0);
			stmt.registerOutParameter(9, Types.VARCHAR);
			stmt.registerOutParameter(10, Types.INTEGER);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add new item");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(9);
			id = stmt.getInt(10);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return id;
	}
	protected void callRemoveItemProcedure(Connection connect, Item temp){
		CallableStatement stmt = null;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditItem(?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, temp.getId());
			stmt.setString(2, null);
			stmt.setString(3, temp.getName());
			stmt.setString(4, temp.getDescription());
			stmt.setInt(5, temp.getQuantity());
			stmt.setInt(6, temp.getParStock());
			stmt.setDouble(7, temp.getPrice());
			stmt.setInt(8, temp.getSupplierID());
			stmt.setInt(9, /*temp.isRemoved()*/1);
			stmt.registerOutParameter(10, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add new user");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(10);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	
	public void setWarningMsg(String text){
	    Toolkit.getDefaultToolkit().beep();
	    JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Warning!");
	    dialog.setAlwaysOnTop(true);
	    dialog.setVisible(true);
	}
	
} 
