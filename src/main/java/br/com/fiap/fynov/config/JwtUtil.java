package br.com.fiap.fynov.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public String generateToken(String email, Long id) {
        return Jwts.builder()
                .subject(email)
                .claims(Map.of("id", id))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86_400_000L))
                .signWith(getKey())
                .compact();
    }

    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    public Long extractId(String token) {
        return getClaims(token).get("id", Long.class);
    }

    public boolean isValid(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
