package com.hotspot.ecommerce.security.config.auth;


import com.hotspot.ecommerce.security.config.auth.requests.AuthenticationRequest;
import com.hotspot.ecommerce.security.config.auth.requests.RegisterRequestCliente;
import com.hotspot.ecommerce.security.config.auth.requests.RegisterRequestEmpresa;
import com.hotspot.ecommerce.security.config.auth.requests.UpdatePasswordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UpdateAccountDataService accountDataService;

    @GetMapping
    public ResponseEntity<String> helloWorldJWT(){
        return ResponseEntity.ok("Hello World, seu JWT ta funcionaod pcro!");
    }


    @PostMapping(value = "/registrar/cliente")
    public ResponseEntity<AuthenticationResponse> registerCliente(@RequestBody RegisterRequestCliente request){
        return ResponseEntity.ok(authenticationService.registerCliente(request));
    }

    @PostMapping(value = "/registrar/empresa")
    public ResponseEntity<AuthenticationResponse> registerEmpresa(@RequestBody RegisterRequestEmpresa request){
        return ResponseEntity.ok(authenticationService.registerEmpresa(request));
    }

    @PostMapping(value = "/autenticar/cliente")
    public ResponseEntity<AuthenticationResponse> authenticateCliente(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticateCliente(request));
    }

    @PostMapping(value = "/autenticar/empresa")
    public ResponseEntity<AuthenticationResponse> authenticateEmpresa(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticateEmpresa(request));
    }

    @PostMapping(value = "/alterar-senha")
    public ResponseEntity<AuthenticationResponse> updatePassword(@RequestBody UpdatePasswordRequest request){
        System.out.println(request);
        return ResponseEntity.ok(accountDataService.updatePassword(request));
    }

}
