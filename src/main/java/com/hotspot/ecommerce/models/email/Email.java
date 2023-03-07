package com.hotspot.ecommerce.models.email;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {

    private String destinatario;
    private String titulo;
    private String mensagem;

}