package com.example.week5day5.Controller;

import com.example.week5day5.ApiResponse.ApiResponse;
import com.example.week5day5.Model.Customer;
import com.example.week5day5.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {


    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(customerService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Customer customer){
        customerService.addcustomer(customer);
        return ResponseEntity.status(200).body(new ApiResponse("customer added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Customer customer){
        customerService.updatecustomer(id, customer);
        return ResponseEntity.status(200).body(new ApiResponse("customer updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        customerService.deletecustomer(id);
        return ResponseEntity.status(200).body(new ApiResponse("customer deleted"));
    }




}
