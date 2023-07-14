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
    private String colaborador;
    private String idioma;
    private Integer ano;
    private Tipo tipo;
    private String link;
    private boolean editar;
    private  boolean aprovado;

    private ArrayList<AutoresRetornoDto> autoresRetornoDtos;
    private ArrayList<PalavraRetornoDto> palavraRetornoDtos;
    private ArrayList<TemaRetornoDto> temaRetornoDtos;

    public MaterialRetornoDto(Material material) {
        this.id = material.getId();
        this.titulo = material.getTitulo();
        this.descricao = material.getDescricao();
        this.tipo = material.getTipo();
        this.link = material.getLink();
        this.editar = material.isEditar();
        this.aprovado = material.isAprovado();
        this.colaborador = material.getCriadoPor();
        this.ano = material.getAno();
        this.idioma = material.getIdioma();

        ArrayList<AutoresRetornoDto> autores = new ArrayList<>();
        ArrayList<PalavraRetornoDto> palavras = new ArrayList<>();
        ArrayList<TemaRetornoDto> temas = new ArrayList<>();

        material.getAutores().forEach(i -> {
            AutoresRetornoDto autor = new AutoresRetornoDto(i);
            autores.add(autor);
        });

        material.getPalavras().forEach(e -> {
            PalavraRetornoDto palavra = new PalavraRetornoDto(e);
            palavras.add(palavra);
        });

        material.getTemas().forEach(j -> {
            TemaRetornoDto tema = new TemaRetornoDto(j);
            temas.add(tema);
        });

        this.autoresRetornoDtos = autores;
        this.palavraRetornoDtos = palavras;
        this.temaRetornoDtos = temas;
    }
}
