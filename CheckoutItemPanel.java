import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CheckoutItemPanel{
	private JPanel parent;
	public JPanel ciPanel = new JPanel();
	public int quant = 1;
	public double itemTotal = 0;
	private NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
	public CheckoutItemPanel(){
	}
	
	public CheckoutItemPanel(Component c)
	{
		ciPanel = (JPanel) c;
	}
	
	public CheckoutItemPanel(Item item, JPanel parent, CheckoutPanel panel_3)
	{
		this.parent = parent;
		ciPanel.setSize(257, 37);
		ciPanel.setLayout(null);
		ciPanel.setVisible(true);
		
		JLabel lblItemName = new JLabel(item.getName());
		lblItemName.setBounds(3, 13, 79, 20);
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ciPanel.add(lblItemName);
		
		JSpinner txtQuant = new JSpinner();
		txtQuant.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		txtQuant.setBounds(88, 11, 44, 25);
		txtQuant.setPreferredSize(new Dimension(6, 12));
		ciPanel.add(txtQuant);
		
		JButton closeButton = new JButton("X");
		closeButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		closeButton.setBounds(149, 8, 41, 36);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(getIndex()==(parent.getComponentCount()-1))
				{
					ciPanel.setVisible(false);
					parent.validate();
					ciPanel.setVisible(true);
				}
				setSubtotal(quant, 0, item.getPrice(), panel_3);
				parent.remove(getIndex());
				parent.revalidate();
			}
		});
		ciPanel.add(closeButton);
		
		itemTotal = quant * item.getPrice();
		JLabel lblNewLabel = new JLabel(formatter.format(itemTotal));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(200, 17, 74, 12);
		ciPanel.add(lblNewLabel);
		
		txtQuant.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				setSubtotal(quant, (int) txtQuant.getValue(), item.getPrice(), panel_3);
				quant = (int) txtQuant.getValue();
				itemTotal = quant * item.getPrice();
				lblNewLabel.setText(itemTotal+"");
			}
		});
	}
	
	public JPanel getThisPanel()
	{
		quant = 1;
		return ciPanel;
	}
	
	public int getQuantity()
	{
		return quant;
	}
	
	public double getTotal()
	{
		return itemTotal;
	}
	
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

	public void setVisible(boolean b) {
		this.setVisible(b);
	}
}