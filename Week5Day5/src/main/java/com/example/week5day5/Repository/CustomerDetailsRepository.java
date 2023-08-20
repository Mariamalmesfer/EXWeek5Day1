package com.example.week5day5.Repository;


import com.example.week5day5.Model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails,Integer> {

    CustomerDetails findCustomerDetailsById(Integer id);

 ;
}