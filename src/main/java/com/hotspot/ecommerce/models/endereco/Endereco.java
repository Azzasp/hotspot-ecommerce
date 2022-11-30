package com.hotspot.ecommerce.models.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String CEP;
    private String numeroCasa;
    private String bairro;
    private String cidade;
    private String UF;



}
