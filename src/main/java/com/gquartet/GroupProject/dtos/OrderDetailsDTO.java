package com.gquartet.GroupProject.dtos;

import com.gquartet.GroupProject.models.Payment;
import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.models.ShippingInformation;

public class OrderDetailsDTO {

    private ShippingInformation shippingInformation;
    private Product product;
    private Payment payment;

    public OrderDetailsDTO(ShippingInformation shippingInformation, Product product, Payment payment) {
        this.shippingInformation = shippingInformation;
        this.product = product;
        this.payment = payment;
    }

    public ShippingInformation getShippingInformation() {
        return shippingInformation;
    }

    public void setShippingInformation(ShippingInformation shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
