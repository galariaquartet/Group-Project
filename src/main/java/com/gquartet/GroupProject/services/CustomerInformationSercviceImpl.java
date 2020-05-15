package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.CustomerInformation;
import com.gquartet.GroupProject.repos.CustomerInformationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerInformationSercviceImpl implements CustomerInformationSercvice {

    @Autowired
    private CustomerInformationRepository repo;

    @Override
    public List<CustomerInformation> listAll() {
        return repo.findAll();
    }

//    @Override
//    public CustomerInformation getCustomerInformation(Integer id) {
//        return repo.findById(id).get();
//    }
    @Override
    public CustomerInformation getCustomerInformation(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void update(CustomerInformation customerInformation) {
        CustomerInformation cI = repo.getOne(customerInformation.getCustomerId());

        cI.setCustomerId(customerInformation.getCustomerId());
        cI.setFirstName(customerInformation.getFirstName());
        cI.setLastName(customerInformation.getLastName());
        cI.setCountry(customerInformation.getCountry());
        cI.setState(customerInformation.getState());
        cI.setCity(customerInformation.getCity());
        cI.setStreet(customerInformation.getStreet());
        cI.setZip(customerInformation.getZip());
        cI.setPhone(customerInformation.getPhone());

        repo.save(cI);

    }

}
