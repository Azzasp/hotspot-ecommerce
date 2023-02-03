package com.hotspot.ecommerce.models.mercadorias.servico;

import com.hotspot.ecommerce.models.mercadorias.categoria.Categoria;
import com.hotspot.ecommerce.models.usuarios.empresa.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

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
    private boolean disponivel;

    @ManyToOne
    private Empresa empresa;

    @ManyToMany
    @JoinTable(name = "CategoriaServico",
            joinColumns = @JoinColumn(name = "id_servico"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private Set<Categoria> categoria;

}
