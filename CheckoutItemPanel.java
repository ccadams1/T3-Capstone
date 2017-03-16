import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckoutItemPanel extends Component{
	public JPanel ciPanel = new JPanel();
	public int quant = 1;
	public double itemTotal = 0;
		
	public CheckoutItemPanel(Item item, JPanel parent)
	{
		ciPanel.setSize(257, 37);
		ciPanel.setLayout(null);
		
		JLabel lblItemName = new JLabel(item.getName());
		lblItemName.setBounds(3, 10, 79, 20);
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ciPanel.add(lblItemName);
		
		JTextField txtQuant = new JTextField();
		txtQuant.setBounds(88, 11, 44, 25);
		txtQuant.setPreferredSize(new Dimension(6, 12));
		txtQuant.setText(quant + "");
		ciPanel.add(txtQuant);
		txtQuant.setColumns(10);
		quant = Integer.parseInt(txtQuant.getText());
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(149, 8, 41, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.remove(parent.getComponentAt(ciPanel.getX(),ciPanel.getY()));
			}
		});
		ciPanel.add(btnNewButton);
		
		itemTotal = quant * item.getPrice();
		JLabel lblNewLabel = new JLabel(itemTotal + "");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(184, 10, 74, 12);
		ciPanel.add(lblNewLabel);
	}
	
	public JPanel getThisPanel()
	{
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
}
