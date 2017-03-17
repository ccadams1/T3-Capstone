import javax.swing.JButton;
import javax.swing.JPanel;

public class POSButton extends JButton {
	private Item item;
	private CheckoutItemPanel checkoutPanel;
	
	public POSButton(Item item, JPanel parent){
		this.item = item;
		this.setText(item.getPrettyName());
		this.checkoutPanel = new CheckoutItemPanel(item, parent);
	}
	
	public JPanel getCheckPanel(){
		return checkoutPanel.getThisPanel();
	}
	
	public String getName()
	{
		return item.getName();
	}
}
