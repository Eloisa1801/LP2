package br.ifms.demo.javabeans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarrinhoCompras {
    @ApiModelProperty(value = "Código do carrinho de compras")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idCarrinho;

    public int getIdCarrinho() {
        return this.idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }
    
    
}
