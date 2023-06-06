package br.furb.inf.furbot.models.usuario;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import br.furb.inf.furbot.enuns.Genero;
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
@Table(name = "aluno")
public class Aluno extends ModelImpl {

	private static final long serialVersionUID = 1L;

	private String nome;

	@Column(name = "professor", columnDefinition = "char(36)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID professor;

	@Type(type = "org.hibernate.type.UUIDCharType")
	@Column(name = "turma_id", columnDefinition = "char(36)")
	private UUID turmaId;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	private String email;

	private Genero genero;

	@Column(name = "turma_nome")
	private String turmaNome;

	@Column(name = "professor_nome")
	private String professorNome;

}
