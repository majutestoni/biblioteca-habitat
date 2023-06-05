package br.furb.inf.furbot.repositories.usuario;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.furb.inf.furbot.models.usuario.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID>, AlunoCustomRepository {

}
