
# Biblioteca Back

### Tabela Materias
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `UUID` | **Obrigatório**. id do material |
| `id_usuario` | `UUID` | **Obrigatório**. id de quem publicou |
| `titulo` | `varchar` | **Obrigatório**. |
| `ano` | `date` | **Obrigatório**. |
| `autores` | `varchar` | **Obrigatório**., array de autores|
| `descricao` | `varchar` |   |
| `palavras` | `varchar` | **Obrigatório**. palavras pré definidas|
| `tipo` | `varchar` | **Obrigatório**. tipo do arquivo |
| `tema` | `varchar` | tema do material |
| `link` | `varchar` | link do material caso seja online |
| `idioma` | `varchar` |**Obrigatório**. |
| `avalicao` | `int` | likes recebidos |
| `publicado` | `bool` | default false |
| `criado_em` | `date` | **Obrigatório**. |
| `atualizado_em` | `date` | **Obrigatório**. |
| `atualizado_por` | `UUID` | **Obrigatório**. |

 - Ainda necessario inserir campo imagem e gerar default da mesma
 - Conseguimos gerar enum do tema?
 - tipo será ume enum