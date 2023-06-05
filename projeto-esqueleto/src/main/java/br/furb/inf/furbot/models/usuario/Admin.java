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
@Table(name = "admins")
public class Admin extends ModelImpl {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Nome não pode ser núlo")
    @NotEmpty(message = "Nome não pode ser vazio")
    @Size(min = 4, max = 150, message = "Nome deve ser entre 4 e 150 dígitos")
    private String name;

    @NotNull(message = "Usuário não pode ser núlo")
    @NotEmpty(message = "Usuário não pode ser vazio")
    @Size(min = 4, max = 15, message = "Nome de usuário deve ser entre 4 e 15 dígitos")
    private String nickname;

    private String email;

    private String phone;

    private String password;


}
