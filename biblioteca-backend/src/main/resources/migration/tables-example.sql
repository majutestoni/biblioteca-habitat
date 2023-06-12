CREATE TABLE IF NOT EXISTS `acesso` (
    `uuid` char(36) NOT NULL,
    `atualizado_em` datetime(6) DEFAULT NULL,
    `criado_em` datetime(6) DEFAULT NULL,
    `autorizado` bit(1) DEFAULT NULL,
    `date` datetime(6) DEFAULT NULL,
    `endpoint` varchar(255) DEFAULT NULL,
    `usuario` varchar(255) DEFAULT NULL,
    `atualizado_por` varchar(255) DEFAULT NULL,
    `criado_por` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`uuid`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `aluno` (
    `uuid` CHAR(36) NOT NULL COLLATE 'latin1_swedish_ci',
    `professor` CHAR(36) NULL COLLATE 'latin1_swedish_ci',
    `turma_id` CHAR(36) NOT NULL COLLATE 'latin1_swedish_ci',
    `nome` VARCHAR(150) NOT NULL COLLATE 'latin1_swedish_ci',
    `data_nascimento` DATETIME(6) NULL,
    `email` VARCHAR(255) NULL COLLATE 'latin1_swedish_ci',
    `genero` INT(11) NULL,
    `turma_nome` VARCHAR(255) NULL COLLATE 'latin1_swedish_ci',
    `professor_nome` VARCHAR(150) NOT NULL COLLATE 'latin1_swedish_ci',
    `criado_em` DATETIME(6) NULL,
    `atualizado_em` DATETIME(6) NULL,
    `criado_por` VARCHAR(255) NULL COLLATE 'latin1_swedish_ci',
    `atualizado_por` VARCHAR(255) NULL COLLATE 'latin1_swedish_ci'
) ENGINE=MyISAM;

-- Copiando estrutura para tabela furbot.escola
CREATE TABLE IF NOT EXISTS `escola` (
    `uuid` char(36) NOT NULL,
    `atualizado_em` datetime(6) DEFAULT NULL,
    `criado_em` datetime(6) DEFAULT NULL,
    `nome` varchar(255) NOT NULL,
    `atualizado_por` varchar(255) DEFAULT NULL,
    `criado_por` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE IF NOT EXISTS `turma` (
    `uuid` char(36) NOT NULL,
    `atualizado_em` datetime(6) DEFAULT NULL,
    `criado_em` datetime(6) DEFAULT NULL,
    `ano` varchar(255) NOT NULL,
    `ano_letivo` int(11) NOT NULL,
    `escola_id` varchar(255) NOT NULL,
    `nome` varchar(255) DEFAULT NULL,
    `professor` char(36) DEFAULT NULL,
    `turno` int(11) NOT NULL,
    `atualizado_por` varchar(255) DEFAULT NULL,
    `criado_por` varchar(255) DEFAULT NULL,
    `codigo` int(11) DEFAULT NULL,
    PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `turma_aluno` (
    `uuid` char(36) NOT NULL,
    `atualizado_em` datetime(6) DEFAULT NULL,
    `criado_em` datetime(6) DEFAULT NULL,
    `aluno_id` char(36) NOT NULL,
    `turma_id` char(36) NOT NULL,
    `atualizado_por` varchar(255) DEFAULT NULL,
    `criado_por` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `usuario` (
    `uuid` char(36) NOT NULL,
    `atualizado_em` datetime(6) DEFAULT NULL,
    `criado_em` datetime(6) DEFAULT NULL,
    `altera_senha` bit(1) DEFAULT NULL,
    `data_nascimento` datetime(6) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `genero` int(11) DEFAULT NULL,
    `nome` varchar(150) NOT NULL,
    `perfil` int(11) DEFAULT NULL,
    `senha` varchar(255) NOT NULL,
    `usuario` varchar(15) NOT NULL,
    `atualizado_por` varchar(255) DEFAULT NULL,
    `criado_por` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `aluno`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `aluno` AS select `u`.`uuid` AS `uuid`,`t`.`professor` AS `professor`,`t`.`uuid` AS `turma_id`,`u`.`nome` AS `nome`,`u`.`data_nascimento` AS `data_nascimento`,`u`.`email` AS `email`,`u`.`genero` AS `genero`,`t`.`nome` AS `turma_nome`,`u2`.`nome` AS `professor_nome`,`u`.`criado_em` AS `criado_em`,`u`.`atualizado_em` AS `atualizado_em`,`u`.`criado_por` AS `criado_por`,`u`.`atualizado_por` AS `atualizado_por` from (((`usuario` `u` join `turma_aluno` `ta` on(`ta`.`aluno_id` = `u`.`uuid`)) join `turma` `t` on(`t`.`uuid` = `ta`.`turma_id`)) join `usuario` `u2` on(`u2`.`uuid` = `t`.`professor`)) where `u`.`perfil` = 0;
