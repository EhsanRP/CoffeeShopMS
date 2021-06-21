package com.example.cofeeshop.services.command;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.services.dto.perms.InputValidation;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class menuCommand {
    private Long id;

    @InputValidation
    private String name;

    private Set<Category> categories = new HashSet<>();
}
