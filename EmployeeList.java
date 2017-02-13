import java.util.ArrayList;

public class EmployeeList {
	
	private ArrayList<Employee> employees;
	
	public EmployeeList(){
		employees = new ArrayList<Employee>();
	}
	
	public void populate(){
		//code to populate list from database connection
	}
	
	public boolean checkForUsername(String user){
		for(int i = 0; i < employees.size(); i++){
			if(employees.get(i).getUser().equals(user)){
				return true;
			}
		}
		return false;
	}
	
	public boolean checkForUser(String fName, String lName){
		for(int i = 0; i < employees.size(); i++){
			if(employees.get(i).getFirstName().equals(fName)){
				if(employees.get(i).getLastName().equals(lName)){
					return true;
				}	
			}
		}
		return false;
	}
	
	public Employee getEmployee(int index){
		return employees.get(index);
	}
	
	public Employee getEmployee(String uName){
		Employee temp = new Employee();
		for(int i = 0; i < employees.size(); i++){
			if(employees.get(i).getUser().equals(uName)){
				temp = employees.get(i);
			}
		}
		return temp;
	}
	
	public Employee getEmployee(String fName, String lName){
		Employee temp = new Employee();
		for(int i = 0; i < employees.size(); i++){
			if(employees.get(i).getFirstName().equals(fName)){
				if(employees.get(i).getLastName().equals(lName)){
					temp = employees.get(i);
				}	
			}
		}
		return temp;
	}
	
	
	
}
