package br.furb.inf.furbot.repositories.usuario;

import java.util.UUID;

import br.furb.inf.furbot.models.usuario.Aluno;

public interface AlunoCustomRepository extends br.furb.inf.furbot.repositories.Repository<Aluno> {

	Long contarAlunos(UUID turmaId);
	
}
