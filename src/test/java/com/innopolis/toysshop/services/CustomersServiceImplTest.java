package com.innopolis.toysshop.services;

import com.innopolis.toysshop.ToysShopApplicationTests;
import com.innopolis.toysshop.forms.CustomerForm;
import com.innopolis.toysshop.forms.ToyForm;
import com.innopolis.toysshop.models.Customer;
import com.innopolis.toysshop.models.Toy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomersServiceImplTest extends ToysShopApplicationTests {

    @Autowired
    private CustomersServiceImpl customersService;

    @Autowired
    private ToysServiceImpl toysService;

    CustomerForm customerForm = CustomerForm.builder()
            .first_name("")
            .last_name("Бледных")
            .email("edblednykh@mail.ru")
            .address("Азино, дом 25")
            .build();

    ToyForm toyForm = ToyForm.builder()
            .description("")
            .cost(22)
            .size("")
            .build();

    @Test
    void testGetAllCustomers() {
        List<Customer> customers = customersService.getAllCustomers();
        assertNotNull(customers);
    }

    @Test
    void testGetCustomer() {

        Customer createdCustomer = customersService.addCustomer(customerForm);
        Customer customer = customersService.getCustomer(createdCustomer.getId());

        assertNotNull(customer);
        assertEquals(customer.getFirst_name(), createdCustomer.getFirst_name());
        assertEquals(customer.getLast_name(), createdCustomer.getLast_name());
        assertEquals(customer.getEmail(), createdCustomer.getEmail());
        assertEquals(customer.getAddress(), createdCustomer.getAddress());
    }

    @Test
    void testAddCustomer() {
        Customer createCustomer = customersService.addCustomer(customerForm);

        assertNotNull(createCustomer.getId());
        assertEquals(customerForm.getFirst_name(), createCustomer.getFirst_name());
        assertEquals(customerForm.getLast_name(), createCustomer.getLast_name());
        assertEquals(customerForm.getEmail(), createCustomer.getEmail());
        assertEquals(customerForm.getAddress(), createCustomer.getAddress());
    }

    @Test
    void testUpdateCustomer() {
        CustomerForm customerFormUpdate = CustomerForm.builder()
                .first_name("Анатолий")
                .last_name("Фирсанов")
                .email("firs@mail.ru")
                .address("Спартаковская, дом 25")
                .build();
        Customer oldCustomer = customersService.addCustomer(customerForm);
        Customer newCustomer = customersService.updateCustomer(oldCustomer.getId(), customerFormUpdate);

        assertEquals(oldCustomer.getId(), newCustomer.getId(), "Ids shouldn't be changed during the update");
        assertNotEquals(oldCustomer.getFirst_name(), newCustomer.getFirst_name());
        assertNotEquals(oldCustomer.getLast_name(), newCustomer.getLast_name());
        assertNotEquals(oldCustomer.getEmail(), newCustomer.getEmail());
        assertNotEquals(oldCustomer.getAddress(), newCustomer.getAddress());
    }

    @Test
    void testDeleteCustomer() {
        Customer createdCustomer = customersService.addCustomer(customerForm);
        customersService.deleteCustomer(createdCustomer.getId());
    }

    @Test
    void testAddToyToCustomer() {
        Toy toy = toysService.addToy(toyForm);
        Customer customer = customersService.addCustomer(customerForm);
        toy = customersService.addToyToCustomer(customer.getId(), toy.getId());

        assertNotNull(toy.getCustomer());
        assertEquals(customer.getFirst_name(), toy.getCustomer().getFirst_name());
        assertEquals(customer.getLast_name(), toy.getCustomer().getLast_name());
        assertEquals(customer.getEmail(), toy.getCustomer().getEmail());
        assertEquals(customer.getAddress(), toy.getCustomer().getAddress());
    }

    @Test
    void testDeleteToyToCustomer() {
        Toy toy = toysService.addToy(toyForm);
        Customer customer = customersService.addCustomer(customerForm);

        toy = customersService.addToyToCustomer(customer.getId(), toy.getId());
        assertNotNull(toy.getCustomer());

        toy = customersService.deleteToyToCustomer(toy.getId());
        assertNull(toy.getCustomer());
    }

    @Test
    void testGetToysByCustomer() {
        Toy toy = toysService.addToy(toyForm);
        Customer customer = customersService.addCustomer(customerForm);

        toy = customersService.addToyToCustomer(customer.getId(), toy.getId());
        List<Toy> toys = customersService.getToysByCustomer(toy.getId());
        assertNotNull(toys);
    }

    @Test
    void  testGetToyWithoutCustomer() {
        Toy toy = toysService.addToy(toyForm);
        List<Toy> toys = customersService.getToyWithoutCustomer();
        assertNotNull(toys);
    }
}