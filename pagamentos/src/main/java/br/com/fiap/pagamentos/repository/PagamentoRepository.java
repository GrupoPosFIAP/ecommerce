package br.com.fiap.pagamentos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.pagamentos.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, UUID> {
}
