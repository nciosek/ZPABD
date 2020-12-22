package com.example.ZPABD;

import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import io.jsonwebtoken.SignatureException;

public class JwtFilter implements javax.servlet.Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String header = httpServletRequest.getHeader("authorization");
        if (header == null || header.startsWith("Bearer ")){
            throw new ServletException("Missing or invalid header");
        } else {
            try{
                String token = header.substring(7);
                Claims claims = Jwts.parser().setSigningKey("pass123").parseClaimsJws(token).getBody();
                servletRequest.setAttribute("claims", claims);
            } catch (final SignatureException e){
                throw new ServletException("Invalid token");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
