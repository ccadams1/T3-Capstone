import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainScreen extends JFrame {
	
	private JButton sales, invoice, supplier, guide, inventory, history;
	
	public MainScreen(){
		
		//Create JFrame and GridLayout
		super("Main Screen");
		setLayout(new GridLayout(2, 3));
		
		// Create Buttons
		sales = new JButton("Sales");
		invoice = new JButton("Invoice");
		supplier = new JButton("Supplier");
		guide = new JButton("User Guide");
		inventory = new JButton("Inventory");
		history = new JButton("History");
		
		//Create ActionListeners
		ActionListener toSales = new goToSales();
		ActionListener toInvoice = new goToInvoice();
		ActionListener toSupplier = new goToSupplier();
		ActionListener toGuide = new goToGuide();
		ActionListener toInventory = new goToInventory();
		ActionListener toHistory = new goToHistory();
		
		//Add ActionListeners to buttons
		sales.addActionListener(toSales);
		invoice.addActionListener(toInvoice);
		supplier.addActionListener(toSupplier);
		guide.addActionListener(toGuide);
		inventory.addActionListener(toInventory);
		history.addActionListener(toHistory);
		
		//Add buttons to GridLayout
		add(sales);
		add(inventory);
		add(invoice);
		add(supplier);
		add(history);
		add(guide);
		
		
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	
	private class goToInventory implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("inventory works");
		}
	}
	
	private class goToSales implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("sales works");
		}
	}
	
	private class goToInvoice implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("invoice works");
		}
	}
	
	private class goToHistory implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("history works");
		}
	}
	
	private class goToSupplier implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("supplier works");
		}
	}
	
	private class goToGuide implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("guide works");
		}
	}
	
	
	
}
