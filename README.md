# 📒 Agenda Digital

Este projeto é uma aplicação **Java Spring Boot** que implementa uma **Agenda Digital**, permitindo o cadastro, atualização, consulta e exclusão de clientes e seus contatos.  
O sistema utiliza **PostgreSQL** como banco de dados, **Swagger** para documentação da API, e também possui integração com **HTML, CSS e JavaScript** para interface simples de interação.


## 🚀 Tecnologias utilizadas

<p align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" alt="Spring Boot" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" alt="PostgreSQL" width="50" height="50"/>
  <img src="https://avatars.githubusercontent.com/u/7658037?s=200&v=4" alt="Swagger" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original.svg" alt="HTML5" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original.svg" alt="CSS3" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" alt="JavaScript" width="50" height="50"/>
  
---

## 📌 Funcionalidades

### 👤 Cliente
- Cadastrar cliente com:
  - nome  
  - cpf  
  - endereço  
  - data de nascimento  
- Consultar cliente por **nome** ou **cpf**  
- Listar todos os clientes cadastrados  
- Atualizar dados do cliente (nome, endereço, data de nascimento) através do **ID**  
- Excluir cliente por **ID**  
  - Obs: ao excluir um cliente, seus contatos também são excluídos automaticamente.  

### ☎️ Contato
- Cadastrar contato para um cliente existente, informando:
  - **ID do cliente**  
  - tipo (**E-MAIL** ou **TELEFONE**)  
  - valor (o e-mail ou número de telefone)  
  - observação
- Buscar contatos de um cliente através do **ID do cliente**, retornando também os dados do cliente  
- Atualizar contato (tipo, valor ou observação) através do **ID do contato**  
- Excluir contato por **ID do contato**  
  - Obs: ao excluir um contato, os dados do cliente permanecem na agenda.  



