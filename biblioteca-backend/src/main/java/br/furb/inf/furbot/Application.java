package br.furb.inf.furbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition( //
		info = @Info(title = "Serviço do Projeto Esqueleto", version = "1.0.0"), //
		externalDocs = @ExternalDocumentation(description = "Este projeto é baseado na estrutura do projeto Furbot. \nConstruido para que outras pessoas se baseiem nele."))
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
