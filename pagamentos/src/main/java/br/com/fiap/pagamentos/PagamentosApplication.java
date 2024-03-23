package br.com.fiap.pagamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiap.rest.configuration.api.config.RestfulAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@ImportAutoConfiguration(classes = RestfulAutoConfiguration.class)
@EnableDiscoveryClient
public class PagamentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagamentosApplication.class, args);
	}

}
