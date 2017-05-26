package db;

import java.util.ArrayList;

public class Component extends DataBaseObject{
	private String name;
	private ArrayList<Supplier> suppliers = new ArrayList<>();
	
	public Component(String name){
	    this.name = name;
	}

    public String getName() {
        return name;
    }

    public void addSupplier(Supplier supplier){
		this.suppliers.add(supplier);
	}
	
	public void removeSupplier(Supplier supplier){
		this.suppliers.remove(supplier);
	}

	@Override
	public void save() {
		DataBase.getDB().addComponent(this);
		
	}
}
