package model.order;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.repository.PersonRepository;

@DatabaseTable(tableName = "Person")
public class Person {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField
    private String name;

    public Person() {
    }  // empty constructor required by ORMLite

    public Person(String name) {
        this.name = name;
        PersonRepository.getInstance().create(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
