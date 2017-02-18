import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	private List<Item> items;
	
	public Inventory(){
		items = new ArrayList<Item>();
	}
	
	public int size(){
		return items.size();
	}
	
	public void addItem(Item n){
		items.add(n);
	}
	
	public Item getItem(int i){
		return items.get(i);
	}
	
	public void removeItem(Item i){
		items.remove(i);
	}
	
	public int searchInventory(String n){
		return -1;
	}
	
	
}
