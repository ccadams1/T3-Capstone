import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	private ArrayList<Item> items = new ArrayList<Item>();
	private NumberFormat formatter = NumberFormat.getCurrencyInstance();

	public Inventory(){
	}
	
	public void populate(ArrayList<Item> items){
		this.items = items;
	}
	
	public int size(){
		return items.size();
	}
	
	public Item get(int i){
		return items.get(i);
	}
	
	public void addItem(String n, String i, double p, int sn, String s, int q, int par, String d){
		Item temp = new Item(n, i, p, sn, s, q, par, d);
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
	
	public int findItemByID(String id) {
		int index = -1;
		for(int i = 0; i < items.size(); i++){
			if(items.get(i).getId().equals(id)){
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

	public ArrayList<Item> getList() {
		return items;
	}
	
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
