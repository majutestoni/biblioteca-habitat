package br.furb.inf.furbot.models.usuario;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.furb.inf.furbot.models.endereco.Endereco;
import br.furb.inf.furbot.models.ModelImpl;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario extends ModelImpl {

	// criar foto de perfil

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

	private Boolean admin;

	@NotNull
	private String email;

	private String fone;

	private String instituição;

	private String clube;

	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

}
