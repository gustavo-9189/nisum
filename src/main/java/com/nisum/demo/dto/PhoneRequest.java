package com.nisum.demo.dto;

public record PhoneRequest(
        String number,
        String cityCode,
        String countryCode
) {
}
