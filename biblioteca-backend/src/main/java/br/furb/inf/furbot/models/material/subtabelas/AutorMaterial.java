package br.furb.inf.furbot.models.material.subtabelas;

import br.furb.inf.furbot.models.ModelImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AutorMaterial extends ModelImpl {

    private static final long serialVersionUID = 1L;

    @Column(name = "autor_id", columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @NotNull(message = "autor é obrigatório")
    private UUID autor;

    @Column(name = "material_id", columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @NotNull(message = "material é obrigatório")
    private UUID material;
}
