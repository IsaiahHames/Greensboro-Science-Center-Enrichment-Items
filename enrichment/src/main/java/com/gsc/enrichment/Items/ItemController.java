package com.gsc.enrichment.Items;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/items")
public class ItemController {

    private ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public String listItems(Model model) {
        model.addAttribute("items", service.getAllItems());
        return "items";
    }

    @GetMapping("/new")
    public String newItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "add-item";
    }

    @PostMapping
    public String saveItem(@ModelAttribute Item item,
                           @RequestParam("imageFile") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            File uploadDir = new File("src/main/resources/static/images");
            if (!uploadDir.exists()) uploadDir.mkdirs();
            String path = "images/" + file.getOriginalFilename();
            file.transferTo(new File(uploadDir, file.getOriginalFilename()));
            item.setImagePath(path);
        }
        service.saveItem(item);
        return "redirect:/items";
    }

    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        model.addAttribute("item", service.getItemByID(id));
        return "edit-item";
    }

    @PostMapping("/update/{id}")
    public String updateItem(@PathVariable Long id, @ModelAttribute Item updatedItem) {
        Item existing = service.getItemByID(id);
        existing.setName(updatedItem.getName());
        existing.setLastLocation(updatedItem.getLastLocation());
        existing.setAvailable(updatedItem.isAvailable());
        service.saveItem(existing);
        return "redirect:/items";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return "redirect:/items";
    }

    @GetMapping("/checkout/{id}")
    public String checkOut(@PathVariable Long id) {
        service.checkOut(id);
        return "redirect:/items";
    }

    @GetMapping("/checkin/{id}")
    public String checkIn(@PathVariable Long id) {
        service.checkIn(id);
        return "redirect:/items";
    }
    
}
