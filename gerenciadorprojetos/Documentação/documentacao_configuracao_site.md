
# 📄 Documentação – Configuração do Site

## Descrição Geral
Este JSON contém as configurações dinâmicas do site da Fábrica de Software.  
Ele permite atualizar conteúdos e imagens sem alterar o código-fonte, facilitando a manutenção e personalização do portal.  

Cada objeto do array representa um item de configuração identificado por um código único (`codigoDaConfguracao`).  

---

## Estrutura do Objeto
| Campo                  | Tipo     | Obrigatório | Descrição |
|------------------------|----------|-------------|-----------|
| **codigoDaConfguracao**| `string` | ✅           | Identificador único da configuração (ex.: `"CONF2883"`). |
| **nomeConfig**         | `string` | ✅           | Nome descritivo da configuração, usado para entender a função do conteúdo. |
| **valorSalvo**         | `string` | ✅           | Valor armazenado para a configuração. Pode ser texto, número ou URL de imagem. |

---

## Configurações Disponíveis

### 1. **Título da Seção "Sobre"**
```json
{
  "codigoDaConfguracao": "CONF2883",
  "nomeConfig": "Titulo-Sobre",
  "valorSalvo": "Sobre a Fabrica"
}
```
- **Função:** Define o título da seção "Sobre" do site.
- **Tipo de valor:** Texto simples.

---

### 2. **Breve Texto - Sobre**
```json
{
  "codigoDaConfguracao": "CONF3212",
  "nomeConfig": "Breve Texto-Sobre",
  "valorSalvo": "A Fábrica de Software é um projeto inovador..."
}
```
- **Função:** Exibe o texto descritivo da seção "Sobre".
- **Tipo de valor:** Texto longo (HTML e quebras de linha devem ser escapados se enviados via JSON).
- **Atenção:** Evitar caracteres de controle não escapados (`\n`, `\r`).

---

### 3. **Imagem - Sobre**
```json
{
  "codigoDaConfguracao": "CONF1181",
  "nomeConfig": "Imagen-Sobre",
  "valorSalvo": "https://cdni.iconscout.com/illustration/free/thumb/free-dados-2103908-1768775.png"
}
```
- **Função:** URL da imagem exibida na seção "Sobre".
- **Tipo de valor:** Link absoluto (HTTPS recomendado).

---

### 4. **Imagem - Formulário de Inscrição de Alunos**
```json
{
  "codigoDaConfguracao": "CONF9869",
  "nomeConfig": "Imagen- Formulario incricao de alunos",
  "valorSalvo": "https://img.freepik.com/vetores-gratis/..."
}
```
- **Função:** Define a imagem exibida no formulário de inscrição de alunos.
- **Tipo de valor:** URL.

---

### 5. **Quantidade de Imagens - Carrossel**
```json
{
  "codigoDaConfguracao": "CONF4710",
  "nomeConfig": "Quantidade de Imagens - Carrossel",
  "valorSalvo": "3"
}
```
- **Função:** Define quantas imagens o carrossel exibe.
- **Tipo de valor:** Número (em formato string).

---

## Boas Práticas
- Sempre manter `codigoDaConfguracao` único para evitar sobrescritas.
- Escapar caracteres especiais no `valorSalvo` quando for texto longo.
- Garantir que URLs sejam acessíveis e seguras (HTTPS).
- Validar valores antes de salvar no banco ou enviar via API.
