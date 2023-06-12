package br.furb.inf.furbot.utils;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {

	private List<T> conteudo;
	private Long totalElementos;
	private Long totalPaginas; 
	
}
