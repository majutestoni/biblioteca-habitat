DROP TABLE IF EXISTS `usuario`;

CREATE TABLE IF NOT EXISTS `usuario` (
    `uuid` char(36) NOT NULL,
    `atualizado_em` datetime(6) DEFAULT NULL,
    `criado_em` datetime(6) DEFAULT NULL,
     admin BIT(1) DEFAULT 0,
    `email` varchar(255) DEFAULT NULL,
    `nome` varchar(150) NOT NULL,
    `senha` varchar(255) NOT NULL,
    `usuario` varchar(15) NOT NULL,
    `fone` varchar(15) DEFAULT NULL,
    `instituicao` varchar(255)  DEFAULT NULL,
    `clube` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`uuid`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `endereco` (
    `uuid` char(36) NOT NULL,
    `atualizado_em` datetime(6) DEFAULT NULL,
    `criado_em` datetime(6) DEFAULT NULL,
    `cidade` varchar(150)  DEFAULT NULL,
    `estado_ou_provincia` varchar(255)  DEFAULT NULL,
    `pais` varchar(150)  DEFAULT NULL,
    PRIMARY KEY (`uuid`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `usuario` add column `endereco_id`  char(36) default null,
ADD CONSTRAINT `fk_usuario_endereco`
  FOREIGN KEY (`endereco_id`)
  REFERENCES `endereco` (`uuid`);
