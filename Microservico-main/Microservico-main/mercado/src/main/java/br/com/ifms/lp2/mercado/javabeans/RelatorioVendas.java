package br.com.ifms.lp2.mercado.javabeans;
import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class RelatorioVendas {
    private int indRelatorioVenda;

    public int getIndRelatorioVenda() {
        return this.indRelatorioVenda;
    }

    public void setIndRelatorioVenda(int indRelatorioVenda) {
        this.indRelatorioVenda = indRelatorioVenda;
    }
    private Date dataInicio;
    private Date dataFim;
    private double valorTotalVendas;

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public double getValorTotalVendas() {
        return this.valorTotalVendas;
    }

    public void setValorTotalVendas(double valorTotalVendas) {
        this.valorTotalVendas = valorTotalVendas;
    }

    public RelatorioVendas(Date dataInicio, Date dataFim, double valorTotalVendas) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorTotalVendas = valorTotalVendas;
    }
    
}
