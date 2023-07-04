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

### Tabela Materias
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `UUID` | **Obrigatório**. id do material |
| `titulo` | `varchar` | **Obrigatório**. |
| `ano` | `date` | **Obrigatório**. |
| `autores` | `varchar` | **Obrigatório**., array de autores|
| `descricao` | `varchar` |   |
| `palavras` | `varchar` | **Obrigatório**. palavras pré definidas|
| `tipo` | `varchar` | **Obrigatório**. tipo do arquivo |
| `tema` | `varchar` | tema do material |
| `link` | `varchar` |  **Obrigatório**. link do material caso seja online |
| `idioma` | `varchar` |**Obrigatório**. |
| `avalicao` | `int` | likes recebidos |
| `publicado` | `bool` | default false |
| `tipo_material` | `varchar` | **Obrigatório**. default outros |
| `criado_em` | `date` | **Obrigatório**. |
| `atualizado_em` | `date` | **Obrigatório**. |
| `atualizado_por` | `UUID` | **Obrigatório**. |
| `criado_por` | `UUID` | **Obrigatório**. |

### Tabela Autores
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `UUID` | **Obrigatório**. id do usuario |
| `atualizado_em` | `datetime` | **Obrigatório**.  |
| `criado_em` | `datetime` | **Obrigatório**. |
| `atualizado_por` | `varchar` | **Obrigatório**.  |
| `criado_por` | `varchar` | **Obrigatório**. |
| `nome` | `varchar` | **Obrigatório**. |

### Tabela de Palavras chaves
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `UUID` | **Obrigatório**. id do usuario |
| `atualizado_em` | `datetime` | **Obrigatório**.  |
| `criado_em` | `datetime` | **Obrigatório**. |
| `atualizado_por` | `varchar` | **Obrigatório**.  |
| `criado_por` | `varchar` | **Obrigatório**. |
| `palavra` | `varchar` | **Obrigatório**. |

### Tabela de Temas
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `UUID` | **Obrigatório**. id do usuario |
| `atualizado_em` | `datetime` | **Obrigatório**.  |
| `criado_em` | `datetime` | **Obrigatório**. |
| `atualizado_por` | `varchar` | **Obrigatório**.  |
| `criado_por` | `varchar` | **Obrigatório**. |
| `tema` | `varchar` | **Obrigatório**. |


