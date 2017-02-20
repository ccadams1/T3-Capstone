import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class ReportPanel extends JPanel{
	public ReportPanel()
	{
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
		
		//view report button
		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Dialog", Font.PLAIN, 21));
		btnView.setBounds(22, 24, 115, 37);
		buttonPanel.add(btnView);
		
		//save report button
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Dialog", Font.PLAIN, 21));
		btnSave.setBounds(22, 77, 115, 37);
		buttonPanel.add(btnSave);
		
		//print report button
		JButton btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Dialog", Font.PLAIN, 21));
		btnPrint.setBounds(22, 127, 115, 37);
		buttonPanel.add(btnPrint);
		
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
	
	private JPanel reportInfoPanel()
	{
		JPanel reportInfoPanel = new JPanel();
		reportInfoPanel.setLayout(null);
		
		//checkbox to include inventory information
		JCheckBox inventoryCheckBox = new JCheckBox("Inventory");
		inventoryCheckBox.setBounds(229, 10, 152, 37);
		inventoryCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 21));
		reportInfoPanel.add(inventoryCheckBox);
		
		//checkbox to include sales information
		JCheckBox salesCheckBox = new JCheckBox("Sales");
		salesCheckBox.setBounds(435, 10, 152, 37);
		salesCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 21));
		reportInfoPanel.add(salesCheckBox);
		
		//checkbox to include business information
		JCheckBox businessCheckBox = new JCheckBox("Business");
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
		JCheckBox chckbxInsertInventoryInfo = new JCheckBox("Insert Inventory info");
		chckbxInsertInventoryInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxInsertInventoryInfo.setActionCommand("");
		inventoryPanel.add(chckbxInsertInventoryInfo);
		
		//checkbox for inventory panel
		JCheckBox checkBox_4 = new JCheckBox("more info");
		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(checkBox_4);
		
		//checkbox for inventory panel
		JCheckBox checkBox_5 = new JCheckBox("and more");
		checkBox_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryPanel.add(checkBox_5);
		
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
		JCheckBox chckbxAnotherone = new JCheckBox("Insert Business info");
		chckbxAnotherone.setActionCommand("");
		chckbxAnotherone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(chckbxAnotherone);
		
		//checkbox for business panel
		JCheckBox chckbxTest = new JCheckBox("more info");
		chckbxTest.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(chckbxTest);
		
		//checkbox for business panel
		JCheckBox chckbxTest_1 = new JCheckBox("and more");
		chckbxTest_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		businessPanel.add(chckbxTest_1);
		
		return reportInfoPanel;
	}
}
