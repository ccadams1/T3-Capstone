import java.awt.CardLayout;
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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class POSPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Inventory inventory = new Inventory();
	private JPanel panel_2;
	private int panelCounter = 0;
	private int checkoutPanels = 1;
	private int switchPosition = 0;
	private static JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10
		= new JPanel(new GridLayout(8, 1, 0, 0));
	private JPanel addingTo = new JPanel(new GridLayout(8, 1, 0, 0));

	public POSPanel(ArrayList<Object> data)
	{
		inventory = (Inventory) data.get(3);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 772, 476);
		this.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setAutoscrolls(true);
		scrollPane_1.setBounds(0, 0, 500, 476);
		panel.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(7, 4, 25, 25));
		
		CheckoutPanel panel_3 = new CheckoutPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(500, 357, 272, 119);
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
		scrollPane.setBounds(500, 0, 272, 333);
		panel.add(scrollPane);
		
		JPanel panel_2 = new JPanel(new CardLayout());
		scrollPane.setViewportView(panel_2);
		
		p1 = new JPanel(new GridLayout(8, 1, 0, 0));
		panel_2.add(p1);
		p2 = new JPanel(new GridLayout(8, 1, 0, 0));
		panel_2.add(p2);
		p3 = new JPanel(new GridLayout(8, 1, 0, 0));
		panel_2.add(p3);
		p4 = new JPanel(new GridLayout(8, 1, 0, 0));
		panel_2.add(p4);
		p5 = new JPanel(new GridLayout(8, 1, 0, 0));
		panel_2.add(p5);
		p6 = new JPanel(new GridLayout(8, 1, 0, 0));
		panel_2.add(p6);
		p7 = new JPanel(new GridLayout(8, 1, 0, 0));
		panel_2.add(p7);
		p8 = new JPanel(new GridLayout(8, 1, 0, 0));
		panel_2.add(p8);
		p9 = new JPanel(new GridLayout(8, 1, 0, 0));
		panel_2.add(p9);
		p10 = new JPanel(new GridLayout(8, 1, 0, 0));
		panel_2.add(p10);		
		
		CardLayout cl = (CardLayout) (panel_2.getLayout());

		JButton btnNewButton = new JButton("Previous");
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(500, 333, 136, 24);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.previous(panel_2);
				switchPosition--;
				int test = switchPosition;
				if(test==0)
				{
					btnNewButton.setEnabled(false);
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.setBounds(636, 333, 136, 24);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.next(panel_2);
				btnNewButton.setEnabled(true);
			}
		});
		
		//panel_2.setLayout(new GridLayout(10, 1, 0, 0));
		ArrayList<CheckoutItemPanel> panelList = new ArrayList<CheckoutItemPanel>(); 

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
								CheckoutItemPanel newPanel = button.checkoutPanel;
								newPanel.setVisible(true);
								JPanel spacer = new JPanel();
								spacer.setSize(235,1);
								if((panelList.size()/6)==checkoutPanels)
								{
									panelCounter++;
									checkoutPanels++;
								}
						        switch (panelCounter) {
						            case 0:  addingTo = p1;
						                     break;
						            case 1:  addingTo = p2;
						                     break;
						            case 2:  addingTo = p3;
						                     break;
						            case 3:  addingTo = p4;
						                     break;
						            case 4:  addingTo = p5;
						                     break;
						            case 5:  addingTo = p6;
						                     break;
						            case 6:  addingTo = p7;
						                     break;
						            case 7:  addingTo = p8;
						                     break;
						            case 8:  addingTo = p9;
						                     break;
						            case 9:  addingTo = p10;
						                     break;
						            default: break;
						        }
								boolean hasPanel = false;
								for(int x = 0; x < panelList.size(); x++)
								{
									if(panelList.get(x).getItemName().equals(newPanel.getItemName()))
									{
										panelList.get(x).increaseQuantity();
										hasPanel = true;
									}
								}
								if(!hasPanel)
								{
									panelList.add(newPanel);
									addingTo.add(panelList.get(panelList.size()-1));
								}
								if(addingTo.getComponentCount()==0)
								{
									panelCounter--;
									checkoutPanels--;
								}
								panel_2.add(spacer);
								panel_3.addToSubtotal(button.getPrice());
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
			public void componentHidden(ComponentEvent e) {
				for(int x = 0; x < panel_1.getComponentCount(); x++)
				{
					panel_1.getComponent(x).setVisible(false);
				}
				panel_1.removeAll();
				panel_1.revalidate();
				panel_2.removeAll();
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
	
	public void populateInnerPanels(JPanel card)
	{
		JPanel p1 = new JPanel();
		panel_2.add(p1, "p1");
		JPanel p2 = new JPanel();
		panel_2.add(p2, "p2");
		JPanel p3 = new JPanel();
		panel_2.add(p3, "p3");
		JPanel p4 = new JPanel();
		panel_2.add(p4, "p4");
		JPanel p5 = new JPanel();
		panel_2.add(p5, "p5");
		JPanel p6 = new JPanel();
		panel_2.add(p6, "p6");
		JPanel p7 = new JPanel();
		panel_2.add(p7, "p7");
		JPanel p8 = new JPanel();
		panel_2.add(p8, "p8");
		JPanel p9 = new JPanel();
		panel_2.add(p9, "p9");
		JPanel p10 = new JPanel();
		panel_2.add(p10, "p10");
	}
} 