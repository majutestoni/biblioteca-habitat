package br.furb.inf.furbot.repositories.material;

import br.furb.inf.furbot.models.material.PalavraChave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PalavraChaveResitory extends JpaRepository<PalavraChave, UUID> {
}
