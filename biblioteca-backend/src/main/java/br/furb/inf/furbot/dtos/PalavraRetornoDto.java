package br.furb.inf.furbot.dtos;

import br.furb.inf.furbot.models.material.PalavraChave;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PalavraRetornoDto {

    private UUID id;
    private String palavra;

    public PalavraRetornoDto(PalavraChave palavraChave) {
        this.id = palavraChave.getId();
        setPalavra(palavraChave.getPalavra());
    }
}
