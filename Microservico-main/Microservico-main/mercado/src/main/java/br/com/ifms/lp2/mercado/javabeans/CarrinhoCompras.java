package br.com.ifms.lp2.mercado.javabeans;
import java.util.ArrayList;
import java.util.HashMap;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
    public void setQuantidadeProdutos(HashMap<Produto,Integer> quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }
    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    private HashMap<Produto, Integer> quantidadeProdutos;
    private ArrayList<Produto> listaProdutos;

    public CarrinhoCompras() {
        this.quantidadeProdutos = new HashMap<Produto, Integer>();
        this.listaProdutos = new ArrayList<Produto>();
    }

    public HashMap<Produto,Integer> getQuantidadeProdutos() {
        return this.quantidadeProdutos;
    }

    public ArrayList<Produto> getListaProdutos() {
        return this.listaProdutos;
    }
    
}
