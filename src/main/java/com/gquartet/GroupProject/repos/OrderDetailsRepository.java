package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.dtos.OrderDetailsDTO;
import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.models.CustomerOrder;
import com.gquartet.GroupProject.models.OrderDetails;
import com.gquartet.GroupProject.models.ShippingInformation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    //   public List<OrderDetails> findByOrderNumber(CustomerOrder id);
//    public List<OrderDetailsDTO> findByOrderNumber(CustomerOrder id);
//    
    //   @Query(value = "SELECT * FROM order_details od, shipping_information si, product p, payment pa WHERE od.shipping_information_id = si.shipping_information_id AND od.product_id = p.product_id AND pa.payment_id = od.payment_id AND od.order_number =?1 ", nativeQuery = true)
    public List<OrderDetails> findByOrderNumber(CustomerOrder id);

}
