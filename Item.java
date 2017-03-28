
public class Item {

	private String name;
	private String id;
	private double price;
	private int quantity;
	private int parStock;
	private String supplier;
	private String description;
	private boolean removed;
	
	public Item(String n, String i, double p, String s, int quantity, int par, String d)
	{
		this.name = n;
		this.id = i;
		this.price = p;
		this.supplier = s;
		this.quantity = quantity;
		this.parStock = par;
		this.description = d;
		this.setRemoved(false);
	}
	
	//constructor for population
	public Item(String n, String i, double p, String s, int q, int par, String d, boolean r)
	{
		this.name = n;
		this.id = i;
		this.price = p;
		this.supplier = s;
		this.quantity = q;
		this.parStock = par;
		this.description = d;
		this.setRemoved(r);
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getName() {
		return name;	
	}
	
	public void setId (String id)
	{
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setPrice (double price)
	{
		this.price = price;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setQuantity (int quantity)
	{
		this.quantity = quantity;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setParStock (int par)
	{
		this.parStock = par;
	}
	
	public int getParStock()
	{
		return this.parStock;
	}
	
	public void addQuantity() {
		this.quantity++;
	}
	
	public void substractQuantity() {
		this.quantity--;
	}
	
	public void setSupplier(String s){
		this.supplier = s;
	}
	
	public String getSupplier(){
		return this.supplier;
	}
	
	public void setDescription(String d){
		this.description = d;
	}
	
	public String getDescription(){
		return this.description;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}

	public String toString(){
		String string = "";
		string +=  name + "\t" + id + "\t" + price + "\t" + quantity + "\t" 
		+ parStock + "\t" + supplier + "\t" + description;
		return string;
	}
}	
