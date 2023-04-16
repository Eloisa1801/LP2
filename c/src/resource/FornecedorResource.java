package resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifms.lp2.javabeans.Aluno;
import br.com.ifms.lp2.repository.AlunoRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import javabeans.Fornecedor;
public class FornecedorResource {

    @RestController
    @RequestMapping(value="api/aluno")

    @Autowired
	FornecedorRepository FornecedorRepository;

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Inserido aluno com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/fornecedores")
        public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor novoFornecedor = fornecedorService.salvar(fornecedor);
        return ResponseEntity.created(URI.create("/fornecedores/" + novoFornecedor.getId())).body(novoFornecedor);
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Inserido aluno com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PutMapping("/fornecedores/{id}")
        public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
            Optional<Fornecedor> fornecedorExistente = fornecedorService.buscarPorId(id);
            if (fornecedorExistente.isPresent()) {
                fornecedor.setId(id);
                Fornecedor fornecedorAtualizado = fornecedorService.salvar(fornecedor);
                return ResponseEntity.ok(fornecedorAtualizado);
            } else {
                return ResponseEntity.notFound().build();
            }
        }


        @ApiResponses(value = {
			@ApiResponse(code = 200, message = " Listado com sucesso!!!"),
			@ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerado uma exceção")
        })
        @GetMapping("/listarFornecedores")
        public List<Fornecedor> listarFornecedores(){
            return fornecedorRepository.findAll();
        }

        @ApiResponses(value = {
			@ApiResponse(code = 200, message = " ID do aluno removido com sucesso!!!"),
			@ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerado uma exceção")
        })
        @DeleteMapping(value="/remover/{id}")
        public void deleteFornecedor(@PathVariable("id")long id) throws Exception {
            
            Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
            if (fornecedor.get().getIdFornecedor() > 0) {
                fornecedorRepository.deleteById(id);
            } else {
                System.out.println("não encontrado");
                throw new Exception("ID não encontrado!!!");
            }
        }
}
