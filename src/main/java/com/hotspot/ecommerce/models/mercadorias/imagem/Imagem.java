package com.hotspot.ecommerce.models.mercadorias.imagem;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "imagens")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Imagem {
    @Id
    @SequenceGenerator(name = "imagem_sequence",
            allocationSize = 1,
            sequenceName = "imagem_sequence" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagem_sequence")
    private Long id_imagem;

}
