package com.innopolis.toysshop.controller;

import com.innopolis.toysshop.forms.StorageForm;
import com.innopolis.toysshop.models.Storage;
import com.innopolis.toysshop.services.StoragesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StoragesController {

    private final StoragesService storagesService;

    @Autowired
    public StoragesController(StoragesService storagesService) {
        this.storagesService = storagesService;
    }


    @GetMapping("/storages")
    public String getStoragesPage(Model model) {
        List<Storage> storages = storagesService.getAllStorages();
        model.addAttribute("storages", storages);
        return "/storages";
    }

    @GetMapping("/storages/{storage-id}")
    public String getStoragePage(Model model, @PathVariable("storage-id") Integer storageId) {
        Storage storage = storagesService.getStorage(storageId);
        model.addAttribute("storage", storage);
        return "storage";
    }

    @PostMapping("/storages")
    public String addStorage(StorageForm form) {
        storagesService.addStorage(form);
        return "redirect:/storages";
    }

    @PostMapping("/storages/{storage-id}/delete")
    public String deleteStorage(@PathVariable("storage-id") Integer storageId) {
        storagesService.deleteStorage(storageId);
        return "redirect:/storages";
    }

    @PostMapping("/storages/{storage-id}/update")
    public String UpdateStorage(StorageForm form, @PathVariable("storage-id") Integer storageId) {
        storagesService.updateStorage(form, storageId);
        return "redirect:/storages";
    }


}
