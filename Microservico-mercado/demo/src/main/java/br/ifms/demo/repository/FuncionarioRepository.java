package br.ifms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifms.demo.javabeans.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
}
