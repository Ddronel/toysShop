package com.innopolis.toysshop.services;

import com.innopolis.toysshop.forms.CustomerForm;
import com.innopolis.toysshop.models.Customer;
import com.innopolis.toysshop.models.Toy;
import com.innopolis.toysshop.repositories.CustomersRepository;
import com.innopolis.toysshop.repositories.ToysRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CustomersServiceImpl implements CustomersService {

    private final CustomersRepository customersRepository;
    private final ToysRepository toysRepository;


    @Override
    public Customer addCustomer(CustomerForm form) {
        Customer customer = Customer.builder()
                .first_name(form.getFirst_name())
                .last_name(form.getLast_name())
                .email(form.getEmail())
                .address(form.getAddress())
                .build();

        return customersRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Integer customerId, CustomerForm form) {
        Customer customer = Customer.builder()
                .id(customerId)
                .first_name(form.getFirst_name())
                .last_name(form.getLast_name())
                .email(form.getEmail())
                .address(form.getAddress())
                .build();

        return customersRepository.save(customer);
    }

    @Override
    public List<Toy> getToysByCustomer(Integer customerId) {
        return toysRepository.findAllByCustomer_Id(customerId);
    }

    @Override
    public List<Toy> getToyWithoutCustomer() {
        return toysRepository.findAllByCustomerIsNull();
    }

    @Override
    public Toy addToyToCustomer(Integer customerId, Integer toyId) {
        Customer customer = customersRepository.getById(customerId);
        Toy toy = toysRepository.getById(toyId);
        toy.setCustomer(customer);
        return toysRepository.save(toy);
    }

    @Override
    public Toy deleteToyToCustomer(Integer toyId) {
        Toy toy = toysRepository.getById(toyId);
        toy.setCustomer(null);
        return toysRepository.save(toy);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customersRepository.findAll();
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customersRepository.deleteById(customerId);
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        return customersRepository.getById(customerId);
    }
}
