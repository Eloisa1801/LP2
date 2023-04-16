package javabeans;
import java.util.Date;
import java.util.HashMap;
public class Estoque {
    private HashMap<Produto, Integer> produtos;
    private HashMap<Produto, Date> dataValidade;

    public HashMap<Produto,Integer> getProdutos() {
        return this.produtos;
    }

    public HashMap<Produto,Date> getDataValidade() {
        return this.dataValidade;
    }

    public Estoque() {
        this.produtos = new HashMap<Produto, Integer>();
        this.dataValidade = new HashMap<Produto, Date>();
    }
    
}
