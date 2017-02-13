import java.util.ArrayList;

public class Employee {
	
	private boolean masterUser, invManager, invUser, posManager, posUser;
	private String username, password, firstName, lastName, email, phone, address;
	
	public Employee(String uName, String pWord,String fName,String lName,String eMale){
		this.username = uName;
		this.password = pWord;
		this.firstName = fName;
		this.lastName = lName;
		this.email = eMale;
		
		masterUser = false;
		invManager = false;
		invUser = false;
		posManager = false;
		posUser = false;
	}
	
	public Employee(){
		
	}
	
	public String getUser(){
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
	
	public String getEmail(){
		return this.email;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setUser(String uName){
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
	
	public void setEmail(String eMale){
		this.email = eMale;
	}
	
	public void setPhone(String tele){
		this.phone = tele;
	}
	
	public void setAddress(String add){
		this.address = add;
	}
	
	public void setMasterUser(boolean bool){
		this.masterUser = bool;
	}
	
	public void setInvManager(boolean bool){
		this.invManager = bool;
	}
	
	public void setInvUser(boolean bool){
		this.invUser = bool;
	}
	
	public void setPosManager(boolean bool){
		this.posManager = bool;
	}
	
	public void setPosUser(boolean bool){
		this.posUser = bool;
	}
	
	
}
