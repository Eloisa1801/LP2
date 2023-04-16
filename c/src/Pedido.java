import java.util.ArrayList;
public class Pedido {
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
