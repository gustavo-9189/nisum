package com.nisum.demo.dto;

import jakarta.validation.constraints.Pattern;
import java.util.List;

public record UserRequest(
        String name,

        @Pattern(
                regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
                message = "The email is not in the correct format")
        String email,

        @Pattern(
                regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$",
                message = "The password has an incorrect format")
        String password,

        List<PhoneRequest> phones
) { }
