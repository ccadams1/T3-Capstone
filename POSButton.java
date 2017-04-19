import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class POSButton extends JButton {
	private static final long serialVersionUID = 1L;
	private Item item;
	public CheckoutItemPanel checkoutPanel;
	
	public POSButton(Item item, JPanel parent, CheckoutPanel panel_3, CardLayout cl, ArrayList<CheckoutItemPanel> panelList){
		this.item = item;
		this.setText(item.getName());
		this.checkoutPanel = new CheckoutItemPanel(item, parent, panel_3, cl, panelList);
	}
	
	public CheckoutItemPanel getCheckPanel(){
		return checkoutPanel.getThisPanel();
	}
	
	public String getName()
	{
		return item.getName();
	}

	public double getPrice() {
		return item.getPrice();
	}
}
