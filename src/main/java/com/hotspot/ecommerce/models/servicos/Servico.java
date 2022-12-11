package com.hotspot.ecommerce.models.servicos;

import com.hotspot.ecommerce.models.carrinho.Carrinho;
import com.hotspot.ecommerce.models.users.empresa.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "servico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Servico {
    @SequenceGenerator(
            name = "servico_sequence",
            sequenceName = "servico_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "servico_sequence"
    )
    private Long id_servico;
    private String nome;
    private String descricao;
    private Double valor;
    private Status status;
    @OneToOne
    private Empresa empresa;
    @OneToMany(targetEntity = Carrinho.class,fetch = FetchType.LAZY, mappedBy = "servicos")
    private List<Carrinho> carrinho;
}
