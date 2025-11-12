package br.com.wsystechnologies.lojaroupa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Builder.Default
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Builder.Default
    private BigDecimal total = BigDecimal.ZERO;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens;

    @PrePersist
    @PreUpdate
    public void calcularTotal() {
        if (itens != null && !itens.isEmpty()) {
            this.total = itens.stream()
                    .filter(item -> item.getSubtotal() != null)
                    .map(ItemPedido::getSubtotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }
}
