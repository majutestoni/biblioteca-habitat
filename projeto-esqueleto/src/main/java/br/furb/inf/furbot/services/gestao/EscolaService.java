package br.furb.inf.furbot.services.gestao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.furb.inf.furbot.models.gestao.Escola;
import br.furb.inf.furbot.repositories.gestao.EscolaRepository;
import br.furb.inf.furbot.services.ServiceImpl;

@Service
public class EscolaService extends ServiceImpl<Escola> {

	@Autowired
	private EscolaRepository escolaRepository;

	@Override
	public JpaRepository<Escola, UUID> getRepository() {
		return escolaRepository;
	}

	@Override
	public void validator(Escola entity) {
	}

}
