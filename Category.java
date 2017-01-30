import java.util.ArrayList;
import java.util.List;

public class Category {
	
	private List<Item> items;
	private String catName;
	
	public Category(String n){
		this.catName = n;
		this.items = new ArrayList<Item>();
	}
	
	public void addItem(Item i){
		items.add(i);
	}
	
	public void deleteItem(Item i){
		int o = items.indexOf(i);
		items.remove(o);
	}
	
	public void changeName(String n){
		this.catName = n;
	}
	
	public String getName(){
		return catName;
	}
	
	public List<Item> getList(){
		return items;
	}
	
	
	
	
	
}
