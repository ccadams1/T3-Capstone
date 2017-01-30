public class Item {
	
	private String name;
	private int id;
	private double price;
	private int quantity;
	private int minStock;

	public Item(String n, int i, double p, int q, int m){
		name = n;
		id = i;
		price = p;
		quantity = q;
		minStock = m;
	}
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public void setId(int i){
		id = i;
	}
	
	public int getId(){
		return id;
	}
	
	public void setPrice(double p){
		price = p;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setQuantity(int q){
		quantity = q;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public void setMinStock(int m){
		minStock = m;
	}
	
	public int getMinStock(){
		return minStock;
	}
	
	public void addQuantity(){
		quantity++;
	}
	
	public void subtractQuantity(){
		quantity--;
	}
}
