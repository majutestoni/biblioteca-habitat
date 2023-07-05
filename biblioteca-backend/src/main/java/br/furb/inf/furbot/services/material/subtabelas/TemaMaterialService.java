package br.furb.inf.furbot.services.material.subtabelas;

import br.furb.inf.furbot.models.material.subtabelas.TemaMaterial;
import br.furb.inf.furbot.repositories.material.subtabelas.TemaMaterialRepository;
import br.furb.inf.furbot.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TemaMaterialService extends ServiceImpl<TemaMaterial> {

    @Autowired
    private TemaMaterialRepository temaMaterialRepository;
    @Override
    public JpaRepository<TemaMaterial, UUID> getRepository() {
        return temaMaterialRepository;
    }

    @Override
    public void validator(TemaMaterial entity) {

    }
}
