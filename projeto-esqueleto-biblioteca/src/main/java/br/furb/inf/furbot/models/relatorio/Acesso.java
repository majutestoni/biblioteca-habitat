package br.furb.inf.furbot.models.relatorio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.furb.inf.furbot.models.ModelImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Acesso extends ModelImpl {

	private static final long serialVersionUID = 1L;

	@Column(nullable = true)
	private String endpoint;

	@Column(nullable = true)
	private String usuario;

	@Column(nullable = true)
	private Date date;

	@Column(nullable = true)
	private boolean autorizado;

}
