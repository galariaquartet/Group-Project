package com.gquartet.GroupProject.dtos;

import com.gquartet.GroupProject.models.CustomerCreditCard;
import com.gquartet.GroupProject.models.CustomerInformation;
import com.gquartet.GroupProject.models.Payment;
import com.gquartet.GroupProject.models.ShippingInformation;


public class ShippingInfoCustomerInfoPaymentDTO {
    private Payment payment;
    private CustomerInformation customerInformation;
    private ShippingInformation ShippingInformation;
    private boolean check; 
    private boolean radioCheck;
    private CustomerCreditCard customerCreditCard;

    public ShippingInfoCustomerInfoPaymentDTO(Payment payment, CustomerInformation customerInformation, ShippingInformation ShippingInformation, boolean check, boolean radioCheck, CustomerCreditCard customerCreditCard) {
        this.payment = payment;
        this.customerInformation = customerInformation;
        this.ShippingInformation = ShippingInformation;
        this.check = check;
        this.radioCheck = radioCheck;
        this.customerCreditCard = customerCreditCard;
    }

    public CustomerCreditCard getCustomerCreditCard() {
        return customerCreditCard;
    }

    public void setCustomerCreditCard(CustomerCreditCard customerCreditCard) {
        this.customerCreditCard = customerCreditCard;
    }



    public boolean isRadioCheck() {
        return radioCheck;
    }

    public void setRadioCheck(boolean radioCheck) {
        this.radioCheck = radioCheck;
    }



    public ShippingInfoCustomerInfoPaymentDTO() {
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    
    

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public CustomerInformation getCustomerInformation() {
        return customerInformation;
    }

    public void setCustomerInformation(CustomerInformation customerInformation) {
        this.customerInformation = customerInformation;
    }

    public ShippingInformation getShippingInformation() {
        return ShippingInformation;
    }

    public void setShippingInformation(ShippingInformation ShippingInformation) {
        this.ShippingInformation = ShippingInformation;
    }
    
    
    
}
