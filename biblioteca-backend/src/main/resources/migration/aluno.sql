create or replace view aluno as
select 
	u.`uuid`, 
	t.professor,
	t.`uuid` as turma_id,
	u.nome,
	u.data_nascimento,
	u.email,
	u.genero,
	t.nome as turma_nome,
	u2.nome as professor_nome,
	u.criado_em,
	u.atualizado_em,
	u.criado_por,
	u.atualizado_por
from usuario u
inner join turma_aluno ta on (ta.aluno_id = u.`uuid`)
inner join turma t on (t.`uuid` = ta.turma_id)
inner join usuario u2 on (u2.`uuid` = t.professor)
where u.perfil = 0