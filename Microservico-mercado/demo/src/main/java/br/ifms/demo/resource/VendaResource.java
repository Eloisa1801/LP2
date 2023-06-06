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

import br.ifms.demo.javabeans.Venda;
import br.ifms.demo.repository.VendaRepository;

@RestController
@RequestMapping(value="api/venda")
public class VendaResource {
    @Autowired
	VendaRepository VendaRepository;

    @PostMapping("/inserir")
    public Venda salvarVenda(@RequestBody Venda venda) {
        return VendaRepository.save(venda);
    }


    
    @PutMapping("/atualizar/{id}")
    public void atualizarVenda(@PathVariable(value= "id")long id,@RequestBody Venda novoVenda) {
        Optional<Venda> antigoVenda = VendaRepository.findById(id);
        
        if(antigoVenda.get().getIdVenda() > 0) {
            novoVenda.setIdVenda(antigoVenda.get().getIdVenda());
            VendaRepository.save(novoVenda);
        }
    }

 
    @GetMapping("/listarVenda")
    public List<Venda> listarVenda(){
        return VendaRepository.findAll();
    }


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
