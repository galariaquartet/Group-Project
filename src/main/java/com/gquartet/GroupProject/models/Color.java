/*
 * Created on 14/05/2020 at 22:25:54 GMT+2
 */
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

@Entity
@Table(name = "color")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Color.findAll", query = "SELECT c FROM Color c"),
    @NamedQuery(name = "Color.findByColorId", query = "SELECT c FROM Color c WHERE c.colorId = :colorId"),
    @NamedQuery(name = "Color.findByColorName", query = "SELECT c FROM Color c WHERE c.colorName = :colorName"),
    @NamedQuery(name = "Color.findByColorImageFilepath", query = "SELECT c FROM Color c WHERE c.colorImageFilepath = :colorImageFilepath")})
public class Color implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "color_id")
    private Integer colorId;
    @Size(max = 20)
    @Column(name = "color_name")
    private String colorName;
    @Size(max = 200)
    @Column(name = "color_image_filepath")
    private String colorImageFilepath;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genderId")
    @JsonBackReference
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Color() {
    }

    public Color(Integer colorId) {
        this.colorId = colorId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorImageFilepath() {
        return colorImageFilepath;
    }

    public void setColorImageFilepath(String colorImageFilepath) {
        this.colorImageFilepath = colorImageFilepath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (colorId != null ? colorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Color)) {
            return false;
        }
        Color other = (Color) object;
        if ((this.colorId == null && other.colorId != null) || (this.colorId != null && !this.colorId.equals(other.colorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gquartet.GroupProject.models.Color[ colorId=" + colorId + " ]";
    }

}
