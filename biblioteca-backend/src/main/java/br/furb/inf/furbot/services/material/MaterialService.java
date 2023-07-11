package br.furb.inf.furbot.services.material;

import br.furb.inf.furbot.dtos.MaterialRetornoDto;
import br.furb.inf.furbot.exceptions.BadRequestException;
import br.furb.inf.furbot.models.material.Autor;
import br.furb.inf.furbot.models.material.Material;
import br.furb.inf.furbot.models.material.PalavraChave;
import br.furb.inf.furbot.models.material.Tema;
import br.furb.inf.furbot.models.usuario.Usuario;
import br.furb.inf.furbot.repositories.material.MaterialRepository;
import br.furb.inf.furbot.services.ServiceImpl;
import br.furb.inf.furbot.services.usuario.UsuarioService;
import br.furb.inf.furbot.utils.FilterImpl;
import br.furb.inf.furbot.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class MaterialService extends ServiceImpl<Material> {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private AutorService autorService;

    @Autowired
    private TemaService temaService;

    @Autowired
    private PalavraChaveService palavraChaveService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public JpaRepository<Material, UUID> getRepository() {
        return materialRepository;
    }

    @Override
    public void validator(Material entity) {

    }

    @Transactional
    public MaterialRetornoDto novo(Material entity) {


        // O motivo pelo qual isto é feito é para poder retornar o nome, palavra e tema
        entity.setAutores(autores(entity.getAutores()));
        entity.setPalavras(palavras(entity.getPalavras()));
        entity.setTemas(temas(entity.getTemas()));

        Usuario usuario = usuarioService.buscarUsuarioLogado();

        if (usuario.getAdmin() == true) {
            entity.setAprovado(true);
            entity.setPublicado(true);
        }

        Material material = super.create(entity);

        MaterialRetornoDto dto = new MaterialRetornoDto(material);
        return dto;

    }

    @Transactional
    public List<MaterialRetornoDto> paraAdmin() {
        Usuario usuario = usuarioService.buscarUsuarioLogado();

        if (!usuario.getAdmin()) {
            throw new BadRequestException("Este usuario não tem permissão apra realizar esta ação!");
        }

        List<Material> list = materialRepository.findByNotAprovado();

        List<MaterialRetornoDto> dto = new ArrayList<>();

        list.forEach(i -> {
            MaterialRetornoDto temp = new MaterialRetornoDto(i);
            dto.add(temp);
        });


        return dto;


    }

    public Page<MaterialRetornoDto> materiasPublicados(List<Material> materiais) {


        Page<MaterialRetornoDto> dto = new Page<>();

        materiais.forEach(i -> {
            MaterialRetornoDto temp = new MaterialRetornoDto(i);
            dto.getConteudo().add(temp);
        });
        return dto;


    }


    private Set<Tema> temas(Set<Tema> entity) {
        Set<Tema> temas = new HashSet<>();
        entity.forEach(e -> {
            Tema temp = temaService.get(e.getId());
            if (temp == null) {
                throw new BadRequestException("Não existe tema com esse id!");
            }
            temas.add(temp);
        });

        return temas;
    }

    private Set<PalavraChave> palavras(Set<PalavraChave> entity) {
        Set<PalavraChave> palavras = new HashSet<>();
        entity.forEach(e -> {
            PalavraChave temp = palavraChaveService.get(e.getId());
            if (temp == null) {
                throw new BadRequestException("Não existe palavra com esse id!");
            }
            palavras.add(temp);
        });

        return palavras;
    }

    private Set<Autor> autores(Set<Autor> entity) {
        Set<Autor> autores = new HashSet<>();
        entity.forEach(e -> {
            Autor temp = autorService.get(e.getId());
            if (temp == null) {
                throw new BadRequestException("Não existe autor com esse id!");
            }
            autores.add(temp);
        });

        return autores;
    }


}
