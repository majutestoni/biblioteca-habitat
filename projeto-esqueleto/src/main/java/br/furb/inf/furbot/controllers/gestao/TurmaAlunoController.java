package br.furb.inf.furbot.controllers.gestao;

import br.furb.inf.furbot.models.gestao.Turma;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.models.gestao.TurmaAluno;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.gestao.TurmaAlunoService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;

@Tag(name = "Serviço de ligação entre aluno x turma", externalDocs = @ExternalDocumentation(description = "Serviço responsável por gerenciar ligação entre aluno x turma"))
@RestController
@RequestMapping("/turma-alunos")
public class TurmaAlunoController extends ControllerImpl<TurmaAluno> {

	@Autowired
	private TurmaAlunoService service;

	@Override
	public Service<TurmaAluno> getService() {
		return service;
	}

	@Operation(summary = "Listar turmas pelo id de um aluno")
	@GetMapping("/turmas-por-aluno/{id}")
	public ResponseEntity<List<Turma>> obterTurmasPorAluno(@PathVariable(required = true) UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.obterTurmasPorAluno(id));
	}
}
