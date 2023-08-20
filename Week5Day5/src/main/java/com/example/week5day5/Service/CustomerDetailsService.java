package com.example.week5day5.Service;

import com.example.week5day5.ApiResponse.ApiException;
import com.example.week5day5.DTO.CustomerDetailsDTO;
import com.example.week5day5.Model.Customer;
import com.example.week5day5.Model.CustomerDetails;
import com.example.week5day5.Repository.CustomerDetailsRepository;
import com.example.week5day5.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerDetailsService {
    final private CustomerRepository customerRepository;
    private final CustomerDetailsRepository customerDetailsRepository;

    public void adddetails(CustomerDetailsDTO customerDetailsDTO) {
        Customer customer = customerRepository.findCustomerById(customerDetailsDTO.getCustomer_id());

        if (customer == null) {
            throw new ApiException("id is null");
        }
        CustomerDetails customerDetails = new CustomerDetails(null, customerDetailsDTO.getGender(), customerDetailsDTO.getAge(), customerDetailsDTO.getEmail(), customer);
        customerDetailsRepository.save(customerDetails);
    }


    public List<CustomerDetails> getAll() {

        return customerDetailsRepository.findAll();
    }

    public void update(Integer id,CustomerDetailsDTO customerDetailsDTO){
        Customer oldcustomer=customerRepository.findCustomerById(customerDetailsDTO.getCustomer_id());
        CustomerDetails customerDetails = customerDetailsRepository.findCustomerDetailsById(id);
        if(oldcustomer==null){
            throw new ApiException("id not found");
        }
        customerDetails.setGender(customerDetailsDTO.getGender());
        customerDetails.setAge(customerDetailsDTO.getAge());
        customerDetails.setEmail(customerDetailsDTO.getEmail());
        customerDetails.setCustomer(oldcustomer);


        customerDetailsRepository.save(customerDetails);

    }


    public void deleteDetailsById(Integer id) {
        CustomerDetails customerDetails = customerDetailsRepository.findCustomerDetailsById(id);
        Customer customer = customerRepository.findCustomerById(id);

        if (customerDetails == null) {
            throw new ApiException("id not found");
        }

        customer.setCustomerDetails(null);
        customerRepository.save(customer);
        customerDetailsRepository.deleteById(id);
    }






}

