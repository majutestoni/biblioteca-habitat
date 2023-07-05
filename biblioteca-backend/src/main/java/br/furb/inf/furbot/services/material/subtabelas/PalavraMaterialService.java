package br.furb.inf.furbot.services.material.subtabelas;

import br.furb.inf.furbot.models.material.subtabelas.PalavraMaterial;
import br.furb.inf.furbot.repositories.material.subtabelas.PalavraMaterialRepository;
import br.furb.inf.furbot.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PalavraMaterialService extends ServiceImpl<PalavraMaterial> {

    @Autowired
    private PalavraMaterialRepository palavraMaterialRepository;
    @Override
    public JpaRepository<PalavraMaterial, UUID> getRepository() {
        return palavraMaterialRepository;
    }

    @Override
    public void validator(PalavraMaterial entity) {

    }
}
