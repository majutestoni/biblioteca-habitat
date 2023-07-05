package br.furb.inf.furbot.controllers.material;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.models.material.Autor;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.material.AutorService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Serviço de autor", externalDocs = @ExternalDocumentation(description = "Serviço responsável por gerenciar os autores"))
@RestController
@RequestMapping("/autor")
public class AutorController extends ControllerImpl<Autor> {

    @Autowired
    private AutorService autorService;
    @Override
    public Service<Autor> getService() {
        return autorService;
    }
}
