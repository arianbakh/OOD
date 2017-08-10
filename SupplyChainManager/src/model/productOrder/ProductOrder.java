package model.productOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import model.order.Order;
import model.product.Product;
import model.repository.ProductOrderRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@DatabaseTable(tableName = "ProductOrder")
public class ProductOrder extends Order {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Product product;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private ProductOrderReport report;
    @DatabaseField
    private Date orderTime;
    @ForeignCollectionField(eager = true)
    private Collection<ProductOrderSupplier> productOrderSuppliers;

    public ProductOrder() {
        this.orderTime = new Date();  // set to current time
    }  // empty constructor required by ORMLite

    public ProductOrder(Product product) {
        this.orderTime = new Date();  // set to current time
        this.product = product;
        ProductOrderRepository.getInstance().create(this);
    }

    public Product getProduct() {
        return product;
    }

    public ProductOrderReport getReport() {
        return report;
    }

    public void setReport(ProductOrderReport report) {
        this.report = report;
        ProductOrderRepository.getInstance().save(this);
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public List<Supplier> getSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        for (ProductOrderSupplier productOrderSupplier : productOrderSuppliers) {
            suppliers.add(productOrderSupplier.getSupplier());
        }
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        productOrderSuppliers.clear();
        for (Supplier supplier : suppliers) {
            productOrderSuppliers.add(new ProductOrderSupplier(this, supplier));
        }
    }

    @Override
    public String toString() {
        return " سفارش محصول " + product.getName();
    }
}
