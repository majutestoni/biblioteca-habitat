package br.furb.inf.furbot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.furb.inf.furbot.enuns.PerfilJWT;
import br.furb.inf.furbot.models.usuario.Usuario;
import br.furb.inf.furbot.security.UserSS;
import br.furb.inf.furbot.services.usuario.UsuarioService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService service;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		Usuario user = this.service.obterPeloUsuario(usuario);
		if (user == null) {
			throw new UsernameNotFoundException(usuario);
		}
		List<PerfilJWT> perfis = new ArrayList<>();
		perfis.add(PerfilJWT.ADMIN);
		return new UserSS(user.getId(), user.getUsuario(), user.getSenha(), perfis);
	}

}
