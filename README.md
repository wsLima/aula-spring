# 🎓 Projeto Prático — API Loja de Roupas (Curso Java + Spring Boot)

Este projeto faz parte do **Curso Completo de Java + Spring Boot**, desenvolvido por **Kennedy Lima**. Ele foi criado para ensinar, na prática, como construir uma **API REST completa** utilizando **Spring Boot**, **Java 17** e **PostgreSQL**.

O projeto atende tanto **iniciantes**, que estão dando os primeiros passos com Spring Boot, quanto **alunos intermediários**, que desejam aprimorar boas práticas, padrões de arquitetura e técnicas de desenvolvimento profissional.

---

## 🎯 Objetivos do Projeto

✅ Aprender os fundamentos do desenvolvimento backend com **Java + Spring Boot**  
✅ Construir uma **API REST** do zero, passo a passo  
✅ Entender o funcionamento das **camadas Controller, Service e Repository**  
✅ Usar **JPA/Hibernate** para persistência de dados com PostgreSQL  
✅ Documentar a API com **Swagger (OpenAPI)**  
✅ Aplicar **boas práticas**, **validação**, **tratamento de erros** e **injeção de dependência**

---

## 🧠 O que você vai aprender

### 🧩 Módulo 1 — Fundamentos do Spring Boot
- O que é o Spring Boot e por que ele é usado
- Estrutura de um projeto Spring Boot
- Como rodar sua primeira aplicação

### 🧩 Módulo 2 — Criando uma API REST
- O que é uma API REST e como ela funciona
- Criando endpoints com `@RestController`
- Usando `@GetMapping`, `@PostMapping`, `@PutMapping` e `@DeleteMapping`

### 🧩 Módulo 3 — Persistência com Spring Data JPA
- Configurando o PostgreSQL
- Mapeamento objeto-relacional (JPA + Hibernate)
- Criando repositórios e consultas personalizadas

### 🧩 Módulo 4 — Camadas e Boas Práticas
- Separação de responsabilidades (Controller, Service, Repository)
- Injeção de dependência com `@Autowired` e construtores
- Validação com `@Valid` e tratamento de erros personalizados

### 🧩 Módulo 5 — Avançando na Arquitetura
- Uso de DTOs e mapeamento entre entidades e respostas
- Versionamento da API
- Introdução a autenticação JWT (opcional)

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Springdoc OpenAPI (Swagger UI)**
- **Docker (opcional)**

---

## ⚙️ Configuração do Projeto

Arquivo `application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/loja_roupa
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        format_sql: true
server:
  port: 8080
```

---

## 🐳 Subindo o Banco de Dados com Docker

```yaml
version: '3.8'
services:
  db:
    image: postgres:15
    container_name: loja_roupa_db
    environment:
      POSTGRES_DB: loja_roupa
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
```
Execute:
```bash
docker-compose up -d
```

---

## 🧱 Endpoints Principais

| Método | Endpoint | Descrição |
|--------|-----------|------------|
| **GET** | `/api/produtos` | Lista todos os produtos |
| **GET** | `/api/produtos/{id}` | Busca produto por ID |
| **POST** | `/api/produtos` | Cria novo produto |
| **PUT** | `/api/produtos/{id}` | Atualiza produto existente |
| **DELETE** | `/api/produtos/{id}` | Remove produto |

Endpoints semelhantes estão disponíveis para **/api/categorias**, **/api/clientes** e **/api/pedidos**.

---

## 🚀 Como Executar o Projeto

### 1️⃣ Via Maven
```bash
mvn spring-boot:run
```

### 2️⃣ Ou buildar e rodar o JAR
```bash
mvn clean package
java -jar target/loja-roupa-0.0.1-SNAPSHOT.jar
```

Acesse: [http://localhost:8080](http://localhost:8080)  
Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 💡 Desafios Práticos

> 🧩 Desafios sugeridos para alunos colocarem em prática o que aprenderam.

1. Criar uma rota para buscar produtos por faixa de preço.
2. Implementar paginação e ordenação nos endpoints.
3. Adicionar DTOs para entrada e saída de dados.
4. Criar o relacionamento **Pedido → Itens de Pedido**.
5. Implementar autenticação básica com JWT.
6. Adicionar testes unitários com JUnit e Mockito.

---

## 🧭 Estrutura de Camadas

```
Controller → Service → Repository → Model
```

**Controller:** recebe requisições HTTP e retorna respostas.  
**Service:** contém a lógica de negócio da aplicação.  
**Repository:** conversa com o banco de dados via JPA.  
**Model:** representa as entidades da aplicação (ex: Produto, Categoria, Cliente, Pedido).

---

## 🎓 Dica para Alunos

> "Não basta copiar o código. Entenda cada linha. Brinque com o projeto, quebre, corrija e experimente." — *Kennedy Lima*

---

## 📄 Licença

Este projeto é distribuído sob a licença **MIT**.

---

👨‍💻 **Instrutor:** Kennedy Lima  
📘 *Desenvolvedor Java | Spring Boot | AWS | Clean Architecture | Educador*
