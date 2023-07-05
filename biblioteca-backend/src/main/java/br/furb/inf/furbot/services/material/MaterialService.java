package br.furb.inf.furbot.services.material;

import br.furb.inf.furbot.models.material.Material;
import br.furb.inf.furbot.repositories.material.MaterialRepository;
import br.furb.inf.furbot.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MaterialService extends ServiceImpl<Material> {

    @Autowired
    private MaterialRepository materialRepository;
    @Override
    public JpaRepository<Material, UUID> getRepository() {
        return materialRepository;
    }

    @Override
    public void validator(Material entity) {

    }
}
