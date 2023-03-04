package br.com.ifms.lp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.lp2.javabeans.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
}
