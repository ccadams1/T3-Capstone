import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
	public CheckoutItemPanel(){
	}
	
	public CheckoutItemPanel(Item item, JPanel parent)
	{
		this.parent = parent;
		ciPanel.setSize(257, 37);
		ciPanel.setLayout(null);
		ciPanel.setVisible(true);
		
		JLabel lblItemName = new JLabel(item.getPrettyName());
		lblItemName.setBounds(3, 13, 79, 20);
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ciPanel.add(lblItemName);
		
		JSpinner txtQuant = new JSpinner();
		txtQuant.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		txtQuant.setBounds(88, 11, 44, 25);
		txtQuant.setPreferredSize(new Dimension(6, 12));
		ciPanel.add(txtQuant);
		
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(149, 8, 41, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(getIndex()==(parent.getComponentCount()-1))
				{
					ciPanel.setVisible(false);
					parent.validate();
					ciPanel.setVisible(true);
				}
				parent.remove(getIndex());
				parent.revalidate();
			}
		});
		ciPanel.add(btnNewButton);
		
		itemTotal = quant * item.getPrice();
		JLabel lblNewLabel = new JLabel(itemTotal + "");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(200, 17, 74, 12);
		ciPanel.add(lblNewLabel);
		
		txtQuant.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
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
}