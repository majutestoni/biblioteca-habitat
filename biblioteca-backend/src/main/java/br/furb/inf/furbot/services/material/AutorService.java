package br.furb.inf.furbot.services.material;

import br.furb.inf.furbot.models.material.Autor;
import br.furb.inf.furbot.repositories.material.AutorRepository;
import br.furb.inf.furbot.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AutorService extends ServiceImpl<Autor> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public JpaRepository<Autor, UUID> getRepository() {
        return autorRepository;
    }

    @Override
    public void validator(Autor entity) {

    }

    public Autor findById(UUID id){
        return autorRepository.getOne(id);
    }

}
