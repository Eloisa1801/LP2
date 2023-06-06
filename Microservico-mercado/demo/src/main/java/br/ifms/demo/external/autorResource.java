package br.ifms.demo.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

@RestController
@RequestMapping(value = "/autor")
public class autorResource {
    @Autowired
    autorService autor;

    @GetMapping(value = "/listarAutores")
    public List<Autor> listarAutores(){
        return autorService.findAll();
    }
    


}
