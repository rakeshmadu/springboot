package com.bridgelabz.fundooapp.utilities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.bridgelabz.fundooapp.dto.Login;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@Component
public class JwtTokenUtil implements Serializable {

    Login loginDTO = new Login();

    private String secret = "spring";

    public String generateToken(Login loginDTO) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", loginDTO.getEmail());
        claims.put("password", loginDTO.getPassword());

        System.out.println("claims : " + claims);
        System.out.println("Generated Token for : ");
        return doGenerateToken(claims);
    }

    private String doGenerateToken(Map<String, Object> claims) {

        return Jwts.builder().setClaims(claims)

                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public Login deCode(String token) {

        final Map<String, Object> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
       
        loginDTO.setEmail((String) claims.get("email"));
        loginDTO.setPassword((String) claims.get("password"));
        // System.out.println("Details: " + loginDTO);
        return loginDTO;

    }
    
    public String generateToken(String email, String password) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("Email", email);
        claims.put("Password", password);
        System.out.println("claims : " + claims);
        System.out.println("Generated Token for : ");
        return doGenerateToken(claims);
    }

}
