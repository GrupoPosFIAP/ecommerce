package br.com.fiap.produtos.controller;

import br.com.fiap.rest.configuration.api.security.annotations.AuthenticationRequired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/produtos")
//@ComponentScan(basePackages = {"br.com.fiap.rest.configuration.api"})
public class ProdutosController {

    @GetMapping
    @AuthenticationRequired
    public String consultar(@RequestHeader(name = "Authorization") String token) {

        RestClient restClient = RestClient.create();

//        restClient.post()
//                .uri("http://localhost:8082/autenticacao-service/authentication/validate")
//                .contentType(MediaType.APPLICATION_JSON)
//                .header("token", token)
//                .retrieve()
//                .onStatus(HttpStatusCode::isError, ((request, response) -> {
//                    throw new InvalidAuthenticationException();
//                }))
//                .toBodilessEntity();

        throw new RuntimeException();
//
//        return "Consulta de produtos";
    }
}
