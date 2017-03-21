public class Customer {

	private String prettyCode;
	private String fName;
	private String lName;
	private String stAddress1;
	private String stAddress2;
	private String city;
	private String state;
	private int zipCode;
	private int phone1;
	private int phone2;
	private String website;
	private String email;
	private int fax;
	
	public Customer (String prettyCode, String fName, String lName, String stAddress1, String stAddress2, String city, String state, int zipCode,
			int phone1, int phone2, String email, int fax)
	{
		this.prettyCode = prettyCode;
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
	
	public Customer() {
	}

	public void setPrettyCode (String prettyCode)
	{
		this.prettyCode = prettyCode;
	}
	
	public String getPrettyCode()
	{
		return prettyCode.toString();
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
	
	public void setPhone1 (int phone1)
	{
		this.phone1 = phone1;
	}
	
	public int getPhone1()
	{
		return phone1;
	}
	
	public void setPhone2 (int phone2)
	{
		this.phone2 = phone2;
	}
	
	public int getPhone2()
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
	
	public void setFax (int fax)
	{
		this.fax = fax;
	}

	public int getFax()
	{
		return fax;
	}
	
	public String toString()
	{
		String string = "";
		string += prettyCode + " ";
		string += fName + " ";
		string += lName + " ";
		string += city + " ";
		string += state + " ";
		string += zipCode + " ";
		string += phone1 + " ";
		string += phone2 + " ";
		string += email + " ";
		string += fax + " ";
		return string;
	}
}
