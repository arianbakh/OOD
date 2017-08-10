package model.customerOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.repository.DelivererRepository;

@DatabaseTable(tableName = "Deliverer")
public class Deliverer {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String properties;

    public Deliverer() {
    }  // empty constructor required by ORMLite

    public Deliverer(String name, String properties) {
        this.name = name;
        this.properties = properties;
        DelivererRepository.getInstance().create(this);
    }

    public String getName() {
        return name;
    }

    public String getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
