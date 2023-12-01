package com.nisum.demo.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class PhoneResponse {

    private UUID id;

    private String number;

    private String citycode;

    private String countrycode;

    private LocalDateTime created;

    private LocalDateTime modified;
}
