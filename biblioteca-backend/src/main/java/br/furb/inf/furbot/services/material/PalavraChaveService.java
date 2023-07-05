package br.furb.inf.furbot.services.material;

import br.furb.inf.furbot.models.material.PalavraChave;
import br.furb.inf.furbot.repositories.material.PalavraChaveResitory;
import br.furb.inf.furbot.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PalavraChaveService extends ServiceImpl<PalavraChave> {

    @Autowired
    private PalavraChaveResitory palavraChaveResitory;

    @Override
    public JpaRepository<PalavraChave, UUID> getRepository() {
        return palavraChaveResitory;
    }

    @Override
    public void validator(PalavraChave entity) {

    }
}
