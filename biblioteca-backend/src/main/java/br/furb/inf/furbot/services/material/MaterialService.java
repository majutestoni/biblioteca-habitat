package br.furb.inf.furbot.services.material;

import br.furb.inf.furbot.dtos.MaterialRetornoDto;
import br.furb.inf.furbot.models.material.Autor;
import br.furb.inf.furbot.models.material.Material;
import br.furb.inf.furbot.repositories.material.MaterialRepository;
import br.furb.inf.furbot.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class MaterialService extends ServiceImpl<Material> {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private AutorService autorService;

    @Override
    public JpaRepository<Material, UUID> getRepository() {
        return materialRepository;
    }

    @Override
    public void validator(Material entity) {

    }

    @Transactional
    public MaterialRetornoDto novo(Material entity) {

        ArrayList<Autor> autores = new ArrayList<>();

        entity.getAutores().forEach(e -> {
            Autor temp = autorService.findById(e.getId());
            autores.add(temp);
        });

        entity.getAutores().clear();
        autores.forEach(c -> {
            entity.getAutores().add(c);
        });

        Material material = super.create(entity);

        MaterialRetornoDto dto = new MaterialRetornoDto(material);
        return dto;

    }

}
