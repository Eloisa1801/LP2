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

import br.com.ifms.lp2.mercado.javabeans.Cliente;
import br.com.ifms.lp2.mercado.repository.ClienteRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="api/cliente")
public class ClienteResource {
    @Autowired
	ClienteRepository ClienteRepository;

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Inserido Cliente com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Cliente salvarCliente(@RequestBody @Valid Cliente cliente) {
        return ClienteRepository.save(cliente);
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Cliente atulizado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    
    @PutMapping("/atualizar/{id}")
    public void atualizarCliente(@PathVariable(value= "id")long id,@RequestBody Cliente novoCliente) {
        Optional<Cliente> antigoCliente = ClienteRepository.findById(id);
        
        if(antigoCliente.get().getIdCliente() > 0) {
            novoCliente.setIdCliente(antigoCliente.get().getIdCliente());
            ClienteRepository.save(novoCliente);
        }
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
 
    @GetMapping("/listarCliente")
    public List<Cliente> listarCliente(){
        return ClienteRepository.findAll();
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Cliente removido com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })

    @DeleteMapping(value="/remover/{id}")
    public void deleteCliente(@PathVariable("id")long id) throws Exception {
        
        Optional<Cliente> cliente = ClienteRepository.findById(id);
        if (cliente.get().getIdCliente() > 0) {
            ClienteRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }

}
