Aqui está um exemplo de README para o seu projeto de sistema hospitalar com Spring Boot:

---

# Sistema Hospitalar - Spring Boot API

Este é um sistema de gestão hospitalar simples desenvolvido utilizando **Spring Boot**. Ele inclui funcionalidades para gerenciar **Pacientes**, **Médicos**, **Consultas**, **Diagnósticos**, **Exames**, e **Medicações**. O projeto segue uma arquitetura baseada em serviços RESTful, facilitando a integração e manutenção.

## Funcionalidades
O sistema oferece as seguintes funcionalidades:

- **Pacientes**: Cadastro, atualização, remoção e consulta de informações dos pacientes, incluindo CPF e histórico médico.
- **Médicos**: Cadastro, atualização, remoção e consulta de médicos, utilizando CRM como identificador.
- **Consultas**: Registro de consultas, vinculadas a médicos e pacientes.
- **Diagnósticos**: Registro e consulta de diagnósticos realizados em consultas.
- **Exames**: Cadastro e gerenciamento de exames solicitados nas consultas.
- **Medicações**: Gerenciamento das medicações prescritas durante as consultas.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database (pode ser substituído por MySQL, PostgreSQL, etc.)**
- **Lombok** para reduzir o código boilerplate
- **Jakarta Persistence API (JPA)**

## Pré-requisitos

Certifique-se de ter instalado:

- [Java JDK 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/)
- Um IDE de sua escolha (IntelliJ, Eclipse, VSCode)

## Executando o Projeto Localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/sistema-hospitalar.git
   ```
   
2. Navegue até o diretório do projeto:
   ```bash
   cd sistema-hospitalar
   ```

3. Compile o projeto com o Maven:
   ```bash
   mvn clean install
   ```

4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

5. Acesse a aplicação através do endereço:
   ```
   http://localhost:8080
   ```

### Estrutura do Projeto

```
src/
 └── main/
     ├── java/
     │   └── com.app.hospital/
     │       ├── controller/         # Controladores REST
     │       ├── entity/             # Entidades JPA
     │       ├── repository/         # Repositórios JPA
     │       └── service/            # Lógica de negócio
     └── resources/
         ├── application.properties  # Configurações da aplicação
         └── data.sql                # (opcional) Dados iniciais
```

### Endpoints Principais

#### Paciente
- **GET /pacientes** - Listar todos os pacientes
- **GET /pacientes/{cpf}** - Buscar paciente por CPF
- **POST /pacientes** - Criar um novo paciente
- **PUT /pacientes/{cpf}** - Atualizar as informações de um paciente
- **DELETE /pacientes/{cpf}** - Deletar um paciente

#### Médico
- **GET /medicos** - Listar todos os médicos
- **GET /medicos/{crm}** - Buscar médico por CRM
- **POST /medicos** - Criar um novo médico
- **PUT /medicos/{crm}** - Atualizar as informações de um médico
- **DELETE /medicos/{crm}** - Deletar um médico

#### Consulta
- **GET /consultas** - Listar todas as consultas
- **GET /consultas/{id}** - Buscar consulta por ID
- **POST /consultas** - Criar uma nova consulta
- **DELETE /consultas/{id}** - Deletar uma consulta

#### Diagnóstico
- **GET /diagnosticos** - Listar todos os diagnósticos
- **POST /diagnosticos** - Criar um novo diagnóstico

#### Exame
- **GET /exames** - Listar todos os exames
- **POST /exames** - Criar um novo exame

#### Medicação
- **GET /medicacoes** - Listar todas as medicações
- **POST /medicacoes** - Criar uma nova medicação

### Exemplo de Requisições

#### Criando um Paciente
```bash
POST /pacientes
Content-Type: application/json

{
  "cpf": "12345678901",
  "nome": "João Silva",
  "historicoMedico": "Histórico de alergias."
}
```

#### Atualizando um Médico
```bash
PUT /medicos/{crm}
Content-Type: application/json

{
  "nome": "Dr. José da Silva",
  "especialidade": "Cardiologia",
  "salario": 15000.00
}
```

#### Criando uma Consulta
```bash
POST /consultas
Content-Type: application/json

{
  "dataHora": "2024-10-22T10:00:00",
  "medico": {
    "crm": "12345"
  },
  "paciente": {
    "cpf": "12345678901"
  }
}
```

### Configurações do Banco de Dados

Por padrão, o projeto usa o banco de dados H2 em memória. Se você quiser usar um banco de dados diferente, edite as configurações no arquivo `application.properties`:

```properties
# H2 Database
spring.datasource.url=jdbc:h2:mem:db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# H2 Console (desenvolvimento)
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```


