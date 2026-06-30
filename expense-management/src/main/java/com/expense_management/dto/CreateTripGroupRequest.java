package com.expense_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateTripGroupRequest {

    @NotBlank
    private String name;
}
