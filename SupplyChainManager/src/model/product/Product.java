package model.product;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import model.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@DatabaseTable(tableName = "Product")
public class Product {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField
    private String name;
    @ForeignCollectionField(eager = true)
    private Collection<ProductComponent> productComponents;
    @DatabaseField
    private int minStock;
    @DatabaseField
    private int maxStock;
    @DatabaseField
    private int currentStock;

    public Product() {
    }  // empty constructor required by ORMLite

    public Product(String name, List<Component> components) {
        this.name = name;
        ProductRepository.getInstance().create(this);
        for (Component component : components) {
            productComponents.add(new ProductComponent(this, component));
        }
    }

    public String getName() {
        return name;
    }

    public List<Component> getComponents() {
        List<Component> components = new ArrayList<>();
        for (ProductComponent productComponent : productComponents) {
            components.add(productComponent.getComponent());
        }
        return components;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
        ProductRepository.getInstance().save(this);
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
        ProductRepository.getInstance().save(this);
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
        ProductRepository.getInstance().save(this);
    }

    public void increaseStock() {
        currentStock++;
        ProductRepository.getInstance().save(this);
    }

    public void decreaseStock() {
        if (currentStock > 0) {
            currentStock--;
            ProductRepository.getInstance().save(this);
        }
    }

    public int getCurrentStock() {
        return currentStock;
    }

    @Override
    public String toString() {
        return name;
    }
}
