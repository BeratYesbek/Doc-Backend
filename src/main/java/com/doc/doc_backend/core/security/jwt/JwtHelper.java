package com.doc.doc_backend.core.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

public class JwtHelper {
    public static String createToken(User user, String url) {
        Algorithm algorithm = Algorithm.HMAC512("my_secret_key_my_secret_key565498498498499487".getBytes());
        String access_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()))
                .withIssuer(url)
                .withNotBefore(new Date(System.currentTimeMillis()))
                .withKeyId(UUID.randomUUID().toString())
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
        return access_token;
    }

    public static DecodedJWT decodeJwtAndGetClaims(String token) {
        Algorithm algorithm = Algorithm.HMAC512("my_secret_key_my_secret_key565498498498499487".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT;
    }
}
