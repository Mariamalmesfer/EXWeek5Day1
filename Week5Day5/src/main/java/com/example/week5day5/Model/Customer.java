package com.example.week5day5.Model;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition="varchar(20) not null")
    private String name;



    @OneToOne(cascade =CascadeType.ALL,mappedBy = "customer")
    @PrimaryKeyJoinColumn

            CustomerDetails customerDetails;
}
