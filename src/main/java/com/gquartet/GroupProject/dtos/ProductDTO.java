/*
 * Created on 15/05/2020 at 19:08:35 GMT+2
 */
package com.gquartet.GroupProject.dtos;

import com.gquartet.GroupProject.models.Color;
import com.gquartet.GroupProject.models.Gender;
import com.gquartet.GroupProject.models.Material;
import com.gquartet.GroupProject.models.OrderDetails;
import com.gquartet.GroupProject.models.ProductImage;
import com.gquartet.GroupProject.models.ProductSize;
import com.gquartet.GroupProject.models.Subcategory;
import java.math.BigDecimal;
import java.util.List;

public class ProductDTO {
    private int productId;
    private int productStock;
    private String productName;
    private BigDecimal productPrice;
    private Color color;
    private Gender gender;
    private Material material;
    private ProductSize size;
    private Subcategory subcategory;
    private List<ProductImage> productImageList;
    private List<OrderDetails> orderDetailsList;

    public ProductDTO(int productId, int productStock, String productName, BigDecimal productPrice, Color color, Gender gender, Material material, ProductSize size, Subcategory subcategory, List<ProductImage> productImageList, List<OrderDetails> orderDetailsList) {
        this.productId = productId;
        this.productStock = productStock;
        this.productName = productName;
        this.productPrice = productPrice;
        this.color = color;
        this.gender = gender;
        this.material = material;
        this.size = size;
        this.subcategory = subcategory;
        this.productImageList = productImageList;
        this.orderDetailsList = orderDetailsList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public ProductSize getSize() {
        return size;
    }

    public void setSize(ProductSize size) {
        this.size = size;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }
    
    
    
}
