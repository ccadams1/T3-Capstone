import java.util.ArrayList;
import java.util.List;

public class SupplierList {
	
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	
	public SupplierList(){
	}
	
	public void populate(ArrayList<Supplier> suppliers){
		this.suppliers = suppliers;
	}
	
	public int size(){
		return suppliers.size();
	}
	
	public boolean checkForSupplier(String supplier){
		for(int i = 0; i < suppliers.size(); i++){
			if(suppliers.get(i).getName().equals(supplier)){
				return true;
			}
		}
		return false;
	}
	
	public Supplier getSupplier(int index){
		return suppliers.get(index);
	}
	
	public void addSupplier(Supplier sup){
		suppliers.add(sup);
	}
	
	public Supplier getSupplier(String supplierName){
		Supplier temp = new Supplier();
		for(int i = 0; i < suppliers.size(); i++){
			if(suppliers.get(i).getName().equals(supplierName)){
				temp = suppliers.get(i);
			}
		}
		return temp;
	}
	
	public String toString(){
		return null;
	}

	public ArrayList<Supplier> getList() {
		return suppliers;
	}

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
