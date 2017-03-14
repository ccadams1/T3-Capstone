import java.sql.*;

public class DatabaseConnection {
	public static String username;
	public static String password;
	public static String serverName = "t3tisvr.database.windows.net";
	public static String portNumber = "1433";
	
	public DatabaseConnection()
	{
		DatabaseConnection.username = "t3tiadmin@t3tisvr";
		DatabaseConnection.password = "T3!admin";
	}
	
	public DatabaseConnection(String username, String password)
	{
		DatabaseConnection.username = username;
		DatabaseConnection.password = password;
	}
	
	//Connect to your database.
	//Replace server name, username, and password with your credentials
	public Connection getConnection() throws SQLException{
		String connectionString =
			"jdbc:sqlserver://t3tisvr.database.windows.net:1433;"
			+ "database=T3_TI_WTCC;" + "user=" + username + ";"
			+ "password=" + password + ";"
			+ "encrypt=true;"
			+ "trustServerCertificate=false;"
			+ "hostNameInCertificate=*.database.windows.net;"
			+ "loginTimeout=30;";
		
		//Declare the JDBC objects.
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			System.out.println("Connected to database");
		}
		catch (Exception e) {
			e.printStackTrace();	
			System.out.println("Connection issue");
		}
		
		return connection;
	}

} 