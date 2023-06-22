# Back-end
- Utilizado Java 8
- Utilizado SpringBoot 2.4.3
- [Projeto base](https://github.com/LDTTFURB/furbot-servidor)
- Utilizado MariaDB

### Tabela usuario
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `UUID` | **Obrigatório**. id do usuario |
| `atualizado_em` | `datetime` | **Obrigatório**.  |
| `criado_em` | `datetime` | **Obrigatório**. |
| `email` | `varchar` | **Obrigatório**. tamanho 255|
| `nome` | `varchar` | **Obrigatório**. tamanho 150|
| `senha` | `varchar` | **Obrigatório**. tamanho 255|
| `usuario` | `varchar` | **Obrigatório**. tamanho 15|
| `clube` | `varchar` | tamanho 255|
| `fone` | `varchar` | tamanho 255|
| `instituicao` | `varchar` | tamanho 255|
| `admin` | `bool` | default false|
| `endereco_id` | `UUID` | **Obrigatório**. id do endereço|

### Tabela endereço
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `UUID` | **Obrigatório**. id do usuario |
| `atualizado_em` | `datetime` | **Obrigatório**.  |
| `criado_em` | `datetime` | **Obrigatório**. |
| `cidade` | `varchar` | **Obrigatório**. tamanho 150|
| `estado_ou_provincia` | `varchar` | **Obrigatório**. tamanho 255|
| `pais` | `varchar` | **Obrigatório**. tamanho 255|