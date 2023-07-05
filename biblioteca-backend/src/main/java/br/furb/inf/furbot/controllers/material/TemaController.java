package br.furb.inf.furbot.controllers.material;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.models.material.Autor;
import br.furb.inf.furbot.models.material.Tema;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.material.TemaService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Serviço de tema", externalDocs = @ExternalDocumentation(description = "Serviço responsável por gerenciar os temas"))
@RestController
@RequestMapping("/tema")
public class TemaController extends ControllerImpl<Tema> {

    @Autowired
    private TemaService temaService;

    @Override
    public Service<Tema> getService() {
        return temaService;
    }
}
