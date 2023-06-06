package br.ifms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifms.demo.javabeans.RelatorioVendas;

public interface RelatorioVendasRepository extends JpaRepository<RelatorioVendas, Long>{
    
}
