package br.ifms.demo.javabeans;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Cliente {
    @ApiModelProperty(value = "Código do cliente")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    private String nomeCliente;
    private String enderecoCliente;
    private String telefoneCliente;    

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoCliente() {
        return this.enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getTelefoneCliente() {
        return this.telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
}
