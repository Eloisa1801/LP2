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

import br.ifms.demo.javabeans.Estoque;
import br.ifms.demo.repository.EstoqueRepository;

@RestController
@RequestMapping(value="api/estoque")
public class EstoqueResource {
    @Autowired
	EstoqueRepository EstoqueRepository;

    @PostMapping("/inserir")
    public Estoque salvarEstoque(@RequestBody Estoque estoque) {
        return EstoqueRepository.save(estoque);
    }

    
    @PutMapping("/atualizar/{id}")
    public void atualizarEstoque(@PathVariable(value= "id")long id,@RequestBody Estoque novoEstoque) {
        Optional<Estoque> antigoEstoque = EstoqueRepository.findById(id);
        
        if(antigoEstoque.get().getIdEstoque() > 0) {
            novoEstoque.setIdEstoque(antigoEstoque.get().getIdEstoque());
            EstoqueRepository.save(novoEstoque);
        }
    }

 
    @GetMapping("/listarEstoque")
    public List<Estoque> listarEstoque(){
        return EstoqueRepository.findAll();
    }


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
