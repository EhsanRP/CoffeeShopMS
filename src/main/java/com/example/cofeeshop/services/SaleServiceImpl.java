package com.example.cofeeshop.services;

import com.example.cofeeshop.domain.Sale;
import com.example.cofeeshop.exceptions.NotFoundException;
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
        return conversionUtil.listAllSales(saleRepository.findAll());
    }

    @Override
    public SaleDTO findSaleById(Long id) {
        return conversionUtil.saleToSaleDTO(findById(id));
    }

    @Override
    public SaleDTO editSale(Long saleId, SaleDTO saleDTO) {
        var sale = findById(saleId);

        if (saleDTO.getFoodId() != null) {
            var food = foodRepository.findById(saleDTO.getFoodId()).orElseThrow(NotFoundException::new);
            sale.setFood(food);
        }

        if (saleDTO.getUnitPrice() != null)
            sale.setUnitPrice(saleDTO.getUnitPrice());

        if (saleDTO.getQuantity() != null)
            sale.setQuantity(saleDTO.getQuantity());

        if (saleDTO.getProfit() != null)
            sale.setProfit(saleDTO.getProfit());

        var newSale = saleRepository.save(sale);
        return conversionUtil.saleToSaleDTO(newSale);
    }

    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {
        var saleToSave = conversionUtil.saleDTOtoSale(saleDTO);
        var sale = saleRepository.save(saleToSave);
        return conversionUtil.saleToSaleDTO(sale);
    }

    private Sale findById(Long saleId) {
        return saleRepository.findById(saleId).orElseThrow(NotFoundException::new);
    }

    @Override
    public void removeSale(Long saleId) {
        saleRepository.deleteById(saleId);
    }
}
