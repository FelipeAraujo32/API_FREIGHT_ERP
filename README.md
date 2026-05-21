# API Freight ERP 🚚

Projeto backend em **Java + Spring Boot** para cálculo de frete com arquitetura orientada a eventos.

> Objetivo: demonstrar capacidade de construir APIs escaláveis, com regras de negócio, mensageria assíncrona e boas práticas de engenharia.

---

## 🎯 Visão de Produto

Este sistema expõe endpoints para:
- Cadastro e gestão de fretes;
- Cálculo de valor de frete com base na distância;
- Publicação e consumo de eventos com RabbitMQ para desacoplamento entre serviços.

A proposta é simular uma base para um ERP logístico, permitindo evolução para cenários reais de alto volume.

---

## 🧠 Destaques Técnicos (para recrutadores)

- **Spring Boot** para construção da API REST;
- **Spring Data JPA** para persistência;
- **Validação e tratamento global de exceções** para respostas previsíveis;
- **Padrão Strategy/Selector** no cálculo de frete por faixa de distância;
- **RabbitMQ (producer + consumer)** para comunicação assíncrona orientada a eventos;
- **Separação por camadas** (controller/service/repository/dto/model/config).

---

## 🏗️ Arquitetura em alto nível

```text
[Client/API Consumer]
        |
        v
[Spring REST API]
        |
        +--> [Service Layer + Freight Calculator Selector]
        |              |
        |              +--> [Strategies por faixa de distância]
        |
        +--> [JPA Repository]
        |
        +--> [RabbitMQ Producer] ---> [Exchange/Queue] ---> [RabbitMQ Consumer]
```

---

## 📂 Estrutura principal

- `freight-api/src/main/java/com/freight/freight_api/Services`
  - Regras de negócio e cálculo de frete;
- `freight-api/src/main/java/com/freight/freight_api/config/rabbitmqconfig`
  - Configuração de exchange, queue e binding;
- `freight-api/src/main/java/com/freight/freight_api/messaging`
  - Eventos de entrada/saída (consumer/producer);
- `freight-api/src/main/java/com/freight/freight_api/repository`
  - Repositórios de persistência;
- `freight-api/src/main/java/com/freight/freight_api/exceptions`
  - Tratamento padronizado de exceções.

---

## ▶️ Como executar localmente

### Pré-requisitos
- Java 17+
- Maven 3.9+
- RabbitMQ (local ou container)

### Rodando
```bash
cd freight-api
./mvnw spring-boot:run
```

### Testes
```bash
cd freight-api
./mvnw test
```

---

## 💼 Pitch de entrevista (resumo rápido)

"Desenvolvi uma API de frete em Spring Boot com cálculo por estratégia e integração assíncrona via RabbitMQ. Estruturei o projeto em camadas, tratei validações/exceções de forma global e deixei a base preparada para escalar com baixo acoplamento."

---

## 🚀 Próximos passos sugeridos

- Adicionar autenticação/autorização (JWT + Spring Security);
- Cobertura de testes de unidade e integração por módulo;
- Containerização com Docker + Docker Compose;
- Observabilidade (actuator, métricas Prometheus, tracing);
- Pipeline CI com lint, testes e quality gates.

---

## 👤 Autor

Projeto desenvolvido por **João Vitor** como portfólio técnico de backend para oportunidades em engenharia de software.
