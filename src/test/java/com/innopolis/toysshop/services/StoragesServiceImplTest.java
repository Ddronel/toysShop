package com.innopolis.toysshop.services;

import com.innopolis.toysshop.ToysShopApplicationTests;
import com.innopolis.toysshop.forms.StorageForm;
import com.innopolis.toysshop.models.Storage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoragesServiceImplTest extends ToysShopApplicationTests {

    @Autowired
    private StoragesServiceImpl storagesService;

    StorageForm storageForm = StorageForm.builder()
            .capacity(900)
            .build();

    @Test
    void testGetAllStorages() {
        List<Storage> storageList = storagesService.getAllStorages();
        assertNotNull(storageList);
    }

    @Test
    void testGetStorage() {

        Storage createdStorage = storagesService.addStorage(storageForm);
        Storage storage = storagesService.getStorage(createdStorage.getId());

        assertNotNull(storage);
        assertEquals(storage.getId(), createdStorage.getId());
        assertEquals(storage.getCapacity(), createdStorage.getCapacity());
    }

    @Test
    void testAddStorage() {
        Storage createStorage = storagesService.addStorage(storageForm);

        assertNotNull(createStorage.getId());
        assertEquals(storageForm.getCapacity(), createStorage.getCapacity());
    }

    @Test
    void testUpdateStorage() {
        StorageForm storageFormUpdate = StorageForm.builder()
                .capacity(400)
                .build();
        Storage oldStorage = storagesService.addStorage(storageForm);
        Storage newStorage = storagesService.updateStorage(storageFormUpdate, oldStorage.getId());

        assertEquals(oldStorage.getId(), newStorage.getId(), "Ids shouldn't be changed during the update");
        assertNotEquals(oldStorage.getCapacity(), newStorage.getCapacity());
    }

    @Test
    void testDeleteStorage() {
        Storage createdStorage = storagesService.addStorage(storageForm);
        storagesService.deleteStorage(createdStorage.getId());
    }
}