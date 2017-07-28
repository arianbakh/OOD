package model.order;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Person")
public class Person {
    @DatabaseField(id = true)
    private String name;

    public Person() {}; // empty constructor required by ORMLite

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
