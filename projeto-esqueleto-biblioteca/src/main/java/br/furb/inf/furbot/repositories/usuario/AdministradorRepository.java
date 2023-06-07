package br.furb.inf.furbot.repositories.usuario;

import br.furb.inf.furbot.models.usuario.Administrador;
import br.furb.inf.furbot.models.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, UUID>{
    Administrador findByUsuario(String usuario);

}
