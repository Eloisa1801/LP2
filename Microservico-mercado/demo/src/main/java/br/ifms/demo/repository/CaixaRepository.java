package br.ifms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.lp2.mercado.javabeans.Caixa;

public interface CaixaRepository extends JpaRepository<Caixa, Long>{
    
}
