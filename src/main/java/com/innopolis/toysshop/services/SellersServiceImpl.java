package com.innopolis.toysshop.services;

import com.innopolis.toysshop.forms.SellerForm;
import com.innopolis.toysshop.models.Customer;
import com.innopolis.toysshop.models.Seller;
import com.innopolis.toysshop.repositories.CustomersRepository;
import com.innopolis.toysshop.repositories.SellersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SellersServiceImpl implements SellersService {

    private final SellersRepository sellersRepository;
    private final CustomersRepository customersRepository;


    @Override
    public List<Seller> getAllSellers() {
        return sellersRepository.findAll();
    }

    @Override
    public Seller addSeller(SellerForm form) {
        Seller seller = Seller.builder()
                .first_last_name(form.getFirst_last_name())
                .age(form.getAge())
                .phone_number(form.getPhone_number())
                .build();

        return sellersRepository.save(seller);
    }

    @Override
    public void deleteSeller(Integer sellerId) {
        sellersRepository.deleteById(sellerId);
    }

    @Override
    public Seller updateSeller(Integer sellerId, SellerForm form) {
        Seller seller = Seller.builder()
                .id(sellerId)
                .first_last_name(form.getFirst_last_name())
                .age(form.getAge())
                .phone_number(form.getPhone_number())
                .build();

        return sellersRepository.save(seller);
    }

    @Override
    public Seller getSeller(Integer sellerId) {
        return sellersRepository.getById(sellerId);
    }

    @Override
    public List<Customer> getCustomersBySeller(Integer sellerId) {
        return customersRepository.findAllBySeller_Id(sellerId);
    }

    @Override
    public List<Customer> getCustomersWithoutSeller() {
        return customersRepository.findAllBySellerIsNull();
    }

    @Override
    public Customer addCustomerToSeller(Integer sellerId, Integer customerId) {
        Seller seller = sellersRepository.getById(sellerId);
        Customer customer = customersRepository.getById(customerId);
        customer.setSeller(seller);
        return customersRepository.save(customer);
    }
}