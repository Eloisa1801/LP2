package br.com.ifms.lp2.mercado.javabeans;

import jakarta.persistence.Entity;

@Entity
public class Produto{
    private int idProtudo;

    public int getIdProtudo() {
        return this.idProtudo;
    }

    public void setIdProtudo(int idProtudo) {
        this.idProtudo = idProtudo;
    }
    private String nomeProtudo;
    private double precoProduto;
    private int estoque;

    public String getNomeProtudo() {
        return this.nomeProtudo;
    }

    public void setNomeProtudo(String nomeProtudo) {
        this.nomeProtudo = nomeProtudo;
    }

    public double getPrecoProduto() {
        return this.precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getEstoque() {
        return this.estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
