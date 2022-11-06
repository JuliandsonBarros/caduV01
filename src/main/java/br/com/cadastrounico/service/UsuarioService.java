package br.com.cadastrounico.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastrounico.dto.UsuarioDTO;
import br.com.cadastrounico.dto.UsuarioDeleteDTO;
import br.com.cadastrounico.dto.UsuarioNewDTO;
import br.com.cadastrounico.model.Usuario;
import br.com.cadastrounico.repository.UsuarioRepository;
import br.com.cadastrounico.service.exception.ObjectNotFoundExeption;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> findAll(){
        return repo.findAll();
    }

    public Usuario findId(Integer id){
        Optional<Usuario> usuario = repo.findById(id);
        if(usuario.orElse(null) == null) {
        	throw new ObjectNotFoundExeption("Usuario não encontrado.");
        }
        return usuario.orElseThrow();
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
    
    public Usuario delete(Usuario usuario){
        Usuario novoUsuario = findId(usuario.getId());
        	novoUsuario.setStatus("I");
        	findId(usuario.getId());
        return repo.save(novoUsuario);
    }

	public Usuario fromDTO(UsuarioDTO objDto){
        return new Usuario(objDto.getId(), objDto.getNomeCompleto(),objDto.getDataNascimento(),objDto.getEmail(),
        		objDto.getSexo(),objDto.getCpf(),objDto.getRg(),objDto.getTelefone(),objDto.getStatus());
    }
    
    public Usuario fromDTO(UsuarioNewDTO objDto){
        Usuario uso = new Usuario(objDto.getId(), objDto.getNomeCompleto(),objDto.getDataNascimento(),objDto.getEmail(),
        		objDto.getSexo(),objDto.getCpf(),objDto.getRg(),objDto.getTelefone(),objDto.getStatus());
        return uso;
    }
    
    public Usuario fromDTO(UsuarioDeleteDTO objDto){
        Usuario uso = new Usuario(objDto.getId(), null,null,null,
        		null,null ,null ,objDto.getStatus(),null);
        return uso;
    }

    private void atualizaBanco(Usuario novoUsuario, Usuario usuario) {
        novoUsuario.setNomeCompleto(usuario.getNomeCompleto());
        novoUsuario.setDataNascimento(usuario.getDataNascimento());
        novoUsuario.setEmail(usuario.getEmail());
        novoUsuario.setSexo(usuario.getSexo());
        novoUsuario.setCpf(usuario.getCpf());
        novoUsuario.setRg(usuario.getRg());
        novoUsuario.setTelefone(usuario.getTelefone());
        novoUsuario.setStatus(usuario.getStatus());
    }
    
    
}

