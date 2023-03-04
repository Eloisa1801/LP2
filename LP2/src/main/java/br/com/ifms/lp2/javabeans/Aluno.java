package br.com.ifms.lp2.javabeans;

 
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Aluno {
	
	@ApiModelProperty(value="Código do aluno")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAluno;
	@NotBlank(message = "O campo nome não pode ser branco")
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}
	
	
}
