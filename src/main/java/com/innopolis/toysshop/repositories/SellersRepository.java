package com.innopolis.toysshop.repositories;

import com.innopolis.toysshop.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellersRepository extends JpaRepository<Seller, Integer> {
}
