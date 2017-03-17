import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	private List<Item> items = new ArrayList<Item>();
	
	public Inventory(){
	}
	
	public void populate(List<Item> items){
		this.items = items;
	}
	
	public int size(){
		return items.size();
	}
	
	public Item get(int i){
		return items.get(i);
	}
	
	public void addItem(String n, String i, double p, String s, int q, int par, String d){
		Item temp = new Item(n, i, p, s, q, par, d);
		items.add(temp);
	}
	
	public void addItem(String n, String i, double p, String s, int par, String d){
		Item temp = new Item(n, i, p, s, par, d);
		items.add(temp);
	}
	
	public void addItem(Item i){
		items.add(i);
	}
	
	public int findItemByName(String n){
		int index = -1;
		for(int i = 0; i < items.size(); i++){
			if(items.get(i).getName().equals(n)){
				index = i;
			}
		}
		return index;
	}
	
	public void removeItem(int i){
		items.remove(i);
	}
	
	public String toString(){
		String s = "";
		
		for(int i = 0; i < items.size(); i++){
			s += "Item: " + items.get(i).getName() + "  ";
			s += "Item Id: " + items.get(i).getId() + "  ";
			s += "Price: " + items.get(i).getPrice() + "  ";
			s += "Supplier: " + items.get(i).getSupplier() + "  ";
			s += "Par Stock: " + items.get(i).getParStock();
			if(!items.get(i).getDescription().equals("")){
				s += "  Description: " + items.get(i).getDescription();
			}
			s += "\n";
		}
		return s;
	}

	public List<Item> getList() {
		return items;
	}
	
	public void setList(List<Item> items){
		this.items = items;
	}
	
	
	
	// default code
	/*
	public Item getItem(int i){
		return items.get(i);
	}
	
	
	
	public int searchInventory(String n){
		return -1;
	}
	*/
	
	
	
	
}
