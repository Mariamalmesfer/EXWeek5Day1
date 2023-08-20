package com.example.week5day5.Controller;

import com.example.week5day5.ApiResponse.ApiResponse;
import com.example.week5day5.DTO.CustomerDetailsDTO;
import com.example.week5day5.Model.Customer;
import com.example.week5day5.Service.CustomerDetailsService;
import com.example.week5day5.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customerdetails")
public class CustomerDetailsController {

    private final CustomerDetailsService customerDetailsServicec ;
    private final CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid CustomerDetailsDTO customerDetailsDTO){
        customerDetailsServicec.adddetails(customerDetailsDTO);
        return ResponseEntity.status(200).body(new ApiResponse("customer added"));
    }

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(customerDetailsServicec.getAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable  Integer id,@RequestBody @Valid CustomerDetailsDTO customerDetailsDTO){
        customerDetailsServicec.update(id,customerDetailsDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Detail update"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        customerDetailsServicec.deleteDetailsById( id);
        return ResponseEntity.status(200).body(new ApiResponse("Detail deleted"));
    }


}
