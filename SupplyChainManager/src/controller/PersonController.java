package controller;

import model.order.Person;
import model.product.Component;
import model.repository.ComponentRepository;
import model.repository.PersonRepository;
import view.NewPersonView;
import view.product.ComponentsListView;
import view.product.NewComponentView;

import java.util.ArrayList;

public class PersonController {    
    public static void startNewPerson(ArrayList<Object> data) {
        new NewPersonView().setVisible(true);
    }
    
    public static void newPersonSubmit(ArrayList<Object> data) {
    	String personName = (String)data.get(0);
    	if (personName.trim().equals("")) {
    		System.err.println("No name for personis provided");
			return;
		}
    	ArrayList<Person> personIfAny = PersonRepository.getInstance().filter(personName);
    	if (personIfAny.size() == 0){
    		Person newPerson = new Person(personName);
    		PersonRepository.getInstance().save(newPerson);
    	} else {
    		System.err.println("Person with same name already exists");
    		return;
    	}
    }
    
    public static void newPersonCancel(ArrayList<Object> data) {
    }
}
