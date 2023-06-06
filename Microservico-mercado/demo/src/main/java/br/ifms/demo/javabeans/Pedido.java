package br.ifms.demo.javabeans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
    @ApiModelProperty(value = "Código do pedido")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idPedido;

    public int getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    private double valorTotal;
    private String formaPagamento;


    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return this.formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Pedido( double valorTotal, String formaPagamento) {

        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }
    
}
