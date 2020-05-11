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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Coily1805
 */
@Entity
@Table(name = "order_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM OrderDetails o"),
    @NamedQuery(name = "OrderDetails.findByOrderDetailsId", query = "SELECT o FROM OrderDetails o WHERE o.orderDetailsId = :orderDetailsId")})
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_details_id")
    private Integer orderDetailsId;
    @JoinColumn(name = "order_number", referencedColumnName = "order_number")
    @ManyToOne(optional = false)
    private CustomerOrder orderNumber;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    @ManyToOne(optional = false)
    private Payment paymentId;
    @JoinColumn(name = "shipping_information_id", referencedColumnName = "shipping_information_id")
    @ManyToOne(optional = false)
    private ShippingInformation shippingInformationId;

    public OrderDetails() {
    }

    public OrderDetails(Integer orderDetailsId, CustomerOrder orderNumber, Product productId, Payment paymentId, ShippingInformation shippingInformationId) {
        this.orderDetailsId = orderDetailsId;
        this.orderNumber = orderNumber;
        this.productId = productId;
        this.paymentId = paymentId;
        this.shippingInformationId = shippingInformationId;
    }
    
    public OrderDetails(Integer orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Integer getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Integer orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public CustomerOrder getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(CustomerOrder orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
    }

    public ShippingInformation getShippingInformationId() {
        return shippingInformationId;
    }

    public void setShippingInformationId(ShippingInformation shippingInformationId) {
        this.shippingInformationId = shippingInformationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailsId != null ? orderDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetails)) {
            return false;
        }
        OrderDetails other = (OrderDetails) object;
        if ((this.orderDetailsId == null && other.orderDetailsId != null) || (this.orderDetailsId != null && !this.orderDetailsId.equals(other.orderDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gquartet.GroupProject.models.OrderDetails[ orderDetailsId=" + orderDetailsId + " ]";
    }
    
}