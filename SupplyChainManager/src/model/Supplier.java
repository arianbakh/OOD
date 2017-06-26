package model;

import database.DataBase;
import database.DataBaseObject;

public class Supplier implements DataBaseObject{

	@Override
	public void save() {
		DataBase.getDB().addSupplier(this);
		
	}
	
}
