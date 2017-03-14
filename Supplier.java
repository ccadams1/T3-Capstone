import java.io.File;

public class Supplier {

	private String name;
	private String prettyCode;
	private String stAddress1;
	private String stAddress2;
	private String city;
	private String state;
	private int zipCode;
	private File logo1;
	private int phone1;
	private int phone2;
	private String website;
	private String email;
	private int fax;
	
	public Supplier (String name, String prettyCode, String stAddress1, String stAddress2, String city, String state, int zipCode,
			File logo1, int phone1, int phone2, String website, String email, int fax)
	{
		this.name = name;
		this.prettyCode = prettyCode;
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
	
	public void setPrettyCode (String prettyCode)
	{
		this.prettyCode = prettyCode;
	}
	
	public String getPrettyCode()
	{
		return prettyCode.toString();
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
	
	public void setFax (int fax)
	{
		this.fax = fax;
	}

	public int getFax()
	{
		return fax;
	}
}
