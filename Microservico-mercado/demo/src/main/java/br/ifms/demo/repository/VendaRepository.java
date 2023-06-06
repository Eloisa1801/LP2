package br.ifms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifms.demo.javabeans.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
    
}
