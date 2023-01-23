package com.hotspot.ecommerce.models.carrinho;

import com.hotspot.ecommerce.models.users.cliente.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "carrinho")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carrinho {
    @Id
    @SequenceGenerator(name = "carrinho_sequence",
            sequenceName = "carrinho_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "carrinho_sequence")
    private Long id_carrinho;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "carrinho")
    private List<CarrinhoProduto> carrinhoProdutos;

}
