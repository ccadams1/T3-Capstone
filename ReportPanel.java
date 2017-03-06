import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class ReportPanel extends JPanel{
	JCheckBox inventoryCheckBox;
	JCheckBox salesCheckBox;
	JCheckBox businessCheckBox;
	JCheckBox businessCheck1;
	JCheckBox businessCheck2;
	JCheckBox businessCheck3;
	JCheckBox businessCheck4;
	JCheckBox businessCheck5;
	JCheckBox businessCheck6;
	JCheckBox businessCheck7;
	JCheckBox businessCheck8;
	JCheckBox businessCheck9;
	JCheckBox businessCheck10;
	JCheckBox businessCheck11;
	JCheckBox businessCheck12;
	
	JCheckBox InventoryCheck1;
	JCheckBox InventoryCheck2;
	JCheckBox InventoryCheck3;
	JCheckBox InventoryCheck4;
	JCheckBox InventoryCheck5;
	JCheckBox InventoryCheck6;
	
	JCheckBox salesCheck1;
	JCheckBox salesCheck2;
	JCheckBox salesCheck3;
	JCheckBox salesCheck4;
	JCheckBox salesCheck5;
	JCheckBox salesCheck6;
	
	private JPanel reportInfoPanel()
	{
		JPanel reportInfoPanel = new JPanel();
		reportInfoPanel.setLayout(null);
		
		//checkbox to include inventory information
		inventoryCheckBox = new JCheckBox("Inventory");
		inventoryCheckBox.setBounds(229, 10, 152, 37);
		inventoryCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 21));
		reportInfoPanel.add(inventoryCheckBox);
		
		//checkbox to include sales information
		salesCheckBox = new JCheckBox("Sales");
		salesCheckBox.setBounds(435, 10, 152, 37);
		salesCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 21));
		reportInfoPanel.add(salesCheckBox);
		
		//checkbox to include business information
		businessCheckBox = new JCheckBox("Business");
		businessCheckBox.setBounds(18, 10, 197, 37);
		businessCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 21));
		reportInfoPanel.add(businessCheckBox);
		
		//scroll pane for business info checkboxes
		JScrollPane businessBoxScrollPane = new JScrollPane();
		businessBoxScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		businessBoxScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		businessBoxScrollPane.setBounds(0, 56, 193, 110);
		reportInfoPanel.add(businessBoxScrollPane);
		
		//contains business checkboxes. To increase the number of checkboxes, increase the first number
		//of the gridlayout below and add checkbox to the business panel
		JPanel businessPanel = new JPanel();
		businessBoxScrollPane.setViewportView(businessPanel);
		businessPanel.setLayout(new GridLayout(15, 1, 0, 0));
		
		//checkbox for business panel
		businessCheck1 = new JCheckBox("Business Name");
		businessCheck1.setActionCommand("");
		businessCheck1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck1);
		
		//checkbox for business panel
		businessCheck2 = new JCheckBox("Street Address");
		businessCheck2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck2);
		
		//checkbox for business panel
		businessCheck3 = new JCheckBox("Street Address Line 2");
		businessCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck3);
		
		//checkbox for business panel
		businessCheck4 = new JCheckBox("City, State, Zip Code");
		businessCheck4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck4);
				
		//checkbox for business panel
		businessCheck5 = new JCheckBox("Logo");
		businessCheck5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck5);
	
		//checkbox for business panel
		businessCheck6 = new JCheckBox("Logo 2");
		businessCheck6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck6);
		
		
		//checkbox for business panel
		businessCheck7 = new JCheckBox("Phone Number");
		businessCheck7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck7);
				
		//checkbox for business panel
		businessCheck8 = new JCheckBox("Phone Number 2");
		businessCheck8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck8);
		
		//checkbox for business panel
		businessCheck9 = new JCheckBox("Website");
		businessCheck9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck9);
				
		//checkbox for business panel
		businessCheck10 = new JCheckBox("E-mail");
		businessCheck10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck10);
				
		//checkbox for business panel
		businessCheck11 = new JCheckBox("Fax Number");
		businessCheck11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck11);
		
		//checkbox for business panel
		businessCheck12 = new JCheckBox("Owner First/Last Name");
		businessCheck12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck12);
		
		
		//scroll pane for inventory checkboxes
		JScrollPane inventoryBoxScrollPane = new JScrollPane();
		inventoryBoxScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		inventoryBoxScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		inventoryBoxScrollPane.setBounds(201, 54, 197, 110);
		reportInfoPanel.add(inventoryBoxScrollPane);
				
		//contains inventory checkboxes. To increase the number of checkboxes, increase the first number
		//of the gridlayout below and add checkbox to the inventory panel
		JPanel inventoryPanel = new JPanel();
		inventoryBoxScrollPane.setViewportView(inventoryPanel);
		inventoryPanel.setLayout(new GridLayout(15, 1, 0, 0));
			
		//checkbox for inventory panel
		InventoryCheck1 = new JCheckBox("Item Name");
		InventoryCheck1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		InventoryCheck1.setActionCommand("");
		inventoryPanel.add(InventoryCheck1);
				
		//checkbox for inventory panel
		InventoryCheck2 = new JCheckBox("Item ID");
		InventoryCheck2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(InventoryCheck2);
						
		//checkbox for inventory panel
		InventoryCheck3 = new JCheckBox("Item Price");
		InventoryCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(InventoryCheck3);
			
		//checkbox for inventory panel
		InventoryCheck4 = new JCheckBox("Item Description");
		InventoryCheck4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(InventoryCheck4);
				
		//checkbox for inventory panel
		InventoryCheck5 = new JCheckBox("Supplier Name");
		InventoryCheck5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(InventoryCheck5);
		
		//checkbox for inventory panel
		InventoryCheck6 = new JCheckBox("Par Stock");
		InventoryCheck6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(InventoryCheck6);
				
		//scroll pane for sales checkboxes
		JScrollPane salesBoxScrollPane = new JScrollPane();
		salesBoxScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		salesBoxScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		salesBoxScrollPane.setBounds(404, 54, 193, 110);
		reportInfoPanel.add(salesBoxScrollPane);
				
		//contains sales checkboxes. To increase the number of checkboxes, increase the first number
		//of the gridlayout below and add checkbox to the sales panel
		JPanel salesPanel = new JPanel();
		salesBoxScrollPane.setViewportView(salesPanel);
		salesPanel.setLayout(new GridLayout(15, 1, 0, 0));
			
		//checkbox for sales panel
		salesCheck1 = new JCheckBox("Insert Sales info");
		salesCheck1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesCheck1.setActionCommand("");
		salesPanel.add(salesCheck1);
				
		//checkbox for sales panel
		salesCheck2 = new JCheckBox("more info");
		salesCheck2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesPanel.add(salesCheck2);
				
		//checkbox for sales panel
		salesCheck3 = new JCheckBox("and more");
		salesCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesPanel.add(salesCheck3);

		//checkbox for sales panel
		salesCheck4 = new JCheckBox("and more");
		salesCheck4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesPanel.add(salesCheck4);
		
		//checkbox for sales panel
		salesCheck5 = new JCheckBox("and more");
		salesCheck5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesPanel.add(salesCheck5);
		
		//checkbox for sales panel
		salesCheck6 = new JCheckBox("and more");
		salesCheck6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesPanel.add(salesCheck6);
		return reportInfoPanel;
	}
	
	public ReportPanel()
	{
		MyBusiness businessObj = new MyBusiness();
		Item inventoryObj = new Item();
		//bounds should be set to (0, 0, 772, 476)
		this.setBounds(0, 0, 772, 476);
		this.setLayout(null);
		
		//sets up a panel for information placement
		Panel informationPanel = new Panel();
		informationPanel.setBounds(0, 0, 772, 178);
		this.add(informationPanel);		
		informationPanel.setLayout(null);
		
		//creates a button group for radio buttons to operate
		ButtonGroup radioButtons = new ButtonGroup();

		//sets customer search Panel
		JPanel rep = reportInfoPanel();
		rep.setBounds(167, 0, 605, 178);
		informationPanel.add(rep);
		
		//panel for the buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 0, 168, 178);
		informationPanel.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		//creates a scrolling text area
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 174, 772, 302);
		this.add(scrollPane);
				
		//creates text area to put in the scrollPane
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));	
		
		//view report button
		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Dialog", Font.PLAIN, 21));
		btnView.setBounds(22, 24, 115, 37);
		buttonPanel.add(btnView);
		
		btnView.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		String textAreaString = "";
		//BUSINESS CONDITIONS ONLY
		if(businessCheckBox.isSelected() && !inventoryCheckBox.isSelected() && !salesCheckBox.isSelected())
		{
			businessCheck1.setSelected(true);
			businessCheck2.setSelected(true);
			businessCheck3.setSelected(true);
			businessCheck4.setSelected(true);
			businessCheck5.setSelected(true);
			businessCheck6.setSelected(true);
			businessCheck7.setSelected(true);
			businessCheck8.setSelected(true);
			businessCheck9.setSelected(true);
			businessCheck10.setSelected(true);
			businessCheck11.setSelected(true);
			businessCheck12.setSelected(true);
			InventoryCheck1.setSelected(false);
			InventoryCheck2.setSelected(false);
			InventoryCheck3.setSelected(false);
			InventoryCheck4.setSelected(false);
			InventoryCheck5.setSelected(false);
			InventoryCheck6.setSelected(false);
			salesCheck1.setSelected(false);
			salesCheck2.setSelected(false);
			salesCheck3.setSelected(false);
			salesCheck4.setSelected(false);
			salesCheck5.setSelected(false);
			salesCheck6.setSelected(false);
			
			//inventoryCheckBox.setEnabled(false);
			//salesCheckBox.setEnabled(false);
			
			if(businessCheck1.isSelected()) {
				textAreaString += "\t \t \tLong Business Name \n";
			}
			if(businessCheck2.isSelected()) {
				textAreaString += "Street Address \n";
				textAreaString += businessObj.getStAdress1();
			}
			if(businessCheck3.isSelected()) {
				textAreaString += "Street Address Line 2 \n";
				textAreaString += businessObj.getStAdress2();
			}
			if(businessCheck4.isSelected()) {
				textAreaString += "City, State, Zip Code \n \n";
				textAreaString += businessObj.getCity()+" , "+businessObj.getState()+" , "+businessObj.getZipCode() + "\n";	    
			}
			if(businessCheck5.isSelected()) {
				textAreaString += "Logo \n";
				textAreaString += businessObj.getLogo1();
			}
			if(businessCheck6.isSelected()) {
				textAreaString += "Logo 2 \n";
				textAreaString += businessObj.getLogo2();
			}
			if(businessCheck7.isSelected()) {
				textAreaString += "Phone Number \n";
				textAreaString += businessObj.getPhone1();
			}
			if(businessCheck8.isSelected()) {
				textAreaString += "Phone Number 2 \n";
				textAreaString += businessObj.getPhone2();
			}
			if(businessCheck9.isSelected()) {
				textAreaString += "Website \n";
				textAreaString += businessObj.getWebsite();
			}
			if(businessCheck10.isSelected()) {
				textAreaString += "E-mail \n";
				textAreaString += businessObj.getEmail();
			}
			if(businessCheck11.isSelected()) {
				textAreaString += "Fax Number \n";
				textAreaString += businessObj.getFax();
			}
			if(businessCheck12.isSelected()) {
				textAreaString += "Owner First/Last Name \n \n";
				textAreaString += businessObj.getOwnerFirstName() + " " + businessObj.getOwnerLastName();
			}
			textArea.setText(textAreaString);
		}
		
		//INVENTORY CONDITIONS
		else if(inventoryCheckBox.isSelected() && !businessCheckBox.isSelected() && !salesCheckBox.isSelected())
		{
			businessCheck1.setSelected(false);
			businessCheck2.setSelected(false);
			businessCheck3.setSelected(false);
			businessCheck4.setSelected(false);
			businessCheck5.setSelected(false);
			businessCheck6.setSelected(false);
			businessCheck7.setSelected(false);
			businessCheck8.setSelected(false);
			businessCheck9.setSelected(false);
			businessCheck10.setSelected(false);
			businessCheck11.setSelected(false);
			businessCheck12.setSelected(false);

			InventoryCheck1.setSelected(true);
			InventoryCheck2.setSelected(true);
			InventoryCheck3.setSelected(true);
			InventoryCheck4.setSelected(true);
			InventoryCheck5.setSelected(true);
			InventoryCheck6.setSelected(true);
			
			salesCheck1.setSelected(false);
			salesCheck2.setSelected(false);
			salesCheck3.setSelected(false);
			salesCheck4.setSelected(false);
			salesCheck5.setSelected(false);
			salesCheck6.setSelected(false);
			
			textAreaString += "Inventory Report \n";
			textAreaString += "-------------------------------------------------------------------------------- \n";
			
			if (InventoryCheck1.isSelected()) {
				textAreaString += "Item Name: \t";
				textAreaString += inventoryObj.getName();
			}
			if (InventoryCheck2.isSelected()) {
				textAreaString += "Item ID: \t";
				textAreaString += inventoryObj.getId();
			}
			if (InventoryCheck3.isSelected()) {
				textAreaString += "Price: \t";
				textAreaString += inventoryObj.getPrice();
			}
			if (InventoryCheck5.isSelected()) {
				textAreaString += "Supplier Name: \t";
				textAreaString += inventoryObj.getSupplier();
			}
			if (InventoryCheck6.isSelected()) {
				textAreaString += "Par Stock: \n";
				textAreaString += inventoryObj.getParStock();
			}
			if (InventoryCheck4.isSelected()) {
				textAreaString += "Item Description: \n";
				textAreaString += inventoryObj.getDescription();
			}
			
		    textArea.setText(textAreaString);
		    //businessCheckBox.setEnabled(false);
		    //salesCheckBox.setEnabled(false);
		}
		
		//SALES CONDITIONS ONLY
		else if(salesCheckBox.isSelected() && !inventoryCheckBox.isSelected() && !businessCheckBox.isSelected())
		{
			businessCheck1.setSelected(false);
			businessCheck2.setSelected(false);
			businessCheck3.setSelected(false);
			businessCheck4.setSelected(false);
			businessCheck5.setSelected(false);
			businessCheck6.setSelected(false);
			businessCheck7.setSelected(false);
			businessCheck8.setSelected(false);
			businessCheck9.setSelected(false);
			businessCheck10.setSelected(false);
			businessCheck11.setSelected(false);
			businessCheck12.setSelected(false);
			InventoryCheck1.setSelected(false);
			InventoryCheck2.setSelected(false);
			InventoryCheck3.setSelected(false);
			InventoryCheck4.setSelected(false);
			InventoryCheck5.setSelected(false);
			InventoryCheck6.setSelected(false);
			salesCheck1.setSelected(true);
			salesCheck2.setSelected(true);
			salesCheck3.setSelected(true);
			salesCheck4.setSelected(true);
			salesCheck5.setSelected(true);
			salesCheck6.setSelected(true);
			textAreaString += "Sales Report\n";
			textAreaString += "-------------------------------------------------------------------------------- \n \n";
			
			textAreaString += "Sales: ";
			textArea.setText(textAreaString);
			
		}
		//BUSINESS AND INVENTORY CONDITIONS
		else if(businessCheckBox.isSelected() && inventoryCheckBox.isSelected() && !salesCheckBox.isSelected())
		{
			businessCheck1.setSelected(true);
			businessCheck2.setSelected(true);
			businessCheck3.setSelected(true);
			businessCheck4.setSelected(true);
			businessCheck5.setSelected(true);
			businessCheck6.setSelected(true);
			businessCheck7.setSelected(true);
			businessCheck8.setSelected(true);
			businessCheck9.setSelected(true);
			businessCheck10.setSelected(true);
			businessCheck11.setSelected(true);
			businessCheck12.setSelected(true);
			InventoryCheck1.setSelected(true);
			InventoryCheck2.setSelected(true);
			InventoryCheck3.setSelected(true);
			InventoryCheck4.setSelected(true);
			InventoryCheck5.setSelected(true);
			InventoryCheck6.setSelected(true);
			salesCheck1.setSelected(false);
			salesCheck2.setSelected(false);
			salesCheck3.setSelected(false);
			salesCheck4.setSelected(false);
			salesCheck5.setSelected(false);
			salesCheck6.setSelected(false);

				textAreaString += "\t \t \tLong Business Name \n";
				textAreaString += "Street Address \n";
				textAreaString += businessObj.getStAdress1();
				textAreaString += "Street Address Line 2 \n";
				textAreaString += businessObj.getStAdress2();
				textAreaString += "City, State, Zip Code \n \n";
				textAreaString += businessObj.getCity()+" , "+businessObj.getState()+" , "+businessObj.getZipCode() + "\n";	    
				textAreaString += "Logo \n";
				textAreaString += businessObj.getLogo1();
				textAreaString += "Logo 2 \n";
				textAreaString += businessObj.getLogo2();
				textAreaString += "Phone Number \n";
				textAreaString += businessObj.getPhone1();
				textAreaString += "Phone Number 2 \n";
				textAreaString += businessObj.getPhone2();
				textAreaString += "Website \n";
				textAreaString += businessObj.getWebsite();
				textAreaString += "E-mail \n";
				textAreaString += businessObj.getEmail();
				textAreaString += "Fax Number \n";
				textAreaString += businessObj.getFax();
				textAreaString += "Owner First/Last Name \n \n";
				textAreaString += businessObj.getOwnerFirstName() + " " + businessObj.getOwnerLastName();
			
				textAreaString += "Inventory Report\n";
				textAreaString += "-------------------------------------------------------------------------------- \n";
				
				
				if (InventoryCheck1.isSelected()) {
					textAreaString += "Item Name: \t";
					textAreaString += inventoryObj.getName();
				}
				if (InventoryCheck2.isSelected()) {
					textAreaString += "Item ID: \t";
					textAreaString += inventoryObj.getId();
				}
				if (InventoryCheck3.isSelected()) {
					textAreaString += "Price: \t";
					textAreaString += inventoryObj.getPrice();
				}
				if (InventoryCheck5.isSelected()) {
					textAreaString += "Supplier Name: \t";
					textAreaString += inventoryObj.getSupplier();
				}
				if (InventoryCheck6.isSelected()) {
					textAreaString += "Par Stock: \n";
					textAreaString += inventoryObj.getParStock();
				}
				if (InventoryCheck4.isSelected()) {
					textAreaString += "Item Description: \n";
					textAreaString += inventoryObj.getDescription();
				}

		    textArea.setText(textAreaString);
		}
		
		//SALES AND INVENTORY CONDITIONS
		else if(inventoryCheckBox.isSelected() && salesCheckBox.isSelected() && !businessCheckBox.isSelected())
		{
			businessCheck1.setSelected(false);
			businessCheck2.setSelected(false);
			businessCheck3.setSelected(false);
			businessCheck4.setSelected(false);
			businessCheck5.setSelected(false);
			businessCheck6.setSelected(false);
			businessCheck7.setSelected(false);
			businessCheck8.setSelected(false);
			businessCheck9.setSelected(false);
			businessCheck10.setSelected(false);
			businessCheck11.setSelected(false);
			businessCheck12.setSelected(false);
			InventoryCheck1.setSelected(true);
			InventoryCheck2.setSelected(true);
			InventoryCheck3.setSelected(true);
			InventoryCheck4.setSelected(true);
			InventoryCheck5.setSelected(true);
			InventoryCheck6.setSelected(true);
			salesCheck1.setSelected(true);
			salesCheck2.setSelected(true);
			salesCheck3.setSelected(true);
			salesCheck4.setSelected(true);
			salesCheck5.setSelected(true);
			salesCheck6.setSelected(true);

			textAreaString += "\t \t \tInventory Report\n";
			textAreaString += "-------------------------------------------------------------------------------- \n";
			
						
				if (InventoryCheck1.isSelected()) {
					textAreaString += "Item Name: \t";
					textAreaString += inventoryObj.getName();
				}
				if (InventoryCheck2.isSelected()) {
					textAreaString += "Item ID: \t";
					textAreaString += inventoryObj.getId();
				}
				if (InventoryCheck3.isSelected()) {
					textAreaString += "Price: \t";
					textAreaString += inventoryObj.getPrice();
				}
				if (InventoryCheck5.isSelected()) {
					textAreaString += "Supplier Name: \t";
					textAreaString += inventoryObj.getSupplier();
				}
				if (InventoryCheck6.isSelected()) {
					textAreaString += "Par Stock: \n";
					textAreaString += inventoryObj.getParStock();
				}
				if (InventoryCheck4.isSelected()) {
					textAreaString += "Item Description: \n";
					textAreaString += inventoryObj.getDescription();
				}
					textAreaString += "\n \nSales Report\n";
					textAreaString += "-------------------------------------------------------------------------------- \n";
					
					textAreaString += "Sales: ";

				    textArea.setText(textAreaString);
				}
		
		//SALES AND BUSINESS CONDITIONS
		else if(salesCheckBox.isSelected() && businessCheckBox.isSelected() && !inventoryCheckBox.isSelected())
		{
			businessCheck1.setSelected(true);
			businessCheck2.setSelected(true);
			businessCheck3.setSelected(true);
			businessCheck4.setSelected(true);
			businessCheck5.setSelected(true);
			businessCheck6.setSelected(true);
			businessCheck7.setSelected(true);
			businessCheck8.setSelected(true);
			businessCheck9.setSelected(true);
			businessCheck10.setSelected(true);
			businessCheck11.setSelected(true);
			businessCheck12.setSelected(true);
			InventoryCheck1.setSelected(false);
			InventoryCheck2.setSelected(false);
			InventoryCheck3.setSelected(false);
			InventoryCheck4.setSelected(false);
			InventoryCheck5.setSelected(false);
			InventoryCheck6.setSelected(false);
			salesCheck1.setSelected(true);
			salesCheck2.setSelected(true);
			salesCheck3.setSelected(true);
			salesCheck4.setSelected(true);
			salesCheck5.setSelected(true);
			salesCheck6.setSelected(true);
					
			if(businessCheck1.isSelected()) {
				textAreaString += "\t \t \tLong Business Name \n";
			}
			if(businessCheck2.isSelected()) {
				textAreaString += "Street Address \n";
				textAreaString += businessObj.getStAdress1();
				}
			if(businessCheck3.isSelected()) {
				textAreaString += "Street Address Line 2 \n";
				textAreaString += businessObj.getStAdress2();
				}
			if(businessCheck4.isSelected()) {
				textAreaString += "City, State, Zip Code \n \n";
				textAreaString += businessObj.getCity()+" , "+businessObj.getState()+" , "+businessObj.getZipCode() + "\n";	    
				}
			if(businessCheck5.isSelected()) {
				textAreaString += "Logo \n";
				textAreaString += businessObj.getLogo1();
				}
			if(businessCheck6.isSelected()) {
				textAreaString += "Logo 2 \n";
				textAreaString += businessObj.getLogo2();
				}
			if(businessCheck7.isSelected()) {
				textAreaString += "Phone Number \n";
				textAreaString += businessObj.getPhone1();
				}
			if(businessCheck8.isSelected()) {
				textAreaString += "Phone Number 2 \n";
				textAreaString += businessObj.getPhone2();
				}
			if(businessCheck9.isSelected()) {
				textAreaString += "Website \n";
				textAreaString += businessObj.getWebsite();
				}
			if(businessCheck10.isSelected()) {
				textAreaString += "E-mail \n";
				textAreaString += businessObj.getEmail();
				}
			if(businessCheck11.isSelected()) {
				textAreaString += "Fax Number \n";
				textAreaString += businessObj.getFax();
				}
			if(businessCheck12.isSelected()) {
				textAreaString += "Owner First/Last Name \n \n";
				textAreaString += businessObj.getOwnerFirstName() + " " + businessObj.getOwnerLastName();
				}
				
			textAreaString += "\n \nSales Report\n";
			textAreaString += "-------------------------------------------------------------------------------- \n";
			
			textAreaString += "Sales: ";
					
		    textArea.setText(textAreaString);
				}
		
		//SALES BUSINESS AND INVENTORY CONDITIONS
		else if(salesCheckBox.isSelected() && businessCheckBox.isSelected() && inventoryCheckBox.isSelected())
		{
			businessCheck1.setSelected(true);
			businessCheck2.setSelected(true);
			businessCheck3.setSelected(true);
			businessCheck4.setSelected(true);
			businessCheck5.setSelected(true);
			businessCheck6.setSelected(true);
			businessCheck7.setSelected(true);
			businessCheck8.setSelected(true);
			businessCheck9.setSelected(true);
			businessCheck10.setSelected(true);
			businessCheck11.setSelected(true);
			businessCheck12.setSelected(true);
			
			InventoryCheck1.setSelected(true);
			InventoryCheck2.setSelected(true);
			InventoryCheck3.setSelected(true);
			InventoryCheck4.setSelected(true);
			InventoryCheck5.setSelected(true);
			InventoryCheck6.setSelected(true);
			salesCheck1.setSelected(true);
			salesCheck2.setSelected(true);
			salesCheck3.setSelected(true);
			salesCheck4.setSelected(true);
			salesCheck5.setSelected(true);
			salesCheck6.setSelected(true);
			
			if(businessCheck1.isSelected()) {
				textAreaString += "\t \t \tLong Business Name \n";
			}
			if(businessCheck2.isSelected()) {
				textAreaString += "Street Address \n";
				textAreaString += businessObj.getStAdress1();
			}
			if(businessCheck3.isSelected()) {
				textAreaString += "Street Address Line 2 \n";
				textAreaString += businessObj.getStAdress2();
			}
			if(businessCheck4.isSelected()) {
				textAreaString += "City, State, Zip Code \n \n";
				textAreaString += businessObj.getCity()+" , "+businessObj.getState()+" , "+businessObj.getZipCode() + "\n";	    
			}
			if(businessCheck5.isSelected()) {
				textAreaString += "Logo \n";
				textAreaString += businessObj.getLogo1();
			}
			if(businessCheck6.isSelected()) {
				textAreaString += "Logo 2 \n";
				textAreaString += businessObj.getLogo2();
			}
			if(businessCheck7.isSelected()) {
				textAreaString += "Phone Number \n";
				textAreaString += businessObj.getPhone1();
			}
			if(businessCheck8.isSelected()) {
				textAreaString += "Phone Number 2 \n";
				textAreaString += businessObj.getPhone2();
			}
			if(businessCheck9.isSelected()) {
				textAreaString += "Website \n";
				textAreaString += businessObj.getWebsite();
			}
			if(businessCheck10.isSelected()) {
				textAreaString += "E-mail \n";
				textAreaString += businessObj.getEmail();
			}
			if(businessCheck11.isSelected()) {
				textAreaString += "Fax Number \n";
				textAreaString += businessObj.getFax();
			}
			if(businessCheck12.isSelected()) {
				textAreaString += "Owner First/Last Name \n \n";
				textAreaString += businessObj.getOwnerFirstName() + " " + businessObj.getOwnerLastName();
			}
			textAreaString += "Inventory Report\n";
			textAreaString += "-------------------------------------------------------------------------------- \n";
			
			if (InventoryCheck1.isSelected()) {
				textAreaString += "Item Name: \t";
				textAreaString += inventoryObj.getName();
			}
			if (InventoryCheck2.isSelected()) {
				textAreaString += "Item ID: \t";
				textAreaString += inventoryObj.getId();
			}
			if (InventoryCheck3.isSelected()) {
				textAreaString += "Price: \t";
				textAreaString += inventoryObj.getPrice();
			}
			if (InventoryCheck5.isSelected()) {
				textAreaString += "Supplier Name: \t";
				textAreaString += inventoryObj.getSupplier();
			}
			if (InventoryCheck6.isSelected()) {
				textAreaString += "Par Stock: \n";
				textAreaString += inventoryObj.getParStock();
			}
			if (InventoryCheck4.isSelected()) {
				textAreaString += "Item Description: \n";
				textAreaString += inventoryObj.getDescription();
			}
			textAreaString += "\n \nSales Report\n";
			textAreaString += "-------------------------------------------------------------------------------- \n";
			
			textAreaString += "Sales: ";
			
		    textArea.setText(textAreaString);
		}
		}
		});
		
		//save report button
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Dialog", Font.PLAIN, 21));
		btnSave.setBounds(22, 77, 115, 37);
		buttonPanel.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
               
        JFileChooser chooser = new JFileChooser();
        int chooserValue = chooser.showSaveDialog(textArea);
        if (chooserValue == JFileChooser.APPROVE_OPTION) 
        {
            PrintWriter printWriter;
            try {
            	printWriter = new PrintWriter(chooser.getSelectedFile() + ".docx");
            	printWriter.printf(textArea.getText().trim());
            	printWriter.close();
				} 
            catch (FileNotFoundException e) 
            {
			// TODO Auto-generated catch block
				e.printStackTrace();      			
			}
            }
            }
        });
		
		//print report button
		JButton btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Dialog", Font.PLAIN, 21));
		btnPrint.setBounds(22, 127, 115, 37);
		buttonPanel.add(btnPrint);
		btnPrint.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent arg0) {
            PrinterJob pJob = PrinterJob.getPrinterJob();
            pJob.setPrintable(textArea.getPrintable(null, null));

                if (pJob.printDialog())
                {
                    try 
                    { 
                    	pJob.print(); 
                    }
                    catch (PrinterException pe) 
                    {
                        System.out.println(pe);
                    }
                }
            }
		
		});
	}
}
