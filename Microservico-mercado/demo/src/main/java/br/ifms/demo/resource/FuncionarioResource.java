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

import br.com.ifms.lp2.mercado.javabeans.Funcionario;
import br.com.ifms.lp2.mercado.repository.FuncionarioRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="api/funcionario")
public class FuncionarioResource {
    @Autowired
	FuncionarioRepository FuncionarioRepository;

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Inserido Funcionario com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Funcionario salvarFuncionario(@RequestBody @Valid Funcionario funcionario) {
        return FuncionarioRepository.save(funcionario);
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Funcionario atulizado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    
    @PutMapping("/atualizar/{id}")
    public void atualizarFuncionario(@PathVariable(value= "id")long id,@RequestBody Funcionario novoFuncionario) {
        Optional<Funcionario> antigoFuncionario = FuncionarioRepository.findById(id);
        
        if(antigoFuncionario.get().getIdFunc() > 0) {
            novoFuncionario.setIdFunc(antigoFuncionario.get().getIdFunc());
            FuncionarioRepository.save(novoFuncionario);
        }
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
 
    @GetMapping("/listarFuncionario")
    public List<Funcionario> listarFuncionario(){
        return FuncionarioRepository.findAll();
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Funcionario removido com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })

    @DeleteMapping(value="/remover/{id}")
    public void deleteFuncionario(@PathVariable("id")long id) throws Exception {
        
        Optional<Funcionario> funcionario = FuncionarioRepository.findById(id);
        if (funcionario.get().getIdFunc() > 0) {
            FuncionarioRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }
}
