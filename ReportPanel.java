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
		JCheckBox InventoryCheck1 = new JCheckBox("Item Name");
		InventoryCheck1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		InventoryCheck1.setActionCommand("");
		inventoryPanel.add(InventoryCheck1);
		
		//checkbox for inventory panel
		JCheckBox InventoryCheck2 = new JCheckBox("Item ID");
		InventoryCheck2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(InventoryCheck2);
				
		//checkbox for inventory panel
		JCheckBox InventoryCheck3 = new JCheckBox("Item Price");
		InventoryCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(InventoryCheck3);
	
		//checkbox for inventory panel
		JCheckBox InventoryCheck4 = new JCheckBox("Item Description");
		InventoryCheck4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(InventoryCheck4);
		
		//checkbox for inventory panel
		JCheckBox InventoryCheck5 = new JCheckBox("Supplier Name");
		InventoryCheck5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(InventoryCheck5);
		
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
		JCheckBox chckbxInsertSalesInfo = new JCheckBox("Insert Sales info");
		chckbxInsertSalesInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxInsertSalesInfo.setActionCommand("");
		salesPanel.add(chckbxInsertSalesInfo);
		
		//checkbox for sales panel
		JCheckBox checkBox_1 = new JCheckBox("more info");
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesPanel.add(checkBox_1);
		
		//checkbox for sales panel
		JCheckBox checkBox_2 = new JCheckBox("and more");
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salesPanel.add(checkBox_2);
		
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
		JCheckBox businessCheck1 = new JCheckBox("Business Name");
		businessCheck1.setActionCommand("");
		businessCheck1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck1);
		
		//checkbox for business panel
		JCheckBox businessCheck2 = new JCheckBox("Street Address");
		businessCheck2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck2);
		
		//checkbox for business panel
		JCheckBox businessCheck3 = new JCheckBox("Street Address Line 2");
		businessCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck3);
		
		//checkbox for business panel
		JCheckBox businessCheck4 = new JCheckBox("City, State, Zip Code");
		businessCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck4);
				
		//checkbox for business panel
		JCheckBox businessCheck5 = new JCheckBox("Logo");
		businessCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck5);
	
		//checkbox for business panel
		JCheckBox businessCheck6 = new JCheckBox("Logo 2");
		businessCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck6);
		
		
		//checkbox for business panel
		JCheckBox businessCheck7 = new JCheckBox("Phone Number");
		businessCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck7);
				
		//checkbox for business panel
		JCheckBox businessCheck8 = new JCheckBox("Phone 2");
		businessCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck8);
		
		//checkbox for business panel
		JCheckBox businessCheck9 = new JCheckBox("Website");
		businessCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck9);
				
		//checkbox for business panel
		JCheckBox businessCheck10 = new JCheckBox("E-mail");
		businessCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck10);
				
		//checkbox for business panel
		JCheckBox businessCheck11 = new JCheckBox("Fax Number");
		businessCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck11);
		
		//checkbox for business panel
		JCheckBox businessCheck12 = new JCheckBox("Owner First/Last Name");
		businessCheck3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(businessCheck12);
				
		
		return reportInfoPanel;
	}
	
	public ReportPanel()
	{
		MyBusiness businessObj = new MyBusiness();
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
		if(businessCheckBox.isSelected() && !inventoryCheckBox.isSelected() && !salesCheckBox.isSelected())
		{
			inventoryCheckBox.setEnabled(false);
			salesCheckBox.setEnabled(false);
			textAreaString += "TESTING";
			//textAreaString += "Business Name: " + businessObj.getBizName();
			//textAreaString += businessObj.getStAdress1();
			//textAreaString += businessObj.getStAdress2();
			//textAreaString += businessObj.getCity()+" , "+businessObj.getState()+" , "+businessObj.getZipCode() + "\n";
		    textArea.setText(textAreaString);
		}
		
		else if(inventoryCheckBox.isSelected() && !businessCheckBox.isSelected() && !salesCheckBox.isSelected())
		{
			textAreaString += "Item Name: \n";
			textAreaString += "Item ID: \n";
			textAreaString += "Price: \n";
			textAreaString += "Item Description: \n";
		    textArea.setText(textAreaString);
		    businessCheckBox.setEnabled(false);
		    salesCheckBox.setEnabled(false);
		}
		else if(salesCheckBox.isSelected() && !inventoryCheckBox.isSelected() && !businessCheckBox.isSelected())
		{
			textAreaString += "Sales: ";
			textArea.setText(textAreaString);
			inventoryCheckBox.setEnabled(false);
			businessCheckBox.setEnabled(false);
		}
		else if(businessCheckBox.isSelected() && inventoryCheckBox.isSelected() && salesCheckBox.isSelected())
		{
			textAreaString += "TESTING \n";
			textAreaString += "Item Name: \n";
			textAreaString += "Item ID: \n";
			textAreaString += "Price: \n";
			textAreaString += "Item Description: \n";
		    textArea.setText(textAreaString);
		}
		else if(businessCheckBox.isSelected() && inventoryCheckBox.isSelected())
		{
			textAreaString += "TESTING \n";
			textAreaString += "Item Name: \n";
			textAreaString += "Item ID: \n";
			textAreaString += "Price: \n";
			textAreaString += "Item Description: \n";
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
