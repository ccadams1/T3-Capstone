import java.io.File;

public class Supplier {

	private String name;
	private String Id;
	private String stAddress;
	private String city;
	private String state;
	private String zipCode;
	private String phone;
	private String website;
	private String email;
	private boolean removed;
	
	public Supplier (String name1, String stAddress1, String city1, String state1, String zipCode1,
			String email1, String website1, String phone1)
	{
		this.name = name1;
		// need to auto generate this.Id = Id;
		this.stAddress = stAddress1;
		this.city = city1;
		this.state = state1;
		this.zipCode = zipCode1;
		this.phone = phone1;
		this.website = website1;
		this.email = email1;
	}
	
	public Supplier() {
	}

	public void setName (String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name.toString();
	}
	
	public void setID (String Id)
	{
		this.Id = Id;
	}
	
	public String getID()
	{
		return Id;
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
	
	public void setPhone (String phone1)
	{
		this.phone = phone1;
	}
	
	public String getPhone1()
	{
		return phone;
	}
	
	public void setWebsite( String website)
	{
		this.website = website;
	}

	public String getWebsite()
	{
		return website.toString();
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
		string += Id + " \t";
		string += name + " \t";
		string += stAddress + " \t";
		string += city + " \t";
		string += state + " \t";
		string += zipCode + " \t";
		string += phone + " \t";
		string += website + " \t";
		string += email + " \t";
		return string;
	}
	
	public void print(){
		String s = "";
		s += "Supplier Name: " + this.name + "\n";
		s += "Address: " + this.stAddress + "\n";
		s += "City: " + this.city + "\n";
		s += "State: " + this.state + "\n";
		s += "Zip: " + this.zipCode + "\n";
		s += "Email Address: " + this.email + "\n";
		s += "Website: " + this.website + "\n";
		s += "Phone Number: " + this.phone + "\n";
		System.out.println(s);
	}
}
