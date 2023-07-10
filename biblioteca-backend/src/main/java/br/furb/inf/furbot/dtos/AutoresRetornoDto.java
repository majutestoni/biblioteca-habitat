package br.furb.inf.furbot.dtos;

import br.furb.inf.furbot.models.material.Autor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutoresRetornoDto {

    private UUID id;
    private String nome;

    public AutoresRetornoDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
    }
}
