package br.furb.inf.furbot.repositories.material.subtabelas;

import br.furb.inf.furbot.models.material.Autor;
import br.furb.inf.furbot.models.material.subtabelas.AutorMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AutorMaterialRepository extends JpaRepository<AutorMaterial, UUID> {
}
