package com.example.cofeeshop.services.dto;

import com.example.cofeeshop.services.dto.perms.InputValidation;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BillDTO {

    private Long id;

    @InputValidation
    private Double totalPrice;

    @NotNull
    private Boolean isApproved;
    private ItemListDTO itemListDTO;
    private Instant creationDate;
    private Instant completionDate;

    private String url;
}
