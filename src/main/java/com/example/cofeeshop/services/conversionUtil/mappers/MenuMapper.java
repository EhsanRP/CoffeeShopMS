package com.example.cofeeshop.services.conversionUtil.mappers;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.services.dto.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuMapper {

    MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);

    MenuDTO menuToMenuDTO(Menu menu);

    Menu menuDTOtoMenu(MenuDTO menuDTO);

}
