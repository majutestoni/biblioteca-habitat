package br.furb.inf.furbot.repositories.usuario;

import com.querydsl.core.types.dsl.EntityPathBase;

import br.furb.inf.furbot.models.usuario.QUsuario;
import br.furb.inf.furbot.models.usuario.Usuario;
import br.furb.inf.furbot.repositories.RepositoryImpl;

public class UsuarioCustomRepositoryImpl extends RepositoryImpl<Usuario> implements UsuarioCustomRepository {

	@Override
	public EntityPathBase<Usuario> getEntity() {
		return QUsuario.usuario1;
	}

}
