package javabeans;
import java.util.Date;
import java.util.ArrayList;
public class Venda {
    private int idVenda;

    public int getIdVenda() {
        return this.idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
    private ArrayList<Produto> listaProdutos;
    private double valorTotal;
    private String formaPagamento;
    private Date Data;

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

    public Date getData() {
        return this.Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public Venda(ArrayList<Produto> listaProdutos, double valorTotal, String formaPagamento, Date Data) {
        this.listaProdutos = listaProdutos;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.Data = Data;
    }

}
