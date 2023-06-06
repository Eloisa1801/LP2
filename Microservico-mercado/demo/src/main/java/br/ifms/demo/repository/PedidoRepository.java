package br.ifms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifms.demo.javabeans.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
