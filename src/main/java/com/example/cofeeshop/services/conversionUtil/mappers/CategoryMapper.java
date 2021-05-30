package com.example.cofeeshop.services.conversionUtil.mappers;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.services.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);


    Category categoryDTOtoCategory(CategoryDTO categoryDTO);

    CategoryDTO categoryToCategoryDTO(Category category);
}
