package com.innopolis.toysshop.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String first_last_name;
    private Integer age;
    private String phone_number;

    @OneToMany(mappedBy = "seller")
    private List<Customer> customers;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;
}
