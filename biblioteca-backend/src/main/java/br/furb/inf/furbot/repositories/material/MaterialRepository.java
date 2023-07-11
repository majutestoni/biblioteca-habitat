package br.furb.inf.furbot.repositories.material;

import br.furb.inf.furbot.models.material.Material;
import br.furb.inf.furbot.utils.FilterImpl;
import br.furb.inf.furbot.utils.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MaterialRepository extends JpaRepository<Material, UUID>, MaterialCustomRepository {

    @Query(value = "select * from material m where m.aprovado is false", nativeQuery = true)
    List<Material> findByNotAprovado();

}
