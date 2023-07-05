package br.furb.inf.furbot.controllers.material;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.models.material.PalavraChave;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.material.PalavraChaveService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Serviço de palavra chave", externalDocs = @ExternalDocumentation(description = "Serviço responsável por gerenciar as palavras chaves"))
@RestController
@RequestMapping("/palavra")
public class PalavraChaveController extends ControllerImpl<PalavraChave> {

    @Autowired
    private PalavraChaveService palavraChaveService;

    @Override
    public Service<PalavraChave> getService() {
        return palavraChaveService;
    }
}
