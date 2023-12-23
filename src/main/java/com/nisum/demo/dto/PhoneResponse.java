package com.nisum.demo.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record PhoneResponse(
        UUID id,
        String number,
        String cityCode,
        String countryCode,
        LocalDateTime created,
        LocalDateTime modified
) { }