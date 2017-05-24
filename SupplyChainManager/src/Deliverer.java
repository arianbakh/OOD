
public class Deliverer extends DataBaseObject{

	@Override
	public void save() {
		DataBase.getDB().addDeliverer(this);
		
	}

}
