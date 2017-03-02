import java.util.ArrayList;

public class Employee {
	
	private String username, password, firstName, lastName, email, phone, address;
	private String uRole;
	private String userId;
	
	private static int idNum = 123;
	
	public Employee(String uName, String pWord,String fName,String lName,String role, String eMale){
		this.userId = Integer.toString(idNum);
		idNum++;
		this.username = uName;
		this.password = pWord;
		this.firstName = fName;
		this.lastName = lName;
		this.uRole = role;
		this.email = eMale;
		this.phone = "";
		
	}
	
	public Employee(String uName, String pWord,String fName,String lName,String role, String eMale, String telNum){
		this.userId = Integer.toString(idNum);
		idNum++;
		this.username = uName;
		this.password = pWord;
		this.firstName = fName;
		this.lastName = lName;
		this.uRole = role;
		this.email = eMale;
		this.phone = telNum;
		
		
	}
	
	public Employee(){
		
	}
	
	public String getUserId(){
		return this.userId;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public String getRole(){
		return this.uRole;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setUsername(String uName){
		this.username = uName;
	}
	
	public void setPassword(String pWord){
		this.password = pWord;
	}
	
	public void setFirstName(String fName){
		this.firstName = fName;
	}
	
	public void setLastName(String lName){
		this.lastName = lName;
	}
	
	public void setRole(String role){
		this.uRole = role;
	}
	
	public void setEmail(String eMale){
		this.email = eMale;
	}
	
	public void setPhone(String tele){
		this.phone = tele;
	}
	
	public void setAddress(String add){
		this.address = add;
	}
	
	public void print(){
		String s = "";
		s += "Username: " + this.username + "\n";
		s += "Password: " + this.password + "\n";
		s += "First Name: " + this.firstName + "\n";
		s += "Last Name: " + this.lastName + "\n";
		s += "Employee Role: " + this.uRole + "\n";
		s += "Email Address: " + this.email + "\n";
		s += "Phone Number: " + this.phone + "\n";
		System.out.println(s);
	}
}
