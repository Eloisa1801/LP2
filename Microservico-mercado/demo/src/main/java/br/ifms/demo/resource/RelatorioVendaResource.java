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

import br.com.ifms.lp2.mercado.javabeans.RelatorioVendas;
import br.com.ifms.lp2.mercado.repository.RelatorioVendasRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="api/relatorio")
public class RelatorioVendaResource {
    @Autowired
	RelatorioVendasRepository RelatorioVendasRepository;

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Inserido RelatorioVendas com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public RelatorioVendas salvarRelatorioVendas(@RequestBody @Valid RelatorioVendas relatorioVendas) {
        return RelatorioVendasRepository.save(relatorioVendas);
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do RelatorioVendas atulizado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    
    @PutMapping("/atualizar/{id}")
    public void atualizarRelatorioVendas(@PathVariable(value= "id")long id,@RequestBody RelatorioVendas novoRelatorioVendas) {
        Optional<RelatorioVendas> antigoRelatorioVendas = RelatorioVendasRepository.findById(id);
        
        if(antigoRelatorioVendas.get().getIdRelatorioVendas() > 0) {
            novoRelatorioVendas.setIdRelatorioVendas(antigoRelatorioVendas.get().getIdRelatorioVendas());
            RelatorioVendasRepository.save(novoRelatorioVendas);
        }
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
 
    @GetMapping("/listarRelatorioVendas")
    public List<RelatorioVendas> listarRelatorioVendas(){
        return RelatorioVendasRepository.findAll();
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do RelatorioVendas removido com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })

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
