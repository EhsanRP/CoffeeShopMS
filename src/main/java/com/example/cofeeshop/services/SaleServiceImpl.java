package com.example.cofeeshop.services;

import com.example.cofeeshop.repositories.FoodRepository;
import com.example.cofeeshop.repositories.SaleRepository;
import com.example.cofeeshop.services.conversionUtil.ConversionUtil;
import com.example.cofeeshop.services.dto.SaleDTO;
import com.example.cofeeshop.services.dto.SaleListDTO;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Value
@Service
public class SaleServiceImpl implements SaleService {

    SaleRepository saleRepository;
    FoodRepository foodRepository;

    ConversionUtil conversionUtil;

    @Override
    public SaleListDTO findAllSales() {
        return null;
    }

    @Override
    public SaleDTO findSaleById(Long id) {
        return null;
    }

    @Override
    public SaleDTO editSale(Long saleId, SaleDTO saleDTO) {
        return null;
    }

    @Override
    public SaleDTO createSale(Long foodId, Integer quantity) {
        return null;
    }
}
