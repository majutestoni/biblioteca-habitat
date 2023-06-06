package br.furb.inf.furbot.repositories.gestao;

import com.querydsl.core.types.dsl.EntityPathBase;

import br.furb.inf.furbot.models.gestao.Escola;
import br.furb.inf.furbot.models.gestao.QEscola;
import br.furb.inf.furbot.repositories.RepositoryImpl;

public class EscolaCustomRepositoryImpl extends RepositoryImpl<Escola> implements EscolaCustomRepository {

	@Override
	public EntityPathBase<Escola> getEntity() {
		return QEscola.escola;
	}

}
