package com.example.testRestApi;

import com.example.testRestApi.dto.ItemDto;
import com.example.testRestApi.mapper.ItemMapper;
import com.example.testRestApi.model.Item;
import com.example.testRestApi.service.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class TestRestApi {
	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemMapper itemMapper;

	@Test
	public void testParameters(){
		Item item = new Item();
		item.setName("Mouse");
		item.setDescription("Optical Mouse");
		item.setCreateAt(LocalDateTime.now());

		ItemDto itemDto = itemMapper.toItemDto(item);

		Assertions.assertEquals(item.getName(), itemDto.getName());
		Assertions.assertEquals(item.getCreateAt(), itemDto.getDateCreate());
		Assertions.assertEquals(item.getDescription(), itemDto.getDescription());
	}

	@Test
	public void testAddItem(){

		ItemDto itemDto = new ItemDto();
		itemDto.setName("xxxx");
		itemService.addItem(itemMapper.toItem(itemDto));

		Item item = itemService.getAll().stream().filter(s-> s.getName().equals("xxxx")).findFirst().get();

		itemService.deleteItem(item.getId());
	}


}
