package br.com.fiap.carrinho.repository;

import br.com.fiap.carrinho.domain.Carrinho;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarrinhoRepository extends MongoRepository<Carrinho, String> {

    Optional<Object> findByUserId(String id);
}
