package br.furb.inf.furbot.repositories.relatorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.furb.inf.furbot.models.relatorio.Acesso;

@Repository
public interface AcessoRespository extends JpaRepository<Acesso, UUID>, AcessoCustomRepository {

}
