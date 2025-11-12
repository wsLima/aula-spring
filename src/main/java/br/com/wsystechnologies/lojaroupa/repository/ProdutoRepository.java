package br.com.wsystechnologies.lojaroupa.repository;

import br.com.wsystechnologies.lojaroupa.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Buscar produtos por nome (ignorando maiúsculas/minúsculas)
    List<Produto> findByNomeContainingIgnoreCase(String nome);

    // Buscar produtos por categoria
    List<Produto> findByCategoriaId(Long categoriaId);
}
