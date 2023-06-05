package br.furb.inf.furbot.repositories.gestao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.furb.inf.furbot.models.gestao.QTurma;
import br.furb.inf.furbot.models.gestao.Turma;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;

import br.furb.inf.furbot.models.gestao.QTurmaAluno;
import br.furb.inf.furbot.models.gestao.TurmaAluno;
import br.furb.inf.furbot.repositories.RepositoryImpl;

public class TurmaAlunoCustomRepositoryImpl extends RepositoryImpl<TurmaAluno> implements TurmaAlunoCustomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EntityPathBase<TurmaAluno> getEntity() {
		return QTurmaAluno.turmaAluno;
	}

	@Override
	public List<TurmaAluno> obterAlunosPorTurma(UUID turmaId) {
		return new JPAQuery<TurmaAluno>(entityManager) //
				.from(getEntity()) //
				.where(QTurmaAluno.turmaAluno.turma.eq(turmaId)).fetch();
	}

	@Override
	public List<Turma> obterTurmasPorAluno(UUID alunoId) {
		return new JPAQuery<Turma>(entityManager)
				.from(QTurma.turma)
					.innerJoin(this.getEntity())
					.on(QTurmaAluno.turmaAluno.turma.eq(QTurma.turma.id))
				.where(QTurmaAluno.turmaAluno.aluno.eq(alunoId))
				.fetch();
	}
}
