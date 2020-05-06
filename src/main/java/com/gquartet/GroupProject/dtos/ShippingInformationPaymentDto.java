package com.gquartet.GroupProject.dtos;

import com.gquartet.GroupProject.models.OrderDetails;

public class ShippingInformationPaymentDto {

    private Integer shippingInformationId;
    private String shippingCountry;
    private String shippingState;
    private String shippingCity;
    private String shippingStreet;
    private String shippingZip;
    private String recipientFirstName;
    private String recipientLastName;
    private String recipientPhone;
    //private OrderDetails orderDetailsId;

    private Integer paymentId;
    private String paymentName;

    public ShippingInformationPaymentDto(String shippingCountry, String shippingState, String shippingCity, String shippingStreet, String shippingZip, String recipientFirstName, String recipientLastName, String recipientPhone, String paymentName) {
        this.shippingCountry = shippingCountry;
        this.shippingState = shippingState;
        this.shippingCity = shippingCity;
        this.shippingStreet = shippingStreet;
        this.shippingZip = shippingZip;
        this.recipientFirstName = recipientFirstName;
        this.recipientLastName = recipientLastName;
        this.recipientPhone = recipientPhone;
        //this.orderDetailsId = orderDetailsId;
        this.paymentName = paymentName;
    }
     

    public ShippingInformationPaymentDto(Integer shippingInformationId, String shippingCountry, String shippingState, String shippingCity, String shippingStreet, String shippingZip, String recipientFirstName, String recipientLastName, String recipientPhone, Integer paymentId, String paymentName) {
        this.shippingInformationId = shippingInformationId;
        this.shippingCountry = shippingCountry;
        this.shippingState = shippingState;
        this.shippingCity = shippingCity;
        this.shippingStreet = shippingStreet;
        this.shippingZip = shippingZip;
        this.recipientFirstName = recipientFirstName;
        this.recipientLastName = recipientLastName;
        this.recipientPhone = recipientPhone;
      //  this.orderDetailsId = orderDetailsId;
        this.paymentId = paymentId;
        this.paymentName = paymentName;
    }
    public ShippingInformationPaymentDto() {

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

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
    
    

}
