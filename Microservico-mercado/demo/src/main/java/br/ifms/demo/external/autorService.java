package br.ifms.demo.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import antlr.collections.List;

@FeignClient(name = "autor", url = "https://10.8.24.133:8080/biblioteca")
public interface autorService {
    @GetMapping(value = "/listarAutores")

    List<Autor> findAll();

}
