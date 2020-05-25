package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.CustomerInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInformationRepository extends JpaRepository<CustomerInformation, Integer> {

}
