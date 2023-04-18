package br.com.ifms.lp2.mercado.javabeans;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
