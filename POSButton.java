import javax.swing.JButton;
import javax.swing.JPanel;

public class POSButton extends JButton {
	private static final long serialVersionUID = 1L;
	private Item item;
	private CheckoutItemPanel checkoutPanel;
	
	public POSButton(Item item, JPanel parent){
		this.item = item;
		this.setText(item.getName());
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
