package com.example.cofeeshop.services.dto;

import com.example.cofeeshop.services.dto.perms.InputValidation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MenuDTO {

    private Long id;

    @InputValidation
    private String name;

    private CategoryListDTO categoryListDTO;

    private Instant creationDate;
    private Instant modificationDate;
    private String url;
}
