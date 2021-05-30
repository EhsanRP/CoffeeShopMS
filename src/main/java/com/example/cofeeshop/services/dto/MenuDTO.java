package com.example.cofeeshop.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MenuDTO {

    private Long id;
    private Instant creationDate;
    private Instant modificationDate;
    private CategoryListDTO categoryListDTO;

    private String url;
}
