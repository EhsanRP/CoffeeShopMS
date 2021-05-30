package com.example.cofeeshop.services.conversionUtil.mappers;

import com.example.cofeeshop.domain.Item;
import com.example.cofeeshop.services.dto.ItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    Item itemDTOtoItem(ItemDTO itemDTO);

    ItemDTO itemToItemDTO(Item item);
}
