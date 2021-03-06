import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

public class PullDatabase {
	//initiates variables
	private Connection connection;
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static ArrayList<Item> items = new ArrayList<Item>();
	private static ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	
	//constructor gets the connection for statement execution
	public PullDatabase(Connection connection){
		this.connection = connection;
	}
	
	//populates the program with the customer information
	public ArrayList<Customer> getCustomers()
	{
		//sql query
		String query = "SELECT cusID, fname, lname, st_address1, "
				+ "st_address2, city, state, zip_code, phone1, phone2, "
				+ "email, fax FROM CUSTOMER"; 
		//try statement to run sql query
		try{
			//creates a new statement
			Statement stmt = connection.createStatement();
			//returns the results after the statement is executed
			ResultSet rs = stmt.executeQuery(query);
			
			//runs through a loop of all results until none are left
			while(rs.next())
			{
				//creates variables of different result information
				String id = rs.getString("cusID");
				String fName = rs.getString("fname");
				String lName = rs.getString("lname");
				String st_address1 = rs.getString("st_address1");
				String st_address2 = rs.getString("st_address2");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zip_code = rs.getInt("zip_code");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String email = rs.getString("email");
				String fax = rs.getString("fax");
				//creates a Customer object from the results
				Customer c = new Customer(id, fName, lName, st_address1,
						st_address2, city, state, zip_code, phone1, phone2, 
						email, fax);
				//adds to the Customer ArrayList for use in the rest of the program
				customers.add(c);
			}
		}
		//catches SQL exceptions
		catch (SQLException e)
		{
			//logs the exception
			System.out.println(e);
		}
		//notifies when all customers are added
		System.out.println("customers added");
		//returns the ArrayList of Customers
		return customers;
	}
	
	public ArrayList<Employee> getEmployees()
	{
		//sql query
		String query = "SELECT UserID, LoginName, PasswordHash, FirstName, "
				+ "LastName, URE_ID, email, phone1, removed FROM USERS"; 
		
		try{
			//creates a new statement
			Statement stmt = connection.createStatement();
			//returns the results after the statement is executed
			ResultSet rs = stmt.executeQuery(query);
			
			//runs through a loop of all results until none are left
			while(rs.next())
			{
				//creates variables of different result information
				String userID = rs.getString("UserID");
				String username = rs.getString("LoginName");
				String password = rs.getString("PasswordHash");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String roleCode = rs.getString("URE_ID");
				String email = rs.getString("email");
				String phone = rs.getString("phone1");
				boolean removed = rs.getBoolean("removed");
				//creates an Employee object from the results
				Employee e = new Employee(userID, username, password, firstName, lastName, roleCode, email, phone, removed);
				//adds to the Employee ArrayList for use in the rest of the program
				employees.add(e);
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		System.out.println("employees added");
		return employees;
	}
	
	public ArrayList<Item> getInventory()
	{
		//sql query
		String query = "SELECT I.invID, I.item_name, I.retail_price, S.name, "
				+ "I.num_in_stock, I.reorder_amt, I.item_description, I.removed,"
				+ " S.supID FROM INVENTORY I LEFT OUTER JOIN SUPPLIER S ON "
				+ "I.SUP_id = S.supID";
		try{
			//creates a new statement
			Statement stmt = connection.createStatement();
			//returns the results after the statement is executed
			ResultSet rs = stmt.executeQuery(query);
			
			//runs through a loop of all results until none are left
			while(rs.next())
			{
				//creates variables of different result information
				String item_name = rs.getString("item_name");
				String invID = rs.getString("invID");
				Double price = rs.getDouble("retail_price");
				String supplier = rs.getString("name");
				String supplierID = rs.getString("supID");
				int quantity = rs.getInt("num_in_stock");
				int parStock = rs.getInt("reorder_amt");
				String item_description = rs.getString("item_description");
				boolean removed = rs.getBoolean("removed");
				//creates an Item object from the results
				Item i = new Item(item_name, invID, price, Integer.parseInt(supplierID), supplier, quantity, 
						parStock, item_description, removed);
				//adds to the Inventory ArrayList for use in the rest of the program
				items.add(i);
			}
		}
		//catches SQL exceptions
		catch (SQLException e)
		{
			//logs the exception
			System.out.println(e);
		}
		//notifies when all items are added
		System.out.println("inventory added");
		//returns inventory ArrayList
		return items;
	}
	
	//MyBusiness code complete
	public MyBusiness getMyBusinessData()
	{
		//initiates variable for MyBusiness information
		MyBusiness data = null;

		//sql query
		String query = "SELECT biz_name, st_address1, st_address2, city, state, "
				+ "zip_code, logo1, logo2, phone1, phone2, website, email, "
				+ "fax, owner_fname, owner_lname FROM MY_BUSINESS"; 
		
		try{
			//creates a new statement
			Statement stmt = connection.createStatement();
			//returns the results after the statement is executed
			ResultSet rs = stmt.executeQuery(query);

			
			//runs through a loop of all results until none are left
			while(rs.next()){
				//creates variables of different result information
				String bizName = rs.getString("biz_Name");
				String stAddress1 = rs.getString("st_address1");
				String stAddress2 = rs.getString("st_address2");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zipCode = rs.getInt("zip_code");
				File logo1 = null;//(File) rs.getObject("logo1");
				File logo2 = null;//(File) rs.getObject("logo2");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String website = rs.getString("website");
				String email = rs.getString("email");
				String fax = rs.getString("fax");
				String ownerFirstName = rs.getString("owner_fname");
				String ownerLastName = rs.getString("owner_lname");
				//creates a new MyBusiness object from the results
				data = new MyBusiness(bizName, stAddress1, stAddress2, city, state, zipCode,
						logo1, logo2, phone1, phone2, website, email, fax, ownerFirstName,
						ownerLastName);
			}
		}
		//catches SQL exceptions
		catch (SQLException e)
		{
			//logs the exception
			System.out.println(e);
		}
		//notifies when MyBusiness information is added
		System.out.println("business information added");
		//returns business information
		return data;
	}
	
	//supplier code complete
	public ArrayList<Supplier> getSuppliers()
	{
		//sql query
		String query = "SELECT name, supID, st_address1, st_address2, "
				+ "city, s_state, zip_code, logo, phone1, phone2, website, "
				+ "email, fax, removed FROM SUPPLIER"; 
		
		try{
			//creates a new statement
			Statement stmt = connection.createStatement();
			//returns the results after the statement is executed
			ResultSet rs = stmt.executeQuery(query);
			
			//runs through a loop of all results until none are left
			while(rs.next())
			{
				//creates variables of different result information
				String name = rs.getString("name");
				String id = rs.getString("supID");
				String st_address1 = rs.getString("st_address1");
				String st_address2 = rs.getString("st_address2");
				String city = rs.getString("city");
				String state = rs.getString("s_state");
				int zip_code = rs.getInt("zip_code");
				File logo = (File) rs.getObject("logo");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String website = rs.getString("website");
				String email = rs.getString("email");
				String fax = rs.getString("fax");
				boolean removed = rs.getBoolean("removed");
				//creates a Supplier object from the results
				Supplier s = new Supplier(name, Integer.parseInt(id), st_address1, st_address2,
						city, state, zip_code, logo, phone1, phone2, website,
						email, fax, removed);
				//adds to the Suppliers ArrayList for use in the rest of the program
				suppliers.add(s);
			}
		}
		//catches SQL exceptions
		catch (SQLException e)
		{
			//logs the exception
			System.out.println(e);
		}
		//notifies when all suppliers are added
		System.out.println("suppliers added");
		//returns suppliers ArrayList
		return suppliers;
	}
}