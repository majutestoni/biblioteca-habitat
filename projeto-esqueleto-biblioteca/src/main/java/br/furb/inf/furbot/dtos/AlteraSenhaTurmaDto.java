package br.furb.inf.furbot.dtos;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlteraSenhaTurmaDto {

	@NotNull(message = "Informe uma turma")
	private UUID id;
	
	@NotNull(message = "Informe uma senha")
	@NotEmpty(message = "Senha não pode ser em branco")
	@Size(min = 4, max = 18, message = "A senha deve conter de 4 a 18 caracteres")
	private String senha;
	
}
