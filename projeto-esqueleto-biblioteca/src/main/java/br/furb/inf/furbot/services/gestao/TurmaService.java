package br.furb.inf.furbot.services.gestao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.furb.inf.furbot.dtos.AlteraSenhaDto;
import br.furb.inf.furbot.models.gestao.Turma;
import br.furb.inf.furbot.models.gestao.TurmaAluno;
import br.furb.inf.furbot.repositories.gestao.TurmaRepository;
import br.furb.inf.furbot.services.ServiceImpl;
import br.furb.inf.furbot.services.usuario.AlunoService;
import br.furb.inf.furbot.services.usuario.UsuarioService;

@Service
public class TurmaService extends ServiceImpl<Turma> {

	@Autowired
	private TurmaRepository repository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private EscolaService escolaService;

	@Autowired
	private TurmaAlunoService turmaAlunoService;

	@Autowired
	private AlunoService alunoService;

	@Override
	public JpaRepository<Turma, UUID> getRepository() {
		return repository;
	}

	@Override
	public void validator(Turma entity) {
	}

	@Override
	public Turma create(Turma entity) {
		entity.setProfessorId(UUID.fromString(usuarioService.buscarUsuarioLogado().getId().toString()));
		entity.setCodigo(repository.obterProximoId());
		return super.create(entity);
	}

	@Override
	public Turma retrieve(UUID id) {
		Turma turma = super.get(id);
		turma.setEscola(escolaService.get(turma.getEscolaId()));
		System.out.println(turma.getEscola());
		return turma;
	}

	public void alteraSenha(String newPassword, UUID turmaId) {
		List<TurmaAluno> turmaAlunos = turmaAlunoService.obterAlunosPorTurma(turmaId);
		for (TurmaAluno turmaAluno : turmaAlunos) {
			alunoService.alterarSenha(new AlteraSenhaDto(turmaAluno.getAluno(), newPassword));
		}
	}
}
