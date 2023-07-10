package br.furb.inf.furbot.models.material;

import br.furb.inf.furbot.models.ModelImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PalavraChave extends ModelImpl {

    @NotNull(message = "palavra não pode ser núlo")
    @NotEmpty(message = "palavra não pode ser vazio")
    @Size(min = 2, max = 150, message = "palavra deve ser entre 4 e 150 dígitos")
    private String palavra;

    @ManyToMany(mappedBy = "palavras")
    private Set<Material> material;

}
