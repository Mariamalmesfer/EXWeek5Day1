package com.example.week5day5.DTO;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Valid
public class CustomerDetailsDTO {

    private Integer customer_id;
    private String gender;
    private Integer age;
    private String email;
}
