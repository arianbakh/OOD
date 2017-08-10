package model.productReview;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.product.Product;
import model.repository.ProductTextReviewRepository;

@DatabaseTable(tableName = "ProductTextReview")
public class ProductTextReview {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField
    private String name;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Product product;
    @DatabaseField
    private String text;

    public ProductTextReview() {
    }  // empty constructor required by ORMLite

    public ProductTextReview(Product product, String text) {
        this.product = product;
        this.text = text;
        ProductTextReviewRepository.getInstance().create(this);
    }

    public Product getProduct() {
        return product;
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }
}
