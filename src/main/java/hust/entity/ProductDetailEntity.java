package main.java.hust.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_detail", schema = "emarket", catalog = "")
public class ProductDetailEntity {
    private int productId;
    private String information;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private String accessories;
    private String guaranty;

    @Id
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "information", nullable = true, length = -1)
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Basic
    @Column(name = "image1", nullable = true, length = 45)
    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    @Basic
    @Column(name = "image2", nullable = true, length = 45)
    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    @Basic
    @Column(name = "image3", nullable = true, length = 45)
    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    @Basic
    @Column(name = "image4", nullable = true, length = 45)
    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    @Basic
    @Column(name = "image5", nullable = true, length = 45)
    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    @Basic
    @Column(name = "accessories", nullable = true, length = -1)
    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    @Basic
    @Column(name = "guaranty", nullable = true, length = -1)
    public String getGuaranty() {
        return guaranty;
    }

    public void setGuaranty(String guaranty) {
        this.guaranty = guaranty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetailEntity that = (ProductDetailEntity) o;
        return productId == that.productId &&
                Objects.equals(information, that.information) &&
                Objects.equals(image1, that.image1) &&
                Objects.equals(image2, that.image2) &&
                Objects.equals(image3, that.image3) &&
                Objects.equals(image4, that.image4) &&
                Objects.equals(image5, that.image5) &&
                Objects.equals(accessories, that.accessories) &&
                Objects.equals(guaranty, that.guaranty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, information, image1, image2, image3, image4, image5, accessories, guaranty);
    }
}
