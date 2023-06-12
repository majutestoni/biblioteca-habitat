package br.furb.inf.furbot.controllers.relatorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.models.relatorio.Acesso;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.relatorio.AcessoService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Serviço de acesso", externalDocs = @ExternalDocumentation(description = "Serviço responsável por gerenciar os acessos"))
@RestController
@RequestMapping("/acesso")
public class AcessoController extends ControllerImpl<Acesso> {

	@Autowired
	private AcessoService service;

	@Override
	public Service<Acesso> getService() {
		return service;
	}

}
