package com.hotspot.ecommerce.security.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtService jwtService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain
                                    )throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwtToken;
        final String username;

        /*  ################
            JWT Filter Chain
            ################

        Caso o header não tenha autorização (ou seja, nulo) ou não comece com Bearer
        (token gerado a partir da autenticação do usuário) irá finalizar o método

        */
        if(authHeader == null || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        jwtToken = authHeader.substring(7); // extraindo o token JWT
        username = jwtService.extractUsername(jwtToken);// TODO: Extract username from JWT token;
    }
}
