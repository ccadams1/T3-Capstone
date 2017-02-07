import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class SaleScreen extends JFrame{

		private JButton tempButton;
		private ArrayList<Item> cart;
		private JScrollPane middle;
		private JPanel saleItems;

		
		public SaleScreen(Inventory inv){
			
			//Create JFrame and BorderLayout
			super("Sales Screen");
			setLayout(new BorderLayout());
			
			makeMiddle(inv);
			//makeEast(cart);
			
			add(middle, BorderLayout.CENTER);
			
			
			
			setSize(600, 500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}
		
		private void makeMiddle(Inventory inv){
			saleItems = new JPanel();
			middle = new JScrollPane(saleItems);
				for(int i = 0; i < inv.size(); i++){
					for(int j = 0; j < inv.getCategory(i).size(); j++){
						// Create Buttons
						tempButton = new JButton(inv.getCategory(i).getItem(j).getName());
					
						//Create ActionListeners
						ActionListener addToCart = new addItemToCart();
					
						//Add ActionListeners to buttons
						tempButton.addActionListener(addToCart);
					
						//Add buttons to BorderLayout
						saleItems.add(tempButton);
					}
				}
		}
		
		private void makeEast(ArrayList<Item> cart){
			int cartSize = cart.size() + 1;
			
		}
		
		private class goToMain implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
			}
		}
		
		private class addItemToCart implements ActionListener{
			public void actionPerformed(ActionEvent e){
				System.out.println("Add to cart works");
			}
		}
		
		private class enterQuantity implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
			}
		}
		
		
		private class checkout implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
			}
		}
		
		
		
}
