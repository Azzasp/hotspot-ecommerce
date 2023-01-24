package com.hotspot.ecommerce.models.users.admin;

import com.hotspot.ecommerce.models.users.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Usuario {

    private String CPF;



}
