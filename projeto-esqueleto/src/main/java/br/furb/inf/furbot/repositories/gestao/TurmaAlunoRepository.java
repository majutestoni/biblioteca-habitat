package br.furb.inf.furbot.repositories.gestao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.furb.inf.furbot.models.gestao.TurmaAluno;

@Repository
public interface TurmaAlunoRepository extends JpaRepository<TurmaAluno, UUID>, TurmaAlunoCustomRepository {

}
