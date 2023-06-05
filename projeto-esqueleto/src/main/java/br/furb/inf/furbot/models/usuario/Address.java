package br.furb.inf.furbot.models.usuario;

import br.furb.inf.furbot.models.ModelImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address extends ModelImpl {

    @NotNull(message = "city não pode ser núlo")
    @NotEmpty(message = "city não pode ser vazio")
    @Size(min = 4, max = 15, message = "Nome de usuário deve ser entre 4 e 15 dígitos")
    private String city;

    @NotNull(message = "País não pode ser núlo")
    @NotEmpty(message = "País não pode ser vazio")
    @Size(min = 4, max = 15, message = "Nome de usuário deve ser entre 4 e 15 dígitos")
    private String country;

    // A mesma faz referencia a estado e provincia
    @NotNull(message = "Estado/província não pode ser núlo")
    @NotEmpty(message = "Estado/província não pode ser vazio")
    @Size(min = 2, max = 15, message = "Nome de usuário deve ser entre 4 e 15 dígitos")
    private String region;
}
