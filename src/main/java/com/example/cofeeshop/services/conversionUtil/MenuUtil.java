package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.repositories.MenuRepository;
import com.example.cofeeshop.services.dto.MenuDTO;

public interface MenuUtil {
    MenuDTO menuToMenuDTO(Menu menu);
}
