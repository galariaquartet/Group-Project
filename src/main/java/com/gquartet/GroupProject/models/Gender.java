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
@Table(name = "gender")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gender.findAll", query = "SELECT g FROM Gender g"),
    @NamedQuery(name = "Gender.findByGenderId", query = "SELECT g FROM Gender g WHERE g.genderId = :genderId"),
    @NamedQuery(name = "Gender.findByGenderName", query = "SELECT g FROM Gender g WHERE g.genderName = :genderName")})
public class Gender implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gender_id")
    private Integer genderId;
    @Size(max = 15)
    @Column(name = "gender_name")
    private String genderName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genderId")
    @JsonBackReference
    private List<Product> productList;

    public Gender() {
    }

    public Gender(Integer genderId) {
        this.genderId = genderId;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
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
        hash += (genderId != null ? genderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gender)) {
            return false;
        }
        Gender other = (Gender) object;
        if ((this.genderId == null && other.genderId != null) || (this.genderId != null && !this.genderId.equals(other.genderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gquartet.GroupProject.models.Gender[ genderId=" + genderId + " ]";
    }

}
