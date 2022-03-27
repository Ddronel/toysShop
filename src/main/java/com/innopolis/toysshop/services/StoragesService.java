package com.innopolis.toysshop.services;

import com.innopolis.toysshop.forms.StorageForm;
import com.innopolis.toysshop.models.Storage;

import java.util.List;

public interface StoragesService {
    List<Storage> getAllStorages();

    Storage getStorage(Integer storageId);

    Storage addStorage(StorageForm form);

    void deleteStorage(Integer storageId);

    Storage updateStorage(StorageForm form, Integer storageId);
}
