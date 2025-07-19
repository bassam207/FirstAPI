package com.example.demo.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private  String SECRET_KEY  ;

    private Key key;

    public void init()
    {
        key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public  String generationTocken(String username)
    {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public <T> T extractClaim(String token, Function<Claims,T>claimsResolver)
    {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Date extractExpiration(String token)
    {
        return extractClaim(token,Claims::getExpiration);
    }

    public   boolean isTokenExpired(String token)
    {
        return extractExpiration(token).before(new Date());
    }

    public boolean isTokenValid(String token, String username)
    {
        final String extractedUsername = extractUsername(token);
        return (extractUsername(token).equals(username)&&!isTokenExpired(token));
    }
    public  String extractUsername(String token)
    {
        return extractClaim(token,Claims::getSubject);
    }

    private Key getSignInKey() {
        if (key == null) {
            key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        }
        return key;
    }
    private Claims extractAllClaims(String token)
    {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
