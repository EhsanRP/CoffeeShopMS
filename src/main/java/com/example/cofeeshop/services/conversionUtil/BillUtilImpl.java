package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Bill;
import com.example.cofeeshop.repositories.BillRepository;
import com.example.cofeeshop.services.conversionUtil.mappers.BillMapper;
import com.example.cofeeshop.services.dto.BillDTO;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Value
@Service
public class BillUtilImpl implements BillUtil {

    BillRepository billRepository;
    BillMapper billMapper;

    @Override
    public BillDTO billToBillDTO(Bill bill) {
        return null;
    }
}
