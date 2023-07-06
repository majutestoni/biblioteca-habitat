package br.furb.inf.furbot.services.material;

import br.furb.inf.furbot.models.material.Autor;
import br.furb.inf.furbot.models.material.Material;
import br.furb.inf.furbot.models.usuario.Usuario;
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


    @Override
    @Transactional
    public Material create(Material entity) {

        ArrayList<Autor> autores = new ArrayList<>();

        entity.getAutores().forEach(e -> {
            Autor temp = autorService.findById(e.getId());
            autores.add(temp);
        });

        entity.getAutores().clear();
        autores.forEach(c -> {
            entity.getAutores().add(c);
        });

        System.out.println("CHEGOU AQUI");

        return super.create(entity);

    }

}
