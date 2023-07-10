package br.furb.inf.furbot.dtos;

import br.furb.inf.furbot.enuns.Tipo;
import br.furb.inf.furbot.models.material.Material;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialRetornoDto {

    private UUID id;
    private String titulo;
    private String descricao;
    private Tipo tipo;
    private String link;

    private ArrayList<AutoresRetornoDto> autoresRetornoDtos;


    public MaterialRetornoDto(Material material) {
        this.id = material.getId();
        this.titulo = material.getTitulo();
        this.descricao = material.getDescricao();
        this.tipo = material.getTipo();
        this.link = material.getLink();

        ArrayList<AutoresRetornoDto> dto = new ArrayList<>();

        material.getAutores().forEach(i -> {
            AutoresRetornoDto autor = new AutoresRetornoDto(i);
            dto.add(autor);
        });

        this.autoresRetornoDtos = dto;

    }
}
