package br.com.fiap.cadastro;

import br.com.fiap.rest.configuration.api.config.RestfulAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableDiscoveryClient
@ImportAutoConfiguration(classes = RestfulAutoConfiguration.class)
public class CadastroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroServiceApplication.class, args);
	}

}
