package db;

public class Supplier extends DataBaseObject{

	@Override
	public void save() {
		DataBase.getDB().addSupplier(this);
		
	}
	
}
