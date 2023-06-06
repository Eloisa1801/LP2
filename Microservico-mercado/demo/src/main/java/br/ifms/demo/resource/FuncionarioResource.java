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

import br.ifms.demo.javabeans.Funcionario;
import br.ifms.demo.repository.FuncionarioRepository;

@RestController
@RequestMapping(value="api/funcionario")
public class FuncionarioResource {
    @Autowired
	FuncionarioRepository FuncionarioRepository;

    @PostMapping("/inserir")
    public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
        return FuncionarioRepository.save(funcionario);
    }

    
    @PutMapping("/atualizar/{id}")
    public void atualizarFuncionario(@PathVariable(value= "id")long id,@RequestBody Funcionario novoFuncionario) {
        Optional<Funcionario> antigoFuncionario = FuncionarioRepository.findById(id);
        
        if(antigoFuncionario.get().getIdFunc() > 0) {
            novoFuncionario.setIdFunc(antigoFuncionario.get().getIdFunc());
            FuncionarioRepository.save(novoFuncionario);
        }
    }
 
    @GetMapping("/listarFuncionario")
    public List<Funcionario> listarFuncionario(){
        return FuncionarioRepository.findAll();
    }



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
