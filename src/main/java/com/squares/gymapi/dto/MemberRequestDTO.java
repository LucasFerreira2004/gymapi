package com.squares.gymapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record MemberRequestDTO(
        @NotBlank String name,
        @NotNull Date dateOfBirth,
        @NotNull char gender,
        @NotBlank String address,
        @NotNull Integer number,
        @NotBlank String unit,
        @NotBlank String zipCode,
        @NotBlank String city,
        @NotBlank String state,
        @NotBlank String phoneNumber,
        @NotBlank String email,
        @NotBlank String membershipPlan,
        @NotNull Boolean active
        ) {
}
