package model.customerOrder;

public class Deliverer {
    private String name;
    private String properties;

    public Deliverer(String name, String properties) {
        this.name = name;
        this.properties = properties;
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
