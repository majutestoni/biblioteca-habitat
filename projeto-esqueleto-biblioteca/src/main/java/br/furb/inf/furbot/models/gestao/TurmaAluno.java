package br.furb.inf.furbot.models.gestao;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

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
public class TurmaAluno extends ModelImpl {

	private static final long serialVersionUID = 1L;

	@Column(name = "turma_id", columnDefinition = "char(36)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	@NotNull(message = "Turma é obrigatório")
	private UUID turma;

	@Column(name = "aluno_id", columnDefinition = "char(36)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	@NotNull(message = "Aluno é obrigatório")
	private UUID aluno;

}
