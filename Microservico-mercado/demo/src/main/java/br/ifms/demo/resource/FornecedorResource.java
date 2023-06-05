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

import br.com.ifms.lp2.mercado.javabeans.Fornecedor;
import br.com.ifms.lp2.mercado.repository.FornecedorRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="api/fornecedor")

public class FornecedorResource {

    @Autowired
	FornecedorRepository FornecedorRepository;

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Inserido fornecedor com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Fornecedor salvarFornecedor(@RequestBody @Valid Fornecedor fornecedor) {
        return FornecedorRepository.save(fornecedor);
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do fornecedor atulizado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    
    @PutMapping("/atualizar/{id}")
    public void atualizarFornecedor(@PathVariable(value= "id")long id,@RequestBody Fornecedor novoFornecedor) {
        Optional<Fornecedor> antigoFornecedor = FornecedorRepository.findById(id);
        
        if(antigoFornecedor.get().getIdFornecedor() > 0) {
            novoFornecedor.setIdFornecedor(antigoFornecedor.get().getIdFornecedor());
            FornecedorRepository.save(novoFornecedor);
        }
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
 
    @GetMapping("/listarFornecedor")
    public List<Fornecedor> listarFornecedor(){
        return FornecedorRepository.findAll();
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do fornecedor removido com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })

    @DeleteMapping(value="/remover/{id}")
    public void deleteFornecedor(@PathVariable("id")long id) throws Exception {
        
        Optional<Fornecedor> fornecedor = FornecedorRepository.findById(id);
        if (fornecedor.get().getIdFornecedor() > 0) {
            FornecedorRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }


}
