import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
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
	public JPanel panel_1 = new JPanel();
	public static JPanel panel_2 = new JPanel(new CardLayout());
	public CheckoutPanel panel_3 = new CheckoutPanel();
	private ArrayList<CheckoutItemPanel> panelList = new ArrayList<CheckoutItemPanel>();
	private JButton btnNext, btnPrevious = new JButton();
	private int switchPosition = 0;
	private static JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
	private static CardLayout cl = (CardLayout) (panel_2.getLayout());
	private JPanel addingTo = new JPanel(new GridLayout(8, 1, 0, 0));

	public POSPanel(ArrayList<Object> data)
	{
		inventory = (Inventory) data.get(3);
		
		JPanel panel = this;
		panel.setBounds(0, 0, 772, 476);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setAutoscrolls(true);
		scrollPane_1.setBounds(0, 0, 500, 476);
		panel.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(7, 4, 25, 25));
		
		panel_3 = new CheckoutPanel();
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
				double totalValue = panel_3.getTotalValue();
				new CheckoutButtonScreen(data, checkoutData, (POSPanel) panel, panelList, totalValue);
			}
		});
		panel_3.add(btnCheckOut);
		
		panel_2.setBounds(500, 0, 272, 333);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setVisible(true);
		panel.add(panel_2);
		
		p1 = new JPanel(new GridLayout(7, 1, 0, 0));
		panel_2.add(p1);
		p2 = new JPanel(new GridLayout(7, 1, 0, 0));
		panel_2.add(p2);
		addCompCycle(p1, p2);
		p3 = new JPanel(new GridLayout(7, 1, 0, 0));
		panel_2.add(p3);
		addCompCycle(p2, p3);
		p4 = new JPanel(new GridLayout(7, 1, 0, 0));
		panel_2.add(p4);
		addCompCycle(p3, p4);
		p5 = new JPanel(new GridLayout(7, 1, 0, 0));
		panel_2.add(p5);
		addCompCycle(p4, p5);
		p6 = new JPanel(new GridLayout(7, 1, 0, 0));
		panel_2.add(p6);
		addCompCycle(p5, p6);
		p7 = new JPanel(new GridLayout(7, 1, 0, 0));
		panel_2.add(p7);
		addCompCycle(p6, p7);
		p8 = new JPanel(new GridLayout(7, 1, 0, 0));
		panel_2.add(p8);
		addCompCycle(p7, p8);
		p9 = new JPanel(new GridLayout(7, 1, 0, 0));
		panel_2.add(p9);
		addCompCycle(p8, p9);
		p10 = new JPanel(new GridLayout(7, 1, 0, 0));
		panel_2.add(p10);	
		addCompCycle(p9, p10);
		
		cl = (CardLayout) (panel_2.getLayout());
				
		btnPrevious = new JButton("Previous");
		btnPrevious.setEnabled(false);
		btnPrevious.setBounds(500, 333, 136, 24);
		panel.add(btnPrevious);
		
		
		btnNext = new JButton("Next");
		btnNext.setBounds(636, 333, 136, 24);
		panel.add(btnNext);
		btnNext.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.next(panel_2);
				btnPrevious.setEnabled(true);
				switchPosition++;
				int test = switchPosition;
				if(test==9)
				{
					btnNext.setEnabled(false);
				}
				btnPrevious.setEnabled(true);
				System.out.println(switchPosition);
			}
		});
		
		btnPrevious.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.previous(panel_2);
				switchPosition--;
				int test = switchPosition;
				if(test==0)
				{
					btnPrevious.setEnabled(false);
				}		
				btnNext.setEnabled(true);
				System.out.println(switchPosition);
			}
		});
		
		panelList = new ArrayList<CheckoutItemPanel>(); 

		this.addComponentListener(new ComponentAdapter(){
			//resets the screen
			public void componentShown(ComponentEvent e){
				cl.first(panel_2);
				switchPosition = 0;
				btnNext.setEnabled(true);
				btnPrevious.setEnabled(false);
				panel_1.removeAll();
				panel_1.revalidate();
				for(int x = 0; x < panel_2.getComponentCount(); x++)
				{
					((Container) panel_2.getComponent(x)).removeAll();
				}
				panel_2.revalidate();
				createButtons(panel_1, panel_3);
				panel_1.revalidate();
				panel_2.revalidate();
			}
			
			public void componentHidden(ComponentEvent e) {
				for(int x = 0; x < panel_1.getComponentCount(); x++)
				{
					panel_1.getComponent(x).setVisible(false);
				}
				panel_1.removeAll();
				
				panelList = new ArrayList<CheckoutItemPanel>();
				
				for(int x = 0; x < panel_2.getComponentCount(); x++)
				{
					((Container) panel_2.getComponent(x)).removeAll();
				}
				panel_3.setSubtotal(0.0);
				panel_1.revalidate();
				panel_2.revalidate();
			}
		});
	}

	private void addCompCycle(JPanel innerPanel, JPanel nextPanel) {
		innerPanel.addContainerListener(new ContainerListener(){
			@Override
			public void componentRemoved(ContainerEvent e){
				if(nextPanel.getComponentCount()>0)
				{
					innerPanel.add(nextPanel.getComponent(0));
				}
			}

			@Override
			public void componentAdded(ContainerEvent arg0) {
			}
		});
	}
	
	private void determinePanel()
	{
		if(p1.getComponentCount()<7){
			addingTo = p1;
			switchPosition = 0;
			cl.first(panel_2);
			btnPrevious.setEnabled(false);
			btnNext.setEnabled(true);
		}
		else if(p2.getComponentCount()<7){
			addingTo = p2;
			switchPosition = 1;
			cl.first(panel_2);
			cl.next(panel_2);
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(true);
		}
		else if(p3.getComponentCount()<7){
			addingTo = p3;
			switchPosition = 2;
			cl.first(panel_2);
			cl.next(panel_2);
			cl.next(panel_2);
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(true);
		}
		else if(p4.getComponentCount()<7){
			addingTo = p4;
			switchPosition = 3;
			cl.first(panel_2);
			for(int x = 0; x < 4; x++)
			{
				cl.next(panel_2);
			}
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(true);
		}
		else if(p5.getComponentCount()<7){
			addingTo = p5;
			switchPosition = 4;
			cl.first(panel_2);
			for(int x = 0; x < 5; x++)
			{
				cl.next(panel_2);
			}
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(true);
		}
		else if(p6.getComponentCount()<7){
			addingTo = p6;
			switchPosition = 5;
			cl.first(panel_2);
			for(int x = 0; x < 6; x++)
			{
				cl.next(panel_2);
			}
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(true);
		}
		else if(p7.getComponentCount()<7){
			addingTo = p7;
			switchPosition = 6;
			cl.first(panel_2);
			for(int x = 0; x < 7; x++)
			{
				cl.next(panel_2);
			}
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(true);
		}
		else if(p8.getComponentCount()<7){
			addingTo = p8;
			switchPosition = 7;
			cl.first(panel_2);
			cl.last(panel_2);
			cl.previous(panel_2);
			cl.previous(panel_2);
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(true);
		}
		else if(p9.getComponentCount()<7){
			addingTo = p9;
			switchPosition = 8;
			cl.last(panel_2);
			cl.previous(panel_2);
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(true);
		}
		else if(p10.getComponentCount()<7){
			addingTo = p10;
			switchPosition = 9;
			cl.last(panel_2);
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(false);
		}
	}

	private double getSubtotal(ArrayList<CheckoutItemPanel> panelList) {
		double sub = 0.00;
		for(int x = 0; x < panelList.size(); x++)
		{
			sub += panelList.get(x).getTotal();
		}
		return sub;
	}
	
	public JPanel getPanel_2() {
		return panel_2;
	}

	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}
	
	public void createButtons(JPanel panel_1, CheckoutPanel panel_3) 
	{
		for(int x = 0; x < inventory.size(); x++)
		{
			if(!inventory.get(x).isRemoved())
			{
				POSButton button = new POSButton(inventory.get(x), panel_2, panel_3, cl, panelList);
				if(inventory.get(x).getQuantity()==0)
				{
					button.setEnabled(false);
					button.setToolTipText("Disabled due to 0 stock");
				}
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CheckoutItemPanel newPanel = button.checkoutPanel;
						newPanel.setVisible(true);
				        
				        //boolean to check for existing panel
						boolean hasPanel = false;
						//for loop to check for existing panel
						for(int x = 0; x < panelList.size(); x++)
						{
							//cycles through existing panel
							if(panelList.get(x).getItemName().equals(newPanel.getItemName()))
							{
								if(panelList.get(x).getQuantity()==0)
								{
									button.setEnabled(false);
									button.setToolTipText("Disabled due to 0 stock");
									hasPanel = true;
								}
								else
								{
									panelList.get(x).increaseQuantity();
									hasPanel = true;
									cl.next(panel_2);
									cl.previous(panel_2);
								}
							}
						}
						if(!hasPanel)
						{
							cl.first(panel_2);
					        determinePanel();
					        newPanel.setQuant(1);
							panelList.add(newPanel);
							addingTo.add(newPanel);
						}
						panel_3.setSubtotal(getSubtotal(panelList));
						panel_3.updateLabels();
						panel_2.validate();				
					}
				});
				panel_1.add(button);
			}
		}
	}
} 