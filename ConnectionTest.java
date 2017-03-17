import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionTest {

public static void main(String[] args) throws SQLException {
	// TODO Auto-generated method stub
	DatabaseConnection data = new DatabaseConnection();
	Connection dataLink = data.getConnection();
	PullDatabase pull = new PullDatabase(dataLink);
	
	EmployeeList employees = new EmployeeList(); 
	employees.populate(pull.getEmployees());
	/*
	String query = "SELECT item_name from inventory";

	Statement stmt = null;
	
	try{
		stmt = dataLink.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next())
		{
			String itemName = rs.getString("item_name");
			System.out.println(itemName);
		}
	}
	catch (SQLException e ) {
	e.printStackTrace();
	}
	finally {
		if (stmt != null)
		{
			stmt.close();
		}
	}*/
	}
} 