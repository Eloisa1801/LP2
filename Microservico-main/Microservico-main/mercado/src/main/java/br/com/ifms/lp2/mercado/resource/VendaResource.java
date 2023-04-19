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

import br.com.ifms.lp2.mercado.javabeans.Venda;
import br.com.ifms.lp2.mercado.repository.VendaRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="api/venda")
public class VendaResource {
    @Autowired
	VendaRepository VendaRepository;

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Inserido Venda com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Venda salvarVenda(@RequestBody @Valid Venda venda) {
        return VendaRepository.save(venda);
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Venda atulizado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    
    @PutMapping("/atualizar/{id}")
    public void atualizarVenda(@PathVariable(value= "id")long id,@RequestBody Venda novoVenda) {
        Optional<Venda> antigoVenda = VendaRepository.findById(id);
        
        if(antigoVenda.get().getIdVenda() > 0) {
            novoVenda.setIdVenda(antigoVenda.get().getIdVenda());
            VendaRepository.save(novoVenda);
        }
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
 
    @GetMapping("/listarVenda")
    public List<Venda> listarVenda(){
        return VendaRepository.findAll();
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Venda removido com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })

    @DeleteMapping(value="/remover/{id}")
    public void deleteVenda(@PathVariable("id")long id) throws Exception {
        
        Optional<Venda> venda = VendaRepository.findById(id);
        if (venda.get().getIdVenda() > 0) {
            VendaRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }
}
