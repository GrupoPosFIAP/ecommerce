package br.com.fiap.autenticacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AutenticacaoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutenticacaoServiceApplication.class, args);
    }

}
