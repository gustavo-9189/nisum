package com.nisum.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.nisum.demo.helpers.Constants.FORMAT_DATE_TIME;

public record PhoneResponse(
        UUID id,
        String number,
        String cityCode,
        String countryCode,
        String createdBy,
        @JsonFormat(pattern = FORMAT_DATE_TIME)
        LocalDateTime created,
        String modifiedBy,
        @JsonFormat(pattern = FORMAT_DATE_TIME)
        LocalDateTime modified
) {
}
