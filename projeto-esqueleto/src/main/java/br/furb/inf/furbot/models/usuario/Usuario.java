package br.furb.inf.furbot.models.usuario;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.furb.inf.furbot.enuns.Genero;
import br.furb.inf.furbot.enuns.Perfil;
import br.furb.inf.furbot.models.ModelImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario extends ModelImpl {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Nome não pode ser núlo")
	@NotEmpty(message = "Nome não pode ser vazio")
	@Size(min = 4, max = 150, message = "Nome deve ser entre 4 e 150 dígitos")
	private String nome;

	@NotNull(message = "Usuário não pode ser núlo")
	@NotEmpty(message = "Usuário não pode ser vazio")
	@Size(min = 4, max = 15, message = "Nome de usuário deve ser entre 4 e 15 dígitos")
	private String usuario;

	private String senha;

	@Column(nullable = true)
	private String email;

	@Column(nullable = true)
	private Perfil perfil;

	@Column(nullable = true)
	private Boolean alteraSenha;

	@Column(nullable = true, name = "data_nascimento")
	private Date dataNascimento;

	@Column(nullable = true)
	private Genero genero;

	@PrePersist
	private void aoCriar() {
		if (this.getGenero() == null) {
			this.setGenero(Genero.OUTRO);
		}
	}

}
