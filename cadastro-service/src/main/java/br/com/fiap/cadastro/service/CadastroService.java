package br.com.fiap.cadastro.service;

import br.com.fiap.cadastro.domain.usuario.Usuario;
import br.com.fiap.cadastro.domain.usuario.dto.CadastroDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CadastroService {

    void cadastrar(CadastroDTO usuario);

    List<Usuario> consultarUsuarios();

    void promover(String id);
}
