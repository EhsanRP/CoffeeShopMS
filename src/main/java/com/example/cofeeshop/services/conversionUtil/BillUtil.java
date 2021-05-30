package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Bill;
import com.example.cofeeshop.services.dto.BillDTO;

public interface BillUtil {
    BillDTO billToBillDTO(Bill bill);
}
