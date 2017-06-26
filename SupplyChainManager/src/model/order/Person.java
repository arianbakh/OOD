package model.order;

import database.DataBase;
import database.DataBaseObject;

public class Person implements DataBaseObject{

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
