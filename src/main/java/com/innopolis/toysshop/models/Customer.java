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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String first_name;
    private String last_name;
    private String email;
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Toy> toys;

    @OneToMany(mappedBy = "customer")
    private List<Feedback> feedbacks;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
