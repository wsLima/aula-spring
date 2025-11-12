package br.com.wsystechnologies.lojaroupa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "Informe um e-mail válido")
    @NotBlank(message = "O e-mail é obrigatório")
    @Column(unique = true, nullable = false)
    private String email;

    private String telefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude // evita recursão no método toString()
    private List<Pedido> pedidos;
}
