import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckoutPanel extends JPanel {
	//sets up variables
	private static double subtotal;
	private NumberFormat formatter = NumberFormat.getCurrencyInstance();
	private double subtotalValue = 0.00;
	private double discountValue = 0.00;
	private double taxesValue = 0.00;
	private double totalValue = 0.00;
	private JLabel subLabel;
	private JLabel taxLabel;
	private JLabel disLabel;
	private JLabel totLabel;
	
	//default constructor
	public CheckoutPanel()
	{
	}
	
	//standard get/set methods
	public double getSubtotal()
	{
		return subtotal;
	}
	
	public void setSubtotal(double sub)
	{
		subtotal = sub;
		updateLabels();
	}

	public void setSubLabel(JLabel subLabel) {
		this.subLabel = subLabel;
	}

	public void setTaxLabel(JLabel taxLabel) {
		this.taxLabel = taxLabel;
	}
	public void setDisLabel(JLabel disLabel) {
		this.disLabel = disLabel;
	}

	public void setTotLabel(JLabel totLabel) {
		this.totLabel = totLabel;
	}
	
	//updates values
	public void updateLabels()
	{
		subtotalValue = getSubtotal();
		taxesValue = subtotalValue * .07;
		totalValue = taxesValue + subtotalValue + discountValue;
		
		subLabel.setText(formatter.format(subtotalValue));
		disLabel.setText(formatter.format(discountValue));
		taxLabel.setText(formatter.format(taxesValue));
		totLabel.setText(formatter.format(totalValue));
	}

	//the following sets label to the corresponding value in text form
	public void addSubtotalLabel(JLabel subtotalValueText) {
		subLabel = subtotalValueText;
		this.add(subtotalValueText);
	}

	public void addDiscountLabel(JLabel discountValueText) {
		disLabel = discountValueText;
		this.add(discountValueText);
	}

	public void addTaxesLabel(JLabel taxesValueText) {
		taxLabel = taxesValueText;
		this.add(taxesValueText);
	}
	
	public void addTotalLabel(JLabel totalValueText) {
		totLabel = totalValueText;
		this.add(totalValueText);
	}

	//increases subtotal
	public void addToSubtotal(double price) {
		subtotal += price;
	}

	//returns total value
	public double getTotalValue() {
		return totalValue;
	}

}
