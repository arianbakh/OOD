package model.repository;

import model.order.Person;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Person> filter(String name) {
        try {
            Map<String, Object> queryFields = new HashMap<>();
            queryFields.put("name", name);
            return getDao().queryForFieldValues(queryFields);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
