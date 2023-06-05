package br.ifms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.lp2.mercado.javabeans.CarrinhoCompras;

public interface CarrinhoComprasRepository extends JpaRepository<CarrinhoCompras, Long>{

}
