package br.furb.inf.furbot.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.furb.inf.furbot.services.usuario.UsuarioService;

@MappedSuperclass
public abstract class ModelImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "uuid", columnDefinition = "char(36)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	protected UUID id;

	@Column(nullable = true, name = "criado_em")
	private Date criadoEm;

	@Column(nullable = true, name = "atualizado_em")
	private Date atualizadoEm;

	@Column(nullable = true, name = "criado_por")
	private String criadoPor;

	@Column(nullable = true, name = "atualizado_por")
	private String atualizadoPor;

	@PrePersist
	private void onCreate() {
		criadoEm = new Date();
		atualizadoEm = new Date();
		criadoPor = UsuarioService.usuarioLogado();
		atualizadoPor = UsuarioService.usuarioLogado();
	}

	@PreUpdate
	private void onUpdate() {
		atualizadoEm = new Date();
		atualizadoPor = UsuarioService.usuarioLogado();
	}

	public Date getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public Date getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(Date atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
