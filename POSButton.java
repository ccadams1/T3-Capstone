import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

//button for POSPanel
public class POSButton extends JButton {
	//sets variables
	private static final long serialVersionUID = 1L;
	private Item item;
	public CheckoutItemPanel checkoutPanel;
	
	//constructor for new button
	public POSButton(Item item, JPanel parent, CheckoutPanel panel_3, CardLayout cl, ArrayList<CheckoutItemPanel> panelList){
		//initiates variable
		this.item = item;
		//sets button name
		this.setText(item.getName());
		//sets it's checkoutItemPanel
		this.checkoutPanel = new CheckoutItemPanel(item, parent, panel_3, cl, panelList);
	}
	
	//returns it's CheckoutItemPanel
	public CheckoutItemPanel getCheckPanel(){
		return checkoutPanel.getThisPanel();
	}
	
	//gets it's item's name
	public String getName()
	{
		return item.getName();
	}

	//returns the item cost
	public double getPrice() {
		return item.getPrice();
	}
}
