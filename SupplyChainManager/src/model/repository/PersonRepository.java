package model.repository;

import model.order.Person;

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
}
