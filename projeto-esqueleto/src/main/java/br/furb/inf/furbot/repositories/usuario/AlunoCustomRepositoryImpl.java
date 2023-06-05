package br.furb.inf.furbot.repositories.usuario;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;

import br.furb.inf.furbot.models.usuario.Aluno;
import br.furb.inf.furbot.models.usuario.QAluno;
import br.furb.inf.furbot.repositories.RepositoryImpl;

public class AlunoCustomRepositoryImpl extends RepositoryImpl<Aluno> implements AlunoCustomRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EntityPathBase<Aluno> getEntity() {
		return QAluno.aluno;
	}

	@Override
	public Long contarAlunos(UUID turmaId) {
		JPAQuery<Long> query = new JPAQuery<Long>(entityManager) //
				.select(QAluno.aluno.id.count()) //
				.from(getEntity());
		if (turmaId != null) {
			query.where(QAluno.aluno.turmaId.eq(turmaId));
		}
		return query.fetchFirst();
	}

}
