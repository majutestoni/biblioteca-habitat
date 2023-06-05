package br.furb.inf.furbot.repositories.usuario;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.furb.inf.furbot.models.usuario.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>, br.furb.inf.furbot.repositories.Repository<Usuario> {

	Usuario findByUsuario(String usuario);
	
}
