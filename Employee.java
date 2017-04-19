public class Employee {
	
	private String username, password, firstName;
	private String lastName, email, uRole;
	private String userID, phone, address;
	private int roleCode;
	private boolean removed;
		
	public Employee(){
		
	}
	
	//populate database
	public Employee(String userID, String uName, String pWord,String fName,String lName, String role, String email, String phone, boolean removed){
		this.userID = userID;
		this.username = uName;
		this.password = pWord;
		this.firstName = fName;
		this.lastName = lName;
		setRoleCode(role);
		this.uRole = role;
		this.email = email;
		this.phone = phone;
		this.removed = removed;
	}
	
	//adding new user
	public Employee(String uName, String pWord,String fName,String lName,String role, String email, String phone){
		this.userID = "";
		this.username = uName;
		this.password = pWord;
		this.firstName = fName;
		this.lastName = lName;
		this.uRole = role;
		setRoleCode(role);
		this.email = email;
		this.phone = phone;
		this.removed = false;
	}
	
	public String getUserId(){
		return this.userID;
	}
	
	public int getIntUserID(){
		int id = Integer.parseInt(this.userID);
		return id;
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
	
	public void setUserId(int id){
		this.userID = id + "";
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
	
	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}

	public void setRoleCode(String role)
	{
		if(role == null)
		{
			roleCode = 1;
		}
		else if(role.equals("Overall Manager"))
		{
			roleCode = 2;
		}
		else if(role.equals("Inventory Manager"))
		{
			roleCode = 3;
		}
		else if(role.equals("POS Manager"))
		{
			roleCode = 4;
		}
		else if(role.equals("Inventory User"))
		{
			roleCode = 5;
		}
		else
		{
			roleCode = 6;
		}
	}
	
	public void setRoleCode(int role)
	{
		this.roleCode = role;
	}
	
	public String getRoleFromCode()
	{
		if(roleCode == 1)
		{
			uRole = "Administrator";
		}
		else if(roleCode == 2)
		{
			uRole = "Overall Manager";
		}
		else if(roleCode == 3)
		{
			uRole = "Inventory Manager";
		}
		else if(roleCode == 4)
		{
			uRole = "POS Manager";
		}
		else if(roleCode == 5)
		{
			uRole = "Inventory User";
		}
		else
		{
			uRole = "POS User";
		}
		return uRole;
	}
	
	public int getRoleCode()
	{
		return roleCode;
	}
	
	public void print(){
		String s = "";
		s += "Username: " + this.username + "\n";
		s += "First Name: " + this.firstName + "\n";
		s += "Last Name: " + this.lastName + "\n";
		s += "Employee Role: " + this.uRole + "\n";
		s += "Email Address: " + this.email + "\n";
		s += "Phone Number: " + this.phone + "\n";
		System.out.println(s);
	}
}
