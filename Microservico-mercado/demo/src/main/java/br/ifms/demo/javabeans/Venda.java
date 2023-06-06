package br.ifms.demo.javabeans;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda {
    @ApiModelProperty(value = "Código do venda")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idVenda;

    public int getIdVenda() {
        return this.idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    private double valorTotal;
    private String formaPagamento;
    private Date Data;

    

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

    public Date getData() {
        return this.Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public Venda(double valorTotal, String formaPagamento, Date Data) {

        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.Data = Data;
    }

}
