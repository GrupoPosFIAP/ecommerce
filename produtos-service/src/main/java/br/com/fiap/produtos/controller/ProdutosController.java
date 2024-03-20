package br.com.fiap.produtos.controller;

import br.com.fiap.produtos.dto.ProdutoDTO;
import br.com.fiap.produtos.service.ProdutoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutosController {

    @Autowired
    private ProdutoService produtoService;


    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public ProdutoDTO save(@Valid @RequestBody ProdutoDTO dto) {
        return this.produtoService.save(dto);
    }


    @GetMapping("/{id}")
    public Optional<ProdutoDTO> findById(@PathVariable("id") String id) {
        return this.produtoService.findById(id);
    }


    @GetMapping
    public List<ProdutoDTO> findAll() {
        return this.produtoService.findAll();
    }


    @PutMapping("/{id}")
//    @AuthenticationRequired
    @RolesAllowed("ROLE_ADMIN")
    public ProdutoDTO update(@PathVariable("id") String id, @RequestBody ProdutoDTO dto) {
        return this.produtoService.update(id, dto);
    }


    @DeleteMapping("/{id}")
//    @AuthenticationRequired
    @RolesAllowed("ROLE_ADMIN")
    public void delete(@PathVariable("id") String id) {
        this.produtoService.delete(id);
    }
}


// Eureka
// Gateway
// Microserviço com porta zerada

//docker run --name mongoFiap -d -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=pass -e MONGO_INITDB_DATABASE=storeDb

