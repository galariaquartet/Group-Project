package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.ShippingInformation;
import java.util.List;

public interface ShippingInformationService {

    public List<ShippingInformation> listAll();

    public void save(ShippingInformation shippingInformation);

    public ShippingInformation getShippingInformation(Integer id);

    public void delete(Integer id);

    public void update(ShippingInformation shippingInformation);
    
    public List<ShippingInformation> findShippingInformation(int orderNumber);

}
