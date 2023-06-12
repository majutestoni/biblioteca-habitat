package br.furb.inf.furbot.repositories.relatorio;

import com.querydsl.core.types.dsl.EntityPathBase;

import br.furb.inf.furbot.models.relatorio.Acesso;
import br.furb.inf.furbot.models.relatorio.QAcesso;
import br.furb.inf.furbot.repositories.RepositoryImpl;

public class AcessoCustomRepositoryImpl extends RepositoryImpl<Acesso> implements AcessoCustomRepository {

	@Override
	public EntityPathBase<Acesso> getEntity() {
		return QAcesso.acesso;
	}

}
