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

import br.ifms.demo.javabeans.Pedido;
import br.ifms.demo.repository.PedidoRepository;


@RestController
@RequestMapping(value="api/pedido")
public class PedidoResource {
    @Autowired
	PedidoRepository PedidoRepository;

    @PostMapping("/inserir")
    public Pedido salvarPedido(@RequestBody Pedido pedido) {
        return PedidoRepository.save(pedido);
    }

    
    @PutMapping("/atualizar/{id}")
    public void atualizarPedido(@PathVariable(value= "id")long id,@RequestBody Pedido novoPedido) {
        Optional<Pedido> antigoPedido = PedidoRepository.findById(id);
        
        if(antigoPedido.get().getIdPedido() > 0) {
            novoPedido.setIdPedido(antigoPedido.get().getIdPedido());
            PedidoRepository.save(novoPedido);
        }
    }

 
    @GetMapping("/listarPedido")
    public List<Pedido> listarPedido(){
        return PedidoRepository.findAll();
    }


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
