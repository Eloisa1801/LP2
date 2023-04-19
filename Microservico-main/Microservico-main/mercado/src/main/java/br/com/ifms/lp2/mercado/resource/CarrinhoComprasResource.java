package br.com.ifms.lp2.mercado.resource;
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

import br.com.ifms.lp2.mercado.javabeans.CarrinhoCompras;
import br.com.ifms.lp2.mercado.repository.CarrinhoComprasRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="api/carrinho")
public class CarrinhoComprasResource {
    @Autowired
	CarrinhoComprasRepository CarrinhoComprasRepository;

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Inserido carrinho com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public CarrinhoCompras salvarCarrinhoCompras(@RequestBody @Valid CarrinhoCompras carrinhoCompras) {
        return CarrinhoComprasRepository.save(carrinhoCompras);
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do CarrinhoCompras atulizado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    
    @PutMapping("/atualizar/{id}")
    public void atualizarCarrinhoCompras(@PathVariable(value= "id")long id,@RequestBody CarrinhoCompras novoCarrinhoCompras) {
        Optional<CarrinhoCompras> antigoCarrinhoCompras = CarrinhoComprasRepository.findById(id);
        
        if(antigoCarrinhoCompras.get().getIdCarrinho() > 0) {
            novoCarrinhoCompras.setIdCarrinho(antigoCarrinhoCompras.get().getIdCarrinho());
            CarrinhoComprasRepository.save(novoCarrinhoCompras);
        }
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
 
    @GetMapping("/listarCarrinhoCompras")
    public List<CarrinhoCompras> listarCarrinhoCompras(){
        return CarrinhoComprasRepository.findAll();
    }


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do CarrinhoCompras removido com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })

    @DeleteMapping(value="/remover/{id}")
    public void deleteCarrinhoCompras(@PathVariable("id")long id) throws Exception {
        
        Optional<CarrinhoCompras> carrinhoCompras = CarrinhoComprasRepository.findById(id);
        if (carrinhoCompras.get().getIdCarrinho() > 0) {
            CarrinhoComprasRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }
}
