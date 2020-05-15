package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.CustomerInformation;
import java.util.List;

public interface CustomerInformationSercvice {

    public List<CustomerInformation> listAll();

//    public void save(CustomerInformation customerInformation);
    public CustomerInformation getCustomerInformation(Integer id);

    public void update(CustomerInformation customerInformation);

}
