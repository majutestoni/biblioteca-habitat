package br.furb.inf.furbot.controllers.material;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.dtos.MaterialRetornoDto;
import br.furb.inf.furbot.models.material.Material;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.material.MaterialService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Serviço de material", externalDocs = @ExternalDocumentation(description = "Serviço responsável por gerenciar os materiais"))
@RestController
@RequestMapping("/material")
public class MaterialController extends ControllerImpl<Material> {

    @Autowired
    private MaterialService materialService;

    @Override
    public Service<Material> getService() {
        return materialService;
    }


    // A escolha de usar um dto pois o retorno entra em loop
    @PostMapping("/novo")
    public ResponseEntity<MaterialRetornoDto> novo(@Valid @RequestBody Material entity){
        MaterialRetornoDto dto = materialService.novo(entity);
        return ResponseEntity.ok(dto);
    }

}
