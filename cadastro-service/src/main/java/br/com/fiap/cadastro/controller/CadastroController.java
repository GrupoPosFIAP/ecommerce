package br.com.fiap.cadastro.controller;

import br.com.fiap.cadastro.domain.usuario.Usuario;
import br.com.fiap.cadastro.domain.usuario.dto.CadastroDTO;
import br.com.fiap.cadastro.service.CadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    public void cadastrar(@RequestBody @Valid CadastroDTO usuario) {
        this.cadastroService.cadastrar(usuario);
    }

    @GetMapping
    public List<Usuario> consultarUsuarios() {
        return this.cadastroService.consultarUsuarios();
    }

    @PostMapping("/promover/{id}")
    public void promover(@PathVariable String id) {
        this.cadastroService.promover(id);
    }
}
