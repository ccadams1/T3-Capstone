import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class POSPanel extends JPanel{
	public POSPanel()
	{
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
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_11 = new JButton("New button");
		panel_1.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("New button");
		panel_1.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("New button");
		panel_1.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("New button");
		panel_1.add(btnNewButton_14);
		
		JButton btnNewButton_21 = new JButton("New button");
		panel_1.add(btnNewButton_21);
		
		JButton btnNewButton_22 = new JButton("New button");
		panel_1.add(btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("New button");
		panel_1.add(btnNewButton_23);
		
		JButton btnNewButton_24 = new JButton("New button");
		panel_1.add(btnNewButton_24);
		
		JButton btnNewButton_124 = new JButton("New button");
		panel_1.add(btnNewButton_124);
		
		JButton btnNewButton_111 = new JButton("New button");
		panel_1.add(btnNewButton_111);
		
		JButton btnNewButton_211 = new JButton("New button");
		panel_1.add(btnNewButton_211);
		
		JButton btnNewButton_311 = new JButton("New button");
		panel_1.add(btnNewButton_311);
		
		JButton btnNewButton_411 = new JButton("New button");
		panel_1.add(btnNewButton_411);
		
		JButton btnNewButton_112 = new JButton("New button");
		panel_1.add(btnNewButton_112);
		
		JButton btnNewButton_122 = new JButton("New button");
		panel_1.add(btnNewButton_122);
		
		JButton btnNewButton_132 = new JButton("New button");
		panel_1.add(btnNewButton_132);
		
		JButton btnNewButton_142 = new JButton("New button");
		panel_1.add(btnNewButton_142);
		
		JButton btnNewButton_212 = new JButton("New button");
		panel_1.add(btnNewButton_212);
		
		JButton btnNewButton_222 = new JButton("New button");
		panel_1.add(btnNewButton_222);
		
		JButton btnNewButton_232 = new JButton("New button");
		panel_1.add(btnNewButton_232);
		
		JButton btnNewButton_242 = new JButton("New button");
		panel_1.add(btnNewButton_242);
		
		JButton btnNewButton_1242 = new JButton("New button");
		panel_1.add(btnNewButton_1242);
		
		JPanel panel_3 = new JPanel();
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
		
		JLabel subtotalValue = new JLabel("$0.00");
		subtotalValue.setHorizontalAlignment(SwingConstants.RIGHT);
		subtotalValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		subtotalValue.setBounds(88, 11, 60, 20);
		panel_3.add(subtotalValue);
		
		JLabel discountValue = new JLabel("$0.00");
		discountValue.setHorizontalAlignment(SwingConstants.RIGHT);
		discountValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		discountValue.setBounds(88, 38, 60, 20);
		panel_3.add(discountValue);
		
		JLabel taxesValue = new JLabel("$0.00");
		taxesValue.setHorizontalAlignment(SwingConstants.RIGHT);
		taxesValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		taxesValue.setBounds(88, 65, 60, 20);
		panel_3.add(taxesValue);
		
		JLabel totalValue = new JLabel("$0.00");
		totalValue.setHorizontalAlignment(SwingConstants.RIGHT);
		totalValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalValue.setBounds(88, 92, 60, 20);
		panel_3.add(totalValue);
		
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCheckOut.setBounds(151, 82, 106, 37);
		panel_3.add(btnCheckOut);
		if (!panel_3.isVisible())
		{
			btnCheckOut.setVisible(false);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(515, 0, 255, 355);
		panel.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setBorder(null);
		panel_2.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel newItem1 = ItemCheckoutPanel();
		JPanel newItem2 = ItemCheckoutPanel();
		JPanel newItem3 = ItemCheckoutPanel();
		panel_2.add(newItem1);
		panel_2.add(newItem2);
		panel_2.add(newItem3);
		JPanel newItem11 = ItemCheckoutPanel();
		JPanel newItem12 = ItemCheckoutPanel();
		JPanel newItem13 = ItemCheckoutPanel();
		panel_2.add(newItem11);
		panel_2.add(newItem12);
		panel_2.add(newItem13);
	}
	
	private JPanel ItemCheckoutPanel()
	{
		JPanel newItem = new JPanel();
		newItem.setBounds(0, 0, 257, 37);
		newItem.setLayout(null);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(3, 10, 79, 20);
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		newItem.add(lblItemName);
		
		JTextField txtQuant = new JTextField();
		txtQuant.setBounds(88, 11, 44, 25);
		txtQuant.setPreferredSize(new Dimension(6, 12));
		txtQuant.setText("Quant");
		newItem.add(txtQuant);
		txtQuant.setColumns(10);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(149, 8, 41, 36);
		newItem.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Item Total");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(184, 10, 74, 12);
		newItem.add(lblNewLabel);
		return newItem;
	}
} 