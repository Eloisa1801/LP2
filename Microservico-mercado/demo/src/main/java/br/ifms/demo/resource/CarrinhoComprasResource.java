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

import  br.ifms.demo.javabeans.CarrinhoCompras;
import  br.ifms.demo.repository.CarrinhoComprasRepository;

@RestController
@RequestMapping(value="api/carrinho")
public class CarrinhoComprasResource {
    @Autowired
	CarrinhoComprasRepository CarrinhoComprasRepository;

    @PostMapping("/inserir")
    public CarrinhoCompras salvarCarrinhoCompras(@RequestBody CarrinhoCompras carrinhoCompras) {
        return CarrinhoComprasRepository.save(carrinhoCompras);
    }

    
    @PutMapping("/atualizar/{id}")
    public void atualizarCarrinhoCompras(@PathVariable(value= "id")long id,@RequestBody CarrinhoCompras novoCarrinhoCompras) {
        Optional<CarrinhoCompras> antigoCarrinhoCompras = CarrinhoComprasRepository.findById(id);
        
        if(antigoCarrinhoCompras.get().getIdCarrinho() > 0) {
            novoCarrinhoCompras.setIdCarrinho(antigoCarrinhoCompras.get().getIdCarrinho());
            CarrinhoComprasRepository.save(novoCarrinhoCompras);
        }
    }


    @GetMapping("/listarCarrinhoCompras")
    public List<CarrinhoCompras> listarCarrinhoCompras(){
        return CarrinhoComprasRepository.findAll();
    }



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
