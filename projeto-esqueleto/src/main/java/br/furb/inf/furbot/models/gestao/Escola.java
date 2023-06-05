package br.furb.inf.furbot.models.gestao;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class Escola extends ModelImpl {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Nome da escola não pode ser nulo!")
	@NotEmpty(message = "Nome da escola não pode ser em branco!")
	@Size(max = 255, message = "Tamanho inválido para o nome!")
	private String nome;

}
