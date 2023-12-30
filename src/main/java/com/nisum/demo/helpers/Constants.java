package com.nisum.demo.helpers;

public class Constants {
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String ACCESS_TOKEN_SECRET = "343f7d35-005b-48a9-bb5e-5b25dbbd638a";
    public static final Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;
    public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
}
