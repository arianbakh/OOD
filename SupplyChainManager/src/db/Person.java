package db;

public class Person extends DataBaseObject{

	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public void save() {
		DataBase.getDB().addPerson(this);
	}

	@Override
	public String toString() {
		return name;
	}
}
