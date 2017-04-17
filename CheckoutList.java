import java.util.ArrayList;

import javax.swing.JPanel;

public class CheckoutList extends JPanel{
	private ArrayList<CheckoutItemPanel> list;
	
	public CheckoutList()
	{
	}
	
	public void add(CheckoutItemPanel x)
	{
		list.add(x);
	}
	
	public CheckoutItemPanel getCheckoutComponent(int x)
	{
		CheckoutItemPanel panel = list.get(x);
		return panel;
	}
}
