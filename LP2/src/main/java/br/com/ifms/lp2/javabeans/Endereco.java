package br.com.ifms.lp2.javabeans;

import jakarta.persistence.Id;

public class Endereco {

	@Id
	private long idEndereco;
	private String nomeRua;
	
	public long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(long idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	public String getNomeRua() {
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}
}
