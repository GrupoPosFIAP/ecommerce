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
- SpringBoot: criação API Restfull e microsserviços
- Docker: Gerar container do SGBD PostgresSQL/MongoDB 
- PostgresSQL: Instanciado o SGBD via Docker
- MongoDB: Instanciado o SGBD noSQL via Docker
- DBeaver: Front-End para o SGBD
- MongoDB Compass: Front-End para o SGBD
- PostMan: Utilizado nos testes dos endpoints
- Swagger: Modelagem, documentação e teste dos endpoints
```


## Como executar a aplicação
```
- Clonar o repositório https://github.com/GrupoPosFIAP/ecommerce
- Iniciar o SGBD PostgresSQL/MongoDB e criar database ecommerce
  Obs: Atualizar no application.properties usuário e senha 
- Confirmar Entrar na pasta raiz do projeto e executar o comando "mvn spring-boot:run"
- Testar via Postman/Swagger no link http://localhost:8080/swagger-ui/index.html#/
```


## Endpoints
* [Cadastro](#Cadastro)
* [Autenticação](#Autenticação)
* [Produtos](#Produtos)
* [Carrinho](#Carrinho)
* [Pagamentos](#Pagamentos)


## Cadastro

* Descrição dos Campos

Campo   | Descrição
--------- | ------
username | O nickname do usuário.
passoword | A senha do usuário.


### Cadastro de usuários:
* POST http://localhost:8082/cadastro-service/cadastro

Request Body:
```
{
    "username": "usuario",
    "password": "senha"
}
```
### Consulta de usuários:

* GET http://localhost:8082/cadastro-service/cadastro

Essa rota traz uma lista de usuários.


## Autenticação

* Descrição dos Campos

Campo   | Descrição
--------- | ------
username | O nickname do usuário.
passoword | A senha do usuário.

### Autenticação de usuários:

* POST http://localhost:8082/autenticacao-service/authentication

Request Body:
```
{
    "username": "usuario",
    "password": "senha"
}
```
Response Body: Status 200 - OK
```
{
    "token": "{bearerToken}"
}
```

## Produtos

* Descrição dos Campos

Campo   | Descrição
--------- | ------
nome | O nome do produto.
descricao | Descrição do produto.
quantidadeEstoque | A quantidade em estoque do produto.
valor | O valor do produto.
imagens | A imagem do produto.


* Rota POST http://localhost:8080/produto

Essa rota faz cadastro dos produtos.

* Rota GET http://localhost:8080/produto/1

Essa rota faz a consulta do produto pelo id.

* Rota GET http://localhost:8080/produto

Essa rota faz uma lista dos produtos.

* Rota PUT http://localhost:8080/produto/1

Essa rota faz alteração dos produtos.

* Rota DELETE http://localhost:8080/produto/1

Essa rota apaga o produto.


## Carrinho

* Descrição dos Campos

Campo   | Descrição ->->->->-> CONFIRMAR CAMPOS <-<-<-<-<-<-
--------- | ------
nome | O nome da carrinho. Deve ser uma string.
paisOrigem  | País de origem do carrinho. Deve ser uma string.
cpf | O número do CPF do carrinho. Deve ser uma string.
passaporte | Número do passaporte do carrinho. Deve ser uma string.
dataDeNascimento | Data de nascimento. Deve ser uma data válida.
enderecoPaisOrigem | Endereço do carrinho. Deve ser uma string.
telefone | Telefone do carrinho. Deve ser uma string.
email | E-mail válido do carrinho. Deve ser uma string.


* Rota GET http://localhost:8080/carrinho

Essa rota faz a consulta do usuário'

* Rota GET http://localhost:8080/carrinho/adicionar

Essa rota adiciona produto ao carrinho.

* Rota DELETE http://localhost:8080/carrinho/editar

Essa rota remove produto do carrinho.

* Rota GET http://localhost:8080/carrinho/finalizar

Essa rota finaliza a compra.


## Pagamento

* Descrição dos Campos

Campo   | Descrição
--------- | ------
statusPagamento | O estado do pagamento.
formaPagamento | A forma de pagamento.
value | O valor do pagamento.
timestamp | Data/hora exatos do pagamento.
pagadorNome | O nome do usário pagador.
pagadorDoc | O documento autenticado do pagamento.


* Rota POST http://localhost:8080/pagamentos

Essa rota faz o pagamento.

* Rota GET http://localhost:8080/pagamentos/search

Essa rota faz a filtragem do pagamento.


## Dificuldades e Aprendizados
```
* O grupo não alinhou a finalização dos módulos da pós-graduação para liberar tempo adequado para o desenvolvimento do projeto.
* Horários de reunião do grupo divergiu entre alguns participantes.
* Certa dificuldade em acrescentar os microserviços ao projeto.
* Certa dificuldade no entendimento do enunciado do projeto. Exemplo: O relacionamento de algumas entidades.
```