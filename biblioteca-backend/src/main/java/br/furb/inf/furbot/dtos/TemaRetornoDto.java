package br.furb.inf.furbot.dtos;

import br.furb.inf.furbot.models.material.PalavraChave;
import br.furb.inf.furbot.models.material.Tema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemaRetornoDto {

    private UUID id;
    private String tema;

    public TemaRetornoDto(Tema tema) {
        this.id = tema.getId();
        this.tema = tema.getTema();
    }
}
