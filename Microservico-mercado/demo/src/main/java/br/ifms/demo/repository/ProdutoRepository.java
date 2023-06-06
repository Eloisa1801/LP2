package br.ifms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifms.demo.javabeans.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
