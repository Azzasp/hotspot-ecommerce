package com.hotspot.ecommerce.models.users.empresa;

import com.hotspot.ecommerce.models.produto.Produto;
import com.hotspot.ecommerce.models.servicos.Servico;
import com.hotspot.ecommerce.models.users.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends Usuario {

    private String CNPJ;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Servico.class, mappedBy = "empresa")
    private List<Servico> servicos;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,targetEntity = Produto.class, mappedBy = "empresa")
    private List<Produto> produtos;



}
