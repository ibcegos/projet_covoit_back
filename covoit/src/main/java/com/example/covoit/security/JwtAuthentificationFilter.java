package com.example.covoit.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthentificationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }




    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("attemptAuthentication");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("username : "+username);
        System.out.println("password : "+password);
        UsernamePasswordAuthenticationToken authenticationToken =new UsernamePasswordAuthenticationToken(username,password);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("successfulAuthentication");
        User user=(User)authResult.getPrincipal();
        Algorithm algorithm= Algorithm.HMAC256("rocBot");
        String jwtAccessToken= JWT.create()
                .withIssuer(request.getRequestURI())
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+2123*60*1000))
                .withClaim("roles",user.getAuthorities().stream().map(a->a.getAuthority()).collect(Collectors.toList()))
                .sign(algorithm);

        String jwtRefreshToken= JWT.create()
                .withIssuer(request.getRequestURI())
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+20*60*1000))
                .sign(algorithm);
        Map<String, String> idToken= new HashMap<>();
        idToken.put("accessToken",jwtAccessToken);
        idToken.put("refreshToken",jwtRefreshToken);
        new ObjectMapper().writeValue(response.getOutputStream(),idToken);
        response.setContentType("application/json");

        response.setHeader("Authorization", jwtAccessToken);
        System.out.println("JWT access token generated for user : "+ jwtAccessToken);
    }
}
