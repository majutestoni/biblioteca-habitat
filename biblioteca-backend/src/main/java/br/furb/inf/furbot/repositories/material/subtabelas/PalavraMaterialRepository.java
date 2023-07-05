package br.furb.inf.furbot.repositories.material.subtabelas;

import br.furb.inf.furbot.models.material.subtabelas.AutorMaterial;
import br.furb.inf.furbot.models.material.subtabelas.PalavraMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PalavraMaterialRepository extends JpaRepository<PalavraMaterial, UUID> {
}
