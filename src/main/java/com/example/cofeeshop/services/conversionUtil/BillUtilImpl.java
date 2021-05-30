package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Bill;
import com.example.cofeeshop.repositories.BillRepository;
import com.example.cofeeshop.services.conversionUtil.mappers.BillMapper;
import com.example.cofeeshop.services.dto.BillDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BillUtilImpl implements BillUtil {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    @Override
    public BillDTO billToBillDTO(Bill bill) {
        return null;
    }
}
