package br.furb.inf.furbot.repositories.gestao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.furb.inf.furbot.models.gestao.QTurmaAluno;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;

import br.furb.inf.furbot.models.gestao.QTurma;
import br.furb.inf.furbot.models.gestao.Turma;
import br.furb.inf.furbot.repositories.RepositoryImpl;

import java.util.List;
import java.util.UUID;

public class TurmaCustomRepositoryImpl extends RepositoryImpl<Turma> implements TurmaCustomRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EntityPathBase<Turma> getEntity() {
		return QTurma.turma;
	}

	public Integer obterProximoId() {
		Integer response = new JPAQuery<Integer>(entityManager) //
				.select(QTurma.turma.codigo) //
				.from(getEntity()) //
				.orderBy(QTurma.turma.codigo.desc()) //
				.fetchFirst();
		return response != null ? response + 1 : 1;
	}
}
