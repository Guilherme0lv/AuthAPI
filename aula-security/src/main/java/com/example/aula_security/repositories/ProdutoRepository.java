package com.example.aula_security.repositories;

import com.example.aula_security.domain.product.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
