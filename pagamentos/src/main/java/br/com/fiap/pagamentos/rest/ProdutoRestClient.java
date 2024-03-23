package br.com.fiap.pagamentos.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ProdutoRestClient {

    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFhYTEyMyIsImV4cCI6MTcxMTE3MTk4OX0.fsBnltdCRCMuEMR2KQ9Xp77mhIYVFZo3PnBpM4Yzs0M";
    private String url = "http://localhost:8081";

    public Object criarCarrinho() {
        RestClient restClient = RestClient.create();

        return restClient
                .post()
                .uri(url + "/carrinho")
                .header("Authorization", "Bearer " + TOKEN)
                .retrieve()
                .body(Object.class);
    }

}
