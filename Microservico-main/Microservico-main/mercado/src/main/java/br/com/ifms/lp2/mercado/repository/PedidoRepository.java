package br.com.ifms.lp2.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.lp2.mercado.javabeans.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
