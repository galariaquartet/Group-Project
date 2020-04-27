package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.dtos.CustomerDto;
import com.gquartet.GroupProject.models.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Customer findByUsername(String username);//briskei ton customer analoga me to onoma tou 

    public Customer findByEmail(String email);//briskei ton customer analoga me to onoma tou

    // dhmiourgoume ena query opou 8a kalesei mono tis sthles tou customer pou tou upodiknuoume 
    //epistrefei mia lista apo CustomerDto --> opou thn ftia3ame gia na mporei na emfanizei mono autes tiw sthles k na mhn epistrefei oles tis allles tou customer opou 8a exoun thn timh null
    @Query("SELECT new com.gquartet.GroupProject.dtos.CustomerDto(c.username , c.email) FROM Customer c") //native query opou epistrefei mia lista me ta onomata
    List<CustomerDto> getCustomerUsernameEmail();

    //enallaktikh lush me to apo panw opou 8a epistrefei mia lista me customer opou oi alles sthles 8a epistrfoun null
//    @Query("SELECT new com.gquartet.GroupProject.models.Customer(c.username as username, c.email) FROM Customer c") //native query opou epistrefei mia lista me ta onomata
//    List<Customer> getCustomerUsernameEmail();
}
