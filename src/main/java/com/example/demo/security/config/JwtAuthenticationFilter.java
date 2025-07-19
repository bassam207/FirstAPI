package com.example.demo.security.config;

import com.example.demo.User.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

private final JwtService jwtservice;
private final UserDetailsServiceImpl userDetailsService;
    @Override
    protected void doFilterInternal( @NotNull HttpServletRequest request,
                                     @NotNull  HttpServletResponse response,
                                     @NotNull  FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final  String jwt;
        final  String userEmail;
        if (authHeader == null||!authHeader.startsWith("Bearer "))
        {
            filterChain.doFilter(request,response);
            return;
        }

        jwt = authHeader.substring(7);
        userEmail = jwtservice.extractUsername(jwt);

        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() != null)
        {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);

            if (jwtservice.isTokenValid(jwt,userEmail))
            {
                UsernamePasswordAuthenticationToken authToken = new
                        UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities());

                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                                    );

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request,response);

    }
}
