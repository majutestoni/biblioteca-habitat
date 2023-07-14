package br.furb.inf.furbot.controllers.material;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.dtos.MaterialRetornoDto;
import br.furb.inf.furbot.models.material.Material;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.material.MaterialService;
import br.furb.inf.furbot.utils.FilterImpl;
import br.furb.inf.furbot.utils.Page;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "Serviço de material", externalDocs = @ExternalDocumentation(description = "Serviço responsável por gerenciar os materiais"))
@RestController
@RequestMapping("/material")
public class MaterialController extends ControllerImpl<Material> {

    // Para aprovação do material será utilizado o update

    @Autowired
    private MaterialService materialService;

    @Override
    public Service<Material> getService() {
        return materialService;
    }


    // A escolha de usar um dto pois o retorno entra em loop
    @PostMapping("/novo")
    public ResponseEntity<MaterialRetornoDto> novo(@Valid @RequestBody Material entity) {
        MaterialRetornoDto dto = materialService.novo(entity);
        return ResponseEntity.ok(dto);
    }

    // Materias para admin aprovar
    @GetMapping("/admin")
    public ResponseEntity<Page<MaterialRetornoDto>> paraAprovar(@Parameter(description = "Filtro genérico para busca", example = "filtro=name IGUAL 'jorge' and idade MAIOR 10 and nome LIKE 'j'") @RequestParam(defaultValue = "") String filtro, //
                                                                @Parameter(description = "Limite de itens por página") @RequestParam(defaultValue = "0") Integer size, //
                                                                @Parameter(description = "Navegar entre as paginas") @RequestParam(defaultValue = "0") Integer page, //
                                                                @Parameter(description = "Ordem que deve retornar os dados", example = "ordenar=nome ASC") @RequestParam(defaultValue = "") String ordenar) {

       materialService.valid();
        filtro = "aprovado IGUAL false";
        Page<Material> materials = super.list(filtro, size, page, ordenar).getBody();
        Page<MaterialRetornoDto> dto  = new Page();

        List<MaterialRetornoDto> MaterialRetornoDto = materialService.materiaisForDto(materials.getConteudo());
        dto.setConteudo(MaterialRetornoDto);
        dto.setTotalPaginas(materials.getTotalPaginas());
        dto.setTotalElementos(materials.getTotalElementos());

        return ResponseEntity.ok(dto);

    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<MaterialRetornoDto> getByid(@Valid @PathVariable UUID id) {
        Material material = materialService.get(id);
        MaterialRetornoDto dto = new MaterialRetornoDto(material);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/publicados")
    public ResponseEntity<Page<MaterialRetornoDto>> publicados(@Parameter(description = "Filtro genérico para busca", example = "filtro=name IGUAL 'jorge' and idade MAIOR 10 and nome LIKE 'j'") @RequestParam(defaultValue = "") String filtro, //
                                                               @Parameter(description = "Limite de itens por página") @RequestParam(defaultValue = "0") Integer size, //
                                                               @Parameter(description = "Navegar entre as paginas") @RequestParam(defaultValue = "0") Integer page, //
                                                               @Parameter(description = "Ordem que deve retornar os dados", example = "ordenar=nome ASC") @RequestParam(defaultValue = "") String ordenar) {

        filtro = "aprovado IGUAL true";
        Page<Material> materials = super.list(filtro, size, page, ordenar).getBody();
        Page<MaterialRetornoDto> dto  = new Page();
        List<MaterialRetornoDto> MaterialRetornoDto = materialService.materiaisForDto(materials.getConteudo());

        dto.setConteudo(MaterialRetornoDto);
        dto.setTotalPaginas(materials.getTotalPaginas());
        dto.setTotalElementos(materials.getTotalElementos());

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping
    public ResponseEntity<String> limparVencidos() {
        String retorno = materialService.limpaDeMateriais();

        return ResponseEntity.ok().body(retorno);
    }


}
