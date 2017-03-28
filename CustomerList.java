import java.util.ArrayList;
import java.util.List;

public class CustomerList {
	
	public ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public CustomerList(){
	}
	
	public void populate(ArrayList<Customer> customer){
		this.customers = customer;
	}
	
	public int size(){
		return customers.size();
	}
	
	public boolean checkForSupplier(String Id){
		for(int i = 0; i < customers.size(); i++){
			if(customers.get(i).getID().equals(Id)){
				return true;
			}
		}
		return false;
	}
	
	public Customer getCustomer(int index){
		return customers.get(index);
	}
	
	public void addCustomer(Customer cust){
		customers.add(cust);
	}
	
	public Customer getCustomer(String firstName, String lastName){
		Customer temp = new Customer();
		for(int i = 0; i < customers.size(); i++){
			if(customers.get(i).getFName().equals(firstName)){
				if(customers.get(i).getLName().equals(lastName)){
					temp = customers.get(i);
				}
			}
		}
		return temp;
	}
	
	public String toString(){
		return null;
	}

	public ArrayList<Customer> getList() {
		return customers;
	}
}
