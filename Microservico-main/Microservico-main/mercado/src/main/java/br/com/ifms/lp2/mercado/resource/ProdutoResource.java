package br.com.ifms.lp2.mercado.resource;
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

import br.com.ifms.lp2.mercado.javabeans.Produto;
import br.com.ifms.lp2.mercado.repository.ProdutoRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="api/produto")
public class ProdutoResource {
    @Autowired
	ProdutoRepository ProdutoRepository;

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Inserido Produto com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Produto salvarProduto(@RequestBody @Valid Produto produto) {
        return ProdutoRepository.save(produto);
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Produto atulizado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    
    @PutMapping("/atualizar/{id}")
    public void atualizarProduto(@PathVariable(value= "id")long id,@RequestBody Produto novoProduto) {
        Optional<Produto> antigoProduto = ProdutoRepository.findById(id);
        
        if(antigoProduto.get().getIdProduto() > 0) {
            novoProduto.setIdProduto(antigoProduto.get().getIdProduto());
            ProdutoRepository.save(novoProduto);
        }
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
 
    @GetMapping("/listarProduto")
    public List<Produto> listarProduto(){
        return ProdutoRepository.findAll();
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Produto removido com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })

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
