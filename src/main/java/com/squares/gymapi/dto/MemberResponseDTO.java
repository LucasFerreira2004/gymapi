package com.squares.gymapi.dto;

import java.util.Date;

public record MemberResponseDTO(
        String name,
        Date dateOfBirth,
        char gender,
        String address,
        Integer number,
        String unit,
        String zipCode,
        String city,
        String state,
        String phoneNumber,
        String email,
        String membershipPlan,
        Boolean active
        ) {
}
