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

import br.com.ifms.lp2.mercado.javabeans.Caixa;
import br.com.ifms.lp2.mercado.repository.CaixaRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="api/caixa")
public class CaixaResource {
    @Autowired
	CaixaRepository CaixaRepository;


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Inserido Caixa com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Caixa salvarCaixa(@RequestBody @Valid Caixa caixa) {
        return CaixaRepository.save(caixa);
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Caixa atulizado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    
    @PutMapping("/atualizar/{id}")
    public void atualizarCaixa(@PathVariable(value= "id")long id,@RequestBody Caixa novoCaixa) {
        Optional<Caixa> antigoCaixa = CaixaRepository.findById(id);
        
        if(antigoCaixa.get().getIdCaixa() > 0) {
            novoCaixa.setIdCaixa(antigoCaixa.get().getIdCaixa());
            CaixaRepository.save(novoCaixa);
        }
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
 
    @GetMapping("/listarCaixa")
    public List<Caixa> listarCaixa(){
        return CaixaRepository.findAll();
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Caixa removido com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })

    @DeleteMapping(value="/remover/{id}")
    public void deleteCaixa(@PathVariable("id")long id) throws Exception {
        
        Optional<Caixa> caixa = CaixaRepository.findById(id);
        if (caixa.get().getIdCaixa() > 0) {
            CaixaRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }

}
