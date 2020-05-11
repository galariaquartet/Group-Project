package com.gquartet.GroupProject.models;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Coily1805
 */
@Entity
@Table(name = "shipping_information")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShippingInformation.findAll", query = "SELECT s FROM ShippingInformation s"),
    @NamedQuery(name = "ShippingInformation.findByShippingInformationId", query = "SELECT s FROM ShippingInformation s WHERE s.shippingInformationId = :shippingInformationId"),
    @NamedQuery(name = "ShippingInformation.findByShippingCountry", query = "SELECT s FROM ShippingInformation s WHERE s.shippingCountry = :shippingCountry"),
    @NamedQuery(name = "ShippingInformation.findByShippingState", query = "SELECT s FROM ShippingInformation s WHERE s.shippingState = :shippingState"),
    @NamedQuery(name = "ShippingInformation.findByShippingCity", query = "SELECT s FROM ShippingInformation s WHERE s.shippingCity = :shippingCity"),
    @NamedQuery(name = "ShippingInformation.findByShippingStreet", query = "SELECT s FROM ShippingInformation s WHERE s.shippingStreet = :shippingStreet"),
    @NamedQuery(name = "ShippingInformation.findByShippingZip", query = "SELECT s FROM ShippingInformation s WHERE s.shippingZip = :shippingZip"),
    @NamedQuery(name = "ShippingInformation.findByRecipientFirstName", query = "SELECT s FROM ShippingInformation s WHERE s.recipientFirstName = :recipientFirstName"),
    @NamedQuery(name = "ShippingInformation.findByRecipientLastName", query = "SELECT s FROM ShippingInformation s WHERE s.recipientLastName = :recipientLastName"),
    @NamedQuery(name = "ShippingInformation.findByRecipientPhone", query = "SELECT s FROM ShippingInformation s WHERE s.recipientPhone = :recipientPhone")})
public class ShippingInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shipping_information_id")
    private Integer shippingInformationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "shipping_country")
    private String shippingCountry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "shipping_state")
    private String shippingState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "shipping_city")
    private String shippingCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "shipping_street")
    private String shippingStreet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "shipping_zip")
    private String shippingZip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "recipient_first_name")
    private String recipientFirstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "recipient_last_name")
    private String recipientLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "recipient_phone")
    private String recipientPhone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shippingInformationId")
    private Collection<OrderDetails> orderDetailsCollection;

    public ShippingInformation() {
    }

    public ShippingInformation(Integer shippingInformationId) {
        this.shippingInformationId = shippingInformationId;
    }

    public ShippingInformation(Integer shippingInformationId, String shippingCountry, String shippingState, String shippingCity, String shippingStreet, String shippingZip, String recipientFirstName, String recipientLastName, String recipientPhone) {
        this.shippingInformationId = shippingInformationId;
        this.shippingCountry = shippingCountry;
        this.shippingState = shippingState;
        this.shippingCity = shippingCity;
        this.shippingStreet = shippingStreet;
        this.shippingZip = shippingZip;
        this.recipientFirstName = recipientFirstName;
        this.recipientLastName = recipientLastName;
        this.recipientPhone = recipientPhone;
    }

    public Integer getShippingInformationId() {
        return shippingInformationId;
    }

    public void setShippingInformationId(Integer shippingInformationId) {
        this.shippingInformationId = shippingInformationId;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingStreet() {
        return shippingStreet;
    }

    public void setShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    public String getShippingZip() {
        return shippingZip;
    }

    public void setShippingZip(String shippingZip) {
        this.shippingZip = shippingZip;
    }

    public String getRecipientFirstName() {
        return recipientFirstName;
    }

    public void setRecipientFirstName(String recipientFirstName) {
        this.recipientFirstName = recipientFirstName;
    }

    public String getRecipientLastName() {
        return recipientLastName;
    }

    public void setRecipientLastName(String recipientLastName) {
        this.recipientLastName = recipientLastName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    @XmlTransient
    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shippingInformationId != null ? shippingInformationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingInformation)) {
            return false;
        }
        ShippingInformation other = (ShippingInformation) object;
        if ((this.shippingInformationId == null && other.shippingInformationId != null) || (this.shippingInformationId != null && !this.shippingInformationId.equals(other.shippingInformationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gquartet.GroupProject.models.ShippingInformation[ shippingInformationId=" + shippingInformationId + " ]";
    }
    
}