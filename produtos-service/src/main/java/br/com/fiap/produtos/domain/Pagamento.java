package br.com.fiap.produtos.domain;


import br.com.fiap.produtos.enums.FormaPagamento;
import br.com.fiap.produtos.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

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
