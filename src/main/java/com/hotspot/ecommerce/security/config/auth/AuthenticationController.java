package com.hotspot.ecommerce.security.config.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @PostMapping(name = "/registrar")
    public ResponseEntity<AuthenticationResponse> registrar(@RequestBody RegisterRequest request){

    }

    @PostMapping(name = "/autenticar")
    public ResponseEntity<AuthenticationResponse> autenticar(@RequestBody AuthenticationRequest request){

    }

}
