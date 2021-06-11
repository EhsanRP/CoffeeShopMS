package com.example.cofeeshop.services;

import com.example.cofeeshop.services.dto.SaleDTO;
import com.example.cofeeshop.services.dto.SaleListDTO;

public interface SaleService {

    SaleListDTO findAllSales();

    SaleDTO findSaleById(Long id);

    SaleDTO editSale(Long saleId,SaleDTO saleDTO);

    SaleDTO createSale(SaleDTO saleDTO);
}
