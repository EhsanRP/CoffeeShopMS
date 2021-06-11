package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Sale;
import com.example.cofeeshop.exceptions.NotFoundException;
import com.example.cofeeshop.repositories.FoodRepository;
import com.example.cofeeshop.services.conversionUtil.mappers.SaleMapper;
import com.example.cofeeshop.services.dto.SaleDTO;
import com.example.cofeeshop.services.dto.SaleListDTO;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Value
@Service
public class SaleUtilImpl implements SaleUtil {

    FoodRepository foodRepository;

    FoodUtil foodUtil;

    SaleMapper saleMapper;
    URIUtil uriUtil;

    @Override
    public SaleDTO saleToSaleDTO(Sale sale) {
        var saleDTO = saleMapper.saleToSaleDTO(sale);

        saleDTO.setFoodId(sale.getFood().getId());
        saleDTO.setUrl(uriUtil.saleUriBuilder(saleDTO));

        return saleDTO;
    }

    @Override
    public SaleListDTO listAllSales(List<Sale> sales) {
        List<SaleDTO> saleDTOList = new ArrayList<>();
        sales.forEach(sale -> saleDTOList.add(saleToSaleDTO(sale)));
        return new SaleListDTO(saleDTOList);
    }

    @Override
    public Sale saleDTOtoSale(SaleDTO saleDTO) {
        var sale = saleMapper.saleDTOtoSale(saleDTO);
        var food = foodRepository.findById(saleDTO.getFoodId()).orElseThrow(NotFoundException::new);

        sale.setFood(food);
        sale.setProfit(food.getProfit());
        sale.setUnitPrice(food.getProfit());

        return sale;
    }

    @Override
    public Set<Sale> listAllSales(Set<SaleDTO> saleDTOS) {
        return saleDTOS.stream().map(this::saleDTOtoSale).collect(Collectors.toSet());
    }
}
