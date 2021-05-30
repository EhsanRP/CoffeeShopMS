package com.example.cofeeshop.services.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemListDTO {
    private List<ItemDTO> itemDTOList = new ArrayList<>();
}
