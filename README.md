# API Ecommerce
## Bem-vindo à API Ecommerce!
## Aqui você encontrará informações sobre como utilizar os microserviços/endpoints para registar venda de usuários em um site de comércio eletrônico.


## Sobre
```
- API E-Commerce permite o gerenciamento de carrinho de compras, usuários (administradores e consumidores), itens de
 compras e pagamentos em um site.

- Disponibilizamos endpoints para cinco categorias: usuários, produtos, carrinho de compras e pagamentos nos quais 
aplicamos a mesma abstração, onde os dados serão recebidos e a seguir validados em seu respectivo microserviço. Com essa
premissa criamos uma interface Dto para ser implementada nas cinco requisições; Essa interface possui um método 
toDomain() para obter a classe de domínio referente a cada requisição, onde poderemos aplicar as regras de negócios 
específicas para cada fluxo. 
```


## Tecnologias adotadas
```
- Java 17: programação server-side
- SpringBoot: criação API Restful e microsserviços
    - Spring Cloud
    - Spring Security
    - Spring JDBC
    - Spring JPA
    - Spring Web
- Eureka Discovery: Server e Gateway para registro e descoberta de microsserviços
- Lombok
- Docker: Gerar container do SGBD PostgresSQL/MongoDB 
- PostgresSQL: Instanciado o SGBD via Docker
- MongoDB: Instanciado o SGBD noSQL via Docker
- DBeaver: Front-End para o SGBD
- MongoDB Compass: Front-End para o SGBD
- PostMan: Utilizado nos testes dos endpoints
```


## Como executar a aplicação

1. Via docker-compose
```
- Clonar o projeto
- Acessar a pasta raíz
- Executar o comando 'docker-compose up' no terminal
- Testar via postman, utilizando as collections da pasta "collections-postman"
```

2. Via linha de comando com maven:
```
- Clonar o repositório https://github.com/GrupoPosFIAP/ecommerce
- Iniciar o SGBD PostgresSQL/MongoDB e criar database ecommerce
  Obs: Atualizar no application.properties usuário e senha 
- Confirmar Entrar na pasta raiz do projeto e executar o comando "mvn spring-boot:run"
- Testar via Postman, utilizando as collections da pasta "collections-postman"
```


## Endpoints
Os endpoints estão sendo disponibilizados como collections dentro da pasta "collections-postman", localizada na raiz do projeto.

## Dificuldades e Aprendizados
```
* O grupo não alinhou a finalização dos módulos da pós-graduação para liberar tempo adequado para o desenvolvimento do projeto.
* Horários de reunião do grupo divergiu entre alguns participantes.
* Certa dificuldade em acrescentar os microserviços ao projeto.
* Como utilizar bibliotecas para reduzir código repetitivo 
```