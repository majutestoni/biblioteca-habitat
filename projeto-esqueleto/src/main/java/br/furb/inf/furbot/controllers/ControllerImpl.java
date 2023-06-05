package br.furb.inf.furbot.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.furb.inf.furbot.services.Service;
import br.furb.inf.furbot.utils.FilterImpl;
import br.furb.inf.furbot.utils.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public abstract class ControllerImpl<T> implements Controller<T> {

	public abstract Service<T> getService();

	@Operation(summary = "Cadastrar novo registro", responses = {
			@ApiResponse(responseCode = "200", description = "Quando o registro for atualizado"),
			@ApiResponse(responseCode = "400", description = "Verifique os dados obrigatórios"),
			@ApiResponse(responseCode = "404", description = "Quando alguma chave estrangeira não for encontrada") })
	@PostMapping
	@Override
	public ResponseEntity<T> create(@Valid @RequestBody T entity) {
		return ResponseEntity.ok().body(getService().create(entity));
	}

	@Operation(summary = "Atualizar um registro existente", responses = {
			@ApiResponse(responseCode = "200", description = "Quando o registro for atualizado"),
			@ApiResponse(responseCode = "400", description = "Verifique os dados obrigatórios"),
			@ApiResponse(responseCode = "404", description = "Quando o registro não for encontrado") })
	@PutMapping("/{id}")
	@Override
	public ResponseEntity<T> update(
			@Parameter(description = "ID do registro a ser atualizado") @PathVariable(required = true) UUID id, //
			@Parameter(description = "Objeto com os novos valores") @Valid @RequestBody T entity) {
		return ResponseEntity.ok().body(getService().update(id, entity));
	}

	@Operation(summary = "Remover um registro existente", responses = {
			@ApiResponse(responseCode = "200", description = "Quando o registro for removido"),
			@ApiResponse(responseCode = "404", description = "Quando o registro não for encontrado") })
	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<?> delete(@PathVariable(required = true) UUID id) {
		getService().delete(id);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "Obter um registro existente pelo ID", responses = {
			@ApiResponse(responseCode = "200", description = "Quando o registro for encontrado"),
			@ApiResponse(responseCode = "404", description = "Quando não encontrar o registro") })
	@GetMapping("/{id}")
	@Override
	public ResponseEntity<T> retrieve(@PathVariable(required = true) UUID id) {
		System.out.println("aqui 1");
		return ResponseEntity.ok().body(getService().retrieve(id));
	}

	@Operation(summary = "Realizar consultas dinâmicas na entidade")
	@GetMapping
	@Override
	public ResponseEntity<Page<T>> list( //
			@Parameter(description = "Filtro genérico para busca", example = "filtro=name IGUAL 'jorge' and idade MAIOR 10 and nome LIKE 'j'") @RequestParam(defaultValue = "") String filtro, //
			@Parameter(description = "Limite de itens por página") @RequestParam(defaultValue = "0") Integer size, //
			@Parameter(description = "Navegar entre as paginas") @RequestParam(defaultValue = "0") Integer page, //
			@Parameter(description = "Ordem que deve retornar os dados", example = "ordenar=nome ASC") @RequestParam(defaultValue = "") String ordenar //
	) {
		return ResponseEntity.ok().body(getService().list(FilterImpl.parse(filtro, size, page, ordenar)));
	}

}
