package com.gquartet.GroupProject.dtos;

import com.gquartet.GroupProject.models.Category;
import com.gquartet.GroupProject.models.OrderDetails;
import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.models.ProductImage;
import com.gquartet.GroupProject.models.ShoppingCart;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductCategoryImageDto {

    private Integer productId;
    private String productName;
    private String productDescription;
    private int productStock;
    private BigDecimal productPrice;
    private Integer categoryId;
    private String categoryName; // mprelok
//    private byte[] categoryImage;
//    private String filename;

    public ProductCategoryImageDto() {
    }
    public ProductCategoryImageDto(Integer productId, String productName, String productDescription, int productStock, BigDecimal productPrice, Integer categoryId, String categoryName) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productStock = productStock;
        this.productPrice = productPrice;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }







    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

//    public String getProductDescription() {
//        return productDescription;
//    }
//
//    public void setProductDescription(String productDescription) {
//        this.productDescription = productDescription;
//    }
//
//    public int getProductStock() {
//        return productStock;
//    }
//
//    public void setProductStock(int productStock) {
//        this.productStock = productStock;
//    }
//
//    public BigDecimal getProductPrice() {
//        return productPrice;
//    }
//
//    public void setProductPrice(BigDecimal productPrice) {
//        this.productPrice = productPrice;
//    }
//
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
//
//    public byte[] getCategoryImage() {
//        return categoryImage;
//    }
//
//    public void setCategoryImage(byte[] categoryImage) {
//        this.categoryImage = categoryImage;
//    }
//
//    public String getFilename() {
//        return filename;
//    }
//
//    public void setFilename(String filename) {
//        this.filename = filename;
//    }

}
