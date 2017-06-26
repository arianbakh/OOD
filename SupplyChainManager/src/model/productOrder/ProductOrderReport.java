package model.productOrder;

import java.time.Duration;
import java.util.ArrayList;

import database.DataBase;
import database.DataBaseObject;
import model.order.Person;
import model.product.Product;

public class ProductOrderReport implements DataBaseObject{

	private Product product;
	private ArrayList<Person> persons = new ArrayList<>();
	
	public ProductOrderReport(Product product,  ArrayList<Person> persons) {
		this.product = product;
		this.persons = persons;
	}
	
	public ArrayList<Person> getPersons() {
		return persons;
	}
	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}
	
	@Override
	public void save() {
		DataBase.getDB().addProductOrderReport(this);
		
	}

}
