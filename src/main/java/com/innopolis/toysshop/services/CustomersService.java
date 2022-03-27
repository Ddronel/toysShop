package com.innopolis.toysshop.services;

import com.innopolis.toysshop.forms.CustomerForm;
import com.innopolis.toysshop.models.Customer;
import com.innopolis.toysshop.models.Toy;

import java.util.List;

public interface CustomersService {
    Customer addCustomer(CustomerForm form);

    List<Customer> getAllCustomers();

    void deleteCustomer(Integer customerId);

    Customer getCustomer(Integer customerId);

    Customer updateCustomer(Integer customerId, CustomerForm form);

    List<Toy> getToysByCustomer(Integer customerId);

    List<Toy> getToyWithoutCustomer();

    Toy addToyToCustomer(Integer customerId, Integer toyId);

    Toy deleteToyToCustomer(Integer toyId);
}
