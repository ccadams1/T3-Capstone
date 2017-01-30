public class T3Main {

		public static void main(String[] args){
		Inventory inventory = new Inventory();	
		DatabaseConnection connection = new DatabaseConnection();
		inventory = connection.getInventory();
		
		}
		
		
}
