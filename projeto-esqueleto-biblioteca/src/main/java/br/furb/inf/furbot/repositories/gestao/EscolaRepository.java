package br.furb.inf.furbot.repositories.gestao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.furb.inf.furbot.models.gestao.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, UUID>, EscolaCustomRepository {

}
