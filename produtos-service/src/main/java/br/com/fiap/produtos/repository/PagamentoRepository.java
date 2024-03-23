package br.com.fiap.produtos.repository;


import br.com.fiap.produtos.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, UUID>, JpaSpecificationExecutor<Pagamento> {
    
}
