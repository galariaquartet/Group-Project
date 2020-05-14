package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.ShippingInformation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingInformationRepository extends JpaRepository<ShippingInformation, Integer>{
    @Query(value = "SELECT * FROM order_details od, shipping_information si WHERE od.shipping_information_id = si.shipping_information_id AND od.order_number =?1 ", nativeQuery = true)
    public List<ShippingInformation> findShippingInformationByOrderDetailsId(int orderNumber);
}
