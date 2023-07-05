package br.furb.inf.furbot.repositories.material.subtabelas;

import br.furb.inf.furbot.models.material.subtabelas.PalavraMaterial;
import br.furb.inf.furbot.models.material.subtabelas.TemaMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TemaMaterialRepository extends JpaRepository<TemaMaterial, UUID> {
}
