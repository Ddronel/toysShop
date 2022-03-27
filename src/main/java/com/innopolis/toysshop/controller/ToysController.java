package com.innopolis.toysshop.controller;

import com.innopolis.toysshop.forms.SellerForm;
import com.innopolis.toysshop.forms.ToyForm;
import com.innopolis.toysshop.models.Customer;
import com.innopolis.toysshop.models.Seller;
import com.innopolis.toysshop.models.Toy;
import com.innopolis.toysshop.services.ToysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ToysController {

    private final ToysService toysService;

    @Autowired
    public ToysController(ToysService toysService) {
        this.toysService = toysService;
    }

    @GetMapping("/toys")
    public String getToysPage(Model model) {
        List<Toy> toys = toysService.getAllToys();
        model.addAttribute("toys", toys);
        return "toys";
    }

    @GetMapping("/toys/{toy-id}")
    public String getToyPage(Model model, @PathVariable("toy-id") Integer toyId) {
        Toy toy = toysService.getToy(toyId);
        model.addAttribute("toy", toy);
        return "toy";
    }

    @PostMapping("/toys")
    public String addToy(ToyForm form) {
        toysService.addToy(form);
        return "redirect:/toys";
    }

    @PostMapping("/toys/{toy-id}/delete")
    public String deleteToy(@PathVariable("toy-id") Integer toyId) {
        toysService.deleteToy(toyId);
        return "redirect:/toys";
    }

    @PostMapping("/toys/{toy-id}/update")
    public String update(ToyForm form, @PathVariable("toy-id") Integer toyId) {
        toysService.updateToy(toyId, form);
        return "redirect:/toys";
    }
}
