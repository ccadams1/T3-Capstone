import java.util.ArrayList;
import java.util.List;

public class CustomerList {
	//initiate variable
	public ArrayList<Customer> customers = new ArrayList<Customer>();
	
	//default constructor
	public CustomerList(){
	}
	
	//populates arrayList
	public void populate(ArrayList<Customer> customer){
		this.customers = customer;
	}
	
	//returns arrayList size
	public int size(){
		return customers.size();
	}
	
	//checks for supplier based on id
	public boolean checkForSupplier(String Id){
		for(int i = 0; i < customers.size(); i++){
			if(customers.get(i).getID().equals(Id)){
				return true;
			}
		}
		return false;
	}
	
	//returns customer based on index
	public Customer getCustomer(int index){
		return customers.get(index);
	}
	
	//adds customer to the arrayList
	public void addCustomer(Customer cust){
		customers.add(cust);
	}
	
	//returns customer based on first and last name
	public Customer getCustomer(String firstName, String lastName){
		Customer temp = null;
		for(int i = 0; i < customers.size(); i++){
			if(customers.get(i).getFName().equals(firstName)){
				if(customers.get(i).getLName().equals(lastName)){
					temp = customers.get(i);
				}
			}
		}
		return temp;
	}

	//returns customer arrayList
	public ArrayList<Customer> getList() {
		return customers;
	}
}