package com.example.week5day5.Service;


import com.example.week5day5.ApiResponse.ApiException;
import com.example.week5day5.Model.Customer;
import com.example.week5day5.Model.CustomerDetails;
import com.example.week5day5.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAll(){

        return customerRepository.findAll();
    }


    public void addcustomer(Customer customer){
        customerRepository.save(customer);
    }



    public void updatecustomer(Integer id, Customer customer){
        Customer oldcustomer=customerRepository.findCustomerById(id);
        if(oldcustomer==null){
            throw new ApiException("id not found");
        }

        oldcustomer.setName(customer.getName());
        customerRepository.save(oldcustomer);

    }
    public void deletecustomer(Integer id){

        Customer oldcustomer=customerRepository.findCustomerById(id);
        if(oldcustomer==null){
            throw new ApiException("id not found");
        }
        customerRepository.deleteById(id);
    }


}
