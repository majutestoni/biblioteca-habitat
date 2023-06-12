package br.furb.inf.furbot.controllers.endereco;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.models.endereco.Endereco;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.endereco.EnderecoService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Serviço de endereco", externalDocs = @ExternalDocumentation(description = "Serviço responsável por gerenciar os enderecos"))
@RestController
@RequestMapping("/endereco")
public class EnderecoController extends ControllerImpl<Endereco> {

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public Service<Endereco> getService() {
        return enderecoService;
    }
}
