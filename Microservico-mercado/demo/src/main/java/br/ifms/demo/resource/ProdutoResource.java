package br.ifms.demo.resource;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifms.demo.javabeans.Produto;
import br.ifms.demo.repository.ProdutoRepository;

@RestController
@RequestMapping(value="api/produto")
public class ProdutoResource {
    @Autowired
	ProdutoRepository ProdutoRepository;

    @PostMapping("/inserir")
    public Produto salvarProduto(@RequestBody Produto produto) {
        return ProdutoRepository.save(produto);
    }


    @PutMapping("/atualizar/{id}")
    public void atualizarProduto(@PathVariable(value= "id")long id,@RequestBody Produto novoProduto) {
        Optional<Produto> antigoProduto = ProdutoRepository.findById(id);
        
        if(antigoProduto.get().getIdProduto() > 0) {
            novoProduto.setIdProduto(antigoProduto.get().getIdProduto());
            ProdutoRepository.save(novoProduto);
        }
    }


    @GetMapping("/listarProduto")
    public List<Produto> listarProduto(){
        return ProdutoRepository.findAll();
    }


    @DeleteMapping(value="/remover/{id}")
    public void deleteProduto(@PathVariable("id")long id) throws Exception {
        
        Optional<Produto> produto = ProdutoRepository.findById(id);
        if (produto.get().getIdProduto() > 0) {
            ProdutoRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }
}
