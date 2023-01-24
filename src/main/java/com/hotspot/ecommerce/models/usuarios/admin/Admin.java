package com.hotspot.ecommerce.models.usuarios.admin;

import com.hotspot.ecommerce.models.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Usuario {

    private String CPF;



}
