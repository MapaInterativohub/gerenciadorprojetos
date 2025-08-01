# Documentação da API - Sistema de Projetos e Alunos

Esta documentação descreve os endpoints disponíveis na API, suas funcionalidades, os modelos utilizados e os dados esperados.

## Informações Gerais

- **Versão:** v0
- **Base URL:** `http://localhost:8080`

## Endpoints Disponíveis

### Projetos

#### `POST /projetos/addprojetos`

- **Descrição:** Adiciona um novo projeto.
- **Request Body:** `dtoProjetos`
- **Response:** `dtoProjetos`

#### `GET /projetos/getprojetos`

- **Descrição:** Lista todos os projetos.
- **Response:** Lista de `dtoProjetos`

#### `GET /projetos/getprojetos/{id}`

- **Descrição:** Retorna um projeto pelo ID.
- **Parâmetro:** `id` (integer)
- **Response:** `dtoProjetos`

#### `PUT /projetos/{id}`

- **Descrição:** Atualiza um projeto existente.
- **Parâmetro:** `id` (integer)
- **Request Body:** `ClassProjetos`
- **Response:** Objeto genérico

#### `DELETE /projetos/{id}`

- **Descrição:** Remove um projeto pelo ID.
- **Parâmetro:** `id` (integer)
- **Request Body:** `ClassProjetos`
- **Response:** Objeto genérico

### Alunos

#### `POST /alunos/addalunos`

- **Descrição:** Adiciona um novo aluno.
- **Request Body:** `dtoAlunosPost`
- **Response:** `dtoAlunosRespost`

#### `GET /alunos/alunos`

- **Descrição:** Lista todos os alunos.
- **Response:** Lista de `dtoAlunosRespost`

#### `GET /alunos/aluno/{ra}`

- **Descrição:** Busca aluno pelo RA.
- **Parâmetro:** `ra` (string)
- **Response:** `dtoAlunosRespost`

#### `PUT /alunos/aluno/{ra}`

- **Descrição:** Atualiza dados de um aluno.
- **Request Body:** `dtoAlunosPost`
- **Response:** `dtoAlunosRespost`

#### `DELETE /alunos/aluno/{ra}`

- **Descrição:** Remove um aluno pelo RA.
- **Response:** `dtoAlunosRespost`

### Configuração do Site

#### `GET /config/config`

- **Descrição:** Lista configurações do site.
- **Response:** Lista de `dtoClassConfgSiteResp`

#### `POST /config/config`

- **Descrição:** Cria uma nova configuração.
- **Request Body:** `dtoClassConfigSitePost`
- **Response:** `dtoClassConfgSiteResp`

#### `PUT /config/config/{codigoDaConfguracao}`

- **Descrição:** Atualiza uma configuração.
- **Parâmetro:** `codigoDaConfguracao` (string)
- **Request Body:** `dtoClassConfigSitePut`
- **Response:** `dtoClassConfgSiteResp`

#### `DELETE /config/config/{codigoDaConfguracao}`

- **Descrição:** Remove uma configuração.
- **Parâmetro:** `codigoDaConfguracao` (string)
- **Response:** `dtoClassConfgSiteResp`

### Carrossel

#### `POST /carrocel/addimagen`

- **Descrição:** Adiciona imagem ao carrossel.
- **Request Body:** `dtoConfgCarrocelPost`
- **Response:** `dtoConfigCarrocelResp`

#### `GET /carrocel/carrocel_imagens`

- **Descrição:** Lista imagens do carrossel.
- **Response:** Lista de `dtoConfigCarrocelResp`

#### `PUT /carrocel/path/{codigoImagem}`

- **Descrição:** Atualiza uma imagem.
- **Parâmetro:** `codigoImagem` (string)
- **Request Body:** `dtoConfgCarrocelPost`
- **Response:** `dtoConfgCarrocelPost`

#### `DELETE /carrocel/path/{codigoImagem}`

- **Descrição:** Remove uma imagem.
- **Response:** `dtoConfgCarrocelPost`

### Cursos

#### `POST /curso/curso`

- **Descrição:** Adiciona um novo curso.
- **Request Body:** `dtoClassCursoPost`
- **Response:** `dtoClassCursoResp`

#### `GET /curso/curso`

- **Descrição:** Lista os cursos.
- **Response:** Lista de `dtoClassCursoResp`

#### `GET /curso/curso/{codigoDoCurso}`

- **Descrição:** Detalha um curso.
- **Response:** `dtoClassCursoResp`

#### `DELETE /curso/curso/{codigoDoCurso}`

- **Descrição:** Remove um curso.
- **Response:** `dtoClassCursoResp`

### Imagens dos Cursos

#### `POST /imagemcurso/imagemcurso`

- **Descrição:** Adiciona uma imagem ao curso.
- **Request Body:** `dtoClassImageCursoPost`
- **Response:** `dtoClassImageCursoResp`

#### `GET /imagemcurso/imagemcurso`

- **Descrição:** Lista todas as imagens dos cursos.
- **Response:** Lista de `dtoClassImageCursoResp`

#### `GET /imagemcurso/imagemcurso/{codigoImagem}`

- **Descrição:** Detalha uma imagem.
- **Parâmetro:** `codigoImagem` (string)
- **Response:** `dtoClassImageCursoResp`

#### `DELETE /imagemcurso/imagemcurso/{codigoImagem}`

- **Descrição:** Remove uma imagem.
- **Response:** `dtoClassImageCursoResp`

## Modelos (Schemas)

Cada endpoint utiliza modelos definidos dentro da seção `components.schemas`, incluindo:

- `ClassProjetos`
- `dtoProjetos`
- `dtoAlunosPost`
- `dtoAlunosRespost`
- `dtoClassCursoPost`
- `dtoClassCursoResp`
- `dtoConfgCarrocelPost`
- `dtoConfigCarrocelResp`
- `dtoClassImageCursoPost`
- `dtoClassImageCursoResp`
- `dtoClassConfigSitePost`
- `dtoClassConfigSitePut`
- `dtoClassConfgSiteResp`

Cada um descreve os atributos esperados para operações de entrada e de saída.

---

**Nota:** Esta documentação foi gerada com base em um arquivo OpenAPI JSON fornecido em duas partes.