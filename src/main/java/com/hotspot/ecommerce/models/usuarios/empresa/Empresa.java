package com.hotspot.ecommerce.models.usuarios.empresa;

import com.hotspot.ecommerce.models.mercadorias.produto.Produto;
import com.hotspot.ecommerce.models.mercadorias.servico.Servico;
import com.hotspot.ecommerce.models.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends Usuario {

    private String CNPJ;


}
