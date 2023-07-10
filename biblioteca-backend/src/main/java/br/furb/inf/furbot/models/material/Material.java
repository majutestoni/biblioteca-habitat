package br.furb.inf.furbot.models.material;

import br.furb.inf.furbot.enuns.Tipo;
import br.furb.inf.furbot.models.ModelImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Material extends ModelImpl {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "titulo não pode ser núlo")
    @NotEmpty(message = "titulo não pode ser vazio")
    @Size(min = 2, max = 150, message = "titulo deve ser entre 4 e 150 dígitos")
    private String titulo;

    @Column(name = "ano")
    private Date ano;

    @NotNull(message = "descricao não pode ser núlo")
    @NotEmpty(message = "descricao não pode ser vazio")
    @Size(min = 2, max = 255, message = "descricao deve ser entre 4 e 255 dígitos")
    private String descricao;

    @Column(nullable = true)
    private Tipo tipo;

    @NotNull(message = "link não pode ser núlo")
    @NotEmpty(message = "link não pode ser vazio")
    @Size(min = 2, max = 255, message = "link deve ser entre 4 e 255 dígitos")
    private String link;

    @Column(nullable = true)
    private String idioma;

    @Column(nullable = true)
    private int avaliacao;

    @Column(nullable = true)
    private boolean publicado;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "autor_material",
            joinColumns = @JoinColumn(name = "material_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private Set<Autor> autores = new HashSet<>();

    @PrePersist
    private void aoCriar() {
        if (this.getTipo() == null) {
            this.setTipo(Tipo.OUTROS);
        }
    }
}
