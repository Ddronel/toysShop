package com.innopolis.toysshop.services;

import com.innopolis.toysshop.forms.SellerForm;
import com.innopolis.toysshop.models.Customer;
import com.innopolis.toysshop.models.Seller;

import java.util.List;

public interface SellersService {
    List<Seller> getAllSellers();

    Seller addSeller(SellerForm form);

    void deleteSeller(Integer sellerId);

    Seller updateSeller(Integer sellerId, SellerForm form);

    Seller getSeller(Integer sellerId);

    List<Customer> getCustomersBySeller(Integer sellerId);

    List<Customer> getCustomersWithoutSeller();

    Customer addCustomerToSeller(Integer sellerId, Integer customerId);
}
