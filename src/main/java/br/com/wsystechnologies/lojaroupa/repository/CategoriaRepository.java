package br.com.wsystechnologies.lojaroupa.repository;

import br.com.wsystechnologies.lojaroupa.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Buscar categoria por nome exato (opcional)
    Categoria findByNome(String nome);
}
