package br.furb.inf.furbot.services.endereco;

import br.furb.inf.furbot.models.endereco.Endereco;
import br.furb.inf.furbot.repositories.endereco.EnderecoRepository;
import br.furb.inf.furbot.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoService extends ServiceImpl<Endereco> {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public JpaRepository<Endereco, UUID> getRepository() {
        return enderecoRepository;
    }

    @Override
    public void validator(Endereco entity) {

    }

    @Override
    public Endereco create(Endereco entity) {

        entity.setCidade(entity.getCidade().toUpperCase());
        entity.setEstadoOuProvincia(entity.getEstadoOuProvincia().toUpperCase());
        entity.setPais(entity.getPais().toUpperCase());

        return super.create(entity);
    }

    public List<Endereco> findByPais(String pais){
        return this.enderecoRepository.findByPais(pais);
    }

    public List<Endereco> findByEstado(String estado){
        return  this.enderecoRepository.findByEstadoOuProvincia(estado);
    }

    public List<String> getPais(){
        return this.enderecoRepository.getPais();
    }



}
