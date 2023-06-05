drop table `acesso`;
drop table `aluno`;
drop table `escola`;
drop table `turma`;
drop table `turma_aluno`;

CREATE TABLE IF NOT EXISTS `admins` (
    `uuid` char(36) NOT NULL,
    `atualizado_em` datetime(6) DEFAULT NULL,
    `criado_em` datetime(6) DEFAULT NULL,
    `name` varchar(150) NOT NULL,
    `nickname` varchar(15) NOT NULL,
    `email` varchar(255) NOT NULL,
    `phone` varchar(15) NOT NULL,

    PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `collaborators` (
    `uuid` char(36) NOT NULL,
    `atualizado_em` datetime(6) DEFAULT NULL,
    `criado_em` datetime(6) DEFAULT NULL,
    `name` varchar(150) NOT NULL,
    `nickname` varchar(15) NOT NULL,
    `email` varchar(255) NOT NULL,
    `phone` varchar(15) NOT NULL,
    `institution` varchar(150) NOT NULL,
    `address_id` char(36) NOT NULL,
    PRIMARY KEY (`uuid`),
      CONSTRAINT address_id FOREIGN KEY (address_id) REFERENCES address (uuid)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `address` (
    `uuid` char(36) NOT NULL,
    `atualizado_em` datetime(6) DEFAULT NULL,
    `criado_em` datetime(6) DEFAULT NULL,
    `city` varchar(150) NOT NULL,
    `country` varchar(150) NOT NULL,
    `region` varchar(150) NOT NULL,

    PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;