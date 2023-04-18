package br.com.ifms.lp2.mercado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.ifms.lp2.mercado.javabeans.Fornecedor;
import jakarta.validation.Valid;


@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

    List<Fornecedor> findAll();

    Optional<Fornecedor> findById(long id);

    void deleteById(long id);

    Fornecedor save(@Valid Fornecedor fornecedor);
    
}
