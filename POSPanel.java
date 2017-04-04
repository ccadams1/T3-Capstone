import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class POSPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Inventory inventory = new Inventory();
	private JPanel panel_2;

	public POSPanel(ArrayList<Object> data)
	{
		inventory = (Inventory) data.get(3);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 772, 476);
		this.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setAutoscrolls(true);
		scrollPane_1.setBounds(0, 0, 515, 476);
		panel.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(7, 4, 25, 25));
		
		CheckoutPanel panel_3 = new CheckoutPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(515, 357, 257, 119);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Subtotal");
		lblNewLabel_1.setBounds(14, 11, 68, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Discounts");
		lblNewLabel_2.setBounds(14, 38, 68, 20);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblNewLabel_2);
		
		JLabel lblTaxes = new JLabel("Taxes");
		lblTaxes.setBounds(14, 65, 68, 20);
		lblTaxes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblTaxes);
		
		JLabel lblNewLabel_3 = new JLabel("Total");
		lblNewLabel_3.setBounds(14, 92, 68, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblNewLabel_3);
		
		JLabel subtotalValueText= new JLabel("$0.00");
		subtotalValueText.setHorizontalAlignment(SwingConstants.RIGHT);
		subtotalValueText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		subtotalValueText.setBounds(88, 11, 60, 20);
		panel_3.addSubtotalLabel(subtotalValueText);
		
		JLabel discountValueText= new JLabel("$0.00");
		discountValueText.setHorizontalAlignment(SwingConstants.RIGHT);
		discountValueText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		discountValueText.setBounds(88, 38, 60, 20);
		panel_3.addDiscountLabel(discountValueText);
	
		JLabel taxesValueText = new JLabel("$0.00");
		taxesValueText.setHorizontalAlignment(SwingConstants.RIGHT);
		taxesValueText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		taxesValueText.setBounds(88, 65, 60, 20);
		panel_3.addTaxesLabel(taxesValueText);
		
		JLabel totalValueText = new JLabel("$0.00");
		totalValueText.setHorizontalAlignment(SwingConstants.RIGHT);
		totalValueText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalValueText.setBounds(88, 92, 60, 20);
		panel_3.addTotalLabel(totalValueText);
		
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCheckOut.setBounds(151, 82, 106, 37);
		btnCheckOut.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> checkoutData = new ArrayList<String>();
				checkoutData.add(subtotalValueText.getText());
				checkoutData.add(discountValueText.getText());
				checkoutData.add(taxesValueText.getText());
				checkoutData.add(totalValueText.getText());
				new CheckoutButtonScreen(data, checkoutData);
			}
		});
		panel_3.add(btnCheckOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(515, 0, 255, 355);
		panel.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setAutoscrolls(true);
		panel_2.setBounds(new Rectangle(0, 0, 234, 1000));
		scrollPane.setViewportView(panel_2);
		panel_2.setBorder(null);
		panel_2.setLayout(new GridLayout(6, 1, 0, 0));

		this.addComponentListener(new ComponentAdapter(){
			public void componentShown(ComponentEvent e){
				panel_1.removeAll();
				panel_2.removeAll();
				panel_1.revalidate();
				panel_2.revalidate();
				for(int x = 0; x < inventory.size(); x++)
				{
					if(!inventory.get(x).isRemoved())
					{
						POSButton button = new POSButton(inventory.get(x), panel_2, panel_3);
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								JPanel newPanel = button.getCheckPanel();
								newPanel.setVisible(true);
								JPanel spacer = new JPanel();
								spacer.setSize(235,1);
								panel_2.add(spacer);
								panel_3.addToSubtotal(button.getPrice());
								panel_2.add(newPanel);
								panel_2.remove(spacer);
								panel_3.updateLabels();
								panel_2.validate();
							}
						});
						panel_1.add(button);
					}
				}
				panel_1.revalidate();
				panel_2.revalidate();
			}
		});
	}

	public JPanel getPanel_2() {
		return panel_2;
	}

	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}
} 