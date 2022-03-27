package com.innopolis.toysshop.services;

import com.innopolis.toysshop.forms.ToyForm;
import com.innopolis.toysshop.models.Toy;

import java.util.List;

public interface ToysService {
    List<Toy> getAllToys();

    Toy addToy(ToyForm form);

    void deleteToy(Integer toyId);

    Toy updateToy(Integer toyId, ToyForm form);

    Toy getToy(Integer toyId);
}
