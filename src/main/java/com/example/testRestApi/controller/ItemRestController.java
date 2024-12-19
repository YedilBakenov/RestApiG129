package com.example.testRestApi.controller;


import com.example.testRestApi.dto.ItemDto;
import com.example.testRestApi.mapper.ItemMapper;
import com.example.testRestApi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemRestController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @GetMapping("/get-all")
    public List<ItemDto> getAllItems(){
        return itemMapper.listItemDto(itemService.getAll());
    }

    @PostMapping("/add-item")
    public void addItem(@RequestBody ItemDto itemDto){
        itemService.addItem(itemMapper.toItem(itemDto));
    }

    @DeleteMapping("/remove/{id}")
    public void deleteItem(@PathVariable int id){
        itemService.deleteItem(id);
    }

    @GetMapping("/search/{id}")
    public ItemDto findById(@PathVariable int id){
        return  itemMapper.toItemDto(itemService.findItemById(id));
    }

    @PutMapping("/update")
    public void updateItem(@RequestBody ItemDto itemDto){
        itemService.updateItem(itemMapper.toItem(itemDto));
    }
}
