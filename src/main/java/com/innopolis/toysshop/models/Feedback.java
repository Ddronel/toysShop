package com.innopolis.toysshop.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String feedback;

    @ManyToOne
    @JoinColumn(name = "toy_id")
    private Toy toy;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
