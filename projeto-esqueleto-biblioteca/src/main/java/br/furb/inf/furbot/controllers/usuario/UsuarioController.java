package br.furb.inf.furbot.controllers.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.furb.inf.furbot.controllers.ControllerImpl;
import br.furb.inf.furbot.models.usuario.Usuario;
import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.services.usuario.UsuarioService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Serviço de usuário", externalDocs = @ExternalDocumentation(description = "Serviço responsável por gerenciar usuário"))
@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends ControllerImpl<Usuario> {

	@Autowired
	private UsuarioService service;

	@Override
	public Service<Usuario> getService() {
		return service;
	}

	@Operation(summary = "Retorna o usuário online", responses = {
			@ApiResponse(responseCode = "200", description = "Quando houver usuário online"),
			@ApiResponse(responseCode = "401", description = "Quando não houver usuário online") })
	@GetMapping("/logado")
	public ResponseEntity<Usuario> buscar() {
		return ResponseEntity.ok().body(this.service.buscarUsuarioLogado());
	}

}
