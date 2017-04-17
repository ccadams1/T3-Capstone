public class Customer {

	private String ID;
	private String fName;
	private String lName;
	private String stAddress1;
	private String stAddress2;
	private String city;
	private String state;
	private int zipCode;
	private String phone1;
	private String phone2;
	private String website;
	private String email;
	private String fax;
	
	public Customer (String ID, String fName, String lName, String stAddress1, String stAddress2, String city, String state, int zipCode,
			String phone1, String phone2, String email, String fax)
	{
		this.ID = ID;
		this.fName = fName;
		this.lName = lName;
		this.stAddress1 = stAddress1;
		this.stAddress2 = stAddress2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.fax = fax;
	}

	public Customer(String firstName, String lastName, String cusAddress, String cusCity, String cusState,
			int cusZip, String cusPhone, String cusEmail) {
		this.ID = null;
		this.fName = firstName;
		this.lName = lastName;
		this.stAddress1 = cusAddress;
		this.stAddress2 = "";
		this.city = cusCity;
		this.state = cusState;
		this.zipCode = cusZip;
		this.phone1 = cusPhone;
		this.phone2 = "";
		this.email = cusEmail;
		this.fax = "";	}

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
		this.stAddress1 = stAddress1;
	}
	
	public String getStAdress1()
	{
		return stAddress1.toString();
	}
	
	public void setStAdress2 (String stAddress2)
	{
		this.stAddress2 = stAddress2;
	}
	
	public String getStAdress2()
	{
		return stAddress2.toString();
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
	
	public void setZipCode (int zipCode)
	{
		this.zipCode = zipCode;
	}
	public int getZipCode()
	{
		return zipCode;
	}
	
	public void setPhone1 (String phone1)
	{
		this.phone1 = phone1;
	}
	
	public String getPhone1()
	{
		return phone1;
	}
	
	public void setPhone2 (String phone2)
	{
		this.phone2 = phone2;
	}
	
	public String getPhone2()
	{
		return phone2;
	}
	
	public void setEmail (String email)
	{
		this.email = email;
	}

	public String getEmail()
	{
		return email.toString();
	}
	
	public void setFax (String fax)
	{
		this.fax = fax;
	}

	public String getFax()
	{
		return fax;
	}
	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String toString()
	{
		String string = "";
		string += ID + " \t";
		string += fName + " \t";
		string += lName + " \t";
		string += stAddress1 + "\t\t";
		string += city + " \t";
		string += state + " \t";
		string += zipCode + " \t";
		string += phone1 + " \t";
		string += phone2 + " \t";
		string += email + " \t";
		string += fax + " \t";
		return string;
	}
	
	public void print(){
		String s = "";
		s += "Customer Name: " + this.fName + " " + this.lName + "\n";
		s += "Address: " + this.stAddress1 + "\n";
		s += "City: " + this.city + "\n";
		s += "State: " + this.state + "\n";
		s += "Zip: " + this.zipCode + "\n";
		s += "Phone Number: " + this.phone1 + "\n";
		s += "Email Address: " + this.email + "\n";
		System.out.println(s);
	}
}