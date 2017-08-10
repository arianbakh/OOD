package model.repository;

import java.util.ArrayList;

import model.order.Person;
import model.product.Component;

public class PersonRepository extends Repository<Person> {
    private static PersonRepository personRepository;

    private PersonRepository() {
    }

    public static PersonRepository getInstance() {
        if (personRepository == null) {
            personRepository = new PersonRepository();
        }
        return personRepository;
    }
    
    public ArrayList<Person> filter(String name){
    	ArrayList<Person> persons = new ArrayList<>();
    	for (Person c: this.getAll())
    		if (c.getName().equals(name))
    			persons.add(c);
    	return persons;
    		
    }
}
