package com.estesting.gateway.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
  private static final String SECRET_KEY =
      "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";

  public String extractUserLogin(String jwtToken) {
    return extractClaims(jwtToken, Claims::getSubject);
  }

  public <T> T extractClaims(String jwtToken, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(jwtToken);
    return claimsResolver.apply(claims);
  }

  public String generateToken(UserDetails userDetails) {
    return generateToken(new HashMap<>(), userDetails);
  }

  public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
    return Jwts.builder()
        .setClaims(claims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 86400000))
        .signWith(getSecretKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  public boolean isTokenValid(String jwtToken, UserDetails userDetails) {
    final String userLogin = extractUserLogin(jwtToken);
    return (userLogin.equals(userDetails.getUsername())) && !isTokenExpired(jwtToken);
  }

  private boolean isTokenExpired(String jwtToken) {
    return extractExpiration(jwtToken).before(new Date());
  }

  private Date extractExpiration(String jwtToken) {
    return extractClaims(jwtToken, Claims::getExpiration);
  }

  public Claims extractAllClaims(String jwtToken) {
    return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(jwtToken).getBody();
  }

  public String extractSignature(String jwtToken) {
    return "";
  }

  private SecretKey getSecretKey() {
    byte[] keyBytesArray = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytesArray);
  }
}
