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

@Entity
@Table(name = "order_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderStatus.findAll", query = "SELECT o FROM OrderStatus o"),
    @NamedQuery(name = "OrderStatus.findByOrderStatusId", query = "SELECT o FROM OrderStatus o WHERE o.orderStatusId = :orderStatusId"),
    @NamedQuery(name = "OrderStatus.findByOrderStatusName", query = "SELECT o FROM OrderStatus o WHERE o.orderStatusName = :orderStatusName"),
    @NamedQuery(name = "OrderStatus.findByTrackingNo", query = "SELECT o FROM OrderStatus o WHERE o.trackingNo = :trackingNo")})
public class OrderStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_status_id")
    private Integer orderStatusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "order_status_name")
    private String orderStatusName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tracking_no")
    private String trackingNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderStatusId")
    private Collection<CustomerOrder> customerOrderCollection;

    public OrderStatus() {
    }

    public OrderStatus(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public OrderStatus(Integer orderStatusId, String orderStatusName, String trackingNo) {
        this.orderStatusId = orderStatusId;
        this.orderStatusName = orderStatusName;
        this.trackingNo = trackingNo;
    }

    public Integer getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    @XmlTransient
    public Collection<CustomerOrder> getCustomerOrderCollection() {
        return customerOrderCollection;
    }

    public void setCustomerOrderCollection(Collection<CustomerOrder> customerOrderCollection) {
        this.customerOrderCollection = customerOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderStatusId != null ? orderStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderStatus)) {
            return false;
        }
        OrderStatus other = (OrderStatus) object;
        if ((this.orderStatusId == null && other.orderStatusId != null) || (this.orderStatusId != null && !this.orderStatusId.equals(other.orderStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "orderStatusId = " + orderStatusId;
    }
    
}
