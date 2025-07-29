
# 📘 Documentação da API - Sistema Acadêmico de Projetos e Alunos

## 🔧 Inicialização do Ambiente

- **Iniciar o servidor:**
  ```bash
  mvn spring-boot:run
  ```

- **Acessar a documentação da API (Swagger):**  
  [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

- **Acessar o console do banco de dados H2:**  
  [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 🧾 Visão Geral da API

Esta API tem como objetivo o gerenciamento de **projetos acadêmicos** e **alunos** vinculados a esses projetos. Ela permite realizar operações de **criação, leitura, atualização e exclusão (CRUD)** para ambos os recursos.

- **Versão da API:** `v0`  
- **Base URL:** `http://localhost:8080`  
- **Formato de Dados:** `JSON`  
- **Especificação:** OpenAPI 3.0.1

---

## 📂 Recursos da API

### 🔹 Projetos

#### `POST /projetos/addprojetos`
- **Descrição:** Cadastra um novo projeto.
- **Corpo da Requisição:** `dtoProjetos`
- **Resposta:** Objeto `dtoProjetos`

#### `GET /projetos/getprojetos`
- **Descrição:** Retorna todos os projetos cadastrados.
- **Resposta:** Lista de objetos `dtoProjetos`

#### `GET /projetos/getprojetos/{id}`
- **Descrição:** Retorna um projeto específico, baseado no `id`.
- **Parâmetro:** `id` (integer)
- **Resposta:** Objeto `dtoProjetos`

#### `PUT /projetos/{id}`
- **Descrição:** Atualiza um projeto existente com base no `id`.
- **Parâmetro:** `id` (integer)  
- **Corpo da Requisição:** `ClassProjetos`  
- **Resposta:** Objeto atualizado

#### `DELETE /projetos/{id}`
- **Descrição:** Remove um projeto existente com base no `id`.
- **Parâmetro:** `id` (integer)  
- **Corpo da Requisição:** `ClassProjetos`  
- **Resposta:** Confirmação ou objeto removido

---

### 🔹 Alunos

#### `POST /alunos/addalunos`
- **Descrição:** Cadastra um novo aluno.
- **Corpo da Requisição:** `dtoAlunosPost`
- **Resposta:** Objeto `dtoAlunosRespost`

#### `GET /alunos/alunos`
- **Descrição:** Retorna todos os alunos cadastrados.
- **Resposta:** Lista de objetos `dtoAlunosRespost`

#### `GET /alunos/aluno/{ra}`
- **Descrição:** Consulta os dados de um aluno com base no seu RA.
- **Parâmetro:** `ra` (string)
- **Resposta:** Objeto `dtoAlunosRespost`

#### `PUT /alunos/aluno/{ra}`
- **Descrição:** Atualiza os dados de um aluno com base no seu RA.
- **Parâmetro:** `ra` (string)  
- **Corpo da Requisição:** `dtoAlunosPost`  
- **Resposta:** Objeto `dtoAlunosRespost`

#### `DELETE /alunos/aluno/{ra}`
- **Descrição:** Remove um aluno com base no seu RA.
- **Parâmetro:** `ra` (string)  
- **Resposta:** Objeto `dtoAlunosRespost`

---

## 📦 Modelos (Schemas)

### 🔸 `dtoProjetos`

| Campo                         | Tipo   | Observações         |
|------------------------------|--------|----------------------|
| identicadorProjetos          | string | Somente leitura      |
| nomeDoProjeto                | string | —                    |
| descricaoDoProjeto           | string | —                    |
| areaDeConhecimento           | string | —                    |
| dataDeInicioDoProjeto        | date   | —                    |
| dataDoFimDoProjeto           | date   | —                    |
| alunosParticipantesDoProjeto| string | —                    |
| linkGit                      | string | —                    |
| linkImage                    | string | —                    |

---

### 🔸 `ClassProjetos`
Mesmo modelo de `dtoProjetos`, com o campo adicional:

- `id` (integer) — utilizado em operações `PUT` e `DELETE`.

---

### 🔸 `dtoAlunosPost`

| Campo                | Tipo   |
|----------------------|--------|
| ra                   | string |
| emailInstitucional   | string |
| nome                 | string |
| curso                | string |
| projetoSelecionado   | string |
| motivoDaInscricao    | string |
| dataInscricao        | date   |

---

### 🔸 `dtoAlunosRespost`

Mesmo que `dtoAlunosPost`, **exceto:**

- **`dataInscricao` não está presente na resposta**

---

## 🛠️ Considerações Técnicas

- Todas as requisições de **criação** e **atualização** devem incluir o cabeçalho:
  ```
  Content-Type: application/json
  ```

- O campo `id` (integer) é obrigatório para atualizar ou remover projetos.

- O campo `ra` (string) é o identificador único de alunos.

---
