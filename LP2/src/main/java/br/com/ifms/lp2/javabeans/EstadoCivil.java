package br.com.ifms.lp2.javabeans;

public enum EstadoCivil {
	
	SOLTEIRO(0),
	CASADO(1);

	public final int code;
	
	private EstadoCivil(int code) {
		this.code = code;
	}
}
