package se.magnus.microservices.core.product.productservice.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class ProductEntity {

    // used to hold the unique database identity of each stored entity, not exposed in the API
    @Id
    private String id;

    // used to implement optimistic locking, allowing Spring Data to verify that updates of an entity in the database do not overwrite a concurrent update.
    // If the version stored in the database is higher than the value in an update request, it indicates that the update is performed on stale data
    @Version
    private Integer version;

    // used to get a unique index created for the business key - productId
    @Indexed(unique = true)
    private int productId;

    private String name;
    private int weight;

    public ProductEntity() {}

    public ProductEntity(int productId, String name, int weight) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}