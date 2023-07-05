package br.furb.inf.furbot.services.material;

import br.furb.inf.furbot.models.material.Tema;
import br.furb.inf.furbot.repositories.material.TemaRepository;
import br.furb.inf.furbot.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TemaService extends ServiceImpl<Tema> {

    @Autowired
    private TemaRepository temaRepository;

    @Override
    public JpaRepository<Tema, UUID> getRepository() {
        return temaRepository;
    }

    @Override
    public void validator(Tema entity) {

    }
}
