package com.example.cofeeshop.web.api.v1;

import com.example.cofeeshop.services.SaleService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Value
@Slf4j
@RequestMapping({"/api/v1/sales/", "/api/v1/sales"})
public class SaleRestController {

    public static String SALE_BASE_URL = "/api/v1/sales/";

    SaleService saleService;

    @GetMapping("delete")
    public void deleteSale(@RequestParam Long saleId){
        saleService.removeSale(saleId);
    }

}
