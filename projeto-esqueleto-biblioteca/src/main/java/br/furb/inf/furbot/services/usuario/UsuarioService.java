package br.furb.inf.furbot.services.usuario;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.furb.inf.furbot.enuns.Perfil;
import br.furb.inf.furbot.exceptions.BadRequestException;
import br.furb.inf.furbot.exceptions.ConflictedException;
import br.furb.inf.furbot.exceptions.NotAuthorizationException;
import br.furb.inf.furbot.models.usuario.Usuario;
import br.furb.inf.furbot.repositories.usuario.UsuarioRepository;
import br.furb.inf.furbot.security.UserSS;
import br.furb.inf.furbot.services.ServiceImpl;

@Service
public class UsuarioService extends ServiceImpl<Usuario> {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private BCryptPasswordEncoder bCript;

	@Override
	public JpaRepository<Usuario, UUID> getRepository() {
		return repository;
	}

	@Override
	@Transactional
	public Usuario create(Usuario usuario) {
		if (obterPeloUsuario(usuario.getUsuario()) != null) {
			throw new ConflictedException("Já existe um usuário com este nome!");
		}
		if (usuario.getSenha() == null && usuario.getSenha().isEmpty()) {
			throw new BadRequestException("Usuário deve conter senha!");
		}
		usuario.setSenha(bCript.encode(usuario.getSenha()));
		if (usuario.getPerfil() == null) {
			usuario.setPerfil(Perfil.JOGADOR);
		}
		if (usuario.getPerfil().equals(Perfil.PROFESSOR)
				&& (usuario.getEmail() == null || usuario.getEmail().isEmpty())) {
			throw new BadRequestException("Usuário do tipo professor deve conter e-mail!");
		}
		return super.create(usuario);
	}

	@Override
	@Transactional
	public Usuario update(UUID id, Usuario usuario) {

		if (!buscarUsuarioLogado().getId().equals(id)) {
			throw new NotAuthorizationException("Seu usuário nao pode fazer isso");
		}
		if (usuario.getSenha() != null) {
			usuario.setSenha(bCript.encode(usuario.getSenha()));
		} else {
			usuario.setSenha(buscarUsuarioLogado().getSenha());
		}
		return super.update(id, usuario);
	}

	@Override
	public void validator(Usuario entity) {

	}

	@Transactional(readOnly = true)
	public Usuario obterPeloUsuario(String usuario) {
		return repository.findByUsuario(usuario);
	}

	public Usuario buscarUsuarioLogado() {
		UserSS ss = this.authenticated();
		if (ss == null) {
			throw new NotAuthorizationException("Usuário não autenticado");
		}
		return this.get(ss.getId());
	}

	public static String usuarioLogado() {
		UserSS user = null;
		try {
			user = (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user != null ? user.getUsername() : "Não autenticado";
	}

	private UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
