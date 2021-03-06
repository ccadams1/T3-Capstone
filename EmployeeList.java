import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
	//sets up variables
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	//default constructor
	public EmployeeList(){
	}
	
	//populates employee arrayLsit
	public void populate(ArrayList<Employee> employees){
		this.employees = employees;
	}
	
	//returns arrayList size
	public int size(){
		return employees.size();
	}
	
	//check the employee based on username
	public boolean checkForUsername(String user){
		for(int i = 0; i < employees.size(); i++){
			if(employees.get(i).getUsername().equals(user)){
				return true;
			}
		}
		return false;
	}
	
	//check the employee based on first and last name
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
	
	//gets employee based on index
	public Employee get(int index){
		return employees.get(index);
	}
	
	//add employee to arrayList
	public void addEmployee(Employee emp){
		emp.print();
		employees.add(emp);
	}
	
	//gets employee based on username
	public Employee getEmployee(String uName){
		Employee temp = new Employee();
		for(int i = 0; i < employees.size(); i++){
			if(employees.get(i).getUsername().equals(uName)){
				temp = employees.get(i);
			}
		}
		return temp;
	}
	
	//gets employee based on first and last name
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
	
	//displays all employees
	public String toString(){
		String s = "";
		s += "UserID\t" + "Username\t" + "First Name\t" + 
		"Last Name\t" + "Role\t" + "Email\t\t" + "Phone\n";
		s += "-------------------------------------------------------------------------";
		s += "-------------------------------------------------------------------------";
		s += "-------------------------------------------------------------------------\n";
		
		for(int i = 0; i < employees.size(); i++)
		{
			if(!employees.get(i).isRemoved())
			{
				s += employees.get(i).getUserId() + "\t" + employees.get(i).getUsername();
				s += "\t" + employees.get(i).getFirstName();
				s += "\t" + employees.get(i).getLastName() + "\t" + employees.get(i).getRole();
				s += "\t" + employees.get(i).getEmail() + "\t" + employees.get(i).getPhone() + "\n";
			}
		}
		return s;
	}

	//returns the employee arrayList
	public List<Employee> getList() {
		return employees;
	}
}
