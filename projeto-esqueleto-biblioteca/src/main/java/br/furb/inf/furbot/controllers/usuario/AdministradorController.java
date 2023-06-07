package br.furb.inf.furbot.controllers.usuario;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.models.usuario.Administrador;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.usuario.AdministradorService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Serviço de administrador", externalDocs = @ExternalDocumentation(description = "Serviço responsável por gerenciar administrador"))
@RestController
@RequestMapping("/administradores")
public class AdministradorController extends ControllerImpl<Administrador> {

    @Autowired
    private AdministradorService administradorService;


    @Override
    public Service<Administrador> getService() {
        return administradorService;
    }
}
