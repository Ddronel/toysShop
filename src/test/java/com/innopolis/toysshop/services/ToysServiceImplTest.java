package com.innopolis.toysshop.services;

import com.innopolis.toysshop.ToysShopApplicationTests;
import com.innopolis.toysshop.forms.ToyForm;
import com.innopolis.toysshop.models.Toy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToysServiceImplTest extends ToysShopApplicationTests {

    @Autowired
    private ToysServiceImpl toysService;

    ToyForm toyForm = ToyForm.builder()
            .description("Tomato")
            .cost(34)
            .size("Middle")
            .build();

    @Test
    void testGetAllToys() {
        List<Toy> toyList = toysService.getAllToys();
        assertNotNull(toyList);
    }

    @Test
    void testGetToy() {

        Toy createdToy = toysService.addToy(toyForm);
        Toy toy = toysService.getToy(createdToy.getId());

        assertNotNull(toy);
        assertEquals(toy.getId(), createdToy.getId());
        assertEquals(toy.getDescription(), createdToy.getDescription());
        assertEquals(toy.getCost(), createdToy.getCost());
        assertEquals(toy.getSize(), createdToy.getSize());
    }

    @Test
    void testAddToy() {
        Toy createToy = toysService.addToy(toyForm);

        assertNotNull(createToy.getId());
        assertEquals(toyForm .getDescription(), createToy.getDescription());
        assertEquals(toyForm .getCost(), createToy.getCost());
        assertEquals(toyForm .getSize(), createToy.getSize());
    }

    @Test
    void testUpdateToy() {
        ToyForm toyFormUpdate = ToyForm.builder()
                .description("reddy")
                .cost(340)
                .size("small")
                .build();
        Toy oldToy = toysService.addToy(toyForm);
        Toy newToy = toysService.updateToy(oldToy.getId(), toyFormUpdate);

        assertEquals(oldToy.getId(), newToy.getId(), "Ids shouldn't be changed during the update");
        assertNotEquals(oldToy.getDescription(), newToy.getDescription());
        assertNotEquals(oldToy.getCost(), newToy.getCost());
        assertNotEquals(oldToy.getSize(), newToy.getSize());
    }

    @Test
    void testDeleteToy() {
        Toy createdToy = toysService.addToy(toyForm);
        toysService.deleteToy(createdToy.getId());
    }
}