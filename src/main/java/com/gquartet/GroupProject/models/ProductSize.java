package com.gquartet.GroupProject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "product_size")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductSize.findAll", query = "SELECT p FROM ProductSize p"),
    @NamedQuery(name = "ProductSize.findBySizeId", query = "SELECT p FROM ProductSize p WHERE p.sizeId = :sizeId"),
    @NamedQuery(name = "ProductSize.findBySizeName", query = "SELECT p FROM ProductSize p WHERE p.sizeName = :sizeName")})
public class ProductSize implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "size_id")
    private Integer sizeId;
    @Size(max = 5)
    @Column(name = "size_name")
    private String sizeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sizeId")
    @JsonBackReference
    private List<Product> productList;

    public ProductSize() {
    }

    public ProductSize(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sizeId != null ? sizeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductSize)) {
            return false;
        }
        ProductSize other = (ProductSize) object;
        if ((this.sizeId == null && other.sizeId != null) || (this.sizeId != null && !this.sizeId.equals(other.sizeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gquartet.GroupProject.models.ProductSize[ sizeId=" + sizeId + " ]";
    }

}
