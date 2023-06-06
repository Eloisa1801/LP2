package br.ifms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifms.demo.javabeans.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
    
}
