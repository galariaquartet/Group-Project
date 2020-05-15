package com.gquartet.GroupProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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

@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByProductStock", query = "SELECT p FROM Product p WHERE p.productStock = :productStock"),
    @NamedQuery(name = "Product.findByProductPrice", query = "SELECT p FROM Product p WHERE p.productPrice = :productPrice")})
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
//    @Basic(optional = false)
    @NotNull
    @Column(name = "product_stock")
    private int productStock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "product_price")
    private BigDecimal productPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    @JsonIgnore
    private List<ShoppingCart> shoppingCartList;
    @JoinColumn(name = "color_id", referencedColumnName = "color_id")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Color colorId;
    @JoinColumn(name = "gender_id", referencedColumnName = "gender_id")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Gender genderId;
    @JoinColumn(name = "material_id", referencedColumnName = "material_id")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Material materialId;
    @JoinColumn(name = "size_id", referencedColumnName = "size_id")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private ProductSize sizeId;
    @JoinColumn(name = "subcategory_id", referencedColumnName = "subcategory_id")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Subcategory subcategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    @JsonManagedReference
    private List<ProductImage> productImageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    @JsonIgnore
    private List<OrderDetails> orderDetailsList;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, String productName, int productStock) {
        this.productId = productId;
        this.productName = productName;
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
    @JsonIgnore
    public List<ShoppingCart> getShoppingCartList() {
        return shoppingCartList;
    }
    
    @JsonProperty
    public void setShoppingCartList(List<ShoppingCart> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }
    
    public Color getColorId() {
        return colorId;
    }
    
    public void setColorId(Color colorId) {
        this.colorId = colorId;
    }
    
    public Gender getGenderId() {
        return genderId;
    }
    
    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }
    
    public Material getMaterialId() {
        return materialId;
    }
    
    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }
    
    public ProductSize getSizeId() {
        return sizeId;
    }
    
    public void setSizeId(ProductSize sizeId) {
        this.sizeId = sizeId;
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
    @JsonIgnore
    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }
    
    @JsonProperty
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
