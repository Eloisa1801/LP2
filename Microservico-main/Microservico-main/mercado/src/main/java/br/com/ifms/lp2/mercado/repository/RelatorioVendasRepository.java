package br.com.ifms.lp2.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.lp2.mercado.javabeans.RelatorioVendas;

public interface RelatorioVendasRepository extends JpaRepository<RelatorioVendas, Long>{
    
}
