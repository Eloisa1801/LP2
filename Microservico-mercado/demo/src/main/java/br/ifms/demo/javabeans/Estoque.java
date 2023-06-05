package br.ifms.demo.javabeans;
import java.util.Date;
import java.util.HashMap;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estoque {
    @ApiModelProperty(value = "Código do estoque")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private HashMap<Produto, Integer> produtos;
    private HashMap<Produto, Date> dataValidade;
    private int idEstoque;

  
    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public HashMap<Produto,Integer> getProdutos() {
        return this.produtos;
    }

    public HashMap<Produto,Date> getDataValidade() {
        return this.dataValidade;
    }

    public Estoque() {
        this.produtos = new HashMap<Produto, Integer>();
        this.dataValidade = new HashMap<Produto, Date>();
    }
    
}
