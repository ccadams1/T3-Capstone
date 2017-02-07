import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class T3Main {

		public static void main(String[] args){
		
			
		Inventory inventory = new Inventory();	/*
		DatabaseConnection connection = new DatabaseConnection();
		inventory = connection.getInventory();
		*/
			
		//Create inventory for development/testing purposes only
			Category category = new Category("Test Category");
			inventory.addCategory(category);
			inventory.getCategory(0).addItem(new Item("first", 1234, 3.99, 15, 3));
			inventory.getCategory(0).addItem(new Item("second", 1235, 4.99, 20, 7));
			inventory.getCategory(0).addItem(new Item("third", 1236, 5.99, 30, 10));
			inventory.getCategory(0).addItem(new Item("fourth", 1237, 6.99, 35, 13));
			inventory.getCategory(0).addItem(new Item("fifth", 1238, 7.99, 45, 23));

		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SaleScreen(inventory);
			}
		});
		}
		
		
}
