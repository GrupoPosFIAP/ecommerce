package br.com.fiap.rest.configuration.api.security.repository;

import br.com.fiap.rest.configuration.api.domain.usuario.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends MongoRepository<Usuario, String> {

    Usuario findByUsername(String username);

}
