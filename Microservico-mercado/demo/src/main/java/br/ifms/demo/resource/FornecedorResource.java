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

import br.ifms.demo.javabeans.Fornecedor;
import br.ifms.demo.repository.FornecedorRepository;
@RestController
@RequestMapping(value="api/fornecedor")

public class FornecedorResource {

    @Autowired
	FornecedorRepository FornecedorRepository;

    @PostMapping("/inserir")
    public Fornecedor salvarFornecedor(@RequestBody Fornecedor fornecedor) {
        return FornecedorRepository.save(fornecedor);
    }
    
    @PutMapping("/atualizar/{id}")
    public void atualizarFornecedor(@PathVariable(value= "id")long id,@RequestBody Fornecedor novoFornecedor) {
        Optional<Fornecedor> antigoFornecedor = FornecedorRepository.findById(id);
        
        if(antigoFornecedor.get().getIdFornecedor() > 0) {
            novoFornecedor.setIdFornecedor(antigoFornecedor.get().getIdFornecedor());
            FornecedorRepository.save(novoFornecedor);
        }
    }

    @GetMapping("/listarFornecedor")
    public List<Fornecedor> listarFornecedor(){
        return FornecedorRepository.findAll();
    }


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
