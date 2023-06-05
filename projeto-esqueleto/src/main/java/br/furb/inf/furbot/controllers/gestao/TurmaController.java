package br.furb.inf.furbot.controllers.gestao;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.dtos.AlteraSenhaTurmaDto;
import br.furb.inf.furbot.models.gestao.Turma;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.gestao.TurmaService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Serviço de turmas", externalDocs = @ExternalDocumentation(description = "Serviço responsável por gerenciar turmas"))
@RestController
@RequestMapping("/turmas")
public class TurmaController extends ControllerImpl<Turma> {

	@Autowired
	private TurmaService service;

	@Override
	public Service<Turma> getService() {
		return service;
	}

	@Operation(summary = "Alterar senha de uma turma")
	@PostMapping("/altera-senha")
	public void alteraSenha(@Valid @RequestBody AlteraSenhaTurmaDto alteraSenhaTurmaDto) {
		service.alteraSenha(alteraSenhaTurmaDto.getSenha(), alteraSenhaTurmaDto.getId());
	}
}
