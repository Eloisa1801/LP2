package br.com.ifms.lp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.lp2.javabeans.Aluno;
import br.com.ifms.lp2.javabeans.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
