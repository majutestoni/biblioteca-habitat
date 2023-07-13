DROP TABLE IF EXISTS `autor`;

CREATE TABLE IF NOT EXISTS `autor` (
    `uuid` char(36) NOT NULL,
    `atualizado_em` datetime(6) DEFAULT NULL,
    `criado_em` datetime(6) DEFAULT NULL,
    `atualizado_por` char(36) DEFAULT NULL,
    `criado_por` char(36) DEFAULT NULL,
    `nome` varchar(150) NOT NULL,
    PRIMARY KEY (`uuid`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `tema`;

CREATE TABLE IF NOT EXISTS `tema` (
    `uuid` char(36) NOT NULL,
    `atualizado_em` datetime(6) DEFAULT NULL,
    `criado_em` datetime(6) DEFAULT NULL,
    `atualizado_por` char(36) DEFAULT NULL,
    `criado_por` char(36) DEFAULT NULL,
    `tema` varchar(150) NOT NULL,
    PRIMARY KEY (`uuid`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `palavra_chave`;

CREATE TABLE IF NOT EXISTS `palavra_chave` (
    `uuid` char(36) NOT NULL,
    `atualizado_em` datetime(6) DEFAULT NULL,
    `criado_em` datetime(6) DEFAULT NULL,
    `atualizado_por` char(36) DEFAULT NULL,
    `criado_por` char(36) DEFAULT NULL,
    `palavra` varchar(150) NOT NULL,
    PRIMARY KEY (`uuid`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `material`;

CREATE TABLE IF NOT EXISTS material (
    uuid char(36) NOT NULL,
    atualizado_em datetime(6) DEFAULT NULL,
    criado_em datetime(6) DEFAULT NULL,
    atualizado_por char(36) DEFAULT NULL,
    criado_por char(36) DEFAULT NULL,
    titulo varchar(150) NOT NULL,
    ano YEAR(4) DEFAULT NULL,
    descricao varchar(255) NOT NULL,
    tipo varchar(60) NOT NULL,
    link varchar(255) NOT NULL,
    idioma varchar(150) NOT NULL,
    avaliacao INT(11) NOT NULL,
    publicado bit(1) DEFAULT FALSE,
    editar bit(1) DEFAULT FALSE,
    PRIMARY KEY (`uuid`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;