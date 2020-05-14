
package com.gquartet.GroupProject.models;

import java.io.Serializable;
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
@Table(name = "subcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcategory.findAll", query = "SELECT s FROM Subcategory s")
    , @NamedQuery(name = "Subcategory.findBySubcategoryId", query = "SELECT s FROM Subcategory s WHERE s.subcategoryId = :subcategoryId")
    , @NamedQuery(name = "Subcategory.findBySubcategoryName", query = "SELECT s FROM Subcategory s WHERE s.subcategoryName = :subcategoryName")
    , @NamedQuery(name = "Subcategory.findBySubcategoryImageFilepath", query = "SELECT s FROM Subcategory s WHERE s.subcategoryImageFilepath = :subcategoryImageFilepath")})
public class Subcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subcategory_id")
    private Integer subcategoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "subcategory_name")
    private String subcategoryName;
    @Size(max = 200)
    @Column(name = "subcategory_image_filepath")
    private String subcategoryImageFilepath;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subcategoryId")
    private List<Product> productList;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false)
    private Category categoryId;

    public Subcategory() {
    }

    public Subcategory(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public Subcategory(Integer subcategoryId, String subcategoryName) {
        this.subcategoryId = subcategoryId;
        this.subcategoryName = subcategoryName;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public String getSubcategoryImageFilepath() {
        return subcategoryImageFilepath;
    }

    public void setSubcategoryImageFilepath(String subcategoryImageFilepath) {
        this.subcategoryImageFilepath = subcategoryImageFilepath;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subcategoryId != null ? subcategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcategory)) {
            return false;
        }
        Subcategory other = (Subcategory) object;
        if ((this.subcategoryId == null && other.subcategoryId != null) || (this.subcategoryId != null && !this.subcategoryId.equals(other.subcategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gquartet.GroupProject.models.Subcategory[ subcategoryId=" + subcategoryId + " ]";
    }
    
}
