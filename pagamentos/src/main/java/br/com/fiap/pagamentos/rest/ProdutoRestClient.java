package br.com.fiap.pagamentos.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ProdutoRestClient {

    @Value("${gateway.host:http://localhost:8082}")
    private String url;

    public Object criarCarrinho(String auth) {
        RestClient restClient = RestClient.create();
        System.out.println("url: " + url);

        return restClient
                .post()
                .uri(url + "/produtos-service/carrinho")
                .header("Authorization", auth)
                .retrieve()
                .body(Object.class);
    }

}
