package com.innopolis.toysshop.services;

import com.innopolis.toysshop.forms.StorageForm;
import com.innopolis.toysshop.models.Storage;
import com.innopolis.toysshop.repositories.StoragesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class StoragesServiceImpl implements StoragesService {

    private final StoragesRepository storagesRepository;

    @Override
    public List<Storage> getAllStorages() {
        return storagesRepository.findAll();
    }

    @Override
    public Storage getStorage(Integer storageId) {
        return storagesRepository.getById(storageId);
    }

    @Override
    public Storage addStorage(StorageForm form) {
        Storage storage = Storage.builder()
                .capacity(form.getCapacity())
                .build();

        return storagesRepository.save(storage);
    }

    @Override
    public void deleteStorage(Integer storageId) {
        storagesRepository.deleteById(storageId);
    }

    @Override
    public Storage updateStorage(StorageForm form, Integer storageId) {
        Storage storage = Storage.builder()
                .id(storageId)
                .capacity(form.getCapacity())
                .build();

        return storagesRepository.save(storage);
    }
}
