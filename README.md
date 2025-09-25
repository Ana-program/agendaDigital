# 📒 Agenda Digital

Este projeto é uma aplicação **Java Spring Boot** que implementa uma **Agenda Digital**, permitindo o cadastro, atualização, consulta e exclusão de clientes e seus contatos.  
O sistema utiliza **PostgreSQL** como banco de dados, **Swagger** para documentação da API, e também possui integração com **HTML, CSS e JavaScript** para interface simples de interação.

---
## 🚀 Tecnologias utilizadas

<p align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" alt="Spring Boot" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" alt="PostgreSQL" width="50" height="50"/>
  <img src="https://avatars.githubusercontent.com/u/7658037?s=200&v=4" alt="Swagger" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original.svg" alt="HTML5" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original.svg" alt="CSS3" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" alt="JavaScript" width="50" height="50"/>


## 📦 Dependências

As principais dependências utilizadas neste projeto são:

- **Spring Boot Starter Data JPA** → persistência de dados com JPA/Hibernate
- **Spring Boot Starter Web** → criação de APIs RESTful
- **Springdoc OpenAPI (Swagger UI)** → documentação da API
- **Swagger Annotations** → anotações para documentação da API
- **Hibernate Validator** → validações de dados com Jakarta Bean Validation
- **PostgreSQL Driver** → integração com banco de dados PostgreSQL
- **Lombok** → redução de boilerplate (getters, setters, construtores etc.)
- **Spring Boot Starter Test** → dependência para testes unitários e de integração


## ⚙️ Configurações 

### Porta de Aplicação e Banco de Dados

No arquivo `application.properties` coloque:

server.port=8080

spring.datasource.url=jdbc:postgresql://localhost:5433/AGENDA
spring.datasource.username=seu_usuario
spring.datasource.password=_sua_senha


spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.springframework.security=DEBUG

spring.profiles.active=default

---

## 📝 Instruções de Uso da Aplicação AgendaDigital

### 1. Executar o Banco de Dados
Antes de iniciar a aplicação, certifique-se de que o seu banco de dados esteja rodando e pronto para conexão com o projeto.

---

### 2. Rodar o Projeto Java Spring Boot
1. Abra o projeto no **IntelliJ IDEA** (ou na IDE de sua preferência).
2. Execute a aplicação clicando em **Run** na classe principal (`@SpringBootApplication`).
3. Aguarde até que a aplicação esteja totalmente carregada.

---

### 3. Acessar a Aplicação no Navegador

#### Tela de Cadastro e Consulta de Clientes
**Link:** [http://localhost:8080/index.html](http://localhost:8080/index.html)

- **Cadastro de cliente:**  
  Preencha obrigatoriamente os campos:
  - Nome
  - CPF
  - Endereço
  - Data de nascimento

- **Busca de cliente:**  
  É possível buscar pelo **nome** ou **CPF**.

- **Retornar todos os clientes:**  
  Clique no botão **"Retornar todos os clientes"** para listar todos os registros.

---

#### Tela de Atualização e Exclusão de Clientes
**Link:** [http://localhost:8080/atualiza.html](http://localhost:8080/atualiza.html)

- **Alteração de dados do cliente:**  
  É possível alterar **nome**, **endereço** ou **data de nascimento**, mas é necessário informar:
  - ID do cliente
  - Campo que deseja alterar e o novo valor

- **Exclusão de cliente:**  
  É possível deletar o cliente utilizando o **ID do cliente**.  
  ⚠️ Ao remover um cliente, **todos os contatos associados a ele também serão removidos**.

---

#### Tela de Cadastro e Gestão de Contatos
**Link:** [http://localhost:8080/cadastroContato.html](http://localhost:8080/cadastroContato.html)

- **Cadastro de contato:**  
  Campos obrigatórios:
  - ID do cliente
  - Tipo (**EMAIL** ou **TELEFONE**)
  - Valor (email ou número de telefone)
  - Observação (opcional)

- **Busca de contato:**  
  Realize a busca pelo **ID do cliente**.

- **Atualização de contato:**  
  É possível alterar **tipo**, **valor** ou **observação**, mas é necessário informar:
  - ID do contato
  - Campo que deseja alterar e o novo valor

- **Exclusão de contato:**  
  É possível deletar o contato usando o **ID do contato**.  
  ⚠️ Remover apenas os contatos **não afeta os dados do cliente**.




