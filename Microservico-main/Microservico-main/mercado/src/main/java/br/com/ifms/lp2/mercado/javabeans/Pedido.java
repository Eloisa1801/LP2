package br.com.ifms.lp2.mercado.javabeans;
import java.util.ArrayList;

import jakarta.persistence.Entity;

@Entity
public class Pedido {
    private int idPedido;

    public int getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    private ArrayList<Produto> listaProdutos;
    private double valorTotal;
    private String formaPagamento;

    public ArrayList<Produto> getListaProdutos() {
        return this.listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

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

    public Pedido(ArrayList<Produto> listaProdutos, double valorTotal, String formaPagamento) {
        this.listaProdutos = listaProdutos;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }
    
}
