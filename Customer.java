public class Customer {

	private String ID;
	private String fName;
	private String lName;
	private String stAddress;
	private String city;
	private String state;
	private String zipCode;
	private String phone;
	private String email;
	
	public Customer (String firstName, String lastName, String stAddress1, String city1, String state1, String zipCode1,
			String phone1, String email1)
	{
		// this.ID = ID;
		this.fName = firstName;
		this.lName = lastName;
		this.stAddress = stAddress1;
		this.city = city1;
		this.state = state1;
		this.zipCode = zipCode1;
		this.phone = phone1;
		this.email = email1;
	}
	
	public Customer() {
	}

	public void setID (String ID)
	{
		this.ID = ID;
	}
	
	public String getID()
	{
		return ID.toString();
	}
	
	public void setFName (String fName)
	{
		this.fName = fName;
	}
	
	public String getFName()
	{
		return fName.toString();
	}
	
	public void setLName (String lName)
	{
		this.lName = lName;
	}
	
	public String getLName()
	{
		return lName.toString();
	}
	
	public void setStAdress1 (String stAddress1)
	{
		this.stAddress = stAddress1;
	}
	
	public String getStAdress1()
	{
		return stAddress.toString();
	}
	
	public void setCity (String city)
	{
		this.city = city;
	}
	public String getCity()
	{
		return city.toString();
	}
	
	public void setState (String state)
	{
		this.state = state;
	}
	
	public String getState()
	{
		return state.toString();
	}
	
	public void setZipCode (String zipCode)
	{
		this.zipCode = zipCode;
	}
	public String getZipCode()
	{
		return zipCode;
	}
	
	public void setPhone1 (String phone1)
	{
		this.phone = phone1;
	}
	
	public String getPhone1()
	{
		return phone;
	}
	
	public void setEmail (String email)
	{
		this.email = email;
	}

	public String getEmail()
	{
		return email.toString();
	}	
	
	public String toString()
	{
		String string = "";
		string += ID + " \t";
		string += fName + " \t";
		string += lName + " \t";
		string += stAddress + " \t";
		string += city + " \t";
		string += state + " \t";
		string += zipCode + " \t";
		string += phone + " \t";
		string += email + " \t";
		return string;
	}
	
	public void print(){
		String s = "";
		s += "Customer Name: " + this.fName + " " + this.lName + "\n";
		s += "Address: " + this.stAddress + "\n";
		s += "City: " + this.city + "\n";
		s += "State: " + this.state + "\n";
		s += "Zip: " + this.zipCode + "\n";
		s += "Phone Number: " + this.phone + "\n";
		s += "Email Address: " + this.email + "\n";
		System.out.println(s);
	}
}