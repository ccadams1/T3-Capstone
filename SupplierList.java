import java.util.ArrayList;
import java.util.List;

public class SupplierList {
	//initiates variable
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	
	//default constructor
	public SupplierList(){
	}
	
	//populates supplier arrayList
	public void populate(ArrayList<Supplier> suppliers){
		this.suppliers = suppliers;
	}
	
	//returns arrayList size
	public int size(){
		return suppliers.size();
	}
	
	//check for supplier based on name
	public boolean checkForSupplier(String supplier){
		for(int i = 0; i < suppliers.size(); i++){
			if(suppliers.get(i).getName().equals(supplier)){
				return true;
			}
		}
		return false;
	}
	
	//gets supplier from the arrayList index
	public Supplier getSupplier(int index){
		return suppliers.get(index);
	}
	
	//adds supplier to arrayList
	public void addSupplier(Supplier sup){
		suppliers.add(sup);
	}
	
	//gets supplier based on name
	public Supplier getSupplier(String supplierName){
		Supplier temp = new Supplier();
		for(int i = 0; i < suppliers.size(); i++){
			if(suppliers.get(i).getName().equals(supplierName)){
				temp = suppliers.get(i);
			}
		}
		return temp;
	}

	//returns supplier arrayList
	public ArrayList<Supplier> getList() {
		return suppliers;
	}

	//copies supplier arrayList
	public ArrayList<Supplier> getListCopy() {
		ArrayList<Supplier> copy = new ArrayList<Supplier>();
		for(int x = 0; x < suppliers.size(); x++)
		{
			Supplier temp = suppliers.get(x);
			copy.add(temp);
		}
		return copy;
	}
}
