package br.com.fiap.pagamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiap.rest.configuration.api.config.RestfulAutoConfiguration;

@SpringBootApplication
@ImportAutoConfiguration(classes = RestfulAutoConfiguration.class)
public class PagamentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagamentosApplication.class, args);
	}

}
