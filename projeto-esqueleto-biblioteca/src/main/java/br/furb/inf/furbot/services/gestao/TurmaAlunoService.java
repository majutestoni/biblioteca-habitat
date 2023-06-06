package br.furb.inf.furbot.services.gestao;

import java.util.List;
import java.util.UUID;

import br.furb.inf.furbot.models.gestao.Turma;
import br.furb.inf.furbot.repositories.gestao.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.furb.inf.furbot.models.gestao.TurmaAluno;
import br.furb.inf.furbot.repositories.gestao.TurmaAlunoRepository;
import br.furb.inf.furbot.services.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TurmaAlunoService extends ServiceImpl<TurmaAluno> {
	
	@Autowired
	private TurmaAlunoRepository repository;

	@Override
	public JpaRepository<TurmaAluno, UUID> getRepository() {
		return repository;
	}

	@Override
	public void validator(TurmaAluno entity) {		
	}

	public List<TurmaAluno> obterAlunosPorTurma(UUID turmaId) {
		return repository.obterAlunosPorTurma(turmaId);
	}

	public List<Turma> obterTurmasPorAluno(UUID alunoId) {
		return this.repository.obterTurmasPorAluno(alunoId);
	}
}
