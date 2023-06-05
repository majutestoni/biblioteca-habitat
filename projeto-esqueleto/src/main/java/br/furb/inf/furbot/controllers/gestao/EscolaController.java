package br.furb.inf.furbot.controllers.gestao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.models.gestao.Escola;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.gestao.EscolaService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Serviço de escola", externalDocs = @ExternalDocumentation(description = "Serviço responsável por gerenciar escolas"))
@RestController
@RequestMapping("/escolas")
public class EscolaController extends ControllerImpl<Escola> {

	@Autowired
	private EscolaService service;

	@Override
	public Service<Escola> getService() {
		return service;
	}

}
