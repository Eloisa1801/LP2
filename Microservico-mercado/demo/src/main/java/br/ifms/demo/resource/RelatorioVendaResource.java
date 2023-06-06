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

import br.ifms.demo.javabeans.RelatorioVendas;
import br.ifms.demo.repository.RelatorioVendasRepository;


@RestController
@RequestMapping(value="api/relatorio")
public class RelatorioVendaResource {
    @Autowired
	RelatorioVendasRepository RelatorioVendasRepository;


    @PostMapping("/inserir")
    public RelatorioVendas salvarRelatorioVendas(@RequestBody RelatorioVendas relatorioVendas) {
        return RelatorioVendasRepository.save(relatorioVendas);
    }



    @PutMapping("/atualizar/{id}")
    public void atualizarRelatorioVendas(@PathVariable(value= "id")long id,@RequestBody RelatorioVendas novoRelatorioVendas) {
        Optional<RelatorioVendas> antigoRelatorioVendas = RelatorioVendasRepository.findById(id);
        
        if(antigoRelatorioVendas.get().getIdRelatorioVendas() > 0) {
            novoRelatorioVendas.setIdRelatorioVendas(antigoRelatorioVendas.get().getIdRelatorioVendas());
            RelatorioVendasRepository.save(novoRelatorioVendas);
        }
    }

   
    @GetMapping("/listarRelatorioVendas")
    public List<RelatorioVendas> listarRelatorioVendas(){
        return RelatorioVendasRepository.findAll();
    }


    @DeleteMapping(value="/remover/{id}")
    public void deleteRelatorioVendas(@PathVariable("id")long id) throws Exception {
        
        Optional<RelatorioVendas> relatorioVendas = RelatorioVendasRepository.findById(id);
        if (relatorioVendas.get().getIdRelatorioVendas() > 0) {
            RelatorioVendasRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }


}
