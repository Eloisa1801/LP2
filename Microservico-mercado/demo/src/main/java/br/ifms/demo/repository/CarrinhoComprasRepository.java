package br.ifms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifms.demo.javabeans.CarrinhoCompras;

public interface CarrinhoComprasRepository extends JpaRepository<CarrinhoCompras, Long>{

}
