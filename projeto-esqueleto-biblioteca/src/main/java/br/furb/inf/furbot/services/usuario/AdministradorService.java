package br.furb.inf.furbot.services.usuario;

import br.furb.inf.furbot.exceptions.BadRequestException;
import br.furb.inf.furbot.exceptions.ConflictedException;
import br.furb.inf.furbot.exceptions.NotAuthorizationException;
import br.furb.inf.furbot.models.ModelImpl;
import br.furb.inf.furbot.models.usuario.Administrador;
import br.furb.inf.furbot.models.usuario.Usuario;
import br.furb.inf.furbot.repositories.usuario.AdministradorRepository;
import br.furb.inf.furbot.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.UUID;

@Service
public class AdministradorService extends ServiceImpl<Administrador> {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private BCryptPasswordEncoder bCript;

    @Override
    public JpaRepository<Administrador, UUID> getRepository() {
        return this.administradorRepository;
    }

    @Override
    public void validator(Administrador entity) {

    }

    @Transactional
    @Override
    public Administrador create(Administrador administrador){
        if (obterPeloUsuario(administrador.getUsuario()) != null) {
            throw new ConflictedException("Já existe um usuário com este nickname!");
        }

        if (administrador.getSenha() == null && administrador.getSenha().isEmpty()) {
            throw new BadRequestException("Usuário deve conter senha!");
        }

        administrador.setSenha(bCript.encode(administrador.getSenha()));

        //validator(administrador);
        if (administrador.getId() != null) {
            throw new BadRequestException("O ID não pode ser passado na criação de um registro");
        }

        return administradorRepository.save(administrador);

    }

    @Transactional
    public Administrador update(UUID id) {

        Administrador administrador = administradorRepository.getOne(id);
        if(administrador == null){
            throw new BadRequestException("usuario não encontrado");
        }
        if (administrador.getSenha() != null) {
            administrador.setSenha(bCript.encode(administrador.getSenha()));
        } else {
            administrador.setSenha(administrador.getSenha());
        }
        return administradorRepository.save(administrador);
    }


    @Transactional(readOnly = true)
    public Administrador obterPeloUsuario(String usuario) {
        return administradorRepository.findByUsuario(usuario);
    }


}
