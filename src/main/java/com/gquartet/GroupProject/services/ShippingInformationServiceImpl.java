package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.OrderDetails;
import com.gquartet.GroupProject.models.ShippingInformation;
import com.gquartet.GroupProject.repos.ShippingInformationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingInformationServiceImpl implements ShippingInformationService {

    @Autowired
    ShippingInformationRepository repo;

    @Override
    public List<ShippingInformation> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(ShippingInformation shippingInformation) {
        repo.save(shippingInformation);
    }

    @Override
    public ShippingInformation getShippingInformation(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void update(ShippingInformation shippingInformation) {
        ShippingInformation si = repo.getOne(shippingInformation.getShippingInformationId());

        si.setShippingInformationId(shippingInformation.getShippingInformationId());
        si.setShippingCountry(shippingInformation.getShippingCountry());
        si.setShippingState(shippingInformation.getShippingState());
        si.setShippingCity(shippingInformation.getShippingCity());
        si.setShippingStreet(shippingInformation.getShippingStreet());
        si.setShippingZip(shippingInformation.getShippingZip());
        si.setRecipientFirstName(shippingInformation.getRecipientFirstName());
        si.setRecipientLastName(shippingInformation.getRecipientLastName());
        si.setRecipientPhone(shippingInformation.getRecipientPhone());

        repo.save(si);
    }

    @Override
    public List<ShippingInformation> findShippingInformation(int orderNumber) {
        return repo.findShippingInformationByOrderDetailsId(orderNumber);
    }

}
