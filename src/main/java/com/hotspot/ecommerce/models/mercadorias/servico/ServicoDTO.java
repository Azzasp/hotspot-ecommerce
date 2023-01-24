package com.hotspot.ecommerce.models.mercadorias.servico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServicoDTO {

    private Long id_servico;
    private String nome;
    private String descricao;
    private Double valor;
    private Status status;


}
