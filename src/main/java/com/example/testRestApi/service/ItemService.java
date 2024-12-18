package com.example.testRestApi.service;

import com.example.testRestApi.model.Item;
import com.example.testRestApi.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    public List<Item> getAll(){
        return repository.findAll();
    }

    public void addItem(Item item){
        repository.save(item);
    }

    public void updateItem(Item item){
        item.setCreateAt(findItemById(item.getId()).getCreateAt());
        repository.save(item);
    }

    public void deleteItem(int id){
        repository.deleteById(id);
    }

    public Item findItemById(int id){
        return repository.findById(id).get();
    }
}