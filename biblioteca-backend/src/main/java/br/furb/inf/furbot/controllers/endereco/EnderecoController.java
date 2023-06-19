package br.furb.inf.furbot.controllers.endereco;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.models.endereco.Endereco;
import br.furb.inf.furbot.models.usuario.Usuario;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.endereco.EnderecoService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/findAll")
    public ResponseEntity<List<String>> buscar() {
        return ResponseEntity.ok().body(this.enderecoService.getPais());
    }
    @GetMapping("/findAll/{pais}")
    public ResponseEntity<List<Endereco>> buscarEstados(@PathVariable String pais) {
        return ResponseEntity.ok().body(this.enderecoService.findByPais(pais));
    }

    @GetMapping("/findAll/estado/{estado}")
    public ResponseEntity<List<Endereco>> buscarCidades(@PathVariable String estado) {
        return ResponseEntity.ok().body(this.enderecoService.findByEstado(estado));
    }


}
