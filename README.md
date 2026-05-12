# Notification Service - Mensageria Assíncrona com Java + RabbitMQ

Projeto desenvolvido para estudo e prática de arquitetura assíncrona utilizando Java, Spring Boot e RabbitMQ.

O objetivo principal deste projeto foi compreender na prática como sistemas distribuídos trabalham com:
- mensageria;
- comunicação assíncrona;
- retries;
- Dead Letter Queue (DLQ);
- ACK automático;
- resiliência;
- tolerância a falhas.

---

# Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- RabbitMQ
- Spring AMQP
- Docker
- Docker Compose
- Maven
- Lombok

---

# Conceitos Estudados

Durante o desenvolvimento deste projeto foram aplicados conceitos importantes de backend moderno:

✅ Producer  
✅ Consumer  
✅ Exchange  
✅ Queue  
✅ Routing Key  
✅ Retry automático  
✅ ACK automático  
✅ Dead Letter Queue (DLQ)  
✅ Conversão JSON ↔ DTO  
✅ Processamento assíncrono  
✅ Resiliência em mensageria  
✅ Tratamento de falhas  
✅ Observabilidade básica  

---

# Arquitetura do Projeto

```text
POST /email
      ↓
Controller
      ↓
Service
      ↓
Producer
      ↓
RabbitMQ Exchange
      ↓
Queue
      ↓
Consumer
      ↓
Processamento
```

---

# Fluxo com Tratamento de Falha (DLQ)

```text
Producer
   ↓
Queue Principal
   ↓
Consumer
   ↓
Erro?
   ↓
Retry Automático
   ↓
Falhou novamente?
   ↓
Dead Letter Queue (DLQ)
```

---

# Estrutura do Projeto

```text
src/main/java/com/skillbase/notification_service

├── config
├── consumer
├── controller
├── dto
├── producer
├── service
├── exception
├── repository
├── entity
└── utils
```

---

# Funcionalidades

## Envio Assíncrono de Mensagens

A API recebe requisições HTTP e publica mensagens no RabbitMQ sem bloquear o processamento da aplicação.

---

## Consumer Assíncrono

O consumer escuta automaticamente a fila e processa as mensagens em background.

---

## Retry Automático

Mensagens que falham são reprocessadas automaticamente.

---

## Dead Letter Queue (DLQ)

Após exceder o limite de tentativas, mensagens inválidas são enviadas para uma fila de erro específica.

---

# Como Executar o Projeto

## 1. Clonar repositório

```bash
git clone https://github.com/SEU-USUARIO/notification-service.git
```

---

## 2. Subir RabbitMQ

```bash
docker compose up -d
```

---

## 3. Executar aplicação

```bash
./mvnw spring-boot:run
```

---

# Painel RabbitMQ

Acesse:

```text
http://localhost:15672
```

Usuário:

```text
admin
```

Senha:

```text
admin
```

---

# Endpoint da API

## POST /email

### Exemplo de Request

```json
{
  "nome": "Robson",
  "email": "robson@email.com",
  "assunto": "Teste RabbitMQ",
  "mensagem": "Aprendendo mensageria"
}
```

---

# Exemplo de Fluxo

1. API recebe requisição
2. Producer publica mensagem
3. RabbitMQ recebe mensagem
4. Consumer processa mensagem
5. ACK automático remove mensagem da fila

---

# Exemplo de Erro Simulado

Caso o e-mail contenha:

```text
erro@email.com
```

o consumer lança exceção propositalmente para demonstrar:

- retry automático;
- tratamento de falha;
- envio para DLQ.

---

# Aprendizados Obtidos

Durante este projeto foi possível compreender na prática:

- funcionamento interno do RabbitMQ;
- diferenças entre processamento síncrono e assíncrono;
- importância de desacoplamento entre serviços;
- estratégias de retry;
- tolerância a falhas;
- fluxo de ACK/NACK;
- observabilidade em filas;
- arquitetura orientada a eventos.


# Autor

Robson Calheira

Backend Developer em evolução focado em:
- Java
- Spring Boot
- Arquitetura Backend
- Sistemas Distribuídos
- Performance
- Mensageria
