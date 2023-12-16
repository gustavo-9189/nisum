package com.nisum.demo.dto;

import lombok.Data;

@Data
public class PhoneRequest {

    private String number;

    private String citycode;

    private String countrycode;
}
