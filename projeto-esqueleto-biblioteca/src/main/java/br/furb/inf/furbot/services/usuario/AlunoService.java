package br.furb.inf.furbot.services.usuario;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.furb.inf.furbot.dtos.AlteraSenhaDto;
import br.furb.inf.furbot.exceptions.NotAuthorizationException;
import br.furb.inf.furbot.models.usuario.Aluno;
import br.furb.inf.furbot.models.usuario.Usuario;
import br.furb.inf.furbot.repositories.usuario.AlunoRepository;
import br.furb.inf.furbot.services.ServiceImpl;

@Service
public class AlunoService extends ServiceImpl<Aluno> {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder bCript;

	@Override
	public JpaRepository<Aluno, UUID> getRepository() {
		return alunoRepository;
	}

	@Override
	public void validator(Aluno entity) {

	}
	
	public Long obterTotalAlunos(UUID turmaId) {
		return alunoRepository.contarAlunos(turmaId);
	}

	@Transactional
	public void alterarSenha(AlteraSenhaDto alteraSenhaDto) {
		Aluno aluno = get(alteraSenhaDto.getId());
		if (!aluno.getProfessor().equals(usuarioService.buscarUsuarioLogado().getId())) {
			throw new NotAuthorizationException("Seu usuário não pode trocar a senha de outro usuário!");
		}
		Usuario usuario = usuarioService.get(alteraSenhaDto.getId());
		usuario.setSenha(bCript.encode(alteraSenhaDto.getSenha()));
		usuarioService.update(alteraSenhaDto.getId(), usuario);
	}

}
