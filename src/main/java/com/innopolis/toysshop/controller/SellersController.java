package com.innopolis.toysshop.controller;

import com.innopolis.toysshop.forms.CustomerForm;
import com.innopolis.toysshop.forms.SellerForm;
import com.innopolis.toysshop.models.Customer;
import com.innopolis.toysshop.models.Seller;
import com.innopolis.toysshop.models.Toy;
import com.innopolis.toysshop.services.SellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SellersController {

    private final SellersService sellersService;

    @Autowired
    public SellersController(SellersService sellersService) {
        this.sellersService = sellersService;
    }

    @GetMapping("/sellers")
    public String getSellersPage(Model model) {
        List<Seller> sellers = sellersService.getAllSellers();
        model.addAttribute("sellers", sellers);
        return "sellers";
    }

    @GetMapping("/sellers/{seller-id}")
    public String getSellerPage(Model model, @PathVariable("seller-id") Integer sellerId) {
        Seller seller = sellersService.getSeller(sellerId);
        model.addAttribute("seller", seller);
        return "seller";
    }

    @GetMapping("/sellers/{seller-id}/customers")
    public String getCustomersBySeller(Model model, @PathVariable("seller-id") Integer sellerId) {
        List<Customer> customers = sellersService.getCustomersBySeller(sellerId);
        List<Customer> unCustomers = sellersService.getCustomersWithoutSeller();
        model.addAttribute("sellerId", sellerId);
        model.addAttribute("customers", customers);
        model.addAttribute("unCustomers", unCustomers);
        return "customers_of_seller";
    }

    @PostMapping("/sellers/{seller-id}/customers")
    public String addCustomerToSeller(@PathVariable("seller-id") Integer sellerId, @RequestParam("customerId") Integer customerId) {
        sellersService.addCustomerToSeller(sellerId, customerId);
        return "redirect:/sellers/" + sellerId + "/customers";
    }

    @PostMapping("/sellers")
    public String addSeller(SellerForm form) {
        sellersService.addSeller(form);
        return "redirect:/sellers";
    }

    @PostMapping("/sellers/{seller-id}/delete")
    public String deleteSeller(@PathVariable("seller-id") Integer sellerId) {
        sellersService.deleteSeller(sellerId);
        return "redirect:/sellers";
    }

    @PostMapping("/sellers/{seller-id}/update")
    public String update(SellerForm form, @PathVariable("seller-id") Integer sellerId) {
        sellersService.updateSeller(sellerId, form);
        return "redirect:/sellers";
    }
}
