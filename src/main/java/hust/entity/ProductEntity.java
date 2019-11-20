package main.java.hust.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "emarket", catalog = "")
public class ProductEntity {
    private int productId;
    private String name;
    private BigDecimal price;
    private String description;
    private Timestamp lastUpdate;
    private String image;
    private String thumbImage;
    private String descriptionDetail;

    @Id
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "last_update", nullable = false)
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 45)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "thumb_image", nullable = true, length = 45)
    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    @Basic
    @Column(name = "description_detail", nullable = true, length = -1)
    public String getDescriptionDetail() {
        return descriptionDetail;
    }

    public void setDescriptionDetail(String descriptionDetail) {
        this.descriptionDetail = descriptionDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return productId == that.productId &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(description, that.description) &&
                Objects.equals(lastUpdate, that.lastUpdate) &&
                Objects.equals(image, that.image) &&
                Objects.equals(thumbImage, that.thumbImage) &&
                Objects.equals(descriptionDetail, that.descriptionDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price, description, lastUpdate, image, thumbImage, descriptionDetail);
    }
}
