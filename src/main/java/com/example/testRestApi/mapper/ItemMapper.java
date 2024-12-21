package com.example.testRestApi.mapper;


import com.example.testRestApi.dto.ItemDto;
import com.example.testRestApi.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(source = "createAt", target = "dateCreate")
    @Mapping(source = "updateAt", target = "dateUpdate")
    ItemDto toItemDto(Item item);

    @Mapping(source = "dateCreate", target = "createAt")
    @Mapping(source = "dateUpdate", target = "updateAt")
    Item toItem(ItemDto itemDto);

    List<ItemDto> listItemDto(List<Item> list);

    List<Item> listItem(List<ItemDto> itemDtoList);

}
