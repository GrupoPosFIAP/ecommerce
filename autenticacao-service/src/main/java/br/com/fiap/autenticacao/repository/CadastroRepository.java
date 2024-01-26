package br.com.fiap.autenticacao.repository;

import br.com.fiap.autenticacao.domain.usuario.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends MongoRepository<Usuario, String> {

    Usuario findByUsername(String username);

}
