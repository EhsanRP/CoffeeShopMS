package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Sale;
import com.example.cofeeshop.services.dto.SaleDTO;
import com.example.cofeeshop.services.dto.SaleListDTO;

import java.util.List;
import java.util.Set;

public interface SaleUtil {

    SaleDTO saleToSaleDTO(Sale sale);

    SaleListDTO listAllSales(List<Sale> sales);

    Sale saleDTOtoSale(SaleDTO saleDTO);

    Set<Sale> listAllSales(Set<SaleDTO> saleDTOS);
}
