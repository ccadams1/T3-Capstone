import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	private List<Category> categories;
	
	public Inventory(){
		categories = new ArrayList<Category>();
	}
	
	public void addCategory(String n){
		Category temp = new Category(n);
		categories.add(temp);
	}
	
	public Category getCategory(int i){
		return categories.get(i);
	}
	
	public void removeCategory(Category c){
		categories.remove(c);
	}
	
	public int searchInventory(String n){
		return -1;
	}
	
	public Item getItem(int i){
		return categories.get(0).getItem(0);
	}
}
