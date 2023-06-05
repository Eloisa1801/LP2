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

import br.com.ifms.lp2.mercado.javabeans.Pedido;
import br.com.ifms.lp2.mercado.repository.PedidoRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="api/pedido")
public class PedidoResource {
    @Autowired
	PedidoRepository PedidoRepository;

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Inserido Pedido com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Pedido salvarPedido(@RequestBody @Valid Pedido pedido) {
        return PedidoRepository.save(pedido);
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Pedido atulizado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    
    @PutMapping("/atualizar/{id}")
    public void atualizarPedido(@PathVariable(value= "id")long id,@RequestBody Pedido novoPedido) {
        Optional<Pedido> antigoPedido = PedidoRepository.findById(id);
        
        if(antigoPedido.get().getIdPedido() > 0) {
            novoPedido.setIdPedido(antigoPedido.get().getIdPedido());
            PedidoRepository.save(novoPedido);
        }
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
 
    @GetMapping("/listarPedido")
    public List<Pedido> listarPedido(){
        return PedidoRepository.findAll();
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Pedido removido com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })

    @DeleteMapping(value="/remover/{id}")
    public void deletePedido(@PathVariable("id")long id) throws Exception {
        
        Optional<Pedido> pedido = PedidoRepository.findById(id);
        if (pedido.get().getIdPedido() > 0) {
            PedidoRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }
}
