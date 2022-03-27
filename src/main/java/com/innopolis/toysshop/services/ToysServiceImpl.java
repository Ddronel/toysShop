package com.innopolis.toysshop.services;

import com.innopolis.toysshop.forms.ToyForm;
import com.innopolis.toysshop.models.Toy;
import com.innopolis.toysshop.repositories.ToysRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ToysServiceImpl implements ToysService {

    private final ToysRepository toysRepository;

    @Override
    public List<Toy> getAllToys() {
        return toysRepository.findAll();
    }

    @Override
    public Toy addToy(ToyForm form) {
        Toy toy = Toy.builder()
                .description(form.getDescription())
                .cost(form.getCost())
                .size(form.getSize())
                .build();

        return toysRepository.save(toy);
    }

    @Override
    public void deleteToy(Integer toyId) {
        toysRepository.deleteById(toyId);
    }

    @Override
    public Toy updateToy(Integer toyId, ToyForm form) {
        Toy toy = Toy.builder()
                .id(toyId)
                .description(form.getDescription())
                .cost(form.getCost())
                .size(form.getSize())
                .build();

        return toysRepository.save(toy);
    }

    @Override
    public Toy getToy(Integer toyId) {
        return toysRepository.getById(toyId);
    }
}
