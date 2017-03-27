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
import java.util.ArrayList;
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
	
	JCheckBox inventoryCheck1;
	JCheckBox inventoryCheck2;
	JCheckBox inventoryCheck3;
	JCheckBox inventoryCheck4;
	JCheckBox inventoryCheck5;
	JCheckBox inventoryCheck6;
	JCheckBox inventoryCheck7;
	
	JCheckBox salesCheck1;
	JCheckBox salesCheck2;
	JCheckBox salesCheck3;
	JCheckBox salesCheck4;
	JCheckBox salesCheck5;
	JCheckBox salesCheck6;
		
	public ReportPanel(ArrayList<Object> data)
	{
		MyBusiness businessObj = (MyBusiness) data.get(4);
		Inventory inventory = (Inventory) data.get(3);
		List<Item> items = inventory.getList();

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
		
		businessCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(businessCheckBox.isSelected())
				{
					businessCheck1.setEnabled(true);
					businessCheck2.setEnabled(true);
					businessCheck3.setEnabled(true);
					businessCheck4.setEnabled(true);
					businessCheck5.setEnabled(true);
					businessCheck6.setEnabled(true);
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
					businessCheck5.setEnabled(false);
					businessCheck6.setEnabled(false);
					businessCheck7.setEnabled(false);
					businessCheck8.setEnabled(false);
					businessCheck9.setEnabled(false);
					businessCheck10.setEnabled(false);
					businessCheck11.setEnabled(false);
					businessCheck12.setEnabled(false);
				}
			}
		});
		
		inventoryCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(inventoryCheckBox.isSelected())
				{
					inventoryCheck1.setEnabled(true);
					inventoryCheck2.setEnabled(true);
					inventoryCheck3.setEnabled(true);
					inventoryCheck4.setEnabled(true);
					inventoryCheck5.setEnabled(true);
					inventoryCheck6.setEnabled(true);
					inventoryCheck7.setEnabled(true);
				}
				else if(!inventoryCheckBox.isSelected())
				{
					inventoryCheck1.setEnabled(false);
					inventoryCheck2.setEnabled(false);
					inventoryCheck3.setEnabled(false);
					inventoryCheck4.setEnabled(false);
					inventoryCheck5.setEnabled(false);
					inventoryCheck6.setEnabled(false);
					inventoryCheck7.setEnabled(false);
				}
			}
		});
		
		salesCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(salesCheckBox.isSelected())
				{
					salesCheck1.setEnabled(true);
					salesCheck2.setEnabled(true);
					salesCheck3.setEnabled(true);
					salesCheck4.setEnabled(true);
					salesCheck5.setEnabled(true);
					salesCheck6.setEnabled(true);
				}
				else if(!salesCheckBox.isSelected())
				{
					salesCheck1.setEnabled(false);
					salesCheck2.setEnabled(false);
					salesCheck3.setEnabled(false);
					salesCheck4.setEnabled(false);
					salesCheck5.setEnabled(false);
					salesCheck6.setEnabled(false);
				}
			}
		});
		
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String textAreaString = "";
				//BUSINESS CONDITIONS ONLY
				if(businessCheckBox.isSelected())
				{
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
				if(inventoryCheckBox.isSelected())
				{
					textAreaString += "Inventory Report \n";
					textAreaString += "-------------------------------------------------------------------------------- \n";
					for(int x = 0; x < items.size(); x++)
					{
						if (inventoryCheck1.isSelected()) {
							textAreaString += "Item Name: \t";
							textAreaString += items.get(x).getName();
						}
						if (inventoryCheck2.isSelected()) {
							textAreaString += "Item ID: \t";
							textAreaString += items.get(x).getId();
						}
						if (inventoryCheck3.isSelected()) {
							textAreaString += "Price: \t";
							textAreaString += items.get(x).getSupplier();
						}
						if (inventoryCheck5.isSelected()) {
							textAreaString += "Supplier Name: \t";
							textAreaString += items.get(x).getSupplier();
						}
						if (inventoryCheck7.isSelected()) {
							textAreaString += "Quantity: \n";
							textAreaString += items.get(x).getQuantity();
						}
						if (inventoryCheck6.isSelected()) {
							textAreaString += "Par Stock: \n";
							textAreaString += items.get(x).getParStock();
						}
						if (inventoryCheck4.isSelected()) {
							textAreaString += "Item Description: \n";
							textAreaString += items.get(x).getDescription();
						}
					}
				    textArea.setText(textAreaString);
				}
				
				//SALES CONDITIONS ONLY
				if(salesCheckBox.isSelected())
				{
					if (salesCheck1.isSelected()) {
						
					}
					if (salesCheck2.isSelected()) {
							
					}
					if (salesCheck3.isSelected()) {
							
					}
					if (salesCheck4.isSelected()) {
							
					}
					if (salesCheck5.isSelected()) {
							
					}
					if (salesCheck6.isSelected()) {
							
					}
						
					textAreaString += "Sales Report\n";
					textAreaString += "-------------------------------------------------------------------------------- \n \n";
					
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
		businessCheck5 = new JCheckBox("Logo");
		businessCheck5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck5);
		businessCheck5.setEnabled(false);
		
		//checkbox for business panel
		businessCheck6 = new JCheckBox("Logo 2");
		businessCheck6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck6);
		businessCheck6.setEnabled(false);
				
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
		inventoryPanel.setLayout(new GridLayout(15, 1, 0, 0));
			
		//checkbox for inventory panel
		inventoryCheck1 = new JCheckBox("Item Name");
		inventoryCheck1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryCheck1.setActionCommand("");
		inventoryPanel.add(inventoryCheck1);
		inventoryCheck1.setEnabled(false);			
		
		//checkbox for inventory panel
		inventoryCheck2 = new JCheckBox("Item ID");
		inventoryCheck2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(inventoryCheck2);
		inventoryCheck2.setEnabled(false);			
								
		//checkbox for inventory panel
		inventoryCheck3 = new JCheckBox("Item Price");
		inventoryCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(inventoryCheck3);
		inventoryCheck3.setEnabled(false);			
			
		//checkbox for inventory panel
		inventoryCheck4 = new JCheckBox("Item Description");
		inventoryCheck4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(inventoryCheck4);
		inventoryCheck4.setEnabled(false);			
					
		//checkbox for inventory panel
		inventoryCheck5 = new JCheckBox("Supplier Name");
		inventoryCheck5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(inventoryCheck5);
		inventoryCheck5.setEnabled(false);			
		
		//checkbox for inventory panel
		inventoryCheck7 = new JCheckBox("Quantity");
		inventoryCheck7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(inventoryCheck7);
		inventoryCheck7.setEnabled(false);			
			
		//checkbox for inventory panel
		inventoryCheck6 = new JCheckBox("Par Stock");
		inventoryCheck6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(inventoryCheck6);
		inventoryCheck6.setEnabled(false);	
		
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
		salesCheck1.setEnabled(false);
				
		//checkbox for sales panel
		salesCheck2 = new JCheckBox("more info");
		salesCheck2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesPanel.add(salesCheck2);
		salesCheck2.setEnabled(false);		
		
		//checkbox for sales panel
		salesCheck3 = new JCheckBox("and more");
		salesCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesPanel.add(salesCheck3);
		salesCheck3.setEnabled(false);
		
		//checkbox for sales panel
		salesCheck4 = new JCheckBox("and more");
		salesCheck4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesPanel.add(salesCheck4);
		salesCheck4.setEnabled(false);
		
		//checkbox for sales panel
		salesCheck5 = new JCheckBox("and more");
		salesCheck5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesPanel.add(salesCheck5);
		salesCheck5.setEnabled(false);
			
		//checkbox for sales panel
		salesCheck6 = new JCheckBox("and more");
		salesCheck6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesPanel.add(salesCheck6);
		salesCheck6.setEnabled(false);
		return reportInfoPanel;
	}
}
