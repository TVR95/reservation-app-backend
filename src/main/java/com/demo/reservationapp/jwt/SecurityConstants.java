package com.demo.reservationapp.jwt;

import org.springframework.beans.factory.annotation.Value;

public class SecurityConstants {
//    @Value("${jwt.get.token.uri}")
    public final static String AUTH_LOGIN_URL = "/api/authenticate";

//    @Value("${jwt.refresh.token.uri}")
    public final static String JWT_REFRESH_URL = "/api/refresh";

//    @Value("${jwt.signing.key.secret}")
    public final static String JWT_SECRET = "6w9z$C&F)J@NcRfUjXn2r5u8x!A%D*G-KaPdSgVkYp3s6v9y$B?E(H+MbQeThWmZ";

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";

    private SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}
