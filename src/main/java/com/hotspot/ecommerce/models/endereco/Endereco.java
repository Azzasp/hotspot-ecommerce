package com.hotspot.ecommerce.models.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @SequenceGenerator(name = "endereco_sequence",
            sequenceName = "endereco_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "endereco_sequence")
    private Long id_endereco;
    private String CEP;
    private String numeroCasa;
    private String bairro;
    private String cidade;
    private String UF;



}
