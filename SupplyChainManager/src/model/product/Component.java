package model.product;

import java.util.ArrayList;

import database.DataBase;
import database.DataBaseObject;
import model.Supplier;

public class Component implements DataBaseObject{
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
	
	@Override
	public String toString() {
		return this.name;
	}
}
