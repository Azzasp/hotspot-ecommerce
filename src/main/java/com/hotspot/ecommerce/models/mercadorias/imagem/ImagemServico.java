package com.hotspot.ecommerce.models.mercadorias.imagem;

import com.hotspot.ecommerce.models.mercadorias.servico.Servico;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "imagem_servico")
@IdClass(ImagemServico.ImagemServicoId.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImagemServico {

    @Id
    @ManyToOne(targetEntity = Imagem.class)
    @JoinColumn(name = "id_imagem", referencedColumnName = "id_imagem")
    private Imagem imagem;

    @Id
    @ManyToOne(targetEntity = Servico.class)
    @JoinColumn(name = "id_servico", referencedColumnName = "id_servico")
    private Servico servico;

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class ImagemServicoId implements Serializable {
        private Imagem imagem;
        private Servico servico;
    }

}
