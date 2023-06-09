package br.furb.inf.furbot.models.material;

import br.furb.inf.furbot.models.ModelImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties("material")
public class Autor extends ModelImpl {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "autor não pode ser núlo")
    @NotEmpty(message = "autor não pode ser vazio")
    @Size(min = 2, max = 150, message = "autor deve ser entre 4 e 150 dígitos")
    private String nome;

    @ManyToMany(mappedBy = "autores")
    private Set<Material> material;

}
