package br.furb.inf.furbot.services.relatorio;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.furb.inf.furbot.models.relatorio.Acesso;
import br.furb.inf.furbot.repositories.relatorio.AcessoRespository;
import br.furb.inf.furbot.services.ServiceImpl;

@Service
public class AcessoService extends ServiceImpl<Acesso> {

	@Autowired
	private AcessoRespository acessoRepository;

	@Override
	public JpaRepository<Acesso, UUID> getRepository() {
		return acessoRepository;
	}

	@Override
	public void validator(Acesso entity) {
	}

}
