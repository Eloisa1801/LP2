
package br.com.ifms.lp2.mercado.javabeans;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fornecedor {
    /**
     *
     */
    @ApiModelProperty(value = "Código do fornecedor")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFornecedor;

    public int getIdFornecedor() {
        return this.idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
    private String nomeFornecedor;
    public Fornecedor(String nomeFornecedor, String enderecoFornecedor, String telefoneFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
        this.enderecoFornecedor = enderecoFornecedor;
        this.telefoneFornecedor = telefoneFornecedor;
    }

    private String enderecoFornecedor;
    private String telefoneFornecedor;

    public String getNomeFornecedor() {
        return this.nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getEnderecoFornecedor() {
        return this.enderecoFornecedor;
    }

    public void setEnderecoFornecedor(String enderecoFornecedor) {
        this.enderecoFornecedor = enderecoFornecedor;
    }

    public String getTelefoneFornecedor() {
        return this.telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public String getId() {
        return null;
    }

    public void setId(Long id) {
    }
}
