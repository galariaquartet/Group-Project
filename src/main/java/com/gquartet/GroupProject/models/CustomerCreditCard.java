package com.gquartet.GroupProject.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "customer_credit_card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerCreditCard.findAll", query = "SELECT c FROM CustomerCreditCard c"),
    @NamedQuery(name = "CustomerCreditCard.findByCardId", query = "SELECT c FROM CustomerCreditCard c WHERE c.cardId = :cardId"),
    @NamedQuery(name = "CustomerCreditCard.findByOwnerFirstName", query = "SELECT c FROM CustomerCreditCard c WHERE c.ownerFirstName = :ownerFirstName"),
    @NamedQuery(name = "CustomerCreditCard.findByOwnerLastName", query = "SELECT c FROM CustomerCreditCard c WHERE c.ownerLastName = :ownerLastName"),
    @NamedQuery(name = "CustomerCreditCard.findByCardNumber", query = "SELECT c FROM CustomerCreditCard c WHERE c.cardNumber = :cardNumber"),
    @NamedQuery(name = "CustomerCreditCard.findByCardNumberLastDigits", query = "SELECT c FROM CustomerCreditCard c WHERE c.cardNumberLastDigits = :cardNumberLastDigits"),
    @NamedQuery(name = "CustomerCreditCard.findByCvv", query = "SELECT c FROM CustomerCreditCard c WHERE c.cvv = :cvv"),
    @NamedQuery(name = "CustomerCreditCard.findByExpirationDate", query = "SELECT c FROM CustomerCreditCard c WHERE c.expirationDate = :expirationDate")})
public class CustomerCreditCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "card_id")
    private Integer cardId;
    @Size(max = 50)
    @Column(name = "owner_first_name")
    private String ownerFirstName;
    @Size(max = 50)
    @Column(name = "owner_last_name")
    private String ownerLastName;
    @Size(max = 60)
    @Column(name = "card_number")
    private String cardNumber;
    @Size(max = 4)
    @Column(name = "card_number_last_digits")
    private String cardNumberLastDigits;
    @Size(max = 60)
    @Column(name = "cvv")
    private String cvv;
    @Size(max = 4)
    @Column(name = "expiration_date")
    private String expirationDate;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
    private Customer customerId;

    public CustomerCreditCard() {
    }

    public CustomerCreditCard(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumberLastDigits() {
        return cardNumberLastDigits;
    }

    public void setCardNumberLastDigits(String cardNumberLastDigits) {
        this.cardNumberLastDigits = cardNumberLastDigits;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardId != null ? cardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerCreditCard)) {
            return false;
        }
        CustomerCreditCard other = (CustomerCreditCard) object;
        if ((this.cardId == null && other.cardId != null) || (this.cardId != null && !this.cardId.equals(other.cardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gquartet.GroupProject.models.CustomerCreditCard[ cardId=" + cardId + " ]";
    }
    
}
