
public class Item {

	private String name;
	private int id;
	private double price;
	private int quantity = 0;
	private int minStock;
	
	public Item(String Name, int Id, double Price, int Quantity, int MinStock)
	{
		this.name = Name;
		this.id = Id;
		this.price = Price;
		this.quantity = Quantity;
		this.minStock = MinStock;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getName() {
		return name;	
	}
	
	public void setId (int id)
	{
		this.id = id;
	}
	
	public int getId() {
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
	
	public void setMinStock (int minStock)
	{
		this.minStock = minStock;
	}
	
	public int getMinStock()
	{
		return minStock;
	}
	
	public void addQuantity() {
		this.quantity++;
	}
	
	public void substractQuantity() {
		this.quantity--;
	}
}
