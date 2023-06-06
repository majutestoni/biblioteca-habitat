package br.furb.inf.furbot.repositories.gestao;

import java.util.List;
import java.util.UUID;

import br.furb.inf.furbot.models.gestao.Turma;
import br.furb.inf.furbot.models.gestao.TurmaAluno;
import br.furb.inf.furbot.repositories.Repository;

public interface TurmaAlunoCustomRepository extends Repository<TurmaAluno> {

	List<TurmaAluno> obterAlunosPorTurma(UUID turmaId);

	List<Turma> obterTurmasPorAluno(UUID alunoId);
}
