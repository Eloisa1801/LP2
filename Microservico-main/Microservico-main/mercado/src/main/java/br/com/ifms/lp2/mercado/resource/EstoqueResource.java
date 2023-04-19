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

import br.com.ifms.lp2.mercado.javabeans.Estoque;
import br.com.ifms.lp2.mercado.repository.EstoqueRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="api/estoque")
public class EstoqueResource {
    @Autowired
	EstoqueRepository EstoqueRepository;

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Inserido Estoque com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Estoque salvarEstoque(@RequestBody @Valid Estoque estoque) {
        return EstoqueRepository.save(estoque);
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Estoque atulizado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    
    @PutMapping("/atualizar/{id}")
    public void atualizarEstoque(@PathVariable(value= "id")long id,@RequestBody Estoque novoEstoque) {
        Optional<Estoque> antigoEstoque = EstoqueRepository.findById(id);
        
        if(antigoEstoque.get().getIdEstoque() > 0) {
            novoEstoque.setIdEstoque(antigoEstoque.get().getIdEstoque());
            EstoqueRepository.save(novoEstoque);
        }
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
 
    @GetMapping("/listarEstoque")
    public List<Estoque> listarEstoque(){
        return EstoqueRepository.findAll();
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Estoque removido com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })

    @DeleteMapping(value="/remover/{id}")
    public void deleteEstoque(@PathVariable("id")long id) throws Exception {
        
        Optional<Estoque> estoque = EstoqueRepository.findById(id);
        if (estoque.get().getIdEstoque() > 0) {
            EstoqueRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }

}
