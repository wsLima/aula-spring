package br.com.wsystechnologies.lojaroupa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @NotNull
    @Positive
    private Integer quantidade;

    private BigDecimal subtotal;

    @PrePersist
    @PreUpdate
    public void calcularSubtotal() {
        if (produto != null && produto.getPreco() != null && quantidade != null) {
            this.subtotal = produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
        }
    }
}
