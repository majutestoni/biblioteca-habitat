package br.furb.inf.furbot.repositories.endereco;

import br.furb.inf.furbot.models.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

    @Query(value = "select DISTINCT e.pais from endereco e", nativeQuery = true)
    List<String> getPais();
    List<Endereco> findByPais(String pais);

    Endereco findByPaisAndEstadoOuProvinciaAndCidade(String pais, String estado, String cidade);

    List<Endereco> findByEstadoOuProvincia(String estado);

}
