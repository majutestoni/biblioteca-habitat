package br.furb.inf.furbot.models.usuario;

import br.furb.inf.furbot.enuns.Perfil;
import br.furb.inf.furbot.models.ModelImpl;
import br.furb.inf.furbot.services.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "administradores")
public class Administrador {
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

    @PrePersist
    private void onCreate() {
        criadoEm = new Date();
        atualizadoEm = new Date();
    }

    @PreUpdate
    private void onUpdate() {
        atualizadoEm = new Date();
    }

    @NotNull(message = "Nome não pode ser núlo")
    @NotEmpty(message = "Nome não pode ser vazio")
    @Size(min = 4, max = 150, message = "Nome deve ser entre 4 e 150 dígitos")
    private String nome;

    @NotNull(message = "Usuário não pode ser núlo")
    @NotEmpty(message = "Usuário não pode ser vazio")
    @Size(min = 4, max = 15, message = "Nome de usuário deve ser entre 4 e 15 dígitos")
    private String usuario;

    private String senha;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private Boolean alteraSenha;

    private String fone;

}
