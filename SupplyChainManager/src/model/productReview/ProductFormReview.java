package model.productReview;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.product.Product;
import model.repository.ProductFormReviewRepository;

@DatabaseTable(tableName = "ProductFormReview")
public class ProductFormReview {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField
    private String name;
    @DatabaseField
    private int qualityRating;
    @DatabaseField
    private int deliveryRating;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Product product;

    public ProductFormReview() {
    }  // empty constructor required by ORMLite

    public ProductFormReview(int qualityRating, int deliveryRating, Product product) {
        this.qualityRating = qualityRating;
        this.deliveryRating = deliveryRating;
        this.product = product;
        ProductFormReviewRepository.getInstance().create(this);
    }

    public int getQualityRating() {
        return qualityRating;
    }

    public int getDeliveryRating() {
        return deliveryRating;
    }

    public Product getProduct() {
        return product;
    }

    public String getName() {
        return name;
    }
}
