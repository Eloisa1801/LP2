package br.ifms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifms.demo.javabeans.Caixa;

public interface CaixaRepository extends JpaRepository<Caixa, Long>{
    
}
