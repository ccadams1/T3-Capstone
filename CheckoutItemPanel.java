import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CheckoutItemPanel extends JPanel{
	//sets up variables
	private JPanel parent;
	private Item item;
	public CheckoutItemPanel ciPanel = this;
	public JSpinner txtQuant;
	public int quant = 0;
	public double itemTotal = 0;
	private NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
	//default constructor
	public CheckoutItemPanel(){
	}
	
	//constructor to use existing CheckoutItemPanel
	public CheckoutItemPanel(CheckoutItemPanel c)
	{
		ciPanel = (CheckoutItemPanel) c;
	}
	
	//five parameter constructor
	public CheckoutItemPanel(Item item, JPanel parent, CheckoutPanel panel_3, CardLayout cl, ArrayList<CheckoutItemPanel> panelList)
	{
		//initiate variables
		this.item = item; 
		this.parent = parent;
		
		//sets panel properties
		this.setSize(257, 37);
		this.setLayout(null);
		this.setVisible(true);
		
		//display's item name
		JLabel lblItemName = new JLabel(item.getName());
		lblItemName.setBounds(3, 13, 79, 20);
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.add(lblItemName);
		
		//sets up quantity JSpinner
		txtQuant = new JSpinner();
		//sets quantity to quantity, min to 0, max to item's available quantity, and increment counter of 1
		txtQuant.setModel(new SpinnerNumberModel(quant, 0, item.getQuantity(), 1));
		txtQuant.setBounds(88, 11, 44, 25);
		txtQuant.setPreferredSize(new Dimension(6, 12));
		this.add(txtQuant);
		
		//button to have panel remove itself
		JButton closeButton = new JButton("X");
		closeButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		closeButton.setBounds(149, 8, 41, 36);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//initiates variables
				int position = 0;
				int totalPanelsUsed = panelList.size()/7;
				//searches panel list for itself by item name
				for(int x = 0; x<panelList.size();x++){
					if(panelList.get(x).getItemName().equals(item.getName()))
					{
						//gets it's position in the list and removes itself
						position = x;
						panelList.remove(x);
					}
				}
				//determines the panel it was in and it's position in the panel
				int panelIndex = (position/7);
				int indexInPanel = (position%7);
				if(getIndex()==(parent.getComponentCount()-1))
				{
					ciPanel.setVisible(false);
					parent.validate();
					ciPanel.setVisible(true);
				}
				//changes quantity
				txtQuant.setValue(quant);
				//sets subtotal
				setSubtotal(quant, 0, item.getPrice(), panel_3);
				//removes it's panel from the parent
				((JPanel)((JPanel) parent).getComponent(panelIndex)).remove(indexInPanel);
				//fixes display
				cl.next(parent);
				cl.previous(parent);
				//refreshes parent
				parent.revalidate();
			}
		});
		this.add(closeButton);
		
		//gets total price
		itemTotal = quant * item.getPrice();
		JLabel lblNewLabel = new JLabel(formatter.format(itemTotal));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(200, 17, 74, 12);
		this.add(lblNewLabel);
		
		//updates price upon quantity change
		txtQuant.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				setSubtotal(quant, (int) txtQuant.getValue(), item.getPrice(), panel_3);
				quant = (int) txtQuant.getValue();
				itemTotal = quant * item.getPrice();
				lblNewLabel.setText("$"+ itemTotal);
			}
		});
	}

	//returns this CheckoutItemPanel
	public CheckoutItemPanel getThisPanel()
	{
		return ciPanel;
	}
	
	//returns quantity
	public int getQuantity()
	{
		return quant;
	}
	
	//returns total
	public double getTotal()
	{
		return itemTotal;
	}
	
	//sets subtotal accordingly
	public void setSubtotal(int previousQuant, int newQuant, double price, CheckoutPanel panel_3)
	{
		double subtotal = panel_3.getSubtotal();
		if(previousQuant > newQuant)
		{
			subtotal -= ((previousQuant - newQuant) * price);
		}
		else
		{
			subtotal += ((newQuant - previousQuant) * price);
		}
		panel_3.setSubtotal(subtotal);
		panel_3.updateLabels();
	}
	
	//returns it's location in it's parent panel
	public int getIndex()
	{
		int index = 0;
		for (int x = 0; x < parent.getComponentCount(); x++)
		{
			if(parent.getComponent(x).equals(getThisPanel()))
			{
				index = x;
			}
		}
		return index;
	}
	
	//increases quantity by 1 if it is less the item quantity
	public void increaseQuantity()
	{
		if(item.getQuantity()>quant)
		{
			quant++;
			txtQuant.setValue(quant);
		}
	}

	//returns item name
	public String getItemName()
	{
		return item.getName();
	}

	//returns item id
	public int getItemID() {
		return Integer.parseInt(item.getId());
	}

	//sets quantity
	public void setQuant(int i) {
		quant = i;
		txtQuant.setValue(quant);
	}
}