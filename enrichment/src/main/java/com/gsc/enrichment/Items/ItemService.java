package com.gsc.enrichment.Items;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //Get all items
    public Object getAllItems() {
        return itemRepository.findAll();
    }

    //Get item by ID
    public Item getItemByID(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    //Get item by name
    public Object getItemByName(String name) {
        return itemRepository.findByName(name);
    }

    //Save item
    public Object saveItem(Item item) {
        return itemRepository.save(item);
    }

    //Delete item
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    //Check in item
    public Object checkIn(Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setAvailable(true);
        return itemRepository.save(item);
    }

    //Check out item
    public Object checkOut(Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setAvailable(false);
        return itemRepository.save(item);
    }

    
    
}
