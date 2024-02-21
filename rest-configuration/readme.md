# Biblioteca rest-configuration

## Ferramentas embarcadas
* MongoDB - MongoTemplate configurado
* SpringSecurity - Módulo de segurança
* ExceptionHandler - Tratamento de exceções
* Spring AOP - Programação orientada a aspectos

## Como usar
Para utilizar a Biblioteca, basta fazer o download do código fonte, 
instalar em seu repositório .m2 com o comando abaixo, inserir a dependência
no pom.xml do seu microsserviço e adicionar a anotação
@ImportAutoConfiguration(classes = RestfulAutoConfiguration.class)
na classe principal do projeto.

Comando para instalar a biblioteca:
```bash
$ mvn clean install
```

Dependência:
```xml
<dependency>
    <groupId>br.com.fiap</groupId>
    <artifactId>rest-configuration</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## Spring Security
Como citado acima, essa biblioteca já possui as configurações do Spring Security
para o projeto em questão, para incluir autenticação em um endpoint,
basta anotar o método do controller que representa o endpoint com a annotation
@AuthenticationRequired e configurar a chave api.security.token.secret no
arquivo application.properties do microsserviço.

## Exception Handlers
As exceções serão tratadas automaticamente pela biblioteca