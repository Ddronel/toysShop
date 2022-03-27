package com.innopolis.toysshop.controller;

import com.innopolis.toysshop.models.Customer;
import com.innopolis.toysshop.forms.CustomerForm;
import com.innopolis.toysshop.models.Toy;
import com.innopolis.toysshop.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomersController {

    private final  CustomersService customersService;

    @Autowired
    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/customers")
    public String getCustomersPage(Model model) {
        List<Customer> customers = customersService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/customers/{customer-id}")
    public String getCustomerPage(Model model, @PathVariable("customer-id") Integer customerId) {
        Customer customer = customersService.getCustomer(customerId);
        model.addAttribute("customer", customer);
        return "customer";
    }

    @GetMapping("/customers/{customer-id}/toys")
    public String getToysByCustomer(Model model, @PathVariable("customer-id") Integer customerId) {
        List<Toy> toys = customersService.getToysByCustomer(customerId);
        List<Toy> unusedToys = customersService.getToyWithoutCustomer();
        model.addAttribute("customerId", customerId);
        model.addAttribute("toys", toys);
        model.addAttribute("unusedToys", unusedToys);
        return "toys_of_customer";
    }

    @PostMapping("/customers/{customer-id}/toys")
    public String addToyToCustomer(@PathVariable("customer-id") Integer customerId, @RequestParam("toyId") Integer toyId) {
        customersService.addToyToCustomer(customerId, toyId);
        return "redirect:/customers/" + customerId + "/toys";
    }

    @PostMapping("/customers/{customer-id}/toys/delete")
    public String deleteToyToCustomer(@PathVariable("customer-id") Integer customerId, @RequestParam("toyId") Integer toyId) {
        customersService.deleteToyToCustomer(toyId);
        return "redirect:/customers/" + customerId + "/toys";
    }

    @PostMapping("/customers")
    public String addCustomer(CustomerForm form) {
        customersService.addCustomer(form);
        return "redirect:/customers";
    }

    @PostMapping("/customers/{customer-id}/delete")
    public String deleteCustomer(@PathVariable("customer-id") Integer customerId) {
        customersService.deleteCustomer(customerId);
        return "redirect:/customers";
    }

    @PostMapping("/customers/{customer-id}/update")
    public String update(CustomerForm form, @PathVariable("customer-id") Integer customerId) {
        customersService.updateCustomer(customerId, form);
        return "redirect:/customers";
    }
}
