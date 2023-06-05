package br.ifms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.lp2.mercado.javabeans.RelatorioVendas;

public interface RelatorioVendasRepository extends JpaRepository<RelatorioVendas, Long>{
    
}
