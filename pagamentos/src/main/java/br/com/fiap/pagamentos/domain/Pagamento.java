package br.com.fiap.pagamentos.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.fiap.pagamentos.enumeration.FormaPagamento;
import br.com.fiap.pagamentos.enumeration.StatusPagamento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pagamentos")
@EqualsAndHashCode(of = "id")
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String cartId;

    private StatusPagamento statusPagamento;

    private FormaPagamento formaPagamento;

    private BigDecimal value;

    private LocalDateTime timestamp;

    private String pagadorNome;

    private String pagadorDoc;
}
