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
	public Usuario insert(Usuario obj) {
		return repo.save(obj);
	}
    
    public Usuario update(Usuario usuario){
        Usuario novoUsuario = findId(usuario.getId_usuario());
        atualizaBanco(novoUsuario, usuario);
        return repo.save(novoUsuario);
    }
    
    public Usuario delete(Usuario usuario){
        Usuario novoUsuario = findId(usuario.getId_usuario());
        	novoUsuario.setSta_usuario("I");
        	findId(usuario.getId_usuario());
        return repo.save(novoUsuario);
    }

	public Usuario fromDTO(UsuarioDTO objDto){
        return new Usuario(objDto.getId_usuario(),objDto.getNom_usuario(),objDto.getDta_nascimento(),
        			objDto.getNom_email(), objDto.getNom_sexo(), objDto.getCod_cpf(),objDto.getCod_rg(),objDto.getCod_telefone(),objDto.getSta_usuario());
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
        novoUsuario.setNom_usuario(usuario.getNom_usuario());
        novoUsuario.setDta_nascimento(usuario.getDta_nascimento());
        novoUsuario.setNom_email(usuario.getNom_email());
        novoUsuario.setNom_sexo(usuario.getNom_sexo());
        novoUsuario.setCod_cpf(usuario.getCod_cpf());
        novoUsuario.setCod_rg(usuario.getCod_rg());
        novoUsuario.setCod_telefone(usuario.getCod_telefone());
        novoUsuario.setSta_usuario(usuario.getSta_usuario());
    }
    
    
}

