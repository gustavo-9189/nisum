package com.nisum.demo.dto;

import jakarta.validation.constraints.Pattern;
import java.util.List;

import static com.nisum.demo.helpers.Constants.EMAIL_REGEX;
import static com.nisum.demo.helpers.Constants.PASSWORD_REGEX;

public record UserRequest(
        String name,

        @Pattern(regexp = EMAIL_REGEX, message = "The email is not in the correct format")
        String email,

        @Pattern(regexp = PASSWORD_REGEX, message = "The password has an incorrect format")
        String password,

        List<PhoneRequest> phones
) {
}
