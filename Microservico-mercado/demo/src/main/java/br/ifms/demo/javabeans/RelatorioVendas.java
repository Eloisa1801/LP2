package br.ifms.demo.javabeans;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RelatorioVendas {
    @ApiModelProperty(value = "Código do relatorio de venda")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idRelatorioVendas;

    public int getIdRelatorioVendas() {
        return idRelatorioVendas;
    }

    public void setIdRelatorioVendas(int idRelatorioVendas) {
        this.idRelatorioVendas = idRelatorioVendas;
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
