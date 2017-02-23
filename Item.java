
public class Item {

	private String name;
	private String id;
	private double price;
	private int quantity = 0;
	private int parStock;
	private String supplier;
	private String description;
	
	public Item(String n, String i, double p, String s, int par)
	{
		this.name = n;
		this.id = i;
		this.price = p;
		this.supplier = s;
		this.parStock = par;
		this.description = "";
	}
	
	public Item(String n, String i, double p, String s, int par, String d)
	{
		this.name = n;
		this.id = i;
		this.price = p;
		this.supplier = s;
		this.parStock = par;
		this.description = d;
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
}
