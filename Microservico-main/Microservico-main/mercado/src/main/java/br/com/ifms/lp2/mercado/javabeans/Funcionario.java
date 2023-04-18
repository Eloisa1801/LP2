package br.com.ifms.lp2.mercado.javabeans;

import jakarta.persistence.Entity;

@Entity
public class Funcionario {
    private int idFunc;

    public int getIdFunc() {
        return this.idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }
    private String nomeFunc;
    private String enderecoFunc;
    private String telefoneFunc;
    private String cargoFunc;

    public String getNomeFunc() {
        return this.nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getEnderecoFunc() {
        return this.enderecoFunc;
    }

    public void setEnderecoFunc(String enderecoFunc) {
        this.enderecoFunc = enderecoFunc;
    }

    public String getTelefoneFunc() {
        return this.telefoneFunc;
    }

    public void setTelefoneFunc(String telefoneFunc) {
        this.telefoneFunc = telefoneFunc;
    }

    public String getCargoFunc() {
        return this.cargoFunc;
    }

    public void setCargoFunc(String cargoFunc) {
        this.cargoFunc = cargoFunc;
    }
}
