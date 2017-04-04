import java.io.File;

public class MyBusiness {

	private String bizName;
	private String stAddress1;
	private String stAddress2;
	private String city;
	private String state;
	private int zipCode;
	private File logo1;
	private File logo2;
	private String phone1;
	private String phone2;
	private String website;
	private String email;
	private String fax;
	private String ownerFirstName;
	private String ownerLastName;
	
	public MyBusiness (){
	}
	
	public MyBusiness (String bizName, String stAddress1, String stAddress2, 
			String city, String state, int zipCode, File logo1, File logo2, 
			String phone1, String phone2, String website, String email, String fax,
			String ownerFirstName, String ownerLastName)
	{
		this.bizName = bizName;
		this.stAddress1 = stAddress1;
		this.stAddress2 = stAddress2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.logo1 = logo1;
		this.logo2 = logo2;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.website = website;
		this.email = email;
		this.fax = fax;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
	}
	
	public void setBizName (String bizName)
	{
		this.bizName = bizName;
	}
	
	public String getBizName()
	{
		return bizName.toString();
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

	public void setLogo2 (File logo2)
	{
		this.logo2 = logo2;
	}
	
	public File getLogo2()
	{
		return logo2;
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
	
	public void setFax (String fax)
	{
		this.fax = fax;
	}

	public String getFax()
	{
		return fax;
	}
	
	public void setOwnerFirstName (String ownerFirstName)
	{
		this.ownerFirstName = ownerFirstName;
	}
	
	public String getOwnerFirstName()
	{
		return ownerFirstName;
	}
	
	public void setOwnerLastName (String ownerLastName)
	{
		this.ownerLastName = ownerLastName;
	}
	
	public String getOwnerLastName()
	{
		return ownerLastName;
	}

	
}


