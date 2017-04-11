import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class Procedure {
	/*protected int callAddUserProcedure(Connection connect, Employee temp) 
	{
		CallableStatement stmt = null;
		
		int id = -1;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspAddUser(?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, temp.getUsername());
			stmt.setString(2, temp.getPassword());
			stmt.setString(3, temp.getFirstName());
			stmt.setString(4, temp.getLastName());
			stmt.setInt(5, 1);//temp.getRole()
			stmt.setString(6, temp.getEmail());
			stmt.setString(7, temp.getPhone());
			stmt.setInt(8, 0);//temp.isRemoved()
			stmt.registerOutParameter(9, Types.VARCHAR);
			stmt.registerOutParameter(10, Types.INTEGER);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add new user");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(9);
			id = stmt.getInt(10);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return id;
	}*/
	/*protected void callEditUserProcedure(Connection connect, Employee temp) 
	{
		CallableStatement stmt = null;
			
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditUser(?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setInt(1, Integer.parseInt(temp.getUserId()));
			stmt.setString(2, temp.getUsername());
			stmt.setString(3, temp.getPassword());
			stmt.setString(4, temp.getFirstName());
			stmt.setString(5, temp.getLastName());
			stmt.setInt(6, 1);//temp.getRole()
			stmt.setString(7, temp.getEmail());
			stmt.setString(8, temp.getPhone());
			stmt.setInt(9, 0);//temp.isRemoved()
			stmt.registerOutParameter(10, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to edit user");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(10);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}*/
	/*protected void callRemoveUserProcedure(Connection connect, Employee temp) 
	{
		CallableStatement stmt = null;
			
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditUser(?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setInt(1, Integer.parseInt(temp.getUserId()));
			stmt.setString(2, temp.getUsername());
			stmt.setString(3, temp.getPassword());
			stmt.setString(4, temp.getFirstName());
			stmt.setString(5, temp.getLastName());
			stmt.setInt(6, 1);//temp.getRole()
			stmt.setString(7, temp.getEmail());
			stmt.setString(8, temp.getPhone());
			stmt.setInt(9, 1);//temp.isRemoved()
			stmt.registerOutParameter(10, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to remove user");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(10);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}*/
	/*protected void callUserLoginProcedure(Connection connect, Employee temp) 
	{
		CallableStatement stmt = null;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspLogin(?,?,?)}");
			
			//set the parameters
			stmt.setString(1, temp.getUsername());
			stmt.setString(2, temp.getPassword());
			stmt.registerOutParameter(3, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to login to employee");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(3);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}*/
	/*protected int callAddSupplierProcedure(Connection connect, Supplier temp) {
		CallableStatement stmt = null;
			
		int id = -1;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspAddSupplier(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, temp.getName());
			stmt.setString(2, temp.getStAdress1());
			stmt.setString(3, temp.getStAdress2());
			stmt.setString(4, temp.getCity());
			stmt.setString(5, temp.getState());
			stmt.setInt(6, temp.getZipCode());
			stmt.setString(7, null);
			stmt.setString(8, temp.getPhone1());
			stmt.setString(9, temp.getPhone2());
			stmt.setString(10, temp.getWebsite());
			stmt.setString(11, temp.getEmail());
			stmt.setString(12, temp.getFax());
			stmt.setInt(13, 0);//temp.isRemoved()
			stmt.registerOutParameter(14, Types.VARCHAR);
			stmt.registerOutParameter(15, Types.INTEGER);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add new supplier");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(14);
			id = stmt.getInt(15);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return id;
	}*/
	protected void callEditSupplierProcedure(Connection connect, Supplier temp) {
		CallableStatement stmt = null;
			
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditSupplier(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, temp.getID());
			stmt.setString(2, temp.getName());
			stmt.setString(3, temp.getStAdress1());
			stmt.setString(4, temp.getStAdress2());
			stmt.setString(5, temp.getCity());
			stmt.setString(6, temp.getState());
			stmt.setInt(7, temp.getZipCode());
			stmt.setString(8, null);
			stmt.setString(9, temp.getPhone1());
			stmt.setString(10, temp.getPhone2());
			stmt.setString(11, temp.getWebsite());
			stmt.setString(12, temp.getEmail());
			stmt.setString(13, temp.getFax());
			stmt.setInt(14, /*temp.isRemoved()*/0);
			stmt.registerOutParameter(15, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to edit supplier");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(15);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	protected void callRemoveSupplierProcedure(Connection connect, Supplier temp){
		CallableStatement stmt = null;
			
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditSupplier(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, temp.getID());
			stmt.setString(2, temp.getName());
			stmt.setString(3, temp.getStAdress1());
			stmt.setString(4, temp.getStAdress2());
			stmt.setString(5, temp.getCity());
			stmt.setString(6, temp.getState());
			stmt.setInt(7, temp.getZipCode());
			stmt.setString(8, null);
			stmt.setString(9, temp.getPhone1());
			stmt.setString(10, temp.getPhone2());
			stmt.setString(11, temp.getWebsite());
			stmt.setString(12, temp.getEmail());
			stmt.setString(13, temp.getFax());
			stmt.setInt(14, /*temp.isRemoved()*/1);
			stmt.registerOutParameter(15, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to remove Supplier");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(15);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	protected int callAddCustomerProcedure(Connection connect, Customer temp) {
		CallableStatement stmt = null;
		
		int id = -1;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspAddCustomer(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, temp.getFName());
			stmt.setString(2, temp.getLName());
			stmt.setString(3, temp.getStAdress1());
			stmt.setString(4, temp.getStAdress2());
			stmt.setString(5, temp.getCity());
			stmt.setString(6, temp.getState());
			stmt.setInt(7, temp.getZipCode());
			stmt.setString(8, temp.getPhone1());
			stmt.setString(9, temp.getPhone2());
			stmt.setString(10, temp.getWebsite());
			stmt.setString(11, temp.getEmail());
			stmt.setString(12, temp.getFax());
			stmt.registerOutParameter(13, Types.VARCHAR);
			stmt.registerOutParameter(14, Types.INTEGER);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add new customer");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(13);
			id = stmt.getInt(14);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return id;
	}
	/*protected void callEditCustomerProcedure(Connection connect, Customer temp) {
		CallableStatement stmt = null;
				
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditCustomer(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, temp.getID());
			stmt.setString(2, temp.getFName());
			stmt.setString(3, temp.getLName());
			stmt.setString(4, temp.getStAdress1());
			stmt.setString(5, temp.getStAdress2());
			stmt.setString(6, temp.getCity());
			stmt.setString(7, temp.getState());
			stmt.setInt(8, temp.getZipCode());
			stmt.setString(9, temp.getPhone1());
			stmt.setString(10, temp.getPhone2());
			stmt.setString(11, temp.getWebsite());
			stmt.setString(12, temp.getEmail());
			stmt.setString(13, temp.getFax());
			stmt.registerOutParameter(14, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to edit customer");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(14);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}*/
	/*protected int callAddItemProcedure(Connection connect, Item temp) {
		CallableStatement stmt = null;
		
		int id = -1;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspAddItem(?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, null);
			stmt.setString(2, temp.getName());
			stmt.setString(3, temp.getDescription());
			stmt.setInt(4, temp.getQuantity());
			stmt.setInt(5, temp.getParStock());
			stmt.setDouble(6, temp.getPrice());
			stmt.setInt(7, temp.getSupplierID());
			stmt.setInt(8, 0);//temp.isRemoved()
			stmt.registerOutParameter(9, Types.VARCHAR);
			stmt.registerOutParameter(10, Types.INTEGER);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add new item");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(9);
			id = stmt.getInt(10);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return id;
	}*/
	/*protected void callEditItemProcedure(Connection connect, Item temp) {
		CallableStatement stmt = null;
				
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditItem(?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, temp.getId());
			stmt.setString(2, null);
			stmt.setString(3, temp.getName());
			stmt.setString(4, temp.getDescription());
			stmt.setInt(5, temp.getQuantity());
			stmt.setInt(6, temp.getParStock());
			stmt.setDouble(7, temp.getPrice());
			stmt.setInt(8, temp.getSupplierID());
			stmt.setInt(9, 0);//temp.isRemoved()
			stmt.registerOutParameter(10, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add new user");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(10);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}*/
	/*protected void callRemoveInventoryProcedure(Connection connect, Item temp){
		CallableStatement stmt = null;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditItem(?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, temp.getId());
			stmt.setString(2, null);
			stmt.setString(3, temp.getName());
			stmt.setString(4, temp.getDescription());
			stmt.setInt(5, temp.getQuantity());
			stmt.setInt(6, temp.getParStock());
			stmt.setDouble(7, temp.getPrice());
			stmt.setInt(8, temp.getSupplierID());
			stmt.setInt(9, 1);//temp.isRemoved()
			stmt.registerOutParameter(10, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add new user");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(10);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}*/
	protected void callAddMyBusinessProcedure(Connection connect, MyBusiness business) {
		CallableStatement stmt = null;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspAddMyBusiness(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, business.getBizName());
			stmt.setString(2, business.getStAdress1());
			stmt.setString(3, business.getStAdress2());
			stmt.setString(4, business.getCity());
			stmt.setString(5, business.getState());
			stmt.setInt(6, business.getZipCode());
			stmt.setString(7, null);
			stmt.setString(8, null);
			stmt.setString(9, business.getPhone1());
			stmt.setString(10, business.getPhone2());
			stmt.setString(11, business.getWebsite());
			stmt.setString(12, business.getEmail());
			stmt.setString(13, business.getFax());
			stmt.setString(14, business.getOwnerFirstName());
			stmt.setString(15, business.getOwnerLastName());
			stmt.registerOutParameter(16, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add new user");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(10);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	/*protected void callEditMyBusinessProcedure(Connection connect, MyBusiness business) {
		CallableStatement stmt = null;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditMyBusiness(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setString(1, business.getBizName());
			stmt.setString(2, business.getStAdress1());
			stmt.setString(3, business.getStAdress2());
			stmt.setString(4, business.getCity());
			stmt.setString(5, business.getState());
			stmt.setInt(6, business.getZipCode());
			stmt.setString(7, null);
			stmt.setString(8, null);
			stmt.setString(9, business.getPhone1());
			stmt.setString(10, business.getPhone2());
			stmt.setString(11, business.getWebsite());
			stmt.setString(12, business.getEmail());
			stmt.setString(13, business.getFax());
			stmt.setString(14, business.getOwnerFirstName());
			stmt.setString(15, business.getOwnerLastName());
			stmt.registerOutParameter(16, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add new user");
			stmt.execute();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(10);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}*/
}