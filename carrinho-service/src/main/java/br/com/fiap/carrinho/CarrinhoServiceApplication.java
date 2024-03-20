package br.com.fiap.carrinho;

import br.com.fiap.rest.configuration.api.config.RestfulAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@ImportAutoConfiguration(classes = RestfulAutoConfiguration.class)
public class CarrinhoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarrinhoServiceApplication.class, args);
    }

}
