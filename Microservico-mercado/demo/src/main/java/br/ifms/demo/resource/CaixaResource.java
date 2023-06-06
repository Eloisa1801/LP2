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

import br.ifms.demo.javabeans.Caixa;
import br.ifms.demo.repository.CaixaRepository;

@RestController
@RequestMapping(value="api/caixa")
public class CaixaResource {
    @Autowired
	CaixaRepository CaixaRepository;

    
    @PostMapping("/inserir")
    public Caixa salvarCaixa(@RequestBody Caixa caixa) {
        return CaixaRepository.save(caixa);
    }
    
    @PutMapping("/atualizar/{id}")
    public void atualizarCaixa(@PathVariable(value= "id")long id,@RequestBody Caixa novoCaixa) {
        Optional<Caixa> antigoCaixa = CaixaRepository.findById(id);
        
        if(antigoCaixa.get().getIdCaixa() > 0) {
            novoCaixa.setIdCaixa(antigoCaixa.get().getIdCaixa());
            CaixaRepository.save(novoCaixa);
        }
    }
 
    @GetMapping(value="listar_caixa")
    public List<Caixa> listarCaixa(){
        return CaixaRepository.findAll();
    }


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
