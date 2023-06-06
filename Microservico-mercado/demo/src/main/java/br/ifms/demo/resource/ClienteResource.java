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

import br.ifms.demo.javabeans.Cliente;
import br.ifms.demo.repository.ClienteRepository;

@RestController
@RequestMapping(value="api/cliente")
public class ClienteResource {
    @Autowired
	ClienteRepository ClienteRepository;

    @PostMapping("/inserir")
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return ClienteRepository.save(cliente);
    }

    
    @PutMapping("/atualizar/{id}")
    public void atualizarCliente(@PathVariable(value= "id")long id,@RequestBody Cliente novoCliente) {
        Optional<Cliente> antigoCliente = ClienteRepository.findById(id);
        
        if(antigoCliente.get().getIdCliente() > 0) {
            novoCliente.setIdCliente(antigoCliente.get().getIdCliente());
            ClienteRepository.save(novoCliente);
        }
    }

 
    @GetMapping("/listarCliente")
    public List<Cliente> listarCliente(){
        return ClienteRepository.findAll();
    }

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
