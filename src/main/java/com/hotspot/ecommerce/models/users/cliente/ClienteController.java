package com.hotspot.ecommerce.models.users.cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cliente")
public class ClienteController {

    @GetMapping
    public String helloworld(){
        return "hello world!";
    }
}
