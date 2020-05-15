package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.CustomerCreditCard;
import java.util.List;

public interface CustomerCreditCardService {

    public List<CustomerCreditCard> listAll();

    public void save(CustomerCreditCard customerCreditCard);

    public CustomerCreditCard getCustomerCreditCard(Integer id);

    public void delete(Integer id);

    public void update(CustomerCreditCard customerCreditCard);

    public CustomerCreditCard findCustomerCreditCardByCustomerId(int customerId);

}
