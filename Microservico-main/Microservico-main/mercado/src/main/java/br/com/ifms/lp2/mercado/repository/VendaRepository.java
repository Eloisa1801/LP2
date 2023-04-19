package br.com.ifms.lp2.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.lp2.mercado.javabeans.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
    
}
