package br.com.fiap.cadastro.service.impl;

import br.com.fiap.cadastro.domain.usuario.Usuario;
import br.com.fiap.cadastro.domain.usuario.dto.CadastroDTO;
import br.com.fiap.cadastro.repository.CadastroRepository;
import br.com.fiap.cadastro.service.CadastroService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CadastroServiceImpl implements CadastroService {

    private final CadastroRepository cadastroRepository;

    @Override
    public void cadastrar(CadastroDTO authenticationDTO) {
        String encryptedPass = new BCryptPasswordEncoder().encode(authenticationDTO.password());
        Usuario usuario = new Usuario(authenticationDTO.username(), encryptedPass);
        cadastroRepository.save(usuario);
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        return cadastroRepository.findAll();
    }
}
