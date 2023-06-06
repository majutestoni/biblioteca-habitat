package br.furb.inf.furbot.repositories.gestao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.furb.inf.furbot.models.gestao.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, UUID>, TurmaCustomRepository {

}
