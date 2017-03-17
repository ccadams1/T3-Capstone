import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PullDatabase {
	private Connection connection;
	private static List<Customer> customers;
	private static List<Employee> employees;
	private static List<Item> items;
	private static List<Supplier> suppliers;
	
	
	public PullDatabase(Connection connection){
		this.connection = connection;
	}
	
	//customer code complete
	public List<Customer> getCustomers()
	{
		String query = "SELECT pretty_code, fname, lname, st_address1, "
				+ "st_address2, city, state, zip_code, phone1, phone2, "
				+ "email, fax FROM CUSTOMER"; 
		
		try{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				String prettyCode = rs.getString("pretty_code");
				String fName = rs.getString("fname");
				String lName = rs.getString("lname");
				String st_address1 = rs.getString("st_address1");
				String st_address2 = rs.getString("st_address2");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zip_code = rs.getInt("zip_code");
				int phone1 = rs.getInt("phone1");
				int phone2 = rs.getInt("phone2");
				String email = rs.getString("email");
				int fax = rs.getInt("fax");
				Customer c = new Customer(prettyCode, fName, lName, st_address1,
						st_address2, city, state, zip_code, phone1, phone2, 
						email, fax);
				customers.add(c);
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return customers;
	}
	
	
	public List<Employee> getEmployees()
	{
		String query = "SELECT UserID, LoginName, PasswordHash, FirstName, "
				+ "LastName, URE_ID, email, phone1 FROM USERS"; 
		
		try{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				String userID = rs.getString("UserID");
				String username = rs.getString("LoginName");
				String password = rs.getString("PasswordHash");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String role = rs.getString("URE_ID");
				String email = rs.getString("email");
				String phone = rs.getString("phone1");
				Employee e = new Employee(userID, username, password, firstName, lastName, role, email, phone);
				employees.add(e);
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return employees;
	}
	
	public List<Item> getInventory()
	{
		String query = "SELECT I.invID, I.pretty_name, I.item_name, O.supplier_price, S.name, "
				+ "I.num_in_stock, I.reorder_amt, I.item_description "
				+ "FROM INVENTORY I LEFT OUTER JOIN INVENTORY_ORDER O "
				+ "ON I.invID = O.INV_id LEFT OUTER JOIN INVENTORY_PRICE P "
				+ "ON I.invID = P.INV_id LEFT OUTER JOIN SUPPLIER S "
				+ "ON O.SUP_id = S.supID"; 
		
		try{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				String item_name = rs.getString("I.item_name");
				String pretty_name = rs.getString("I.pretty_name");
				String invID = rs.getString("I.invID");
				Double price = rs.getDouble("O.supplier_price");
				String supplier = rs.getString("S.name");
				int quantity = rs.getInt("I.num_in_stock");
				int parStock = rs.getInt("I.reorder_amt");
				String item_description = rs.getString("I.item_description");
				Item i = new Item(item_name, pretty_name, invID, price, supplier, quantity, 
						parStock, item_description);
				items.add(i);
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return items;
	}
	
	//MyBusiness code complete
	public MyBusiness getMyBusinessData()
	{
		MyBusiness data = null;

		String query = "SELECT biz_name, st_address1, st_address2, city, state, "
				+ "zip_code, logo1, logo2, phone1, phone2, website, email, "
				+ "fax, owner_fname, owner_lname FROM MY_BUSINESS"; 
		
		try{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			
			while(rs.next()){
				String bizName = rs.getString("biz_Name");
				String stAddress1 = rs.getString("st_address1");
				String stAddress2 = rs.getString("st_address2");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zipCode = rs.getInt("zip_code");
				File logo1 = null;//(File) rs.getObject("logo1");
				File logo2 = null;//(File) rs.getObject("logo2");
				int phone1 = rs.getInt("phone1");
				int phone2 = rs.getInt("phone2");
				String website = rs.getString("website");
				String email = rs.getString("email");
				int fax = rs.getInt("fax");
				String ownerFirstName = rs.getString("owner_fname");
				String ownerLastName = rs.getString("owner_lname");
				data = new MyBusiness(bizName, stAddress1, stAddress2, city, state, zipCode,
						logo1, logo2, phone1, phone2, website, email, fax, ownerFirstName,
						ownerLastName);
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return data;
	}
	
	//supplier code complete
	public List<Supplier> getSuppliers()
	{
		String query = "SELECT name, pretty_code, st_address1, st_address2, "
				+ "city, state, zip_code, logo, phone1, phone2, website, "
				+ "email, fax FROM SUPPLIER"; 
		
		try{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				String name = rs.getString("name");
				String pretty_code = rs.getString("pretty_code");
				String st_address1 = rs.getString("st_address1");
				String st_address2 = rs.getString("st_address2");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zip_code = rs.getInt("zip_code");
				File logo = (File) rs.getObject("logo");
				int phone1 = rs.getInt("phone1");
				int phone2 = rs.getInt("phone2");
				String website = rs.getString("website");
				String email = rs.getString("email");
				int fax = rs.getInt("fax");
				Supplier s = new Supplier(name, pretty_code, st_address1, st_address2,
						city, state, zip_code, logo, phone1, phone2, website,
						email, fax);
				suppliers.add(s);
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return suppliers;
	}
}