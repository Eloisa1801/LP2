package br.ifms.demo.javabeans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Caixa {
    @ApiModelProperty(value = "Código do caixa")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idCaixa;

    public int getIdCaixa() {
        return this.idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }
    private double caixa;

    public double getCaixa() {
        return this.caixa;
    }

    public void setCaixa(double caixa) {
        this.caixa = caixa;
    }
}
