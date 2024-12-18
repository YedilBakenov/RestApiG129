package com.example.testRestApi.controller;


import com.example.testRestApi.model.Item;
import com.example.testRestApi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemRestController {

    private final ItemService itemService;

    @GetMapping("/get-all")
    public List<Item> getAllItems(){
        return itemService.getAll();
    }

    @PostMapping("/add-item")
    public void addItem(@RequestBody Item item){
        itemService.addItem(item);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteItem(@PathVariable int id){
        itemService.deleteItem(id);
    }

    @GetMapping("/search/{id}")
    public Item findById(@PathVariable int id){
        return itemService.findItemById(id);
    }

    @PutMapping("/update")
    public void updateItem(@RequestBody Item item){
        itemService.updateItem(item);
    }
}
