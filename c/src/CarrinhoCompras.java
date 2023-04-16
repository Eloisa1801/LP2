import java.util.ArrayList;
import java.util.HashMap;
public class CarrinhoCompras {
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
