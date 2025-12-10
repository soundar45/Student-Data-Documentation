package com.example.demo.Secuirty;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class JwtService {
    final  String secretkey ="@#45";
    public String generateToken(String username){
        return io.jsonwebtoken.Jwts.builder()
                                   .setSubject(username)
                                   .setIssuedAt(new Date())
                                   .setExpiration(new Date(System.currentTimeMillis()+1000*30*30))
                                   .signWith(SignatureAlgorithm.HS256, secretkey)
                                   .compact();
    }

    public String extractToken (String token){
        return io.jsonwebtoken.Jwts.parser()
                                   .setSigningKey(secretkey)
                                   .parseClaimsJws(token)
                                   .getBody()
                                   .getSubject();
                            

    }

    }
    

