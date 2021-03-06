import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	//sets up variables
	private JCheckBox inventoryCheckBox;
	private JCheckBox salesCheckBox;
	private JCheckBox businessCheckBox;
	private JCheckBox businessCheck1;
	private JCheckBox businessCheck2;
	private JCheckBox businessCheck3;
	private JCheckBox businessCheck4;
	private JCheckBox businessCheck7;
	private JCheckBox businessCheck8;
	private JCheckBox businessCheck9;
	private JCheckBox businessCheck10;
	private JCheckBox businessCheck11;
	private JCheckBox businessCheck12;
	
	private JCheckBox itemNameCheck;
	private JCheckBox itemIDCheck;
	private JCheckBox itemPriceCheck;
	private JCheckBox itemDescriptionCheck;
	private JCheckBox itemSupplierNameCheck;
	private JCheckBox itemParCheck;
	private JCheckBox itemQuantityCheck;
	private JCheckBox itemActiveCheck;
	private JCheckBox itemInactiveCheck;
	
	private JCheckBox salesCheck1;
	
	private Connection connect = null;
	
	//constructor with necessary parameter
	public ReportPanel(ArrayList<Object> data)
	{
		//gets database information
		connect = (Connection) data.get(0);
		MyBusiness businessObj = (MyBusiness) data.get(4);
		Inventory inventory = (Inventory) data.get(3);

		//bounds should be set to (0, 0, 772, 476)
		this.setBounds(0, 0, 772, 476);
		this.setLayout(null);
		
		//sets up a panel for information placement
		Panel informationPanel = new Panel();
		informationPanel.setBounds(0, 0, 772, 178);
		this.add(informationPanel);		
		informationPanel.setLayout(null);

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
		
		//enables business buttons if checked
		businessCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(businessCheckBox.isSelected())
				{
					businessCheck1.setEnabled(true);
					businessCheck2.setEnabled(true);
					businessCheck3.setEnabled(true);
					businessCheck4.setEnabled(true);
					businessCheck7.setEnabled(true);
					businessCheck8.setEnabled(true);
					businessCheck9.setEnabled(true);
					businessCheck10.setEnabled(true);
					businessCheck11.setEnabled(true);
					businessCheck12.setEnabled(true);
				}
				else if(!businessCheckBox.isSelected())
				{
					businessCheck1.setEnabled(false);
					businessCheck2.setEnabled(false);
					businessCheck3.setEnabled(false);
					businessCheck4.setEnabled(false);
					businessCheck7.setEnabled(false);
					businessCheck8.setEnabled(false);
					businessCheck9.setEnabled(false);
					businessCheck10.setEnabled(false);
					businessCheck11.setEnabled(false);
					businessCheck12.setEnabled(false);
				}
			}
		});
		
		//enables inventory buttons if checked
		inventoryCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(inventoryCheckBox.isSelected())
				{
					itemNameCheck.setEnabled(true);
					itemIDCheck.setEnabled(true);
					itemPriceCheck.setEnabled(true);
					itemDescriptionCheck.setEnabled(true);
					itemSupplierNameCheck.setEnabled(true);
					itemParCheck.setEnabled(true);
					itemQuantityCheck.setEnabled(true);
					itemActiveCheck.setEnabled(true);
					itemInactiveCheck.setEnabled(true);
				}
				else if(!inventoryCheckBox.isSelected())
				{
					itemNameCheck.setEnabled(false);
					itemIDCheck.setEnabled(false);
					itemPriceCheck.setEnabled(false);
					itemDescriptionCheck.setEnabled(false);
					itemSupplierNameCheck.setEnabled(false);
					itemParCheck.setEnabled(false);
					itemQuantityCheck.setEnabled(false);
					itemActiveCheck.setEnabled(false);
					itemInactiveCheck.setEnabled(false);
				}
			}
		});
		
		//enables sales buttons if checked
		salesCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(salesCheckBox.isSelected())
				{
					salesCheck1.setEnabled(true);
				}
				else if(!salesCheckBox.isSelected())
				{
					salesCheck1.setEnabled(false);
				}
			}
		});
		
		//displays checked information
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String textAreaString = "";
				//BUSINESS CONDITIONS ONLY
				if(businessCheckBox.isSelected())
				{
					if(businessCheck1.isSelected()) {
						textAreaString += "\t \t \t"+ businessObj.getBizName() +" \n";
					}
					if(businessCheck2.isSelected()) {
						textAreaString += businessObj.getStAdress1()+"\n";
					}
					if(businessCheck3.isSelected()) {
						textAreaString += businessObj.getStAdress2()+"\n";
					}
					if(businessCheck4.isSelected()) {
						textAreaString += businessObj.getCity()+" , "+businessObj.getState()+" , "+businessObj.getZipCode() + "\n\n";	    
					}
					if(businessCheck7.isSelected()) {
						textAreaString += "Phone Number: ";
						textAreaString += businessObj.getPhone1()+"\n";
					}
					if(businessCheck8.isSelected()) {
						textAreaString += "Phone Number 2: ";
						textAreaString += businessObj.getPhone2()+"\n";
					}
					if(businessCheck9.isSelected()) {
						textAreaString += "Website: ";
						textAreaString += businessObj.getWebsite()+"\n";
					}
					if(businessCheck10.isSelected()) {
						textAreaString += "E-mail: ";
						textAreaString += businessObj.getEmail()+"\n";
					}
					if(businessCheck11.isSelected()) {
						textAreaString += "Fax Number: ";
						textAreaString += businessObj.getFax()+"\n";
					}
					if(businessCheck12.isSelected()) {
						textAreaString += "Owner: ";
						textAreaString += businessObj.getOwnerFirstName() + " " + businessObj.getOwnerLastName()+"\n\n";
					}
					textArea.setText(textAreaString);
				}
				
				//INVENTORY CONDITIONS
				if(inventoryCheckBox.isSelected())
				{
					textAreaString += "\nInventory Report \n";
					textAreaString += "-------------------------------------------------------------------------------- \n";
					for(int x = 0; x < inventory.size(); x++)
					{
						if (itemActiveCheck.isSelected() && !itemInactiveCheck.isSelected() && !inventory.get(x).isRemoved())
						{
							if (itemNameCheck.isSelected()) {
								textAreaString += "Item Name: \t";
								textAreaString += inventory.get(x).getName() +"\t";
							}
							if (itemIDCheck.isSelected()) {
								textAreaString += "Item ID: \t";
								textAreaString += inventory.get(x).getId() +"\t";
							}
							if (itemPriceCheck.isSelected()) {
								textAreaString += "Price: \t";
								textAreaString += inventory.get(x).getPrice() +"\t";
							}
							if (itemSupplierNameCheck.isSelected()) {
								textAreaString += "Supplier Name: ";
								textAreaString += inventory.get(x).getSupplier() +"\t";
							}
							if (itemQuantityCheck.isSelected()) {
								textAreaString += "Quantity: \t";
								textAreaString += inventory.get(x).getQuantity() +"\t";
							}
							if (itemParCheck.isSelected()) {
								textAreaString += "Par Stock: \t";
								textAreaString += inventory.get(x).getParStock() +"\t";
							}
							if (itemDescriptionCheck.isSelected()) {
								textAreaString += "Item Description: \t";
								textAreaString += inventory.get(x).getDescription() +"\t";
							}
							if (itemActiveCheck.isSelected()){
								textAreaString += "Active Item: \t";
								if(!inventory.get(x).isRemoved())
								{
									textAreaString += "yes\t";
								}
							}
							textAreaString += "\n";
						}
						else if (!itemActiveCheck.isSelected() && itemInactiveCheck.isSelected() && inventory.get(x).isRemoved())
						{
							if (itemNameCheck.isSelected()) {
								textAreaString += "Item Name: \t";
								textAreaString += inventory.get(x).getName() +"\t";
							}
							if (itemIDCheck.isSelected()) {
								textAreaString += "Item ID: \t";
								textAreaString += inventory.get(x).getId() +"\t";
							}
							if (itemPriceCheck.isSelected()) {
								textAreaString += "Price: \t";
								textAreaString += inventory.get(x).getPrice() +"\t";
							}
							if (itemSupplierNameCheck.isSelected()) {
								textAreaString += "Supplier Name: ";
								textAreaString += inventory.get(x).getSupplier() +"\t";
							}
							if (itemQuantityCheck.isSelected()) {
								textAreaString += "Quantity: \t";
								textAreaString += inventory.get(x).getQuantity() +"\t";
							}
							if (itemParCheck.isSelected()) {
								textAreaString += "Par Stock: \t";
								textAreaString += inventory.get(x).getParStock() +"\t";
							}
							if (itemDescriptionCheck.isSelected()) {
								textAreaString += "Item Description: \t";
								textAreaString += inventory.get(x).getDescription() +"\t";
							}
							if (itemInactiveCheck.isSelected()){
								textAreaString += "Active Item: \t";
								if(inventory.get(x).isRemoved())
								{
									textAreaString += "no\t";
								}
							}
							textAreaString += "\n";
						}
						else if (itemActiveCheck.isSelected() && itemInactiveCheck.isSelected())
						{
							if (itemNameCheck.isSelected()) {
								textAreaString += "Item Name: \t";
								textAreaString += inventory.get(x).getName() +"\t";
							}
							if (itemIDCheck.isSelected()) {
								textAreaString += "Item ID: \t";
								textAreaString += inventory.get(x).getId() +"\t";
							}
							if (itemPriceCheck.isSelected()) {
								textAreaString += "Price: \t";
								textAreaString += inventory.get(x).getPrice() +"\t";
							}
							if (itemSupplierNameCheck.isSelected()) {
								textAreaString += "Supplier Name: ";
								textAreaString += inventory.get(x).getSupplier() +"\t";
							}
							if (itemQuantityCheck.isSelected()) {
								textAreaString += "Quantity: \t";
								textAreaString += inventory.get(x).getQuantity() +"\t";
							}
							if (itemParCheck.isSelected()) {
								textAreaString += "Par Stock: \t";
								textAreaString += inventory.get(x).getParStock() +"\t";
							}
							if (itemDescriptionCheck.isSelected()) {
								textAreaString += "Item Description: \t";
								textAreaString += inventory.get(x).getDescription() +"\t";
							}
							if (itemActiveCheck.isSelected()){
								textAreaString += "Active Item: \t";
								if(!inventory.get(x).isRemoved())
								{
									textAreaString += "yes\t";
								}
								else
								{
									textAreaString += "no\t";
								}
							}
							textAreaString += "\n";
						}
						else
						{
						}
					}
				    textArea.setText(textAreaString);
				}
				
				//SALES CONDITIONS ONLY
				if(salesCheckBox.isSelected())
				{
					textAreaString += "\nSales Report\n";
					textAreaString += "-------------------------------------------------------------------------------- \n ";
					if (salesCheck1.isSelected()) {
						textAreaString += "Today's Sales: \n";
						textAreaString += getSalesReport();
					}
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
	               
				//selects location
		        JFileChooser chooser = new JFileChooser();
		        int chooserValue = chooser.showSaveDialog(textArea);
		        if (chooserValue == JFileChooser.APPROVE_OPTION) 
		        {
		        	//writes the file
		            PrintWriter printWriter;
		            try {
		            	printWriter = new PrintWriter(chooser.getSelectedFile() + ".rtf");
		            	printWriter.printf(textArea.getText().trim());
		            	printWriter.close();
					} 
		            catch (FileNotFoundException e){
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
	
	//set up checkboxes
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
		businessPanel.setLayout(new GridLayout(12, 1, 0, 0));
		
		//checkbox for business panel
		businessCheck1 = new JCheckBox("Business Name");
		businessCheck1.setActionCommand("");
		businessCheck1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck1);
		businessCheck1.setEnabled(false);
		
		//checkbox for business panel
		businessCheck2 = new JCheckBox("Street Address");
		businessCheck2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck2);
		businessCheck2.setEnabled(false);
		
		//checkbox for business panel
		businessCheck3 = new JCheckBox("Street Address Line 2");
		businessCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck3);
		businessCheck3.setEnabled(false);
		
		//checkbox for business panel
		businessCheck4 = new JCheckBox("City, State, Zip Code");
		businessCheck4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck4);
		businessCheck4.setEnabled(false);
				
		//checkbox for business panel
		businessCheck7 = new JCheckBox("Phone Number");
		businessCheck7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck7);
		businessCheck7.setEnabled(false);
				
		//checkbox for business panel
		businessCheck8 = new JCheckBox("Phone Number 2");
		businessCheck8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck8);
		businessCheck8.setEnabled(false);
		
		//checkbox for business panel
		businessCheck9 = new JCheckBox("Website");
		businessCheck9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck9);
		businessCheck9.setEnabled(false);		
		
		//checkbox for business panel
		businessCheck10 = new JCheckBox("E-mail");
		businessCheck10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck10);
		businessCheck10.setEnabled(false);
				
		//checkbox for business panel
		businessCheck11 = new JCheckBox("Fax Number");
		businessCheck11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck11);
		businessCheck11.setEnabled(false);
		
		//checkbox for business panel
		businessCheck12 = new JCheckBox("Owner First/Last Name");
		businessCheck12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck12);
		businessCheck12.setEnabled(false);
		
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
		inventoryPanel.setLayout(new GridLayout(9, 1, 0, 0));
			
		//checkbox for inventory panel
		itemNameCheck = new JCheckBox("Item Name");
		itemNameCheck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		itemNameCheck.setActionCommand("");
		inventoryPanel.add(itemNameCheck);
		itemNameCheck.setEnabled(false);			
		
		//checkbox for inventory panel
		itemIDCheck = new JCheckBox("Item ID");
		itemIDCheck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(itemIDCheck);
		itemIDCheck.setEnabled(false);			
								
		//checkbox for inventory panel
		itemPriceCheck = new JCheckBox("Item Price");
		itemPriceCheck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(itemPriceCheck);
		itemPriceCheck.setEnabled(false);			
			
		//checkbox for inventory panel
		itemDescriptionCheck = new JCheckBox("Item Description");
		itemDescriptionCheck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(itemDescriptionCheck);
		itemDescriptionCheck.setEnabled(false);			
					
		//checkbox for inventory panel
		itemSupplierNameCheck = new JCheckBox("Supplier Name");
		itemSupplierNameCheck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(itemSupplierNameCheck);
		itemSupplierNameCheck.setEnabled(false);			
		
		//checkbox for inventory panel
		itemQuantityCheck = new JCheckBox("Quantity");
		itemQuantityCheck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(itemQuantityCheck);
		itemQuantityCheck.setEnabled(false);			
			
		//checkbox for inventory panel
		itemParCheck = new JCheckBox("Par Stock");
		itemParCheck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(itemParCheck);
		itemParCheck.setEnabled(false);	
		
		//checkbox for inventory panel
		itemActiveCheck = new JCheckBox("Active Item");
		itemActiveCheck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(itemActiveCheck);
		itemActiveCheck.setEnabled(false);
		itemActiveCheck.setSelected(true);
		
		//checkbox for inventory panel
		itemInactiveCheck = new JCheckBox("Inactive Item");
		itemInactiveCheck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(itemInactiveCheck);
		itemInactiveCheck.setEnabled(false);
		
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
		salesCheck1 = new JCheckBox("Today's sales");
		salesCheck1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesCheck1.setActionCommand("");
		salesPanel.add(salesCheck1);
		salesCheck1.setEnabled(false);
		return reportInfoPanel;
	}
	
	//gets sales report string
	public String getSalesReport() {
		String reportString = "";
		ArrayList<Double> report = callReportProcedure(connect);
		reportString += "  Today's Cash Sales: $" + report.get(0);
		reportString += "\n  Today's Credit Sales: $" + report.get(1); 
		return reportString;
	}
	
	//calls the report information view from database
	protected ArrayList<Double> callReportProcedure(Connection connect) {
		CallableStatement stmt = null;
		
		ArrayList<Double> report = new ArrayList<Double>();
		double cashTotal = 0.00;
		double creditTotal = 0.00;
		
		//sets today's date
		Date date = new Date();
		String dateString = date.getYear()+1900 + "-";
		if((date.getMonth()+1)<10)
		{
			dateString += "0" + (date.getMonth() + 1) + "-";
		}
		else
		{
			dateString += (date.getMonth() + 1) + "-";
		}
		
		if(date.getDate()<10)
		{
			dateString += "0" + date.getDate();
		}
		else
		{
			dateString += date.getDate();
		}
		System.out.println(dateString);
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.SalesByDate(?,?)}");
			
			//set the parameters
			stmt.setString(1, dateString);
			stmt.setString(2, dateString);
			
			//call stored procedure
			System.out.println("Calling stored procedure for report information");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the results
			ResultSet rs = stmt.getResultSet();
			while(rs.next())
			{
				if(rs.getString(3).toUpperCase().equals("CASH"))
				{
					cashTotal += rs.getDouble(4);
				}
				else
				{
					creditTotal += rs.getDouble(4);
				}
			}
			report.add(cashTotal);
			report.add(creditTotal);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return report;
	}
}
