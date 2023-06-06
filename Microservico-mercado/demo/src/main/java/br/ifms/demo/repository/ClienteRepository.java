package br.ifms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifms.demo.javabeans.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
