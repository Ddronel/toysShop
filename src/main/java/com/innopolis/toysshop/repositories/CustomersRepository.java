package com.innopolis.toysshop.repositories;

import com.innopolis.toysshop.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllBySeller_Id(Integer Id);
    List<Customer> findAllBySellerIsNull();
}
