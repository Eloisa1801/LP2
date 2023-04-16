package javabeans;
import java.util.ArrayList;
import java.util.HashMap;
public class CarrinhoCompras {
    private int idCarrinho;

    public int getIdCarrinho() {
        return this.idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }
    public void setQuantidadeProdutos(HashMap<Produto,Integer> quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }
    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    private HashMap<Produto, Integer> quantidadeProdutos;
    private ArrayList<Produto> listaProdutos;

    public CarrinhoCompras() {
        this.quantidadeProdutos = new HashMap<Produto, Integer>();
        this.listaProdutos = new ArrayList<Produto>();
    }

    public HashMap<Produto,Integer> getQuantidadeProdutos() {
        return this.quantidadeProdutos;
    }

    public ArrayList<Produto> getListaProdutos() {
        return this.listaProdutos;
    }
    
}
