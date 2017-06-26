package model.customerOrder;

import database.DataBase;
import database.DataBaseObject;

public class Deliverer implements DataBaseObject{

	@Override
	public void save() {
		DataBase.getDB().addDeliverer(this);
	}

}
