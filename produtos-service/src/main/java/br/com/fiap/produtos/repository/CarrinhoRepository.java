package br.com.fiap.produtos.repository;


import br.com.fiap.produtos.domain.Carrinho;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarrinhoRepository extends MongoRepository<Carrinho, String> {
    Optional<Object> findByUserId(String id);
}
