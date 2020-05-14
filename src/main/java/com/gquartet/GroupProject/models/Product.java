/*
 * Created on 13/05/2020 at 23:53:18 GMT+2
 */
package com.gquartet.GroupProject.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId")
    , @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName")
    , @NamedQuery(name = "Product.findByProductSize", query = "SELECT p FROM Product p WHERE p.productSize = :productSize")
    , @NamedQuery(name = "Product.findByProductColor", query = "SELECT p FROM Product p WHERE p.productColor = :productColor")
    , @NamedQuery(name = "Product.findByProductMaterial", query = "SELECT p FROM Product p WHERE p.productMaterial = :productMaterial")
    , @NamedQuery(name = "Product.findByProductGender", query = "SELECT p FROM Product p WHERE p.productGender = :productGender")
    , @NamedQuery(name = "Product.findByProductStock", query = "SELECT p FROM Product p WHERE p.productStock = :productStock")
    , @NamedQuery(name = "Product.findByProductPrice", query = "SELECT p FROM Product p WHERE p.productPrice = :productPrice")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "product_name")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "product_size")
    private String productSize;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "product_color")
    private String productColor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "product_material")
    private String productMaterial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_gender")
    private Character productGender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_stock")
    private int productStock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "product_price")
    private BigDecimal productPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private List<ShoppingCart> shoppingCartList;
    @JoinColumn(name = "subcategory_id", referencedColumnName = "subcategory_id")
    @ManyToOne(optional = false)
    private Subcategory subcategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private List<ProductImage> productImageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private List<OrderDetails> orderDetailsList;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, String productName, String productSize, String productColor, String productMaterial, Character productGender, int productStock) {
        this.productId = productId;
        this.productName = productName;
        this.productSize = productSize;
        this.productColor = productColor;
        this.productMaterial = productMaterial;
        this.productGender = productGender;
        this.productStock = productStock;
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

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductMaterial() {
        return productMaterial;
    }

    public void setProductMaterial(String productMaterial) {
        this.productMaterial = productMaterial;
    }

    public Character getProductGender() {
        return productGender;
    }

    public void setProductGender(Character productGender) {
        this.productGender = productGender;
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

    @XmlTransient
    public List<ShoppingCart> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(List<ShoppingCart> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }

    public Subcategory getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Subcategory subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    @XmlTransient
    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    @XmlTransient
    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gquartet.GroupProject.models.Product[ productId=" + productId + " ]";
    }
    
}
