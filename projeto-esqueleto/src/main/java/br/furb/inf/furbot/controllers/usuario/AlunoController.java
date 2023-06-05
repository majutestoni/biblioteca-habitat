package br.furb.inf.furbot.controllers.usuario;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.dtos.AlteraSenhaDto;
import br.furb.inf.furbot.models.usuario.Aluno;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.usuario.AlunoService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Serviço de alunos", externalDocs = @ExternalDocumentation(description = "Serviço responsável por gerenciar alunos"))
@RestController
@RequestMapping("/alunos")
public class  AlunoController extends ControllerImpl<Aluno> {
	
	@Autowired
	private AlunoService alunoService;

	@Override
	public Service<Aluno> getService() {
		return alunoService;
	}

	@Operation(summary = "Alterar senha de um aluno")
	@PostMapping("/alterar-senha")
	public void alterarSenha(@Valid @RequestBody AlteraSenhaDto alteraSenhaDto) {
		alunoService.alterarSenha(alteraSenhaDto);
	}
}
