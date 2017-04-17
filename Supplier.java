import java.io.File;

public class Supplier {

	private String name;
	private int Id;
	private String stAddress1;
	private String stAddress2;
	private String city;
	private String state;
	private int zipCode;
	private File logo1;
	private String phone1;
	private String phone2;
	private String website;
	private String email;
	private String fax;
	private boolean removed;
	
	public Supplier (String name, int Id, String stAddress1, String stAddress2, String city, String state, int zipCode,
			File logo1, String phone1, String phone2, String website, String email, String fax, boolean r)
	{
		this.name = name;
		this.Id = Id;
		this.stAddress1 = stAddress1;
		this.stAddress2 = stAddress2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.logo1 = logo1;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.website = website;
		this.email = email;
		this.fax = fax;
		this.setRemoved(r);
	}
	public Supplier (String name, String stAddress1,String city, String state, int zipCode,
			String email, String website, String phone1)
	{
		this.name = name;
		this.stAddress1 = stAddress1;
		this.stAddress2 = "";
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.logo1 = null;
		this.phone1 = phone1;
		this.phone2 = "";
		this.website = website;
		this.email = email;
		this.fax = "";
		this.setRemoved(false);
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
	
	public void setID (int i)
	{
		this.Id = i;
	}
	
	public int getID()
	{
		return Id;
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
	
	public void setLogo1 (File logo1)
	{
		this.logo1 = logo1;
	}
	
	public File getLogo1()
	{
		return logo1;
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
	
	public void setWebsite( String website)
	{
		this.website = website;
	}

	public String getWebsite()
	{
		return website;
	}
	
	public void setEmail (String email)
	{
		this.email = email;
	}

	public String getEmail()
	{
		return email;
	}
	
	public void setFax (String fax)
	{
		this.fax = fax;
	}

	public String getFax()
	{
		return fax;
	}

	public boolean isRemoved() {
		return removed;
	}
	public void setRemoved(boolean removed) {
		this.removed = removed;
	}
	
	public String toString()
	{
		String string = "";
		string += Id + " \t";
		string += name + " \t";
		string += stAddress1 + " \t";
		string += city + " \t";
		string += state + " \t";
		string += zipCode + " \t";
		string += phone1 + " \t";
		string += website + " \t";
		string += email + " \t";
		string += fax + " \t";
		return string;
	}

	public void print(){
		String s = "";
		s += "Supplier Name: " + this.name + "\n";
		s += "Address: " + this.stAddress1 + "\n";
		s += "City: " + this.city + "\n";
		s += "State: " + this.state + "\n";
		s += "Zip: " + this.zipCode + "\n";
		s += "Email Address: " + this.email + "\n";
		s += "Website: " + this.website + "\n";
		s += "Phone Number: " + this.phone1 + "\n";
		System.out.println(s);
	}
}
