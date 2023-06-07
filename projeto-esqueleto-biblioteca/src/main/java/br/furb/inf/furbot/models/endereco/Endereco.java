package br.furb.inf.furbot.models.endereco;

import br.furb.inf.furbot.models.ModelImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco extends ModelImpl {

    public Endereco(String uuid) {
        setId(UUID.fromString(uuid));
    }

    @NotNull(message = "cidade não pode ser núlo")
    @NotEmpty(message = "cidade não pode ser vazio")
    @Size(min = 2, max = 150, message = "Nome deve ser entre 4 e 150 dígitos")
    private String cidade;

    @NotNull(message = "Estado não pode ser núlo")
    @NotEmpty(message = "Estado não pode ser vazio")
    @Size(min = 2, max = 255, message = "Nome deve ser entre 4 e 150 dígitos")
    private String estadoOuProvincia;

    @NotNull(message = "pais não pode ser núlo")
    @NotEmpty(message = "pais não pode ser vazio")
    @Size(min = 2, max = 255, message = "Nome deve ser entre 4 e 150 dígitos")
    private String pais;
}
