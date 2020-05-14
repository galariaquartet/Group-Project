/*
 * Created on 13/05/2020 at 23:53:18 GMT+2
 */
package com.gquartet.GroupProject.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "customer_information")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerInformation.findAll", query = "SELECT c FROM CustomerInformation c")
    , @NamedQuery(name = "CustomerInformation.findByCustomerId", query = "SELECT c FROM CustomerInformation c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "CustomerInformation.findByFirstName", query = "SELECT c FROM CustomerInformation c WHERE c.firstName = :firstName")
    , @NamedQuery(name = "CustomerInformation.findByLastName", query = "SELECT c FROM CustomerInformation c WHERE c.lastName = :lastName")
    , @NamedQuery(name = "CustomerInformation.findByCountry", query = "SELECT c FROM CustomerInformation c WHERE c.country = :country")
    , @NamedQuery(name = "CustomerInformation.findByState", query = "SELECT c FROM CustomerInformation c WHERE c.state = :state")
    , @NamedQuery(name = "CustomerInformation.findByCity", query = "SELECT c FROM CustomerInformation c WHERE c.city = :city")
    , @NamedQuery(name = "CustomerInformation.findByStreet", query = "SELECT c FROM CustomerInformation c WHERE c.street = :street")
    , @NamedQuery(name = "CustomerInformation.findByZip", query = "SELECT c FROM CustomerInformation c WHERE c.zip = :zip")
    , @NamedQuery(name = "CustomerInformation.findByPhone", query = "SELECT c FROM CustomerInformation c WHERE c.phone = :phone")})
public class CustomerInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 50)
    @Column(name = "country")
    private String country;
    @Size(max = 50)
    @Column(name = "state")
    private String state;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Size(max = 50)
    @Column(name = "street")
    private String street;
    @Size(max = 12)
    @Column(name = "zip")
    private String zip;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "phone")
    private String phone;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Customer customer;

    public CustomerInformation() {
    }

    public CustomerInformation(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerInformation)) {
            return false;
        }
        CustomerInformation other = (CustomerInformation) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gquartet.GroupProject.models.CustomerInformation[ customerId=" + customerId + " ]";
    }
    
}
