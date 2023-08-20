package com.example.week5day5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class CustomerDetails  {

    @Id
    private Integer id;

    private String gender;

    private Integer age;

    private String email;


    @OneToOne
    @MapsId
    @JsonIgnore
    Customer customer;




}


