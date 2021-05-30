package com.example.cofeeshop.services.conversionUtil.mappers;

import com.example.cofeeshop.domain.Bill;
import com.example.cofeeshop.services.dto.BillDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillMapper {

    BillMapper INSTANCE = Mappers.getMapper(BillMapper.class);

    Bill billDTOtoBill(BillDTO billDTO);

    BillDTO billToBillDTO(Bill bill);
}
