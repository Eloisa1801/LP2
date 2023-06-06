package br.ifms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifms.demo.javabeans.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

    
}
