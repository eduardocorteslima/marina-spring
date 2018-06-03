package br.net.ti2.MarinaAbramovick.config;

import org.springframework.beans.factory.annotation.Value;

public class SecurityConstants {
	@Value("${app.SECRET_MARINA_SERVER}")
	static String SECRET;
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
    static final String SIGN_UP_URL = "/users/sign-up";
    static final long EXPIRATION_TIME = 86400000L;
}