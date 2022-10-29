package br.com.cadastrounico.service;

import java.util.List;
import java.util.Optional;

import br.com.cadastrounico.model.Secretaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastrounico.dto.UsuarioDTO;
import br.com.cadastrounico.dto.UsuarioNewDTO;
import br.com.cadastrounico.model.Usuario;
import br.com.cadastrounico.repository.UsuarioRepository;

import javax.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> findAll(){
        return repo.findAll();
    }

    public Usuario findId(Integer id){
        Optional<Usuario> usuario = repo.findById(id);
        return usuario.orElse(null);
    }

    @Transactional
    public Usuario insert(Usuario obj){
        obj.setId(null);
        repo.save(obj);
        return obj;
    }

    public Usuario update(Usuario usuario){
        Usuario novoUsuario = findId(usuario.getId());
        atualizaBanco(novoUsuario, usuario);
        return repo.save(novoUsuario);
    }

    public Usuario fromDTO(UsuarioDTO objDto){
        return new Usuario(objDto.getId(), objDto.getNomeCompleto(),objDto.getDataNascimento(),objDto.getEmail(),objDto.getCpf()
        ,objDto.getRg(),objDto.getStatus(),objDto.getTelefone());
    }
    @Transactional
    public Usuario fromDTO(UsuarioNewDTO objDto){
        Usuario uso = new Usuario(null, objDto.getNomeCompleto(),objDto.getDataNascimento(),objDto.getEmail(),objDto.getCpf()
                ,objDto.getRg(),objDto.getStatus(),objDto.getTelefone());
        return uso;
    }

    private void atualizaBanco(Usuario novoUsuario, Usuario usuario) {
        novoUsuario.setNomeCompleto(usuario.getNomeCompleto());
        novoUsuario.setDataNascimento(usuario.getDataNascimento());
        novoUsuario.setEmail(usuario.getEmail());
        novoUsuario.setCpf(usuario.getCpf());
        novoUsuario.setRg(usuario.getRg());
        novoUsuario.setStatus(usuario.getStatus());
    }
}