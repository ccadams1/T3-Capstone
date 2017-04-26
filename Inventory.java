import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
	//sets inventory arrayList for items
	private ArrayList<Item> items = new ArrayList<Item>();
	private NumberFormat formatter = NumberFormat.getCurrencyInstance();

	//default constructor
	public Inventory(){
	}
	
	//populates arrayList with inventory items
	public void populate(ArrayList<Item> items){
		this.items = items;
	}
	
	//returns size
	public int size(){
		return items.size();
	}
	
	//gets item
	public Item get(int i){
		return items.get(i);
	}
	
	//adds item to inventory through parameters
	public void addItem(String n, String i, double p, int sn, String s, int q, int par, String d){
		Item temp = new Item(n, i, p, sn, s, q, par, d);
		items.add(temp);
	}
	
	//adds item to inventory
	public void addItem(Item i){
		items.add(i);
	}
	
	//finds an item in the arrayList by the item name
	public int findItemByName(String n){
		int index = -1;
		for(int i = 0; i < items.size(); i++){
			if(items.get(i).getName().equals(n)){
				index = i;
			}
		}
		return index;
	}

	//finds an item in the arrayList by the item id
	public int findItemByID(String id) {
		int index = -1;
		for(int i = 0; i < items.size(); i++){
			if(items.get(i).getId().equals(id)){
				index = i;
			}
		}
		return index;
	}
	
	//removes an item from the inventory
	public void removeItem(int i){
		items.remove(i);
	}
	
	//displays each item's information that is in the inventory arrayList
	public String toString(){
		String s = "";
		
		for(int i = 0; i < items.size(); i++){
			if(!items.get(i).isRemoved())
			{
				s += "Item: " + items.get(i).getName() + " \t";
				s += "Item Id: " + items.get(i).getId() + " \t";
				s += "Price: " + formatter.format(items.get(i).getPrice()) + " \t";
				s += "Supplier: " + items.get(i).getSupplier() + " \t";
				s += "Par Stock: " + items.get(i).getParStock() + " \t";
				s += "Quantity: " + items.get(i).getQuantity() + " \t";
				if(!items.get(i).getDescription().equals("")){
					s += "Description: " + items.get(i).getDescription();
				}
				s += "\n";
			}
		}
		return s;
	}

	//returns the inventory arrayList
	public ArrayList<Item> getList() {
		return items;
	}
	
	//copies the inventory arrayList
	public ArrayList<Item> getListCopy() {
		ArrayList<Item> copy = new ArrayList<Item>();
		for(int x = 0; x < items.size(); x++)
		{
			Item temp = items.get(x);
			copy.add(temp);
		}
		return copy;
	}

}
