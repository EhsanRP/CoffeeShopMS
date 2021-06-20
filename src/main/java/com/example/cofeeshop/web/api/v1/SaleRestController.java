package com.example.cofeeshop.web.api.v1;

import com.example.cofeeshop.services.SaleService;
import com.example.cofeeshop.services.dto.SaleDTO;
import com.example.cofeeshop.services.dto.SaleListDTO;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Value
@Slf4j
@RequestMapping({"/api/v1/sales/", "/api/v1/sales"})
public class SaleRestController {

    public static String SALE_BASE_URL = "/api/v1/sales/";
    SaleService saleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SaleListDTO findAllSales(){
        return saleService.findAllSales();
    }

    @GetMapping("{saleId}")
    @ResponseStatus(HttpStatus.OK)
    public SaleDTO findSaleById(@PathVariable Long saleId){
        return saleService.findSaleById(saleId);
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public SaleDTO createSale(@Valid @RequestBody SaleDTO saleDTO){
        return saleService.createSale(saleDTO);
    }

    @PostMapping("edit/{saleId}")
    @ResponseStatus(HttpStatus.OK)
    public SaleDTO editSale(
            @PathVariable Long saleId,
            @RequestBody SaleDTO saleDTO){
        return saleService.editSale(saleId,saleDTO);
    }

    @GetMapping("delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSale(@RequestParam Long saleId){
        saleService.removeSale(saleId);
    }

}
