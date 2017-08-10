package controller;

import model.order.Person;
import model.repository.PersonRepository;
import view.NewPersonView;

import java.util.ArrayList;

class PersonController {
    static void startNewPerson(ArrayList<Object> data) {
        new NewPersonView().setVisible(true);
    }

    static void newPersonSubmit(ArrayList<Object> data) {
        String personName = (String) data.get(0);
        if (personName.trim().equals("")) {
            System.err.println("No name for person is provided");
            return;
        }
        ArrayList<Person> personIfAny = PersonRepository.getInstance().filter(personName);
        if (personIfAny.size() == 0) {
            Person newPerson = new Person(personName);
            PersonRepository.getInstance().save(newPerson);
        } else {
            System.err.println("Person with same name already exists");
        }
    }

    static void newPersonCancel(ArrayList<Object> data) {
    }
}
