package com.innopolis.toysshop.repositories;

import com.innopolis.toysshop.models.Toy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToysRepository extends JpaRepository<Toy, Integer> {
    List<Toy> findAllByCustomer_Id(Integer id);
    List<Toy> findAllByCustomerIsNull();
}
