package br.furb.inf.furbot.services.material.subtabelas;

import br.furb.inf.furbot.models.material.Autor;
import br.furb.inf.furbot.models.material.subtabelas.AutorMaterial;
import br.furb.inf.furbot.repositories.material.subtabelas.AutorMaterialRepository;
import br.furb.inf.furbot.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AutorMaterialService extends ServiceImpl<AutorMaterial> {

    @Autowired
    private AutorMaterialRepository autorMaterialRepository;
    @Override
    public JpaRepository<AutorMaterial, UUID> getRepository() {
        return autorMaterialRepository;
    }

    @Override
    public void validator(AutorMaterial entity) {

    }
}
