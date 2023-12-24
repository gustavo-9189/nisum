package com.nisum.demo.helpers;

import org.springframework.beans.factory.annotation.Value;

public class Constants {

    @Value("${constants.authorization}")
    public static String AUTHORIZATION;

    @Value("${constants.bearer}")
    public static String BEARER;

    @Value("${constants.secret}")
    public static String ACCESS_TOKEN_SECRET;

    @Value("${constants.seconds}")
    public static Long ACCESS_TOKEN_VALIDITY_SECONDS;
}
