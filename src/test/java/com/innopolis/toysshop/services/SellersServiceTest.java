package com.innopolis.toysshop.services;

import com.innopolis.toysshop.ToysShopApplicationTests;
import com.innopolis.toysshop.forms.CustomerForm;
import com.innopolis.toysshop.forms.SellerForm;
import com.innopolis.toysshop.models.Customer;
import com.innopolis.toysshop.models.Seller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SellersServiceTest extends ToysShopApplicationTests {
    @Autowired
    private SellersServiceImpl sellersService;

    @Autowired
    private CustomersServiceImpl customersService;

    SellerForm sellerForm = SellerForm.builder()
            .first_last_name("Артем Ерин")
            .age(19)
            .phone_number("+78787814523")
            .build();

    CustomerForm customerForm = CustomerForm.builder()
            .first_name("Елана")
            .last_name("Коваль")
            .email("gg@mail.ru")
            .address("г Москва, ул. Казанская, д 65, кв 12")
            .build();

    @Test
    void testGetAllSellers() {
        List<Seller> sellers = sellersService.getAllSellers();
        assertNotNull(sellers);
    }

    @Test
    void testGetSeller() {

        Seller createdSeller = sellersService.addSeller(sellerForm);
        Seller seller = sellersService.getSeller(createdSeller.getId());

        assertNotNull(seller);
        assertEquals(seller.getFirst_last_name(), createdSeller.getFirst_last_name());
        assertEquals(seller.getAge(), createdSeller.getAge());
        assertEquals(seller.getPhone_number(), createdSeller.getPhone_number());
    }

    @Test
    void testAddSeller() {
        Seller createSeller = sellersService.addSeller(sellerForm);

        assertNotNull(createSeller.getId());
        assertEquals(sellerForm.getFirst_last_name(), createSeller.getFirst_last_name());
        assertEquals(sellerForm.getAge(), createSeller.getAge());
        assertEquals(sellerForm.getPhone_number(), createSeller.getPhone_number());
    }

    @Test
    void testUpdateSeller() {
        SellerForm sellerFormUpdate = SellerForm.builder()
                .first_last_name("Василиса Бородач")
                .age(45)
                .phone_number("+78965621456")
                .build();
        Seller oldSeller = sellersService.addSeller(sellerForm);
        Seller newSeller = sellersService.updateSeller(oldSeller.getId(),sellerFormUpdate);

        assertEquals(oldSeller.getId(), newSeller.getId(), "Ids shouldn't be changed during the update");
        assertNotEquals(oldSeller.getFirst_last_name(), newSeller.getFirst_last_name());
        assertNotEquals(oldSeller.getAge(), newSeller.getAge());
        assertNotEquals(oldSeller.getPhone_number(), newSeller.getPhone_number());
    }

    @Test
    void testDeleteSeller() {
        Seller createdSeller = sellersService.addSeller(sellerForm);
        sellersService.deleteSeller(createdSeller.getId());
    }

    @Test
    void testAddCustomerToSeller() {
        Customer customer = customersService.addCustomer(customerForm);
        Seller seller = sellersService.addSeller(sellerForm);
        customer = sellersService.addCustomerToSeller(seller.getId(), customer.getId());

        assertNotNull(customer.getSeller());
        assertEquals(seller.getFirst_last_name(), customer.getSeller().getFirst_last_name());
        assertEquals(seller.getAge(), customer.getSeller().getAge());
        assertEquals(seller.getPhone_number(), customer.getSeller().getPhone_number());
    }

    @Test
    void testGetCustomersBySeller() {
        Customer customer = customersService.addCustomer(customerForm);
        Seller seller = sellersService.addSeller(sellerForm);

        customer = sellersService.addCustomerToSeller(seller.getId(), customer.getId());
        List<Customer> customers = sellersService.getCustomersBySeller(customer.getId());
        assertNotNull(customers);
    }

    @Test
    void  testGetProductWithoutSeller() {
        Customer customer = customersService.addCustomer(customerForm);
        List<Customer> customers = sellersService.getCustomersWithoutSeller();
        assertNotNull(customers);
    }
}