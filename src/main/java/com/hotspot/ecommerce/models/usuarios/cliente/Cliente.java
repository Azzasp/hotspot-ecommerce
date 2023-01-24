package com.hotspot.ecommerce.models.usuarios.cliente;



import com.hotspot.ecommerce.models.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends Usuario{


    private String CPF;
    private Date data_nasc;


}
