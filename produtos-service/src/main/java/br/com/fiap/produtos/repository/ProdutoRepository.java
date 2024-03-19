package br.com.fiap.produtos.repository;

import br.com.fiap.produtos.domain.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {

    Produto findByProduto(String nome);

}