package com.gquartet.GroupProject.validators;

import com.gquartet.GroupProject.dtos.RegisterCustomerDto;
import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {

    @Autowired
    private CustomerService customerService;

    @Override
    public boolean supports(Class<?> type) {
        return RegisterCustomerDto.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegisterCustomerDto c = (RegisterCustomerDto) o;

        boolean customerUsernameExists = customerService.existsCustomerUsername(c.getUsername());//elegx an to username uparxei hdh sth bash
        boolean customerEmailExists = customerService.existsCustomerEmail(c.getEmail());//elegxw an to email uparxei hdh sth 

//na balw na epistrefei boolean metablhth anti gia ton customer
        if (customerUsernameExists == true) {// wrong username          
            errors.rejectValue("username", "customerUsername.exists");
        }
        if (customerEmailExists == true) {
            errors.rejectValue("email", "customerEmail.exists");
        }
        if (!c.getPassword().equals(c.getPassword2())) {
            errors.rejectValue("password2", "cPassoword.no.match"); //den prepei na uparxoun ka8olou kena gia na tre3ei
        }
    }

}
