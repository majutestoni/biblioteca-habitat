package br.furb.inf.furbot.models.gestao;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import br.furb.inf.furbot.enuns.Turno;
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
public class Turma extends ModelImpl {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Ano não pode ser nulo!")
	@NotEmpty(message = "Ano não pode ser vazio!")
	@Size(min = 4, max = 50, message = "Ano deve ser entre 4 e 50 dígitos")
	private String ano;

	@NotNull(message = "Escola não pode ser nulo!")
	@JoinColumn(name = "escola_id", referencedColumnName = "id", table = "escola", columnDefinition = "char(36)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID escolaId;

	@Column(nullable = true)
	@Size(min = 4, max = 150, message = "Nome da turma deve ser entre 4 e 150 dígitos")
	private String nome;

	@NotNull(message = "Turno não pode ser nulo!")
	private Turno turno;

	@NotNull(message = "Ano letivo não pode ser nulo!")
	private Integer anoLetivo;

	@Column(name = "professor", columnDefinition = "char(36)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID professorId;
	
	private Integer codigo;

	@Transient
	private Escola escola;
}
