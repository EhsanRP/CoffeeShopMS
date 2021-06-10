package com.example.cofeeshop.services.conversionUtil.mappers;

import com.example.cofeeshop.domain.Sale;
import com.example.cofeeshop.services.dto.SaleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SaleMapper {

    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);

    SaleDTO saleToSaleDTO(Sale sale);

    Sale saleDTOtoSale(SaleDTO saleDTO);
}
