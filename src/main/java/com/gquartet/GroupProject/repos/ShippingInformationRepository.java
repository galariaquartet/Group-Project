package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.ShippingInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingInformationRepository extends JpaRepository<ShippingInformation, Integer>{
    
}
