package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.CustomerCreditCard;
import com.gquartet.GroupProject.repos.CustomerCreditCardRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCreditCardServiceImpl implements CustomerCreditCardService {

    @Autowired //h spring kalei automata to antikeimeno me olew tis idiothtes me to autowired
    private CustomerCreditCardRepository repo;

    @Override
    public List<CustomerCreditCard> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(CustomerCreditCard customerCreditCard) {
        repo.save(customerCreditCard);
    }

    @Override
    public CustomerCreditCard getCustomerCreditCard(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void update(CustomerCreditCard customerCreditCard) {
        CustomerCreditCard cc = repo.getOne(customerCreditCard.getCardId());
        cc.setCardId(customerCreditCard.getCardId());
        cc.setOwnerFirstName(customerCreditCard.getOwnerFirstName());
        cc.setOwnerLastName(customerCreditCard.getOwnerLastName());
        cc.setCardNumber(customerCreditCard.getCardNumber());
        cc.setCardNumberLastDigits(customerCreditCard.getCardNumberLastDigits());
        cc.setCvv(customerCreditCard.getCvv());
        cc.setExpirationDate(customerCreditCard.getExpirationDate());
        cc.setCustomerId(customerCreditCard.getCustomerId());

        repo.save(cc);
    }

    @Override
    public CustomerCreditCard findCustomerCreditCardByCustomerId(int customerId) {
        return repo.getCustomerCreditCardByCustomerId(customerId);
    }

}
