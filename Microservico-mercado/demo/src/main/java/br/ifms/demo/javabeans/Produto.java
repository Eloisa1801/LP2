package br.ifms.demo.javabeans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto{
    @ApiModelProperty(value = "Código do produto")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idProduto;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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
